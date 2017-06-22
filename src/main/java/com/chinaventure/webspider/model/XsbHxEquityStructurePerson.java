package com.chinaventure.webspider.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_hx_equity_structure_person")
public class XsbHxEquityStructurePerson {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联企业ID
     */
    @Column(name = "ent_id")
    private Integer entId;

    /**
     * 报告日期
     */
    @Column(name = "report_date")
    private Date reportDate;

    /**
     * 股东人数(户)
     */
    @Column(name = "shareholders_number")
    private Integer shareholdersNumber;

    /**
     * 股东人数较上期变化(%)
     */
    @Column(name = "shareholders_number_previous_change")
    private BigDecimal shareholdersNumberPreviousChange;

    /**
     * 人均流通股(万股)
     */
    @Column(name = "per_capita_tradable_shares")
    private BigDecimal perCapitaTradableShares;

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
     * 获取关联企业ID
     *
     * @return ent_id - 关联企业ID
     */
    public Integer getEntId() {
        return entId;
    }

    /**
     * 设置关联企业ID
     *
     * @param entId 关联企业ID
     */
    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    /**
     * 获取报告日期
     *
     * @return report_date - 报告日期
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * 设置报告日期
     *
     * @param reportDate 报告日期
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * 获取股东人数(户)
     *
     * @return shareholders_number - 股东人数(户)
     */
    public Integer getShareholdersNumber() {
        return shareholdersNumber;
    }

    /**
     * 设置股东人数(户)
     *
     * @param shareholdersNumber 股东人数(户)
     */
    public void setShareholdersNumber(Integer shareholdersNumber) {
        this.shareholdersNumber = shareholdersNumber;
    }

    /**
     * 获取股东人数较上期变化(%)
     *
     * @return shareholders_number_previous_change - 股东人数较上期变化(%)
     */
    public BigDecimal getShareholdersNumberPreviousChange() {
        return shareholdersNumberPreviousChange;
    }

    /**
     * 设置股东人数较上期变化(%)
     *
     * @param shareholdersNumberPreviousChange 股东人数较上期变化(%)
     */
    public void setShareholdersNumberPreviousChange(BigDecimal shareholdersNumberPreviousChange) {
        this.shareholdersNumberPreviousChange = shareholdersNumberPreviousChange;
    }

    /**
     * 获取人均流通股(万股)
     *
     * @return per_capita_tradable_shares - 人均流通股(万股)
     */
    public BigDecimal getPerCapitaTradableShares() {
        return perCapitaTradableShares;
    }

    /**
     * 设置人均流通股(万股)
     *
     * @param perCapitaTradableShares 人均流通股(万股)
     */
    public void setPerCapitaTradableShares(BigDecimal perCapitaTradableShares) {
        this.perCapitaTradableShares = perCapitaTradableShares;
    }
}