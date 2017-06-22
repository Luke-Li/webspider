package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_invest_private_placement_plan")
public class XsbThsInvestPrivatePlacementPlan {
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
     * 企业简称
     */
    @Column(name = "ent_short_name")
    private String entShortName;

    /**
     * 事件日期
     */
    @Column(name = "report_date")
    private Date reportDate;

    /**
     * 最新进度
     */
    @Column(name = "latest_progress")
    private String latestProgress;

    /**
     * 发行价格(元)
     */
    @Column(name = "issue_price")
    private String issuePrice;

    /**
     * 发行数量(万股)
     */
    @Column(name = "number_issued")
    private String numberIssued;

    /**
     * 募集资金(万元)
     */
    @Column(name = "raise_funds")
    private String raiseFunds;

    /**
     * 融资市盈率
     */
    @Column(name = "earnings_ratio")
    private String earningsRatio;

    /**
     * 溢价率
     */
    @Column(name = "premium_rate")
    private String premiumRate;

    /**
     * 发行对象
     */
    @Column(name = "issue_object")
    private String issueObject;

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
     * 获取最新进度
     *
     * @return latest_progress - 最新进度
     */
    public String getLatestProgress() {
        return latestProgress;
    }

    /**
     * 设置最新进度
     *
     * @param latestProgress 最新进度
     */
    public void setLatestProgress(String latestProgress) {
        this.latestProgress = latestProgress;
    }

    /**
     * 获取发行价格(元)
     *
     * @return issue_price - 发行价格(元)
     */
    public String getIssuePrice() {
        return issuePrice;
    }

    /**
     * 设置发行价格(元)
     *
     * @param issuePrice 发行价格(元)
     */
    public void setIssuePrice(String issuePrice) {
        this.issuePrice = issuePrice;
    }

    /**
     * 获取发行数量(万股)
     *
     * @return number_issued - 发行数量(万股)
     */
    public String getNumberIssued() {
        return numberIssued;
    }

    /**
     * 设置发行数量(万股)
     *
     * @param numberIssued 发行数量(万股)
     */
    public void setNumberIssued(String numberIssued) {
        this.numberIssued = numberIssued;
    }

    /**
     * 获取募集资金(万元)
     *
     * @return raise_funds - 募集资金(万元)
     */
    public String getRaiseFunds() {
        return raiseFunds;
    }

    /**
     * 设置募集资金(万元)
     *
     * @param raiseFunds 募集资金(万元)
     */
    public void setRaiseFunds(String raiseFunds) {
        this.raiseFunds = raiseFunds;
    }

    /**
     * 获取融资市盈率
     *
     * @return earnings_ratio - 融资市盈率
     */
    public String getEarningsRatio() {
        return earningsRatio;
    }

    /**
     * 设置融资市盈率
     *
     * @param earningsRatio 融资市盈率
     */
    public void setEarningsRatio(String earningsRatio) {
        this.earningsRatio = earningsRatio;
    }

    /**
     * 获取溢价率
     *
     * @return premium_rate - 溢价率
     */
    public String getPremiumRate() {
        return premiumRate;
    }

    /**
     * 设置溢价率
     *
     * @param premiumRate 溢价率
     */
    public void setPremiumRate(String premiumRate) {
        this.premiumRate = premiumRate;
    }

    /**
     * 获取发行对象
     *
     * @return issue_object - 发行对象
     */
    public String getIssueObject() {
        return issueObject;
    }

    /**
     * 设置发行对象
     *
     * @param issueObject 发行对象
     */
    public void setIssueObject(String issueObject) {
        this.issueObject = issueObject;
    }
}