package com.chinaventure.webspider.bean;

import java.util.Date;

import javax.persistence.Column;

import com.alibaba.fastjson.JSONArray;

public class ChoiceEntBean {
	/**
	 * 公司需要抓取的项  
	 * 数据格式：name,url,referfer
	 */
	public static String[][] EntItems = {
			//公司简介
//			{"info","http://app.jg.eastmoney.com/F9Stock/GetCompanyIntroductionInfo.do?securityCode={0}&yearList=undefined,undefined&dateSearchType=3&=0&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=0",""},
			{"info","http://app.jg.eastmoney.com/F9Stock/Index.do?securityCode={0}","http://app.jg.eastmoney.com/F9Stock/GetWindowIndustryRankData.do?securityCode={0}.{1}&industry="},
			//曾用名
			{"name_history","http://app.jg.eastmoney.com/F9Stock/GetCompanyNameHistoryList.do?securityCode={0}&rotate=0","http://app.jg.eastmoney.com/html_f9/companyNameHistory.html?securityCode={0}"},
			//经营分析
			{"ManageAnalysis","http://app.jg.eastmoney.com/F9Stock/GetCompanyIntrInfoManageAnalysis.do?securityCode={0}","http://app.jg.eastmoney.com/html_f9/manageAnalysis.html?securityCode={0}"},
			//简史
			{"SimpleAnalysis","http://app.jg.eastmoney.com/F9Stock/GetCompanyIntrInfoSimpleAnalysis.do?securityCode={0}",""},
			
			//参控股子公司
			{"EquityCnotrolledCompany","http://app.jg.eastmoney.com/F9Stock/GetEquityCnotrolledCompanyList.do?securityCode={0}{1}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//股本结构
			{"StockStructure","http://app.jg.eastmoney.com/F9Stock/GetStockStructureList.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=0&customSelect=0",""},
			
			//十大股东明细 HTML格式
			{"Top10Holder","http://app.jg.eastmoney.com/F9Stock/GetTop10HolderListForHTML.do?securityCode={0}{1}&yearList=2017,2016,2015,2014,2013&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//10大流通股东 HTML格式
			{"Top10CirculationShareHolder","http://app.jg.eastmoney.com/F9Stock/GetTop10CirculationShareHolder.do?securityCode={0}{1}&yearList=2017,2016,2015,2014,2013,2012,2011,2010,2009,2008,2007,2006,2005,2004,2003,2002,2001,2000,1999,1998,1997,1996,1995,1994,1993,1992,1991,1990,1989,1988,1987,1986,1985,1984,1983,1982,1981,1980,1979,1978,1977,1976,1975,1974,1973,1972,1971,1970,1969,1968,1967,1966,1965,1964,1963,1962,1961,1960,1959,1958,1957,1956,1955,1954,1953,1952,1951,1950,1949,1948,1947,1946,1945,1944,1943,1942,1941,1940,1939,1938,1937,1936,1935,1934,1933,1932,1931,1930,1929,1928,1927,1926,1925,1924,1923,1922,1921,1920,1919,1918,1917,1916&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//机构投资者 HTML格式
			{"InstitutionInvestor","http://app.jg.eastmoney.com/F9Stock/GetInstitutionInvestorListForHTML.do?securityCode={0}{1}&filedOrder=desc&sort=SHAREHDNUM&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//基金持股统计 HTML格式
			{"FundHoldStatistic","http://app.jg.eastmoney.com/F9Stock/GetFundHoldStatisticForHTML.do?securityCode={0}{1}&filedOrder=desc&sort=DEC_HOLDSHARE&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},

			//董事会(现任)
			{"ManagerInfoType1","http://app.jg.eastmoney.com/F9Stock/getManagerInfo.do?securityCode={0}&type=1&yearList=undefined,undefined&dateSearchType=3&=0&rotate=1&seperate=0&order=asc&cashType=0&exchangeValue=0",""},
			//监事会(现任)
			{"ManagerInfoType2","http://app.jg.eastmoney.com/F9Stock/getManagerInfo.do?securityCode={0}&type=2&yearList=undefined,undefined&dateSearchType=3&=0&rotate=1&seperate=0&order=asc&cashType=0&exchangeValue=0",""},
			//高级管理人员(现任)
			{"ManagerInfoType3","http://app.jg.eastmoney.com/F9Stock/getManagerInfo.do?securityCode={0}&type=3&yearList=undefined,undefined&dateSearchType=3&=0&rotate=1&seperate=0&order=asc&cashType=0&exchangeValue=0",""},
			//历任管理层成员
			{"ManagerInfoType4","http://app.jg.eastmoney.com/F9Stock/getManagerInfo.do?securityCode={0}&type=4&yearList=undefined,undefined&dateSearchType=3&directorType=1&rotate=1&seperate=0&order=asc&cashType=0&exchangeValue=0",""},
			//管理层持股及报酬
			{"ManagementRemuneration","http://app.jg.eastmoney.com/F9Stock/ManagementRemuneration.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&reportTypeList=5,6&dateSearchType=1&=0&rotate=1&seperate=1&order=desc&cashType=1&exchangeValue=1&customSelect=0",""},
			//管理层持股变化
			{"ManagementStockChange","http://app.jg.eastmoney.com/F9Stock/ManagementStockChange.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&dateSearchType=1&=0&rotate=1&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},

			//每日行情数据统计
			{"DailyMarketData","http://app.jg.eastmoney.com/F9Stock/GetDailyMarketDataListForReport.do?securityCode={0}{1}&yearList=2017,2016,2015,2014&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=1&customSelect=0",""},

			//资产负债  1:普通报表  2:销售百分比 3：资产百分比  4:同比增长率
			{"AssetDebtOrdinary","http://app.jg.eastmoney.com/F9Stock/AssetDebt.do?securityCode={0}{1}&companyType=&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&listedType=0,1&reportTypeInScope=1,2,3,4&reportType=1&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=1&CurrencySelect=0",""},
			{"AssetDebtSales","http://app.jg.eastmoney.com/F9Stock/AssetDebt.do?securityCode={0}{1}&companyType=&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&listedType=0,1&reportTypeInScope=1,2,3,4&reportType=2&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=2&CurrencySelect=0",""},
			{"AssetDebtAssets","http://app.jg.eastmoney.com/F9Stock/AssetDebt.do?securityCode={0}{1}&companyType=&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&listedType=0,1&reportTypeInScope=1,2,3,4&reportType=3&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=3&CurrencySelect=0",""},
			{"AssetDebtGrowth","http://app.jg.eastmoney.com/F9Stock/AssetDebt.do?securityCode={0}{1}&companyType=&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&listedType=0,1&reportTypeInScope=1,2,3,4&reportType=4&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=4&CurrencySelect=0",""},
				  
			//利润表   1:普通报表  2:销售百分比 3:同比增长率
			{"ProfitTableOrdinary","http://app.jg.eastmoney.com/F9Stock/ProfitTable.do?securityCode={0}{1}&companyType=&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&listedType=0,1&reportTypeInScope=1&reportType=1&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=1&CurrencySelect=0",""},
			{"ProfitTableSales","http://app.jg.eastmoney.com/F9Stock/ProfitTable.do?securityCode={0}{1}&companyType=&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&listedType=0,1&reportTypeInScope=1&reportType=2&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=2&CurrencySelect=0",""},
			{"ProfitTableGrowth","http://app.jg.eastmoney.com/F9Stock/ProfitTable.do?securityCode={0}{1}&companyType=&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&listedType=0,1&reportTypeInScope=1&reportType=3&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=3&CurrencySelect=0",""},
			
			//现金流量表  1:普通报表  2:同比增长率
			{"CashFlowTableOrdinary","http://app.jg.eastmoney.com/F9Stock/CashFlowTable.do?securityCode={0}{1}&companyType=&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&listedType=0,1&reportTypeInScope=1&reportType=1&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=1&CurrencySelect=0",""},				  
			{"CashFlowTableGrowth","http://app.jg.eastmoney.com/F9Stock/CashFlowTable.do?securityCode={0}{1}&companyType=&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&listedType=0,1&reportTypeInScope=1&reportType=2&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=2&CurrencySelect=0",""},

			//分红
			{"ShareRed","http://app.jg.eastmoney.com/F9Stock/ShareRed.do?securityCode={0}{1}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//配股
			{"MatchStock","http://app.jg.eastmoney.com/F9Stock/MatchStock.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=0",""},
			//增发
			{"ZengFa","http://app.jg.eastmoney.com/F9Stock/ZengFa.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=0",""},

			//每股指标
			{"EachStockIndex","http://app.jg.eastmoney.com/F9Stock/EachStockIndex.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//盈利能力与收益质量
			{"ProfitAndQuantity","http://app.jg.eastmoney.com/F9Stock/ProfitAndQuantity.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//资本结构与偿债能力
			{"CapitalAndRepay","http://app.jg.eastmoney.com/F9Stock/CapitalAndRepay.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//营运能力
			{"BussinessAbility","http://app.jg.eastmoney.com/F9Stock/BussinessAbilityModel_Report.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//成长能力
			{"GrowthAbility","http://app.jg.eastmoney.com/F9Stock/GrowthAbility.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//现金流量
			{"CashFlow","http://app.jg.eastmoney.com/F9Stock/CashFlow.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//杜邦分析
			{"DuBangAnaysis","http://app.jg.eastmoney.com/F9Stock/DuBangAnaysis.do?securityCode={0}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0",""},
			//单季度财务指标										
			{"SingleMonthFinanceIndex","http://app.jg.eastmoney.com/F9Stock/SingleMonthFinanceIndex.do?securityCode={0}{1}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,2,3,4&dateSearchType=1&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=0&CurrencySelect=0",""},
			//银行业专项指标
			{"BankIndex","http://app.jg.eastmoney.com/F9Stock/BankIndex.do?securityCode={0}{1}&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&=0&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=0",""},
			
			//所属行业
			{"IndustryInfo","http://app.jg.eastmoney.com/F9Stock/GetIndustryInfo.do?securityCode={0}&yearList=undefined,undefined&dateSearchType=3&industryType=1&rotate=0&seperate=0&order=desc&cashType=0&exchangeValue=0&customSelect=1",""},

			//财务数据-主营构成
			//按项目名称展示
			{"MainBusinessStructReport_ProjectName","http://app.jg.eastmoney.com/F9Stock/MainBusinessStructReport.do?securityCode={0}{1}&rotate=2&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&type=%E4%BA%A7%E5%93%81&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=%E4%BA%A7%E5%93%81",""},
			//按行业分类
			{"MainBusinessStructReport_Industy","http://app.jg.eastmoney.com/F9Stock/MainBusinessStructReport.do?securityCode={0}{1}&type=%E8%A1%8C%E4%B8%9A&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&method=1&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=1",""},
			//按产品(项目)分类
			{"MainBusinessStructReport_Product","http://app.jg.eastmoney.com/F9Stock/MainBusinessStructReport.do?securityCode={0}{1}&type=%E4%BA%A7%E5%93%81&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&method=1&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=1",""},
			//按地区分类
			{"MainBusinessStructReport_Area","http://app.jg.eastmoney.com/F9Stock/MainBusinessStructReport.do?securityCode={0}{1}&type=%E5%9C%B0%E5%8C%BA&yearList=2017,2016,2015,2014,2013&reportTypeList=1,5,3,6&dateSearchType=1&method=1&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=1",""}
	};
	
	
	
	/**
	 * 参控股公司
	 */
	public String EquityCnotrolledCompany;

	/**
	 * 股本结构
	 */
	public String StockStructure;

	
	/**
	 * 10大股东明细
	 */
	public String Top10Holder;

	
	/**
	 * 10大流通股东
	 */
	public String Top10CirculationShareHolder;
	
	/**
	 * 机构投资者 HTML格式
	 */
	public String InstitutionInvestor;
	/**
	 * 基金持股统计 HTML格式
	 */
	public String FundHoldStatistic;

	
    
/**
 * 董事会(现任)
 */
public String ManagerInfoType1;

/**
 * 监事会(现任)  
 */                        
public String ManagerInfoType2; 
/**
 *高级管理人员(现任) 
 */
public String ManagerInfoType3;                     
/**
 *历任管理层成员 
 */
public String ManagerInfoType4;         
                      
/**
 *	管理层持股及报酬 
 */
public String ManagementRemuneration;   
/**
 * 管理层持股变化             
 */
public String ManagementStockChange;           
/**
 * 每日行情数据统计 
 */
public String DailyMarketData;     


/**
 * 资产负债-普通报表
 */
public String AssetDebtOrdinary;
/**
 * 资产负债-销售百分比
 */
public String AssetDebtSales;
/**
 * 资产负债-资产百分比
 */
public String AssetDebtAssets;
/**
 * 资产负债-同比增长率
 */
public String AssetDebtGrowth;


/**
 *利润表 -普通报表
 */
public String ProfitTableOrdinary;  
/**
 *利润表 -销售百分比
 */
public String ProfitTableSales;
/**
 *利润表 -同比增长率
 */
public String ProfitTableGrowth;

/**
 * 现金流量表
 */
public String CashFlowTableOrdinary;            
/**
 * 现金流量表-同比增长率
 */
public String CashFlowTableGrowth;



/**
 * 分红 
 */
public String ShareRed;                 
/**
 * 配股                                  
 */
public String MatchStock;               
/**
 * 增发                                  
 */
public String ZengFa;                   
/**
 * 每股指标                              
 */
public String EachStockIndex;           
/**
 *盈利能力与收益质量 
 */
public String ProfitAndQuantity;        
/**
 *资本结构与偿债能力 
 */
public String CapitalAndRepay;          
/**
 *营运能力 
 */
public String BussinessAbility;         
/**
 *成长能力 
 */
public String GrowthAbility;            
/**
 *现金流量 
 */
public String CashFlow;
/**
 *杜邦分析 
 */
public String DuBangAnaysis;            
/**
 *单季度财务指标 
 */
public String SingleMonthFinanceIndex;              
/**
 *银行业专项指标 
 */
public String BankIndex;                

/**
 *	所属行业 
 */
public String IndustryInfo;

//财务数据-主营构成
/**
 *	按项目名称展示 
 */
public String MainBusinessStructReport_ProjectName;

/**
 *	按行业分类 
 */
public String MainBusinessStructReport_Industy;

/**
 *	按产品(项目)分类 
 */
public String MainBusinessStructReport_Product;

/**
 *	按地区分类 
 */
public String MainBusinessStructReport_Area;



	/**
     * 下载使用的COOKIE编号
     */
    private String cookie;

	/**
     * 启信宝的UUID(公司ID)
     */
    private String code;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
    
    
    /**
     * 公司基本信息
     */
    private JSONArray info;
    
   

	/**
     * 获取启信宝的UUID(公司ID)
     *
     * @return uuid - 启信宝的UUID(公司ID)
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置启信宝的UUID(公司ID)
     *
     * @param uuid 启信宝的UUID(公司ID)
     */
    public void setCode(String uuid) {
        this.code = uuid;
    }

    /**
     * 获取公司名称
     *
     * @return name - 公司名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司名称
     *
     * @param name 公司名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public JSONArray getInfo() {
		return info;
	}

	public void setInfo(JSONArray entInfo) {
		this.info = entInfo;
	}
	
	/**
     * 下载使用的COOKIE编号
     */
	public String getCookie() {
		return cookie;
	}

	/**
     * 下载使用的COOKIE编号
     */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
}
