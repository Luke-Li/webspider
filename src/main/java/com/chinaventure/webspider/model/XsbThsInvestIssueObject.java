package com.chinaventure.webspider.model;

import javax.persistence.*;

@Table(name = "xsb_ths_invest_issue_object")
public class XsbThsInvestIssueObject {
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
    @Column(name = "org_name")
    private String orgName;

    /**
     * 发行类型
     */
    @Column(name = "org_type")
    private String orgType;

    /**
     * 发行对象性质,如券商
     */
    @Column(name = "org_nature")
    private String orgNature;

    /**
     * 认购价格(元)
     */
    @Column(name = "subscription_price")
    private String subscriptionPrice;

    /**
     * 认购数量(万股)
     */
    @Column(name = "subscription_number")
    private String subscriptionNumber;

    /**
     * 持股日期
     */
    @Column(name = "stock_holding_date")
    private String stockHoldingDate;

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
     * @return org_name - 发行对象
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置发行对象
     *
     * @param orgName 发行对象
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取发行类型
     *
     * @return org_type - 发行类型
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * 设置发行类型
     *
     * @param orgType 发行类型
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    /**
     * 获取发行对象性质,如券商
     *
     * @return org_nature - 发行对象性质,如券商
     */
    public String getOrgNature() {
        return orgNature;
    }

    /**
     * 设置发行对象性质,如券商
     *
     * @param orgNature 发行对象性质,如券商
     */
    public void setOrgNature(String orgNature) {
        this.orgNature = orgNature;
    }

    /**
     * 获取认购价格(元)
     *
     * @return subscription_price - 认购价格(元)
     */
    public String getSubscriptionPrice() {
        return subscriptionPrice;
    }

    /**
     * 设置认购价格(元)
     *
     * @param subscriptionPrice 认购价格(元)
     */
    public void setSubscriptionPrice(String subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

    /**
     * 获取认购数量(万股)
     *
     * @return subscription_number - 认购数量(万股)
     */
    public String getSubscriptionNumber() {
        return subscriptionNumber;
    }

    /**
     * 设置认购数量(万股)
     *
     * @param subscriptionNumber 认购数量(万股)
     */
    public void setSubscriptionNumber(String subscriptionNumber) {
        this.subscriptionNumber = subscriptionNumber;
    }

    /**
     * 获取持股日期
     *
     * @return stock_holding_date - 持股日期
     */
    public String getStockHoldingDate() {
        return stockHoldingDate;
    }

    /**
     * 设置持股日期
     *
     * @param stockHoldingDate 持股日期
     */
    public void setStockHoldingDate(String stockHoldingDate) {
        this.stockHoldingDate = stockHoldingDate;
    }
}