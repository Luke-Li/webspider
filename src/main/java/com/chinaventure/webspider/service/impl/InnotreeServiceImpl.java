package com.chinaventure.webspider.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaventure.webspider.mapper.InnotreeEntMapper;
import com.chinaventure.webspider.model.InnotreeEnt;
import com.chinaventure.webspider.service.InnotreeService;

import tk.mybatis.mapper.entity.Example;

@Service
public class InnotreeServiceImpl extends BaseService<InnotreeEnt> implements InnotreeService{
	
	/**
	 * 公司Mapper
	 */
	@Autowired
	private InnotreeEntMapper entMapper;

	/**
	 * 公司数据入库,自动去重
	 * @param aoinFunds
	 */
	@Override
	public void updateEnts(List<InnotreeEnt> ents){
		List<InnotreeEnt> uninDatabase = new ArrayList<>();
		for (InnotreeEnt ent : ents) {
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
	     
		return entMapper.selectCount(new InnotreeEnt(){{setName(entName);}})>0;
	}

	/**
	 * 查询所有未填充公司名称和简介的公司数据
	 * @param innotreeEnt
	 */
	@Override
	public List<InnotreeEnt> selectUnfillData(Integer startId,Integer endId) {
		 Example example = new Example(InnotreeEnt.class);
	     Example.Criteria criteria = example.createCriteria();
	     criteria.andEqualTo("fullname", null).andEqualTo("brief",null);
	     
	     if(startId != null){
	    	 criteria.andGreaterThanOrEqualTo("innerid", startId);
	     }
	     
	     if(endId != null){
	    	 criteria.andLessThan("innerid", endId);
	     }
	     
	     return entMapper.selectByExample(example);
	}
	
	@Override
	public List<InnotreeEnt> selectUnfillData() {
		 Example example = new Example(InnotreeEnt.class);
	     Example.Criteria criteria = example.createCriteria();
	     criteria.andIsNull("fullname");
	     
	     return entMapper.selectByExample(example);
	}
	
	/**
	 * 查询所有的公司
	 * @param innotreeEnt
	 */
	@Override
	public List<InnotreeEnt> selectAll(InnotreeEnt ent) {
		return entMapper.select(ent);
	}

	/**
	 * 更新公司数据
	 */
	@Override
	public void updateEnt(InnotreeEnt innotreeEnt) {
		entMapper.updateByPrimaryKeySelective(innotreeEnt);
	}

}
