package com.chinaventure.webspider.service;

import java.util.List;

import com.chinaventure.webspider.model.KrEnt;

public interface KrService {

	/**
	 * 公司数据入库,自动去重
	 * @param aoinFunds
	 */
	void updateEnts(List<KrEnt> ents);

	/**
	 * 是否包含公司
	 * @param managername
	 * @return
	 */
	boolean containsEnt(String name);
	
}
