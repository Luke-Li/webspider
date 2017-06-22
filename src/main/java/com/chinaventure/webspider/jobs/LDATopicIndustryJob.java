package com.chinaventure.webspider.jobs;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.model.jfinal.ChoiceStockA;
import com.chinaventure.webspider.model.jfinal.ChoiceStockBizInfo;
import com.chinaventure.webspider.model.jfinal.ChoiceStockThirdboard;
import com.jfinal.plugin.activerecord.Db;

import sealion.core.Job;

/**
 * LDA行业TOPIC处理
 * 
 * @author Administrator
 *
 */
public class LDATopicIndustryJob extends Job {
	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		new LDATopicIndustryJob().execute(null);
	}

	TTransport transport = null;

	private void constructBizInfo(String stock_code, String cn_name, String infoJsonStr) {
		String info = "", main_product = "", biz_scope = "", srcr_industry = "";

		JSONArray infos = JSONArray.parseArray(infoJsonStr);
		if (null != infos && infos.size() > 0) {
			for (int i = 0; i < infos.size(); i++) {
				JSONObject item = infos.getJSONObject(i);
				String key = item.getString("col0");
				if (StringUtils.isNotBlank(key)) {
					switch (key) {
					case "公司简介":
						info = item.getString("col1");
						break;
					case "主营产品":
						main_product = item.getString("col1");
						break;
					case "经营范围":
						biz_scope = item.getString("col1");
						break;
					case "所属证监会行业":
						srcr_industry = item.getString("col1");
						break;
					default:
						break;
					}
				}
			}
		}

		String content = String.format("%s %s %s %s %s", cn_name, info, main_product, biz_scope, srcr_industry);

		ChoiceStockBizInfo biz = new ChoiceStockBizInfo();
		biz.set("stock_code", stock_code);
		biz.set("cn_name", cn_name);
		biz.set("content", content);
		biz.save();
	}

	@Override
	public void execute(Map<String, String> params) {
		try {
			JFConfig.start();

			logger.info("begin truncate table choice_stock_biz_info");
			Db.update(" truncate choice_stock_biz_info ");

			logger.info("handle ChoiceStockA");
			List<ChoiceStockA> listStocka = ChoiceStockA.dao.find(String.format(" select id,code,name,info from %s", ChoiceStockA.TableName));
			for (ChoiceStockA choiceStockA : listStocka) {
				String stock_code = choiceStockA.getStr("code");
				String cn_name = choiceStockA.getStr("name");
				try {
					constructBizInfo(stock_code, cn_name, choiceStockA.getStr("info"));
				} catch (Exception e) {
					logger.error(String.format("company:%s", cn_name), e);
				}
			}
			logger.info("handle ChoiceStockThirdboard");
			List<ChoiceStockThirdboard> listStockThirdboard = ChoiceStockThirdboard.dao.find(String.format(" select id,code,name,info from %s", ChoiceStockThirdboard.TableName));
			for (ChoiceStockThirdboard choiceStockThird : listStockThirdboard) {
				String stock_code = choiceStockThird.getStr("code");
				String cn_name = choiceStockThird.getStr("name");

				try {
					constructBizInfo(stock_code, cn_name, choiceStockThird.getStr("info"));
				} catch (Exception e) {
					logger.error(String.format("company:%s", cn_name), e);
				}
			}

			logger.info(String.format("LDA行业TOPIC开始处理 ：地址 %s : %s ", "192.168.0.70", "18090"));
			transport = new TSocket("192.168.0.70", 18090, 30000);
			// 协议要和服务端一致
			TProtocol protocol = new TBinaryProtocol(transport);
			com.chinaventure.webspider.service.impl.TopicService.Client client = new com.chinaventure.webspider.service.impl.TopicService.Client(protocol);
			transport.open();

			// result = client.getMediaTopic(content);
			// System.out.println("Thrify client getMediaTopic result =: " +
			// result);

			int totalCount = 0;

			for (ChoiceStockBizInfo element : ChoiceStockBizInfo.dao.findAll()) {
				String topicId = client.getIndusryTopic(element.getStr("content"));

				element.set("topic_id", topicId);
				element.update();

				totalCount++;
			}

			logger.info(String.format("LDA行业TOPIC处理完成 入库数量 ：%s", totalCount));

		} catch (Exception e) {
			logger.error("LDA行业TOPIC处理异常", e);
		} finally {
			if (null != transport) {
				transport.close();
			}
		}
	}
}
