package com.chinaventure.webspider.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaventure.webspider.mapper.XsbDfcfInvestDetailsMapper;
import com.chinaventure.webspider.mapper.XsbDfcfInvestPevcMapper;
import com.chinaventure.webspider.mapper.XsbDfcfMarketMakerStockMapper;
import com.chinaventure.webspider.mapper.XsbHxAssetLiabilityMapper;
import com.chinaventure.webspider.mapper.XsbHxCashFlowStatementMapper;
import com.chinaventure.webspider.mapper.XsbHxEquityStructurePersonMapper;
import com.chinaventure.webspider.mapper.XsbHxFinancialRatiosMapper;
import com.chinaventure.webspider.mapper.XsbHxIncomeStatementMapper;
import com.chinaventure.webspider.mapper.XsbThsAdditionalMapper;
import com.chinaventure.webspider.mapper.XsbThsDividendsMapper;
import com.chinaventure.webspider.mapper.XsbThsEntManageteamMapper;
import com.chinaventure.webspider.mapper.XsbThsEntMapper;
import com.chinaventure.webspider.mapper.XsbThsEquityStructureMapper;
import com.chinaventure.webspider.mapper.XsbThsFinanceJsonMapper;
import com.chinaventure.webspider.mapper.XsbThsHoldingCompanyMapper;
import com.chinaventure.webspider.mapper.XsbThsInvestAdditionalDetailsMapper;
import com.chinaventure.webspider.mapper.XsbThsInvestIssueObjectMapper;
import com.chinaventure.webspider.mapper.XsbThsInvestPevcMapper;
import com.chinaventure.webspider.mapper.XsbThsInvestPrivatePlacementPlanCompletedMapper;
import com.chinaventure.webspider.mapper.XsbThsInvestPrivatePlacementPlanMapper;
import com.chinaventure.webspider.mapper.XsbThsMonitorFhtsMapper;
import com.chinaventure.webspider.mapper.XsbThsMonitorGptsMapper;
import com.chinaventure.webspider.mapper.XsbThsMonitorZftsMapper;
import com.chinaventure.webspider.mapper.XsbThsMonitorZstsMapper;
import com.chinaventure.webspider.mapper.XsbThsQuotaChangeMapper;
import com.chinaventure.webspider.mapper.XsbThsRecentImportantEventsMapper;
import com.chinaventure.webspider.mapper.XsbThsShareholderSharepriceCompareMapper;
import com.chinaventure.webspider.mapper.XsbThsShareholdersMapper;
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
import com.chinaventure.webspider.service.XsbEnterpriseService;

/**
 * 企业管理类
 * 
 * @author Administrator
 *
 */
@Service
public class XsbEnterpriseServiceImpl extends BaseService<XsbThsEnt> implements XsbEnterpriseService {

	Logger log = Logger.getLogger(getClass());
	// 和讯网
	@Autowired
	XsbHxAssetLiabilityMapper hxAssetLiabilityMapper;
	@Autowired
	XsbHxCashFlowStatementMapper hxCashFlowMapper;
	@Autowired
	XsbHxEquityStructurePersonMapper hxEquityStructurePersonMapper;
	@Autowired
	XsbHxFinancialRatiosMapper hxFinancialRatiosMapper;
	@Autowired
	XsbHxIncomeStatementMapper hxIncomeStatementMapper;

	// 同花顺
	@Autowired
	XsbThsEntMapper thxEntMapper;
	@Autowired
	XsbThsEntManageteamMapper thxManageteamMapper;
	@Autowired
	XsbThsEquityStructureMapper thxEquityStructureMapper;
	@Autowired
	XsbThsHoldingCompanyMapper thxHoldingCompanyMapper;
	@Autowired
	XsbThsQuotaChangeMapper thxQuotaChangeMapper;
	@Autowired
	XsbThsShareholderSharepriceCompareMapper thxShareholderSharepriceCompareMapper;
	@Autowired
	XsbThsShareholdersMapper thxShareholdersMapper;
	@Autowired
	XsbThsDividendsMapper thxDividendsMapper;
	@Autowired
	XsbThsAdditionalMapper thxAdditionalMapper;
	@Autowired
	XsbThsRecentImportantEventsMapper thxRecentImportantEventsMapper;
	@Autowired
	XsbThsFinanceJsonMapper financeJsonMapper;

