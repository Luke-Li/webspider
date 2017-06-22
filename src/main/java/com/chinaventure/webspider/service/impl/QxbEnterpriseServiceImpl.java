package com.chinaventure.webspider.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaventure.webspider.bean.QxbEntBean;
import com.chinaventure.webspider.mapper.EntQxbEntErrorLogMapper;
import com.chinaventure.webspider.mapper.EntQxbEntMapper;
import com.chinaventure.webspider.mapper.EntQxbSeedMapper;
import com.chinaventure.webspider.model.EntQxbEnt;
import com.chinaventure.webspider.model.EntQxbEntErrorLog;
import com.chinaventure.webspider.model.EntQxbSeed;
import com.chinaventure.webspider.service.QxbEnterpriseService;
import com.chinaventure.webspider.util.FileUtil;
import com.chinaventure.webspider.util.KafkaProducerHelper;

import tk.mybatis.mapper.entity.Example;

@Service
public class QxbEnterpriseServiceImpl extends  BaseService<EntQxbEnt> implements QxbEnterpriseService{

	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	EntQxbEntErrorLogMapper errorLogMapper;
	
	@Autowired
	EntQxbSeedMapper qxbSeedMapper;
	
	@Autowired
	EntQxbEntMapper qxbMapper;
	
	/**
	 * 插入抓取的异常公司数据
	 * @param log
	 */
	@Override
	public void InsertErrorLog(String uuid,String companyName,String message) {
		EntQxbEntErrorLog log = new EntQxbEntErrorLog();
		log.setCreateTime(new Date());
		log.setDescription(message);
		log.setName(companyName);
		log.setUuid(uuid);

		log.setUrl(FileUtil.getLocalIp());
		
		errorLogMapper.insert(log);
	}
	
	/**
	 * 查询异常的抓取记录，并从数据库中删除
	 * @return
	 */
	@Override
	public List<EntQxbEntErrorLog> deleteAndReturnAllData(){
		List<EntQxbEntErrorLog> logs = errorLogMapper.selectAll();
		for (EntQxbEntErrorLog log : logs) {
			errorLogMapper.deleteByPrimaryKey(log.getId());
		}
		
		return logs;
	}

	/**
	 * 查询所有的种子记录
	 * @return
	 */
	@Override
	public List<EntQxbSeed> selectSeed(EntQxbSeed model){
		List<EntQxbSeed> logs = qxbSeedMapper.select(model);
		return logs;
	}
	
	/**
	 * 插入种子
	 */
	@Override
	public void insertSeed(EntQxbSeed model) {
		qxbSeedMapper.insert(model);
	}
	
	/**
	 * 批量插入种子
	 */
	@Override
	public void insertSeed(List<EntQxbSeed> models) {
		if(models.size()>0)
		qxbSeedMapper.insertList(models);
	}
	
	/**
	 * 根据ID更新数据
	 */
	@Override
	public void updateSeed(EntQxbSeed seed) {
		qxbSeedMapper.updateByPrimaryKeySelective(seed);
	}
	
	/**
	 * 把TABLE解析成JSON字符串格式
	 */
	@Override
	public String parseTable(Element table){
		if (null == table) {
			return StringUtils.EMPTY;
		}
		JSONArray array = JSONArray.parseArray("[]");
		Elements rows = table.getElementsByTag("tr");
		Elements cols = rows.get(0).getElementsByTag("th");
		for (int i = 1; i < rows.size(); i++) {
			JSONObject object = JSONObject.parseObject("{}");
			Element currentRow = rows.get(i);
			if(currentRow.children().size()==cols.size()){
				for (int j = 0; j < cols.size(); j++) {
					object.put(cols.get(j).text(), currentRow.child(j).text());
				}
				array.add(object);
			}
		}
		
		return array.toJSONString();
	}
	
	/**
	 * 根据URL解析出公司ID
	 * @param url
	 * @return
	 */
	@Override
	public String parseEntidByUrl(String entUrl) {
		String[] paths = StringUtils.split(entUrl,'_');
		paths = StringUtils.split(paths[paths.length-1],'/');
		return paths[paths.length-1];
	}

	@Override
	public void insertDatabase(QxbEntBean bean) throws Exception {
		//数据入库 choice
		KafkaProducerHelper.getInstance("").send("qxb",bean.getUuid(), new String[]{bean.getUuid(),bean.getName(),Long.toString(bean.getCreateTime().getTime()),Long.toString(bean.getUpdateTime().getTime()),bean.getEntInfo(),
				bean.getShareholder(),bean.getPersonnel(),bean.getBranch(),bean.getRiskInfo(),bean.getIntellectualProperty(),
				bean.getInvestedCompanies(),bean.getAnnualReport(),bean.getOperationInfo(),bean.getRootNodeInfo(),bean.getEntClan()});

		//构造参数
		EntQxbEnt entity = new EntQxbEnt();
		entity.setCreateTime(new Date());
		entity.setName(bean.getName());
		entity.setUpdateTime(new Date());
		entity.setUuid(bean.getUuid());
		entity.setIp(FileUtil.getLocalIp());
		entity.setCookie(bean.getCookie());
		
		//查询是否已经存在
		EntQxbEnt model = new EntQxbEnt();
		model.setUuid(bean.getUuid());
		List<EntQxbEnt> result = select(model);
		if (result == null || result.size() == 0) {
			save(entity);
		}else {
			entity.setId(result.get(0).getId());
			entity.setCreateTime(null);
			updateNotNull(entity);
		}
	}

	@Override
	public Boolean containsUuid(String uuid) {
		Example example = new Example(EntQxbEnt.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("uuid", uuid);
        
        return qxbMapper.selectCountByExample(example)>0;
	}
}
