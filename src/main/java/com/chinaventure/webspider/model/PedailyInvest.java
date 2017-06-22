package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pedaily_invest")
public class PedailyInvest {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 第几轮融资
     */
    private String round;

    /**
     * 融资日期
     */
    @Column(name = "financing_date")
    private String financingDate;

    /**
     * 投资方
     */
    @Column(name = "funded_party")
    private String fundedParty;

    /**
     * 受资方
     */
    @Column(name = "invest_side")
    private String investSide;

    /**
     * 融资金额
     */
    @Column(name = "invenst_amount")
    private String invenstAmount;

    /**
     * 详细信息链接
     */
    @Column(name = "detail_url")
    private String detailUrl;

    /**
     * 行业
     */
    private String industry;

    /**
     * 公司简介
     */
    private String brief;

    /**
     * 建立时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取第几轮融资
     *
     * @return round - 第几轮融资
     */
    public String getRound() {
        return round;
    }

    /**
     * 设置第几轮融资
     *
     * @param round 第几轮融资
     */
    public void setRound(String round) {
        this.round = round;
    }

    /**
     * 获取融资日期
     *
     * @return financing_date - 融资日期
     */
    public String getFinancingDate() {
        return financingDate;
    }

    /**
     * 设置融资日期
     *
     * @param financingDate 融资日期
     */
    public void setFinancingDate(String financingDate) {
        this.financingDate = financingDate;
    }

    /**
     * 获取投资方
     *
     * @return funded_party - 投资方
     */
    public String getFundedParty() {
        return fundedParty;
    }

    /**
     * 设置投资方
     *
     * @param fundedParty 投资方
     */
    public void setFundedParty(String fundedParty) {
        this.fundedParty = fundedParty;
    }

    /**
     * 获取受资方
     *
     * @return invest_side - 受资方
     */
    public String getInvestSide() {
        return investSide;
    }

    /**
     * 设置受资方
     *
     * @param investSide 受资方
     */
    public void setInvestSide(String investSide) {
        this.investSide = investSide;
    }

    /**
     * 获取融资金额
     *
     * @return invenst_amount - 融资金额
     */
    public String getInvenstAmount() {
        return invenstAmount;
    }

    /**
     * 设置融资金额
     *
     * @param invenstAmount 融资金额
     */
    public void setInvenstAmount(String invenstAmount) {
        this.invenstAmount = invenstAmount;
    }

    /**
     * 获取详细信息链接
     *
     * @return detail_url - 详细信息链接
     */
    public String getDetailUrl() {
        return detailUrl;
    }

    /**
     * 设置详细信息链接
     *
     * @param detailUrl 详细信息链接
     */
    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    /**
     * 获取行业
     *
     * @return industry - 行业
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置行业
     *
     * @param industry 行业
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 获取公司简介
     *
     * @return brief - 公司简介
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置公司简介
     *
     * @param brief 公司简介
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }

    /**
     * 获取建立时间
     *
     * @return create_time - 建立时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置建立时间
     *
     * @param createTime 建立时间
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
}