package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_monitor_gpts")
public class XsbThsMonitorGpts {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联公司ID
     */
    @Column(name = "ent_id")
    private Integer entId;

    /**
     * 发行对象
     */
    @Column(name = "stock_name")
    private String stockName;

    /**
     * 最新价
     */
    @Column(name = "latest_price")
    private String latestPrice;

    /**
     * 市值(亿)
     */
    @Column(name = "market_value")
    private String marketValue;

    /**
     * 转让方式
     */
    @Column(name = "transfer_mode")
    private String transferMode;

    /**
     * 主办券商
     */
    @Column(name = "sponsored_broker")
    private String sponsoredBroker;

    /**
     * 流通股本(万股)
     */
    @Column(name = "tradable_capital")
    private String tradableCapital;

    /**
     * 总股本(万股)
     */
    @Column(name = "share_capital")
    private String shareCapital;

    /**
     * 所属行业
     */
    @Column(name = "owned_industry")
    private String ownedIndustry;

    /**
     * 挂牌日期
     */
    @Column(name = "start_date")
    private Date startDate;

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
     * 获取关联公司ID
     *
     * @return ent_id - 关联公司ID
     */
    public Integer getEntId() {
        return entId;
    }

    /**
     * 设置关联公司ID
     *
     * @param entId 关联公司ID
     */
    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    /**
     * 获取发行对象
     *
     * @return stock_name - 发行对象
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * 设置发行对象
     *
     * @param stockName 发行对象
     */
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    /**
     * 获取最新价
     *
     * @return latest_price - 最新价
     */
    public String getLatestPrice() {
        return latestPrice;
    }

    /**
     * 设置最新价
     *
     * @param latestPrice 最新价
     */
    public void setLatestPrice(String latestPrice) {
        this.latestPrice = latestPrice;
    }

    /**
     * 获取市值(亿)
     *
     * @return market_value - 市值(亿)
     */
    public String getMarketValue() {
        return marketValue;
    }

    /**
     * 设置市值(亿)
     *
     * @param marketValue 市值(亿)
     */
    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    /**
     * 获取转让方式
     *
     * @return transfer_mode - 转让方式
     */
    public String getTransferMode() {
        return transferMode;
    }

    /**
     * 设置转让方式
     *
     * @param transferMode 转让方式
     */
    public void setTransferMode(String transferMode) {
        this.transferMode = transferMode;
    }

    /**
     * 获取主办券商
     *
     * @return sponsored_broker - 主办券商
     */
    public String getSponsoredBroker() {
        return sponsoredBroker;
    }

    /**
     * 设置主办券商
     *
     * @param sponsoredBroker 主办券商
     */
    public void setSponsoredBroker(String sponsoredBroker) {
        this.sponsoredBroker = sponsoredBroker;
    }

    /**
     * 获取流通股本(万股)
     *
     * @return tradable_capital - 流通股本(万股)
     */
    public String getTradableCapital() {
        return tradableCapital;
    }

    /**
     * 设置流通股本(万股)
     *
     * @param tradableCapital 流通股本(万股)
     */
    public void setTradableCapital(String tradableCapital) {
        this.tradableCapital = tradableCapital;
    }

    /**
     * 获取总股本(万股)
     *
     * @return share_capital - 总股本(万股)
     */
    public String getShareCapital() {
        return shareCapital;
    }

    /**
     * 设置总股本(万股)
     *
     * @param shareCapital 总股本(万股)
     */
    public void setShareCapital(String shareCapital) {
        this.shareCapital = shareCapital;
    }

    /**
     * 获取所属行业
     *
     * @return owned_industry - 所属行业
     */
    public String getOwnedIndustry() {
        return ownedIndustry;
    }

    /**
     * 设置所属行业
     *
     * @param ownedIndustry 所属行业
     */
    public void setOwnedIndustry(String ownedIndustry) {
        this.ownedIndustry = ownedIndustry;
    }

    /**
     * 获取挂牌日期
     *
     * @return start_date - 挂牌日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置挂牌日期
     *
     * @param startDate 挂牌日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}