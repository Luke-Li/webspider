package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_shareholder_shareprice_compare")
public class XsbThsShareholderSharepriceCompare {
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
     * 指标/日期
     */
    @Column(name = "report_date")
    private Date reportDate;

    /**
     * 股东人数
     */
    private String shareholders;

    /**
     * 较上期变化
     */
    @Column(name = "pre_change")
    private String preChange;

    /**
     * 人均流通股(万股)
     */
    @Column(name = "per_capita_share")
    private String perCapitaShare;

    /**
     * 人均流通变化
     */
    @Column(name = "per_capita_change")
    private String perCapitaChange;

    /**
     * 行业平均(万户)
     */
    @Column(name = "industry_average")
    private String industryAverage;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取指标/日期
     *
     * @return report_date - 指标/日期
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * 设置指标/日期
     *
     * @param reportDate 指标/日期
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * 获取股东人数
     *
     * @return shareholders - 股东人数
     */
    public String getShareholders() {
        return shareholders;
    }

    /**
     * 设置股东人数
     *
     * @param shareholders 股东人数
     */
    public void setShareholders(String shareholders) {
        this.shareholders = shareholders;
    }

    /**
     * 获取较上期变化
     *
     * @return pre_change - 较上期变化
     */
    public String getPreChange() {
        return preChange;
    }

    /**
     * 设置较上期变化
     *
     * @param preChange 较上期变化
     */
    public void setPreChange(String preChange) {
        this.preChange = preChange;
    }

    /**
     * 获取人均流通股(万股)
     *
     * @return per_capita_share - 人均流通股(万股)
     */
    public String getPerCapitaShare() {
        return perCapitaShare;
    }

    /**
     * 设置人均流通股(万股)
     *
     * @param perCapitaShare 人均流通股(万股)
     */
    public void setPerCapitaShare(String perCapitaShare) {
        this.perCapitaShare = perCapitaShare;
    }

    /**
     * 获取人均流通变化
     *
     * @return per_capita_change - 人均流通变化
     */
    public String getPerCapitaChange() {
        return perCapitaChange;
    }

    /**
     * 设置人均流通变化
     *
     * @param perCapitaChange 人均流通变化
     */
    public void setPerCapitaChange(String perCapitaChange) {
        this.perCapitaChange = perCapitaChange;
    }

    /**
     * 获取行业平均(万户)
     *
     * @return industry_average - 行业平均(万户)
     */
    public String getIndustryAverage() {
        return industryAverage;
    }

    /**
     * 设置行业平均(万户)
     *
     * @param industryAverage 行业平均(万户)
     */
    public void setIndustryAverage(String industryAverage) {
        this.industryAverage = industryAverage;
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
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}