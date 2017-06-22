package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "kr_ent")
public class KrEnt {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 地址1
     */
    private Integer address1;

    /**
     * 地址2
     */
    private Integer address2;

    /**
     * 简介
     */
    private String brief;

    /**
     * 公司类型
     */
    @Column(name = "companyType")
    private String companytype;

    /**
     * 36kr 创建日期
     */
    @Column(name = "createDate")
    private Long createdate;

    /**
     * crowdfundingId
     */
    @Column(name = "crowdfundingId")
    private Integer crowdfundingid;

    /**
     * faId
     */
    @Column(name = "faId")
    private Integer faid;

    /**
     * financeEventId
     */
    @Column(name = "financeEventId")
    private Integer financeeventid;

    /**
     * financePhase
     */
    @Column(name = "financePhase")
    private String financephase;

    /**
     * 全名
     */
    @Column(name = "fullName")
    private String fullname;

    /**
     * fundId
     */
    @Column(name = "fundId")
    private Integer fundid;

    /**
     * 是否有管理人员
     */
    @Column(name = "hasManager")
    private Boolean hasmanager;

    /**
     * 内部id
     */
    @Column(name = "innerId")
    private Integer innerid;

    /**
     * 行业1
     */
    private String industry;

    /**
     * 行业2
     */
    private Integer industry2;

    /**
     * logo
     */
    private String logo;

    /**
     * 管理人员编号
     */
    @Column(name = "managerId")
    private Integer managerid;

    /**
     * 名称
     */
    private String name;

    /**
     * 36kr start日期
     */
    @Column(name = "startDate")
    private Long startdate;

    /**
     * 状态
     */
    private String status;

    /**
     * 36kr 更新日期
     */
    @Column(name = "updateDate")
    private Long updatedate;

    /**
     * 创始人
     */
    private String founder;

    /**
     * 建立时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Date updatetime;

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
     * 获取地址1
     *
     * @return address1 - 地址1
     */
    public Integer getAddress1() {
        return address1;
    }

    /**
     * 设置地址1
     *
     * @param address1 地址1
     */
    public void setAddress1(Integer address1) {
        this.address1 = address1;
    }

    /**
     * 获取地址2
     *
     * @return address2 - 地址2
     */
    public Integer getAddress2() {
        return address2;
    }

    /**
     * 设置地址2
     *
     * @param address2 地址2
     */
    public void setAddress2(Integer address2) {
        this.address2 = address2;
    }

    /**
     * 获取简介
     *
     * @return brief - 简介
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置简介
     *
     * @param brief 简介
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }

    /**
     * 获取公司类型
     *
     * @return companyType - 公司类型
     */
    public String getCompanytype() {
        return companytype;
    }

    /**
     * 设置公司类型
     *
     * @param companytype 公司类型
     */
    public void setCompanytype(String companytype) {
        this.companytype = companytype;
    }

    /**
     * 获取36kr 创建日期
     *
     * @return createDate - 36kr 创建日期
     */
    public Long getCreatedate() {
        return createdate;
    }

    /**
     * 设置36kr 创建日期
     *
     * @param createdate 36kr 创建日期
     */
    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取crowdfundingId
     *
     * @return crowdfundingId - crowdfundingId
     */
    public Integer getCrowdfundingid() {
        return crowdfundingid;
    }

    /**
     * 设置crowdfundingId
     *
     * @param crowdfundingid crowdfundingId
     */
    public void setCrowdfundingid(Integer crowdfundingid) {
        this.crowdfundingid = crowdfundingid;
    }

    /**
     * 获取faId
     *
     * @return faId - faId
     */
    public Integer getFaid() {
        return faid;
    }

    /**
     * 设置faId
     *
     * @param faid faId
     */
    public void setFaid(Integer faid) {
        this.faid = faid;
    }

    /**
     * 获取financeEventId
     *
     * @return financeEventId - financeEventId
     */
    public Integer getFinanceeventid() {
        return financeeventid;
    }

    /**
     * 设置financeEventId
     *
     * @param financeeventid financeEventId
     */
    public void setFinanceeventid(Integer financeeventid) {
        this.financeeventid = financeeventid;
    }

    /**
     * 获取financePhase
     *
     * @return financePhase - financePhase
     */
    public String getFinancephase() {
        return financephase;
    }

    /**
     * 设置financePhase
     *
     * @param financephase financePhase
     */
    public void setFinancephase(String financephase) {
        this.financephase = financephase;
    }

    /**
     * 获取全名
     *
     * @return fullName - 全名
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * 设置全名
     *
     * @param fullname 全名
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * 获取fundId
     *
     * @return fundId - fundId
     */
    public Integer getFundid() {
        return fundid;
    }

    /**
     * 设置fundId
     *
     * @param fundid fundId
     */
    public void setFundid(Integer fundid) {
        this.fundid = fundid;
    }

    /**
     * 获取是否有管理人员
     *
     * @return hasManager - 是否有管理人员
     */
    public Boolean getHasmanager() {
        return hasmanager;
    }

    /**
     * 设置是否有管理人员
     *
     * @param hasmanager 是否有管理人员
     */
    public void setHasmanager(Boolean hasmanager) {
        this.hasmanager = hasmanager;
    }

    /**
     * 获取内部id
     *
     * @return innerId - 内部id
     */
    public Integer getInnerid() {
        return innerid;
    }

    /**
     * 设置内部id
     *
     * @param innerid 内部id
     */
    public void setInnerid(Integer innerid) {
        this.innerid = innerid;
    }

    /**
     * 获取行业1
     *
     * @return industry - 行业1
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置行业1
     *
     * @param industry 行业1
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 获取行业2
     *
     * @return industry2 - 行业2
     */
    public Integer getIndustry2() {
        return industry2;
    }

    /**
     * 设置行业2
     *
     * @param industry2 行业2
     */
    public void setIndustry2(Integer industry2) {
        this.industry2 = industry2;
    }

    /**
     * 获取logo
     *
     * @return logo - logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置logo
     *
     * @param logo logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取管理人员编号
     *
     * @return managerId - 管理人员编号
     */
    public Integer getManagerid() {
        return managerid;
    }

    /**
     * 设置管理人员编号
     *
     * @param managerid 管理人员编号
     */
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取36kr start日期
     *
     * @return startDate - 36kr start日期
     */
    public Long getStartdate() {
        return startdate;
    }

    /**
     * 设置36kr start日期
     *
     * @param startdate 36kr start日期
     */
    public void setStartdate(Long startdate) {
        this.startdate = startdate;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取36kr 更新日期
     *
     * @return updateDate - 36kr 更新日期
     */
    public Long getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置36kr 更新日期
     *
     * @param updatedate 36kr 更新日期
     */
    public void setUpdatedate(Long updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取创始人
     *
     * @return founder - 创始人
     */
    public String getFounder() {
        return founder;
    }

    /**
     * 设置创始人
     *
     * @param founder 创始人
     */
    public void setFounder(String founder) {
        this.founder = founder;
    }

    /**
     * 获取建立时间
     *
     * @return createTime - 建立时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置建立时间
     *
     * @param createtime 建立时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间
     *
     * @return updateTime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}