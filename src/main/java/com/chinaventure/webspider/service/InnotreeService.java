package com.chinaventure.webspider.service;

import java.util.List;

import com.chinaventure.webspider.model.InnotreeEnt;

public interface InnotreeService {

	/**
	 * 公司数据入库,自动去重
	 * @param aoinFunds
	 */
	void updateEnts(List<InnotreeEnt> ents);

	/**
	 * 是否包含公司
	 * @param managername
	 * @return
	 */
	boolean containsEnt(String managername);

	/**
	 * 查询所有的公司
	 * @param innotreeEnt
	 * @return 
	 */
	List<InnotreeEnt> selectAll(InnotreeEnt ent);

	/**
	 * 查询所有的未填充数据的公司
	 * @param startId
	 * @param endId
	 * @return
	 */
	List<InnotreeEnt> selectUnfillData(Integer startId, Integer endId);
	
	/**
	 * 查询所有的未填充数据的公司
	 * @return
	 */
	List<InnotreeEnt> selectUnfillData();

	/**
	 * 更新公司信息
	 * @param innotreeEnt
	 */
	void updateEnt(InnotreeEnt innotreeEnt);

}
