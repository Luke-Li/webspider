package com.chinaventure.webspider.model;

import javax.persistence.*;

@Table(name = "xsb_ths_monitor_zsts")
public class XsbThsMonitorZsts {
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
     * 做市商总数
     */
    @Column(name = "market_makers_num")
    private String marketMakersNum;

    /**
     * 提示信息
     */
    private String tip;

    /**
     * 总股本(万股)
     */
    @Column(name = "share_capital")
    private String shareCapital;

    /**
     * 总市值(万元)
     */
    @Column(name = "market_value")
    private String marketValue;

    /**
     * 做市首日前收盘价(元)
     */
    @Column(name = "first_closing_price")
    private String firstClosingPrice;

    /**
     * 做市首日涨跌幅	
     */
    @Column(name = "rise_fall")
    private String riseFall;

    /**
     * 做市起始日
     */
    @Column(name = "start_date")
    private String startDate;

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
     * 获取做市商总数
     *
     * @return market_makers_num - 做市商总数
     */
    public String getMarketMakersNum() {
        return marketMakersNum;
    }

    /**
     * 设置做市商总数
     *
     * @param marketMakersNum 做市商总数
     */
    public void setMarketMakersNum(String marketMakersNum) {
        this.marketMakersNum = marketMakersNum;
    }

    /**
     * 获取提示信息
     *
     * @return tip - 提示信息
     */
    public String getTip() {
        return tip;
    }

    /**
     * 设置提示信息
     *
     * @param tip 提示信息
     */
    public void setTip(String tip) {
        this.tip = tip;
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
     * 获取总市值(万元)
     *
     * @return market_value - 总市值(万元)
     */
    public String getMarketValue() {
        return marketValue;
    }

    /**
     * 设置总市值(万元)
     *
     * @param marketValue 总市值(万元)
     */
    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    /**
     * 获取做市首日前收盘价(元)
     *
     * @return first_closing_price - 做市首日前收盘价(元)
     */
    public String getFirstClosingPrice() {
        return firstClosingPrice;
    }

    /**
     * 设置做市首日前收盘价(元)
     *
     * @param firstClosingPrice 做市首日前收盘价(元)
     */
    public void setFirstClosingPrice(String firstClosingPrice) {
        this.firstClosingPrice = firstClosingPrice;
    }

    /**
     * 获取做市首日涨跌幅	
     *
     * @return rise_fall - 做市首日涨跌幅	
     */
    public String getRiseFall() {
        return riseFall;
    }

    /**
     * 设置做市首日涨跌幅	
     *
     * @param riseFall 做市首日涨跌幅	
     */
    public void setRiseFall(String riseFall) {
        this.riseFall = riseFall;
    }

    /**
     * 获取做市起始日
     *
     * @return start_date - 做市起始日
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置做市起始日
     *
     * @param startDate 做市起始日
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}