package com.chinaventure.webspider.service;

import com.chinaventure.webspider.model.PedailyCompany;
import com.chinaventure.webspider.model.PedailyInvest;

public interface PedailyService {

	

	/**
	 * 更新投资事件信息
	 * @param invest
	 */
	void insertInvest(PedailyInvest invest);

	/**
	 * 更新创业公司信息
	 * @param invest
	 */
	void insertCompany(PedailyCompany company);

}
