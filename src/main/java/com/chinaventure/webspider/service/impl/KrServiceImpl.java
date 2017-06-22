package com.chinaventure.webspider.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaventure.webspider.mapper.KrEntMapper;
import com.chinaventure.webspider.model.KrEnt;
import com.chinaventure.webspider.service.KrService;

@Service
public class KrServiceImpl extends BaseService<KrEnt> implements KrService{
	
	/**
	 * 公司Mapper
	 */
	@Autowired
	private KrEntMapper entMapper;

	/**
	 * 公司数据入库,自动去重
	 * @param aoinFunds
	 */
	@Override
	public void updateEnts(List<KrEnt> ents){
		List<KrEnt> uninDatabase = new ArrayList<>();
		for (KrEnt ent : ents) {
			if(!containsEnt(ent.getName())){
				uninDatabase.add(ent);
			}
		}
		
		if(uninDatabase.size()>0){
			entMapper.insertList(uninDatabase);
		}
	}

	/*------------私募基金----------------*/
	
	/**
	 * 是否包含私募基金管理人
	 * @param managerName
	 * @return
	 */
	@Override
	public boolean containsEnt(String entName){
		
		/*
		 Example example = new Example(StockChoiceStock.class);
	     Example.Criteria criteria = example.createCriteria();
	     criteria.andEqualTo("code", code).andEqualTo("data_date",date);*/
	     
		return entMapper.selectCount(new KrEnt(){{setName(entName);}})>0;
	}
	
	
}
