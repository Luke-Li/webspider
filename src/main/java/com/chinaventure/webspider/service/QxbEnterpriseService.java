package com.chinaventure.webspider.service;

import java.util.List;

import org.jsoup.nodes.Element;

import com.chinaventure.webspider.bean.QxbEntBean;
import com.chinaventure.webspider.model.EntQxbEnt;
import com.chinaventure.webspider.model.EntQxbEntErrorLog;
import com.chinaventure.webspider.model.EntQxbSeed;

public interface QxbEnterpriseService   extends IService<EntQxbEnt>{

	/**
	 * 解析表格数据为JSON格式
	 * @param table
	 * @return
	 */
	String parseTable(Element table);
	
	/**
	 * 根据企业URL解析出企业ID
	 * @param entUrl
	 * @return
	 */
	String parseEntidByUrl(String entUrl);

	
	/**
	 * 插入抓取的异常公司数据
	 * @param log
	 */
	void InsertErrorLog(String uuid, String companyName, String message);

	/**
	 * 查询错误数据并删除
	 * @return
	 */
	List<EntQxbEntErrorLog> deleteAndReturnAllData();

	/**
	 * 数据入库
	 * @param bean
	 * @throws Exception 
	 */
	void insertDatabase(QxbEntBean bean) throws Exception;

	/**
	 * 查询所有的种子记录
	 * @return
	 */
	List<EntQxbSeed> selectSeed(EntQxbSeed model);
	
	/**
	 * 插入种子记录
	 * @return
	 */
	void insertSeed(EntQxbSeed model);
	
	/**
	 * 批量插入种子记录
	 * @return
	 */
	void insertSeed(List<EntQxbSeed> models);
	
	/**
	 * 根据ID更新数据
	 * @param seed
	 */
	void updateSeed(EntQxbSeed seed);

	/**
	 * 是否包含UUID
	 * @param uuid
	 * @return
	 */
	Boolean containsUuid(String uuid);
}
