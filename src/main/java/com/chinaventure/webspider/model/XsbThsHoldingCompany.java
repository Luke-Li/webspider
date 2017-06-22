package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_holding_company")
public class XsbThsHoldingCompany {
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
     * 关联公司名称
     */
    @Column(name = "affiliates_name")
    private String affiliatesName;

    /**
     * 参控关系
     */
    private String relationship;

    /**
     * 参控比例(%)
     */
    private String proportion;

    /**
     * 投资金额(万元)
     */
    @Column(name = "investment_amount")
    private String investmentAmount;

    /**
     * 被参控公司净利润(万元)
     */
    @Column(name = "byshares_com_net_profit")
    private String bysharesComNetProfit;

    /**
     * 是否报表合并
     */
    @Column(name = "is_merger_report")
    private String isMergerReport;

    /**
     * 被参股公司主营业务
     */
    @Column(name = "byshares_com_main_business")
    private String bysharesComMainBusiness;

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
     * 获取关联公司名称
     *
     * @return affiliates_name - 关联公司名称
     */
    public String getAffiliatesName() {
        return affiliatesName;
    }

    /**
     * 设置关联公司名称
     *
     * @param affiliatesName 关联公司名称
     */
    public void setAffiliatesName(String affiliatesName) {
        this.affiliatesName = affiliatesName;
    }

    /**
     * 获取参控关系
     *
     * @return relationship - 参控关系
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * 设置参控关系
     *
     * @param relationship 参控关系
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     * 获取参控比例(%)
     *
     * @return proportion - 参控比例(%)
     */
    public String getProportion() {
        return proportion;
    }

    /**
     * 设置参控比例(%)
     *
     * @param proportion 参控比例(%)
     */
    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    /**
     * 获取投资金额(万元)
     *
     * @return investment_amount - 投资金额(万元)
     */
    public String getInvestmentAmount() {
        return investmentAmount;
    }

    /**
     * 设置投资金额(万元)
     *
     * @param investmentAmount 投资金额(万元)
     */
    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    /**
     * 获取被参控公司净利润(万元)
     *
     * @return byshares_com_net_profit - 被参控公司净利润(万元)
     */
    public String getBysharesComNetProfit() {
        return bysharesComNetProfit;
    }

    /**
     * 设置被参控公司净利润(万元)
     *
     * @param bysharesComNetProfit 被参控公司净利润(万元)
     */
    public void setBysharesComNetProfit(String bysharesComNetProfit) {
        this.bysharesComNetProfit = bysharesComNetProfit;
    }

    /**
     * 获取是否报表合并
     *
     * @return is_merger_report - 是否报表合并
     */
    public String getIsMergerReport() {
        return isMergerReport;
    }

    /**
     * 设置是否报表合并
     *
     * @param isMergerReport 是否报表合并
     */
    public void setIsMergerReport(String isMergerReport) {
        this.isMergerReport = isMergerReport;
    }

    /**
     * 获取被参股公司主营业务
     *
     * @return byshares_com_main_business - 被参股公司主营业务
     */
    public String getBysharesComMainBusiness() {
        return bysharesComMainBusiness;
    }

    /**
     * 设置被参股公司主营业务
     *
     * @param bysharesComMainBusiness 被参股公司主营业务
     */
    public void setBysharesComMainBusiness(String bysharesComMainBusiness) {
        this.bysharesComMainBusiness = bysharesComMainBusiness;
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