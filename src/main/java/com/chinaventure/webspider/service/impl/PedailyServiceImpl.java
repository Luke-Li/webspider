package com.chinaventure.webspider.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaventure.webspider.mapper.PedailyCompanyMapper;
import com.chinaventure.webspider.mapper.PedailyInvestMapper;
import com.chinaventure.webspider.model.PedailyCompany;
import com.chinaventure.webspider.model.PedailyInvest;
import com.chinaventure.webspider.service.PedailyService;

@Service
public class PedailyServiceImpl extends BaseService<PedailyInvest> implements PedailyService{
	
	
	Logger logger = Logger.getLogger(getClass());
	
	/**
	 * 公司Mapper
	 */
	@Autowired
	private PedailyInvestMapper entMapper;

	@Autowired
	private PedailyCompanyMapper companyMapper;
	
	@Override
	public void insertInvest(PedailyInvest invest) {
		
		if(entMapper.selectCount(new PedailyInvest(){{setDetailUrl(invest.getDetailUrl());}}) <=0){
			entMapper.insert(invest);
		}else{
			logger.warn(String.format("投资事件 : %s url:%s 已经存在,本次插入取消",invest.getInvestSide(),invest.getDetailUrl()));
		}

	}

	@Override
	public void insertCompany(PedailyCompany company) {
		if(companyMapper.selectCount(new PedailyCompany(){{setDetailUrl(company.getDetailUrl());}}) <=0){
			companyMapper.insert(company);
		}else{
			logger.warn(String.format("创业公司 : %s url:%s 已经存在,本次插入取消",company.getCompanyName(),company.getDetailUrl()));
		}
	}

	

}