	// 东方财富做市商库存数据
	@Autowired
	XsbDfcfMarketMakerStockMapper dfcfMarketMakerStockMapper;
	//监控数据
	@Autowired
	XsbThsMonitorZstsMapper xsbThsMonitorZstsMapper;
	@Autowired
	XsbThsMonitorZftsMapper xsbThsMonitorZftsMapper;
	@Autowired
	XsbThsMonitorFhtsMapper xsbThsMonitorFhtsMapper;
	@Autowired
	XsbThsMonitorGptsMapper xsbThsMonitorGptsMapper;
	
	
	
	/**
	 * 清除数据
	 * 
	 * @param stockCode
	 * @return
	 */
	private boolean clearHistoryData(Integer stockCode) {
			thxEntMapper.delete(new XsbThsEnt() {
				{
					setStockCode(stockCode);
				}
			});
			thxManageteamMapper.delete(new XsbThsEntManageteam() {
				{
					setEntId(stockCode);
				}
			});
			thxHoldingCompanyMapper.delete(new XsbThsHoldingCompany() {
				{
					setEntId(stockCode);
				}
			});
			thxQuotaChangeMapper.delete(new XsbThsQuotaChange() {
				{
					setEntId(stockCode);
				}
			});
			thxShareholderSharepriceCompareMapper.delete(new XsbThsShareholderSharepriceCompare() {
				{
					setEntId(stockCode);
				}
			});
			thxShareholdersMapper.delete(new XsbThsShareholders() {
				{
					setEntId(stockCode);
				}
			});
			thxEquityStructureMapper.delete(new XsbThsEquityStructure() {
				{
					setEntId(stockCode);
				}
			});
			thxDividendsMapper.delete(new XsbThsDividends() {
				{
					setEntId(stockCode);
				}
			});
			thxAdditionalMapper.delete(new XsbThsAdditional() {
				{
					setEntId(stockCode);
				}
			});
			thxRecentImportantEventsMapper.delete(new XsbThsRecentImportantEvents() {
				{
					setEntId(stockCode);
				}
			});

			// 删除和讯数据
			hxAssetLiabilityMapper.delete(new XsbHxAssetLiability() {
				{
					setEntId(stockCode);
				}
			});
			hxCashFlowMapper.delete(new XsbHxCashFlowStatement() {
				{
					setEntId(stockCode);
				}
			});
			hxEquityStructurePersonMapper.delete(new XsbHxEquityStructurePerson() {
				{
					setEntId(stockCode);
				}
			});
			hxFinancialRatiosMapper.delete(new XsbHxFinancialRatios() {
				{
					setEntId(stockCode);
				}
			});
			hxIncomeStatementMapper.delete(new XsbHxIncomeStatement() {
				{
					setEntId(stockCode);
				}
			});
			// 东方财富
			dfcfMarketMakerStockMapper.delete(new XsbDfcfMarketMakerStock() {
				{
					setEntId(stockCode);
				}
			});

			financeJsonMapper.delete(new XsbThsFinanceJson(){
				{
					setEntId(stockCode);
				}
			});
			
		return true;
	}

	@Override
	public boolean containsStockid(Integer stockid) {
		XsbThsEnt model = thxEntMapper.selectOne(new XsbThsEnt() {
			{
				setStockCode(stockid);
			}
		});
		return model == null ? false : true;
	}

