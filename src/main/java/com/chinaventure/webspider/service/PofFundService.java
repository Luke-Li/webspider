package com.chinaventure.webspider.service;

import java.util.List;

import com.chinaventure.webspider.model.PofAoinFund;
import com.chinaventure.webspider.model.PofInfo;
import com.chinaventure.webspider.model.PofList;

public interface PofFundService {

	/**
	 * 直投基金数据入库,自动去重
	 * @param aoinFunds
	 */
	void insertAoinFund(List<PofAoinFund> aoinFunds);

	/**
	 * 更新私募基金管理人
	 * @param stocks
	 */
	void updatePofList(PofList pofList);

	/**
	 * 是否包含基金管理人
	 * @param managername
	 * @return
	 */
	boolean containsPof(String managername);
	
	/**
	 * 获取更新基金信息
	 * @param managerName
	 * @return
	 */
	PofInfo selectPofInfoByMananagerName(String managerName);
	
	void test();
	
}
