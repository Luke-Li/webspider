package com.chinaventure.webspider.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaventure.webspider.mapper.PofAoinFundMapper;
import com.chinaventure.webspider.mapper.PofInfoFundMapper;
import com.chinaventure.webspider.mapper.PofInfoLegalpersonResumeMapper;
import com.chinaventure.webspider.mapper.PofInfoManagerMapper;
import com.chinaventure.webspider.mapper.PofInfoMapper;
import com.chinaventure.webspider.mapper.PofListMapper;
import com.chinaventure.webspider.model.PofAoinFund;
import com.chinaventure.webspider.model.PofInfo;
import com.chinaventure.webspider.model.PofInfoFund;
import com.chinaventure.webspider.model.PofInfoLegalpersonResume;
import com.chinaventure.webspider.model.PofInfoManager;
import com.chinaventure.webspider.model.PofList;
import com.chinaventure.webspider.service.PofFundService;

@Service
public class PofFundServiceImpl extends BaseService<PofList> implements PofFundService {
	/**
	 * 私募基金管理人列表
	 */
	@Autowired
	private PofListMapper pofListMapper;
	/**
	 * 私募基金管理人公示信息
	 */
	@Autowired
	private PofInfoMapper pofInfoMapper;
	/**
	 * 私募基金公示信息
	 */
	@Autowired
	private PofInfoFundMapper pofInfoFundMapper;
	/**
	 * 私募基金管理人公示信息法人的工作履历
	 */
	@Autowired
	private PofInfoLegalpersonResumeMapper legalpersonResumeMapper;
	/**
	 * 私募基金管理人公示信息高管
	 */
	@Autowired
	private PofInfoManagerMapper pofInfoManagerMapper;
	/**
	 * 证券公司直投基金
	 */
	@Autowired
	private PofAoinFundMapper aoinFundMapper;

	/*------------证券公司直投基金----------------*/

	/**
	 * 数据库里是否包含直投基金
	 * 
	 * @param name
	 * @return
	 */
	private boolean containsAoinFund(String innerId) {
		/*
		 * Example example = new Example(StockChoiceStock.class);
		 * Example.Criteria criteria = example.createCriteria();
		 * criteria.andEqualTo("code", code).andEqualTo("data_date",date);
		 */

		return aoinFundMapper.selectCount(new PofAoinFund() {
			{
				setInnerid(innerId);
			}
		}) > 0;
	}

	/**
	 * 直投基金数据入库,自动去重
	 * 
	 * @param aoinFunds
	 */
	@Override
	public void insertAoinFund(List<PofAoinFund> aoinFunds) {
		for (PofAoinFund pofAoinFund : aoinFunds) {
			if (!containsAoinFund(pofAoinFund.getInnerid())) {
				aoinFundMapper.insert(pofAoinFund);
			}
		}
	}

	/*------------私募基金----------------*/

	/**
	 * 是否包含私募基金管理人
	 * 
	 * @param managerName
	 * @return
	 */
	@Override
	public boolean containsPof(String managerName) {

		/*
		 * Example example = new Example(StockChoiceStock.class);
		 * Example.Criteria criteria = example.createCriteria();
		 * criteria.andEqualTo("code", code).andEqualTo("data_date",date);
		 */

		return pofListMapper.selectCount(new PofList() {
			{
				setManagername(managerName);
			}
		}) > 0;
	}

	/**
	 * 更新私募基金管理人
	 * 
	 * @param stocks
	 */
	@Override
	public void updatePofList(PofList pofList) {

		PofList model = pofListMapper.selectOne(new PofList() {
			{
				setManagername(pofList.getManagername());
			}
		});
		if (null == model) {
			pofListMapper.insert(pofList);
		} else {
			pofList.setId(model.getId());
			pofListMapper.updateByPrimaryKeySelective(pofList);
		}

		Date now = new Date();

		PofInfo info = pofList.getInfo();
		info.setCreatetime(now);
		info.setUpdatetime(now);
		info.setPofId(pofList.getId());

		// 先删除，再插入
		pofInfoMapper.delete(new PofInfo() {
			{
				setPofId(pofList.getId());
			}
		});
		pofInfoMapper.insert(info);

		// 高管履历
		List<PofInfoLegalpersonResume> resumes = info.getPersonResumes();
		for (PofInfoLegalpersonResume personResume : resumes) {
			personResume.setCreatetime(now);
			personResume.setUpdatetime(now);
			personResume.setPofInfoId(info.getId());
		}

		// 先删除，再插入
		legalpersonResumeMapper.delete(new PofInfoLegalpersonResume() {
			{
				setPofInfoId(info.getId());
			}
		});
		if (resumes.size() > 0)
			legalpersonResumeMapper.insertList(resumes);
		// 高管情况
		List<PofInfoManager> managers = info.getFundManagers();
		for (PofInfoManager manager : managers) {
			manager.setCreatetime(now);
			manager.setUpdatetime(now);
			manager.setPofInfoId(info.getId());
		}
		pofInfoManagerMapper.delete(new PofInfoManager() {
			{
				setPofInfoId(info.getId());
			}
		});
		if (managers.size() > 0)
			pofInfoManagerMapper.insertList(managers);
		// 基金信息
		List<PofInfoFund> funds = info.getInfoFunds();
		for (PofInfoFund fund : funds) {
			fund.setCreatetime(now);
			fund.setUpdatetime(now);
			fund.setPofInfoId(info.getId());
		}

		if (funds.size() > 0) {
			pofInfoFundMapper.delete(new PofInfoFund() {
				{
					this.setPofmanagername(funds.get(0).getPofmanagername());
				}
			});
			pofInfoFundMapper.insertList(funds);
		}

	}

	/**
	 * 获取基金信息
	 */
	@Override
	public PofInfo selectPofInfoByMananagerName(String managerName) {
		return pofInfoMapper.selectOne(new PofInfo() {
			{
				this.setManagername(managerName);
			}
		});
	}

	@Override
	public void test() {
		pofInfoFundMapper.delete(new PofInfoFund() {
			{
				setPofInfoId(13053);
			}
		});
	}

}
