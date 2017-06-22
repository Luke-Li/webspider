package com.chinaventure.webspider.service;

import java.util.List;

import com.chinaventure.webspider.model.XsbDfcfInvestDetails;
import com.chinaventure.webspider.model.XsbDfcfInvestPevc;
import com.chinaventure.webspider.model.XsbDfcfMarketMakerStock;
import com.chinaventure.webspider.model.XsbHxAssetLiability;
import com.chinaventure.webspider.model.XsbHxCashFlowStatement;
import com.chinaventure.webspider.model.XsbHxEquityStructurePerson;
import com.chinaventure.webspider.model.XsbHxFinancialRatios;
import com.chinaventure.webspider.model.XsbHxIncomeStatement;
import com.chinaventure.webspider.model.XsbThsAdditional;
import com.chinaventure.webspider.model.XsbThsDividends;
import com.chinaventure.webspider.model.XsbThsEnt;
import com.chinaventure.webspider.model.XsbThsEntManageteam;
import com.chinaventure.webspider.model.XsbThsEquityStructure;
import com.chinaventure.webspider.model.XsbThsFinanceJson;
import com.chinaventure.webspider.model.XsbThsHoldingCompany;
import com.chinaventure.webspider.model.XsbThsInvestAdditionalDetails;
import com.chinaventure.webspider.model.XsbThsInvestIssueObject;
import com.chinaventure.webspider.model.XsbThsInvestPevc;
import com.chinaventure.webspider.model.XsbThsInvestPrivatePlacementPlan;
import com.chinaventure.webspider.model.XsbThsInvestPrivatePlacementPlanCompleted;
import com.chinaventure.webspider.model.XsbThsMonitorFhts;
import com.chinaventure.webspider.model.XsbThsMonitorGpts;
import com.chinaventure.webspider.model.XsbThsMonitorZfts;
import com.chinaventure.webspider.model.XsbThsMonitorZsts;
import com.chinaventure.webspider.model.XsbThsQuotaChange;
import com.chinaventure.webspider.model.XsbThsRecentImportantEvents;
import com.chinaventure.webspider.model.XsbThsShareholderSharepriceCompare;
import com.chinaventure.webspider.model.XsbThsShareholders;

public interface XsbEnterpriseService extends IService<XsbThsEnt>{
	/**
	 * 企业及相关数据插入
	 * @param enterprise
	 * @param contact
	 * @param manageteams
	 * @param structures 
	 * @param topShareholders 
	 * @param shareholderSharepriceCompares 
	 * @param quotas 
	 * @param holdingCompanies 
	 * @param events 
	 * @param additionals 
	 * @param dividends 
	 * @param incomeStatements 
	 * @param ratios 
	 * @param structuresPerson 
	 * @param flowStatements 
	 * @param liabilities 
	 * @param makerStocks 
	 * @param financeJson 
	 * @return
	 */
	boolean insertEnterpriseData(XsbThsEnt enterprise,List<XsbThsEntManageteam> manageteams, List<XsbThsHoldingCompany> holdingCompanies, List<XsbThsQuotaChange> quotas, List<XsbThsShareholderSharepriceCompare> shareholderSharepriceCompares, List<XsbThsShareholders> topShareholders, List<XsbThsEquityStructure> structures, List<XsbThsDividends> dividends, List<XsbThsAdditional> additionals, List<XsbThsRecentImportantEvents> events, List<XsbHxAssetLiability> liabilities, List<XsbHxCashFlowStatement> flowStatements, List<XsbHxEquityStructurePerson> structuresPerson, List<XsbHxFinancialRatios> ratios, List<XsbHxIncomeStatement> incomeStatements, List<XsbDfcfMarketMakerStock> makerStocks, XsbThsFinanceJson financeJson);
	
	/**
	 * 股票ID是否已经包含在了表中
	 * @param stockid
	 * @return
	 */
	boolean containsStockid(Integer stockid);
	
	/**
	 * 删除所有的批量数据
	 * @return
	 */
	boolean clearAllBatchData(int[] deleteItems);
	/**
	 * 插入批量数据-定向增发预案
	 * @param placementPlans
	 */
	void insertBatchDataDxzf(List<XsbThsInvestPrivatePlacementPlan> placementPlans);
	/**
	 * 插入批量数据-已完成定向增发
	 * @param placementPlanCompleteds
	 * @param issueObjects
	 */
	void insertBatchDataDxzfwc(List<XsbThsInvestPrivatePlacementPlanCompleted> placementPlanCompleteds,List<XsbThsInvestIssueObject> issueObjects);
	/**
	 * 插入批量数据-定增投资人明细
	 * @param investorDetails
	 */
	void insertBatchDataTzzmx(List<XsbThsInvestAdditionalDetails> investorDetails);

	/**
	 * 插入批量数据-PE-VC投资人明细
	 * @param pevcInvestorDetails
	 */
	void insertBatchDataPevctzzmx(List<XsbThsInvestPevc> pevcInvestorDetails);
	
	/**
	 * 插入批量数据-定增投资人明细
	 * @param investorDetails
	 */
	void insertBatchDataDfcfTzzmx(List<XsbDfcfInvestDetails> investorDetails);

	/**
	 * 插入批量数据-PE-VC投资人明细
	 * @param pevcInvestorDetails
	 */
	void insertBatchDataDfcfPevctzzmx(List<XsbDfcfInvestPevc> pevcInvestorDetails);
	
	
	/**
	 * 删除监控数据
	 * @return
	 */
	boolean clearMonitorData(int[] deleteItems);
	/**
	 * 做市提示
	 * @param zsts
	 */
	void insertMonitorZsts(List<XsbThsMonitorZsts> zsts);
	/**
	 * 增发提示
	 * @param zfts
	 */
	void insertMonitorZfts(List<XsbThsMonitorZfts> zfts);
	/**
	 * 分红提示
	 * @param fhts
	 */
	void insertMonitorFhts(List<XsbThsMonitorFhts> fhts);
	/**
	 * 挂牌提示
	 * @param fhts
	 */
	void insertMonitorGpts(List<XsbThsMonitorGpts> fhts);
	

}
