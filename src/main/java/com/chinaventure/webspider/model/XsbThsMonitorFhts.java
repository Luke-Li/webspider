package com.chinaventure.webspider.model;

import javax.persistence.*;

@Table(name = "xsb_ths_monitor_fhts")
public class XsbThsMonitorFhts {
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
     * 方案说明
     */
    @Column(name = "program_description")
    private String programDescription;

    /**
     * 每股派息(税后)
     */
    @Column(name = "per_share_dividend")
    private String perShareDividend;

    /**
     * 基本股本(万股)
     */
    @Column(name = "basic_equity")
    private String basicEquity;

    /**
     * 报告期
     */
    @Column(name = "reporting_period")
    private String reportingPeriod;

    /**
     * 实施公告日
     */
    @Column(name = "announcement_date")
    private String announcementDate;

    /**
     * 除权除息日
     */
    @Column(name = "ex_dividend_date")
    private String exDividendDate;

    /**
     * 派息日
     */
    @Column(name = "dividend_date")
    private String dividendDate;

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
     * 获取方案说明
     *
     * @return program_description - 方案说明
     */
    public String getProgramDescription() {
        return programDescription;
    }

    /**
     * 设置方案说明
     *
     * @param programDescription 方案说明
     */
    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    /**
     * 获取每股派息(税后)
     *
     * @return per_share_dividend - 每股派息(税后)
     */
    public String getPerShareDividend() {
        return perShareDividend;
    }

    /**
     * 设置每股派息(税后)
     *
     * @param perShareDividend 每股派息(税后)
     */
    public void setPerShareDividend(String perShareDividend) {
        this.perShareDividend = perShareDividend;
    }

    /**
     * 获取基本股本(万股)
     *
     * @return basic_equity - 基本股本(万股)
     */
    public String getBasicEquity() {
        return basicEquity;
    }

    /**
     * 设置基本股本(万股)
     *
     * @param basicEquity 基本股本(万股)
     */
    public void setBasicEquity(String basicEquity) {
        this.basicEquity = basicEquity;
    }

    /**
     * 获取报告期
     *
     * @return reporting_period - 报告期
     */
    public String getReportingPeriod() {
        return reportingPeriod;
    }

    /**
     * 设置报告期
     *
     * @param reportingPeriod 报告期
     */
    public void setReportingPeriod(String reportingPeriod) {
        this.reportingPeriod = reportingPeriod;
    }

    /**
     * 获取实施公告日
     *
     * @return announcement_date - 实施公告日
     */
    public String getAnnouncementDate() {
        return announcementDate;
    }

    /**
     * 设置实施公告日
     *
     * @param announcementDate 实施公告日
     */
    public void setAnnouncementDate(String announcementDate) {
        this.announcementDate = announcementDate;
    }

    /**
     * 获取除权除息日
     *
     * @return ex_dividend_date - 除权除息日
     */
    public String getExDividendDate() {
        return exDividendDate;
    }

    /**
     * 设置除权除息日
     *
     * @param exDividendDate 除权除息日
     */
    public void setExDividendDate(String exDividendDate) {
        this.exDividendDate = exDividendDate;
    }

    /**
     * 获取派息日
     *
     * @return dividend_date - 派息日
     */
    public String getDividendDate() {
        return dividendDate;
    }

    /**
     * 设置派息日
     *
     * @param dividendDate 派息日
     */
    public void setDividendDate(String dividendDate) {
        this.dividendDate = dividendDate;
    }
}