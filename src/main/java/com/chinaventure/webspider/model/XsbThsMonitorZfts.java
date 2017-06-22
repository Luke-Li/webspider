package com.chinaventure.webspider.model;

import javax.persistence.*;

@Table(name = "xsb_ths_monitor_zfts")
public class XsbThsMonitorZfts {
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
     * 方案进度
     */
    private String schedule;

    /**
     * 增发数量(万股)
     */
    @Column(name = "additional_num")
    private String additionalNum;

    /**
     * 增发价格(元)
     */
    @Column(name = "additional_price")
    private String additionalPrice;

    /**
     * 市盈率(LYR)
     */
    private String lyr;

    /**
     * 折溢价率
     */
    @Column(name = "discount_rate")
    private String discountRate;

    /**
     * 发行方式
     */
    @Column(name = "release_mode")
    private String releaseMode;

    /**
     * 最新公告日
     */
    @Column(name = "latest_announcement")
    private String latestAnnouncement;

    /**
     * 首次公告日
     */
    @Column(name = "first_announcement")
    private String firstAnnouncement;

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
     * 获取方案进度
     *
     * @return schedule - 方案进度
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * 设置方案进度
     *
     * @param schedule 方案进度
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * 获取增发数量(万股)
     *
     * @return additional_num - 增发数量(万股)
     */
    public String getAdditionalNum() {
        return additionalNum;
    }

    /**
     * 设置增发数量(万股)
     *
     * @param additionalNum 增发数量(万股)
     */
    public void setAdditionalNum(String additionalNum) {
        this.additionalNum = additionalNum;
    }

    /**
     * 获取增发价格(元)
     *
     * @return additional_price - 增发价格(元)
     */
    public String getAdditionalPrice() {
        return additionalPrice;
    }

    /**
     * 设置增发价格(元)
     *
     * @param additionalPrice 增发价格(元)
     */
    public void setAdditionalPrice(String additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    /**
     * 获取市盈率(LYR)
     *
     * @return lyr - 市盈率(LYR)
     */
    public String getLyr() {
        return lyr;
    }

    /**
     * 设置市盈率(LYR)
     *
     * @param lyr 市盈率(LYR)
     */
    public void setLyr(String lyr) {
        this.lyr = lyr;
    }

    /**
     * 获取折溢价率
     *
     * @return discount_rate - 折溢价率
     */
    public String getDiscountRate() {
        return discountRate;
    }

    /**
     * 设置折溢价率
     *
     * @param discountRate 折溢价率
     */
    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * 获取发行方式
     *
     * @return release_mode - 发行方式
     */
    public String getReleaseMode() {
        return releaseMode;
    }

    /**
     * 设置发行方式
     *
     * @param releaseMode 发行方式
     */
    public void setReleaseMode(String releaseMode) {
        this.releaseMode = releaseMode;
    }

    /**
     * 获取最新公告日
     *
     * @return latest_announcement - 最新公告日
     */
    public String getLatestAnnouncement() {
        return latestAnnouncement;
    }

    /**
     * 设置最新公告日
     *
     * @param latestAnnouncement 最新公告日
     */
    public void setLatestAnnouncement(String latestAnnouncement) {
        this.latestAnnouncement = latestAnnouncement;
    }

    /**
     * 获取首次公告日
     *
     * @return first_announcement - 首次公告日
     */
    public String getFirstAnnouncement() {
        return firstAnnouncement;
    }

    /**
     * 设置首次公告日
     *
     * @param firstAnnouncement 首次公告日
     */
    public void setFirstAnnouncement(String firstAnnouncement) {
        this.firstAnnouncement = firstAnnouncement;
    }
}