	@Override
	public boolean insertEnterpriseData(XsbThsEnt enterprise, List<XsbThsEntManageteam> manageteams,
			List<XsbThsHoldingCompany> holdingCompanies, List<XsbThsQuotaChange> quotas,
			List<XsbThsShareholderSharepriceCompare> shareholderSharepriceCompares,
			List<XsbThsShareholders> topShareholders, List<XsbThsEquityStructure> structures,
			List<XsbThsDividends> dividends, List<XsbThsAdditional> additionals,
			List<XsbThsRecentImportantEvents> events, List<XsbHxAssetLiability> liabilities,
			List<XsbHxCashFlowStatement> flowStatements, List<XsbHxEquityStructurePerson> structuresPerson,
			List<XsbHxFinancialRatios> ratios, List<XsbHxIncomeStatement> incomeStatements,
			List<XsbDfcfMarketMakerStock> makerStocks,XsbThsFinanceJson financeJson) {
		try {

			if (enterprise.getStockCode() == null || enterprise.getStockCode() == 0) {
				log.error("插入数据时未提供股票代码");
				return false;
			}

			if (enterprise != null) {
				clearHistoryData(enterprise.getStockCode());
			}

			Date now = new Date();

			enterprise.setCreateTime(now);
			enterprise.setUpdateTime(now);
			thxEntMapper.insert(enterprise);
			int entId = enterprise.getStockCode();

			if (manageteams.size() > 0) {
				for (XsbThsEntManageteam enterpriseManageteam : manageteams) {
					enterpriseManageteam.setEntId(entId);
					enterpriseManageteam.setCreateTime(now);
					enterpriseManageteam.setUpdateTime(now);
				}
				thxManageteamMapper.insertList(manageteams);
			}

			if (holdingCompanies.size() > 0) {
				for (XsbThsHoldingCompany model : holdingCompanies) {
					model.setEntId(entId);
					model.setCreateTime(now);
					model.setUpdateTime(now);
				}
				thxHoldingCompanyMapper.insertList(holdingCompanies);
			}

			if (quotas.size() > 0) {
				for (XsbThsQuotaChange model : quotas) {
					model.setEntId(entId);
					model.setCreateTime(now);
					model.setUpdateTime(now);
				}
				thxQuotaChangeMapper.insertList(quotas);
			}

			if (shareholderSharepriceCompares.size() > 0) {
				for (XsbThsShareholderSharepriceCompare model : shareholderSharepriceCompares) {
					model.setEntId(entId);
					model.setCreateTime(now);
					model.setUpdateTime(now);
				}
				thxShareholderSharepriceCompareMapper.insertList(shareholderSharepriceCompares);
			}

			if (topShareholders.size() > 0) {
				for (XsbThsShareholders model : topShareholders) {
					model.setEntId(entId);
					model.setCreateTime(now);
					model.setUpdateTime(now);
				}
				thxShareholdersMapper.insertList(topShareholders);
			}

			if (structures.size() > 0) {
				for (XsbThsEquityStructure model : structures) {
					model.setEntId(entId);
				}
				thxEquityStructureMapper.insertList(structures);
			}
			if (dividends.size() > 0) {
				for (XsbThsDividends model : dividends) {
					model.setEntId(entId);
				}

				thxDividendsMapper.insertList(dividends);
			}
			if (additionals.size() > 0) {
				for (XsbThsAdditional model : additionals) {
					model.setEntId(entId);
				}

				thxAdditionalMapper.insertList(additionals);
			}
			if (events.size() > 0) {
				for (XsbThsRecentImportantEvents model : events) {
					model.setEntId(entId);
				}
				thxRecentImportantEventsMapper.insertList(events);
			}
			// 和讯数据处理
			if (liabilities.size() > 0) {
				for (XsbHxAssetLiability model : liabilities) {
					model.setEntId(entId);
				}
				hxAssetLiabilityMapper.insertList(liabilities);
			}
			if (flowStatements.size() > 0) {
				for (XsbHxCashFlowStatement model : flowStatements) {
					model.setEntId(entId);
				}
				hxCashFlowMapper.insertList(flowStatements);
			}
			if (structuresPerson.size() > 0) {
				for (XsbHxEquityStructurePerson model : structuresPerson) {
					model.setEntId(entId);
				}
				hxEquityStructurePersonMapper.insertList(structuresPerson);
			}
			if (ratios.size() > 0) {
				for (XsbHxFinancialRatios model : ratios) {
					model.setEntId(entId);
				}
				hxFinancialRatiosMapper.insertList(ratios);
			}
			if (incomeStatements.size() > 0) {
				for (XsbHxIncomeStatement model : incomeStatements) {
					model.setEntId(entId);
				}
				hxIncomeStatementMapper.insertList(incomeStatements);
			}
			// 东方财富数据
			if (makerStocks.size() > 0) {
				for (XsbDfcfMarketMakerStock model : makerStocks) {
					model.setEntId(entId);
				}
				dfcfMarketMakerStockMapper.insertList(makerStocks);
			}
			
			financeJson.setEntId(entId);
			financeJson.setCreateTime(now);
			financeJson.setUpdateTime(now);

			financeJsonMapper.insert(financeJson);
			
			log.info(String.format("公司 ID：%d  name:%s 入库完成", enterprise.getStockCode(), enterprise.getCnShort()));
			return true;
		} catch (Exception e) {
			log.fatal("处理企业数据", e);
			return false;
		}
	}
	
	/*----------------------------------批量数据处理----------------------------------*/

