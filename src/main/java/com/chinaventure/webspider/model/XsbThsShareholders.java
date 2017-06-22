package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_shareholders")
public class XsbThsShareholders {
    /**
     * 自动增长ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司关联ID
     */
    @Column(name = "ent_id")
    private Integer entId;

    /**
     * 报告日期
     */
    @Column(name = "report_date")
    private Date reportDate;

    /**
     * 持股人或机构名称
     */
    @Column(name = "institutions_person_name")
    private String institutionsPersonName;

    /**
     * 持股数量(万股)
     */
    private String ownership;

    /**
     * 持股变化(万股)
     */
    @Column(name = "owner_change")
    private String ownerChange;

    /**
     * 占总股本比例(%)
     */
    @Column(name = "total_equity_ratio")
    private String totalEquityRatio;

    /**
     * 实际增减持(%)
     */
    private String increases;

    /**
     * 股东类型:如:十大流通股东,十大股东
     */
    @Column(name = "shareholders_type")
    private String shareholdersType;

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
     * 获取自动增长ID
     *
     * @return id - 自动增长ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自动增长ID
     *
     * @param id 自动增长ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取公司关联ID
     *
     * @return ent_id - 公司关联ID
     */
    public Integer getEntId() {
        return entId;
    }

    /**
     * 设置公司关联ID
     *
     * @param entId 公司关联ID
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
     * 获取持股人或机构名称
     *
     * @return institutions_person_name - 持股人或机构名称
     */
    public String getInstitutionsPersonName() {
        return institutionsPersonName;
    }

    /**
     * 设置持股人或机构名称
     *
     * @param institutionsPersonName 持股人或机构名称
     */
    public void setInstitutionsPersonName(String institutionsPersonName) {
        this.institutionsPersonName = institutionsPersonName;
    }

    /**
     * 获取持股数量(万股)
     *
     * @return ownership - 持股数量(万股)
     */
    public String getOwnership() {
        return ownership;
    }

    /**
     * 设置持股数量(万股)
     *
     * @param ownership 持股数量(万股)
     */
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    /**
     * 获取持股变化(万股)
     *
     * @return owner_change - 持股变化(万股)
     */
    public String getOwnerChange() {
        return ownerChange;
    }

    /**
     * 设置持股变化(万股)
     *
     * @param ownerChange 持股变化(万股)
     */
    public void setOwnerChange(String ownerChange) {
        this.ownerChange = ownerChange;
    }

    /**
     * 获取占总股本比例(%)
     *
     * @return total_equity_ratio - 占总股本比例(%)
     */
    public String getTotalEquityRatio() {
        return totalEquityRatio;
    }

    /**
     * 设置占总股本比例(%)
     *
     * @param totalEquityRatio 占总股本比例(%)
     */
    public void setTotalEquityRatio(String totalEquityRatio) {
        this.totalEquityRatio = totalEquityRatio;
    }

    /**
     * 获取实际增减持(%)
     *
     * @return increases - 实际增减持(%)
     */
    public String getIncreases() {
        return increases;
    }

    /**
     * 设置实际增减持(%)
     *
     * @param increases 实际增减持(%)
     */
    public void setIncreases(String increases) {
        this.increases = increases;
    }

    /**
     * 获取股东类型:如:十大流通股东,十大股东
     *
     * @return shareholders_type - 股东类型:如:十大流通股东,十大股东
     */
    public String getShareholdersType() {
        return shareholdersType;
    }

    /**
     * 设置股东类型:如:十大流通股东,十大股东
     *
     * @param shareholdersType 股东类型:如:十大流通股东,十大股东
     */
    public void setShareholdersType(String shareholdersType) {
        this.shareholdersType = shareholdersType;
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