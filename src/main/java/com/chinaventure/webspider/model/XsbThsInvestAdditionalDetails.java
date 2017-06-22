package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_invest_additional_details")
public class XsbThsInvestAdditionalDetails {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 股票代码(可以重复)
     */
    @Column(name = "stock_code")
    private Integer stockCode;

    /**
     * 事件日期
     */
    @Column(name = "report_date")
    private Date reportDate;

    /**
     * 投资者名称
     */
    @Column(name = "investor_name")
    private String investorName;

    /**
     * 投资者类型
     */
    @Column(name = "investor_type")
    private String investorType;

    /**
     * 企业简称
     */
    @Column(name = "ent_short_name")
    private String entShortName;

    /**
     * 每股价格(元)
     */
    @Column(name = "issue_price")
    private String issuePrice;

    /**
     * 投资数量(万股)
     */
    @Column(name = "number_investment")
    private String numberInvestment;

    /**
     * 投资额(万元)
     */
    @Column(name = "investment_amount")
    private String investmentAmount;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取股票代码(可以重复)
     *
     * @return stock_code - 股票代码(可以重复)
     */
    public Integer getStockCode() {
        return stockCode;
    }

    /**
     * 设置股票代码(可以重复)
     *
     * @param stockCode 股票代码(可以重复)
     */
    public void setStockCode(Integer stockCode) {
        this.stockCode = stockCode;
    }

    /**
     * 获取事件日期
     *
     * @return report_date - 事件日期
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * 设置事件日期
     *
     * @param reportDate 事件日期
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * 获取投资者名称
     *
     * @return investor_name - 投资者名称
     */
    public String getInvestorName() {
        return investorName;
    }

    /**
     * 设置投资者名称
     *
     * @param investorName 投资者名称
     */
    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    /**
     * 获取投资者类型
     *
     * @return investor_type - 投资者类型
     */
    public String getInvestorType() {
        return investorType;
    }

    /**
     * 设置投资者类型
     *
     * @param investorType 投资者类型
     */
    public void setInvestorType(String investorType) {
        this.investorType = investorType;
    }

    /**
     * 获取企业简称
     *
     * @return ent_short_name - 企业简称
     */
    public String getEntShortName() {
        return entShortName;
    }

    /**
     * 设置企业简称
     *
     * @param entShortName 企业简称
     */
    public void setEntShortName(String entShortName) {
        this.entShortName = entShortName;
    }

    /**
     * 获取每股价格(元)
     *
     * @return issue_price - 每股价格(元)
     */
    public String getIssuePrice() {
        return issuePrice;
    }

    /**
     * 设置每股价格(元)
     *
     * @param issuePrice 每股价格(元)
     */
    public void setIssuePrice(String issuePrice) {
        this.issuePrice = issuePrice;
    }

    /**
     * 获取投资数量(万股)
     *
     * @return number_investment - 投资数量(万股)
     */
    public String getNumberInvestment() {
        return numberInvestment;
    }

    /**
     * 设置投资数量(万股)
     *
     * @param numberInvestment 投资数量(万股)
     */
    public void setNumberInvestment(String numberInvestment) {
        this.numberInvestment = numberInvestment;
    }

    /**
     * 获取投资额(万元)
     *
     * @return investment_amount - 投资额(万元)
     */
    public String getInvestmentAmount() {
        return investmentAmount;
    }

    /**
     * 设置投资额(万元)
     *
     * @param investmentAmount 投资额(万元)
     */
    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }
}