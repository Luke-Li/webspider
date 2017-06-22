package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_equity_structure")
public class XsbThsEquityStructure {
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
     * 总股本(万股)
     */
    @Column(name = "total_equity")
    private String totalEquity;

    /**
     * A股总股本
     */
    @Column(name = "atotal_equity")
    private String atotalEquity;

    /**
     * 流通A股
     */
    @Column(name = "tradable_a_shares")
    private String tradableAShares;

    /**
     * 限售A股
     */
    @Column(name = "restricted_a_shares")
    private String restrictedAShares;

    /**
     * 变动原因
     */
    @Column(name = "change_reason")
    private String changeReason;

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
     * 获取总股本(万股)
     *
     * @return total_equity - 总股本(万股)
     */
    public String getTotalEquity() {
        return totalEquity;
    }

    /**
     * 设置总股本(万股)
     *
     * @param totalEquity 总股本(万股)
     */
    public void setTotalEquity(String totalEquity) {
        this.totalEquity = totalEquity;
    }

    /**
     * 获取A股总股本
     *
     * @return atotal_equity - A股总股本
     */
    public String getAtotalEquity() {
        return atotalEquity;
    }

    /**
     * 设置A股总股本
     *
     * @param atotalEquity A股总股本
     */
    public void setAtotalEquity(String atotalEquity) {
        this.atotalEquity = atotalEquity;
    }

    /**
     * 获取流通A股
     *
     * @return tradable_a_shares - 流通A股
     */
    public String getTradableAShares() {
        return tradableAShares;
    }

    /**
     * 设置流通A股
     *
     * @param tradableAShares 流通A股
     */
    public void setTradableAShares(String tradableAShares) {
        this.tradableAShares = tradableAShares;
    }

    /**
     * 获取限售A股
     *
     * @return restricted_a_shares - 限售A股
     */
    public String getRestrictedAShares() {
        return restrictedAShares;
    }

    /**
     * 设置限售A股
     *
     * @param restrictedAShares 限售A股
     */
    public void setRestrictedAShares(String restrictedAShares) {
        this.restrictedAShares = restrictedAShares;
    }

    /**
     * 获取变动原因
     *
     * @return change_reason - 变动原因
     */
    public String getChangeReason() {
        return changeReason;
    }

    /**
     * 设置变动原因
     *
     * @param changeReason 变动原因
     */
    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }
}