	// 同花顺综合数据
	@Autowired
	XsbThsInvestPrivatePlacementPlanMapper thsPrivatePlacementPlanMapper;
	@Autowired
	XsbThsInvestPrivatePlacementPlanCompletedMapper thsPrivatePlacementPlanCompletedMapper;
	@Autowired
	XsbThsInvestIssueObjectMapper issueObjectMapper;
	@Autowired
	XsbThsInvestAdditionalDetailsMapper thsAdditionalInvestorDetailsMapper;
	@Autowired
	XsbThsInvestPevcMapper thsPevcInvestmentDetailsMapper;
	
	
	@Autowired
	XsbDfcfInvestDetailsMapper dfcfInvestDetailsMapper;
	@Autowired
	XsbDfcfInvestPevcMapper dfcfInvestPevcMapper;
	
	
	
	@Override
	public boolean clearAllBatchData(int[] deleteItems) {
		for (int item : deleteItems) {
			switch (item) {
			case 0:
				thsPrivatePlacementPlanMapper.delete(null);
				break;
			case 1:
				issueObjectMapper.delete(null);
				thsPrivatePlacementPlanCompletedMapper.delete(null);
				break;
			case 2:
				thsAdditionalInvestorDetailsMapper.delete(null);
				break;
			case 3:
				thsPevcInvestmentDetailsMapper.delete(null);
				break;
				
			case 4:
				dfcfInvestDetailsMapper.delete(null);
				break;
			case 5:
				dfcfInvestPevcMapper.delete(null);
				break;
				
			default:
				break;
			}
		}
		return true;
	}

	@Override
	public void insertBatchDataDxzf(List<XsbThsInvestPrivatePlacementPlan> placementPlans) {
		if (placementPlans.size() != 0)
		thsPrivatePlacementPlanMapper.insertList(placementPlans);
	}

	@Override
	public void insertBatchDataDxzfwc(List<XsbThsInvestPrivatePlacementPlanCompleted> placementPlanCompleteds,List<XsbThsInvestIssueObject> issueObjects) {
		if (placementPlanCompleteds.size() != 0)
			thsPrivatePlacementPlanCompletedMapper.insertList(placementPlanCompleteds);
		if (issueObjects.size() != 0)
			issueObjectMapper.insertList(issueObjects);

	}

	
	@Override
	public void insertBatchDataTzzmx(List<XsbThsInvestAdditionalDetails> investorDetails) {
		if (investorDetails.size() != 0)
		thsAdditionalInvestorDetailsMapper.insertList(investorDetails);
	}

	@Override
	public void insertBatchDataPevctzzmx(List<XsbThsInvestPevc> pevcInvestorDetails) {
		if (pevcInvestorDetails.size() != 0)
		thsPevcInvestmentDetailsMapper.insertList(pevcInvestorDetails);
	}
	

	
	@Override
	public void insertBatchDataDfcfTzzmx(List<XsbDfcfInvestDetails> investorDetails) {
		if(investorDetails.size()!=0)
			dfcfInvestDetailsMapper.insertList(investorDetails);
		
	}
	
	
	@Override
	public void insertBatchDataDfcfPevctzzmx(List<XsbDfcfInvestPevc> pevcInvestorDetails) {
		if (pevcInvestorDetails.size()!=0) {
			dfcfInvestPevcMapper.insertList(pevcInvestorDetails);
		}
	}
	
	/*-----------------------------------------监控数据-----------------------------------*/
	@Override
	public boolean clearMonitorData(int[] deleteItems) {
		for (int item : deleteItems) {
			switch (item) {
			case 0:
				xsbThsMonitorZstsMapper.delete(null);
				break;
			case 1:
				xsbThsMonitorZftsMapper.delete(null);
				break;
			case 2:
				xsbThsMonitorFhtsMapper.delete(null);
				break;
			case 3:
				xsbThsMonitorGptsMapper.delete(null);
				break;
			default:
				break;
			}
		}
		return true;
	}

	@Override
	public void insertMonitorZsts(List<XsbThsMonitorZsts> zsts) {
		if (zsts.size() != 0)
			xsbThsMonitorZstsMapper.insertList(zsts);
	}

	@Override
	public void insertMonitorZfts(List<XsbThsMonitorZfts> zfts) {
		if (zfts.size() != 0)
			xsbThsMonitorZftsMapper.insertList(zfts);
	}

	@Override
	public void insertMonitorFhts(List<XsbThsMonitorFhts> fhts) {
		if (fhts.size() != 0)
			xsbThsMonitorFhtsMapper.insertList(fhts);
	}

	@Override
	public void insertMonitorGpts(List<XsbThsMonitorGpts> gpts) {
		if (gpts.size() != 0)
			xsbThsMonitorGptsMapper.insertList(gpts);
		
	}
}