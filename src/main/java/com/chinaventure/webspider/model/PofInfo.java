package com.chinaventure.webspider.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "pof_info")
public class PofInfo {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * pof_list的外键
     */
    @Column(name = "pof_id")
    private Integer pofId;

    /**
     * 机构诚信信息:
     */
    @Column(name = "integrityInfo")
    private String integrityinfo;

    /**
     * 私募基金管理人名称(中文)
     */
    @Column(name = "managerName")
    private String managername;

    /**
     * 私募基金管理人名称(英文)
     */
    @Column(name = "managerNameEn")
    private String managernameen;

    /**
     * 登记编号
     */
    @Column(name = "registerNo")
    private String registerno;

    /**
     * 组织机构代码
     */
    @Column(name = "organizationCode")
    private String organizationcode;

    /**
     * 成立日期
     */
    @Column(name = "establishDate")
    private String establishdate;

    /**
     * 登记日期
     */
    @Column(name = "registerDate")
    private String registerdate;

    /**
     * 注册地址
     */
    @Column(name = "registerAddress")
    private String registeraddress;

    /**
     * 办公地址
     */
    @Column(name = "officeAddress")
    private String officeaddress;

    /**
     * 注册资本(万元):
     */
    @Column(name = "regCapital")
    private String regcapital;

    /**
     * 实缴资本(万元):
     */
    @Column(name = "paidinCapital")
    private String paidincapital;

    /**
     * 企业性质:
     */
    @Column(name = "entNature")
    private String entnature;

    /**
     * 注册资本实缴比例:
     */
    @Column(name = "regcapitalPaidinRatio")
    private String regcapitalpaidinratio;

    /**
     * 基金主要类别
     */
    @Column(name = "primaryInvestType")
    private String primaryinvesttype;

    /**
     * 申请的其他业务类型:
     */
    @Column(name = "otherBiztype")
    private String otherbiztype;

    /**
     * 员工人数:
     */
    @Column(name = "employNum")
    private String employnum;

    /**
     * 机构网址:
     */
    private String site;

    /**
     * 法律意见书状态:
     */
    @Column(name = "legalOpinion")
    private String legalopinion;

    /**
     * 法定代表人/执行事务合伙人(委派代表)姓名:
     */
    @Column(name = "artificialPersonName")
    private String artificialpersonname;

    /**
     * 是否有从业资格:
     */
    @Column(name = "isHasCredit")
    private String ishascredit;

    /**
     * 资格取得方式:
     */
    @Column(name = "creditGetWay")
    private String creditgetway;

    /**
     * 机构信息最后更新时间:
     */
    @Column(name = "lastUpdatedDate")
    private String lastupdateddate;

    /**
     * 特别提示信息:
     */
    @Column(name = "specialTips")
    private String specialtips;

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
     * 获取pof_list的外键
     *
     * @return pof_id - pof_list的外键
     */
    public Integer getPofId() {
        return pofId;
    }

    /**
     * 设置pof_list的外键
     *
     * @param pofId pof_list的外键
     */
    public void setPofId(Integer pofId) {
        this.pofId = pofId;
    }

    /**
     * 获取机构诚信信息:
     *
     * @return integrityInfo - 机构诚信信息:
     */
    public String getIntegrityinfo() {
        return integrityinfo;
    }

    /**
     * 设置机构诚信信息:
     *
     * @param integrityinfo 机构诚信信息:
     */
    public void setIntegrityinfo(String integrityinfo) {
        this.integrityinfo = integrityinfo;
    }

    /**
     * 获取私募基金管理人名称(中文)
     *
     * @return managerName - 私募基金管理人名称(中文)
     */
    public String getManagername() {
        return managername;
    }

    /**
     * 设置私募基金管理人名称(中文)
     *
     * @param managername 私募基金管理人名称(中文)
     */
    public void setManagername(String managername) {
        this.managername = managername;
    }

    /**
     * 获取私募基金管理人名称(英文)
     *
     * @return managerNameEn - 私募基金管理人名称(英文)
     */
    public String getManagernameen() {
        return managernameen;
    }

    /**
     * 设置私募基金管理人名称(英文)
     *
     * @param managernameen 私募基金管理人名称(英文)
     */
    public void setManagernameen(String managernameen) {
        this.managernameen = managernameen;
    }

    /**
     * 获取登记编号
     *
     * @return registerNo - 登记编号
     */
    public String getRegisterno() {
        return registerno;
    }

    /**
     * 设置登记编号
     *
     * @param registerno 登记编号
     */
    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    /**
     * 获取组织机构代码
     *
     * @return organizationCode - 组织机构代码
     */
    public String getOrganizationcode() {
        return organizationcode;
    }

    /**
     * 设置组织机构代码
     *
     * @param organizationcode 组织机构代码
     */
    public void setOrganizationcode(String organizationcode) {
        this.organizationcode = organizationcode;
    }

    /**
     * 获取成立日期
     *
     * @return establishDate - 成立日期
     */
    public String getEstablishdate() {
        return establishdate;
    }

    /**
     * 设置成立日期
     *
     * @param establishdate 成立日期
     */
    public void setEstablishdate(String establishdate) {
        this.establishdate = establishdate;
    }

    /**
     * 获取登记日期
     *
     * @return registerDate - 登记日期
     */
    public String getRegisterdate() {
        return registerdate;
    }

    /**
     * 设置登记日期
     *
     * @param registerdate 登记日期
     */
    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    /**
     * 获取注册地址
     *
     * @return registerAddress - 注册地址
     */
    public String getRegisteraddress() {
        return registeraddress;
    }

    /**
     * 设置注册地址
     *
     * @param registeraddress 注册地址
     */
    public void setRegisteraddress(String registeraddress) {
        this.registeraddress = registeraddress;
    }

    /**
     * 获取办公地址
     *
     * @return officeAddress - 办公地址
     */
    public String getOfficeaddress() {
        return officeaddress;
    }

    /**
     * 设置办公地址
     *
     * @param officeaddress 办公地址
     */
    public void setOfficeaddress(String officeaddress) {
        this.officeaddress = officeaddress;
    }

    /**
     * 获取注册资本(万元):
     *
     * @return regCapital - 注册资本(万元):
     */
    public String getRegcapital() {
        return regcapital;
    }

    /**
     * 设置注册资本(万元):
     *
     * @param regcapital 注册资本(万元):
     */
    public void setRegcapital(String regcapital) {
        this.regcapital = regcapital;
    }

    /**
     * 获取实缴资本(万元):
     *
     * @return paidinCapital - 实缴资本(万元):
     */
    public String getPaidincapital() {
        return paidincapital;
    }

    /**
     * 设置实缴资本(万元):
     *
     * @param paidincapital 实缴资本(万元):
     */
    public void setPaidincapital(String paidincapital) {
        this.paidincapital = paidincapital;
    }

    /**
     * 获取企业性质:
     *
     * @return entNature - 企业性质:
     */
    public String getEntnature() {
        return entnature;
    }

    /**
     * 设置企业性质:
     *
     * @param entnature 企业性质:
     */
    public void setEntnature(String entnature) {
        this.entnature = entnature;
    }

    /**
     * 获取注册资本实缴比例:
     *
     * @return regcapitalPaidinRatio - 注册资本实缴比例:
     */
    public String getRegcapitalpaidinratio() {
        return regcapitalpaidinratio;
    }

    /**
     * 设置注册资本实缴比例:
     *
     * @param regcapitalpaidinratio 注册资本实缴比例:
     */
    public void setRegcapitalpaidinratio(String regcapitalpaidinratio) {
        this.regcapitalpaidinratio = regcapitalpaidinratio;
    }

    /**
     * 获取基金主要类别
     *
     * @return primaryInvestType - 基金主要类别
     */
    public String getPrimaryinvesttype() {
        return primaryinvesttype;
    }

    /**
     * 设置基金主要类别
     *
     * @param primaryinvesttype 基金主要类别
     */
    public void setPrimaryinvesttype(String primaryinvesttype) {
        this.primaryinvesttype = primaryinvesttype;
    }

    /**
     * 获取申请的其他业务类型:
     *
     * @return otherBiztype - 申请的其他业务类型:
     */
    public String getOtherbiztype() {
        return otherbiztype;
    }

    /**
     * 设置申请的其他业务类型:
     *
     * @param otherbiztype 申请的其他业务类型:
     */
    public void setOtherbiztype(String otherbiztype) {
        this.otherbiztype = otherbiztype;
    }

    /**
     * 获取员工人数:
     *
     * @return employNum - 员工人数:
     */
    public String getEmploynum() {
        return employnum;
    }

    /**
     * 设置员工人数:
     *
     * @param employnum 员工人数:
     */
    public void setEmploynum(String employnum) {
        this.employnum = employnum;
    }

    /**
     * 获取机构网址:
     *
     * @return site - 机构网址:
     */
    public String getSite() {
        return site;
    }

    /**
     * 设置机构网址:
     *
     * @param site 机构网址:
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * 获取法律意见书状态:
     *
     * @return legalOpinion - 法律意见书状态:
     */
    public String getLegalopinion() {
        return legalopinion;
    }

    /**
     * 设置法律意见书状态:
     *
     * @param legalopinion 法律意见书状态:
     */
    public void setLegalopinion(String legalopinion) {
        this.legalopinion = legalopinion;
    }

    /**
     * 获取法定代表人/执行事务合伙人(委派代表)姓名:
     *
     * @return artificialPersonName - 法定代表人/执行事务合伙人(委派代表)姓名:
     */
    public String getArtificialpersonname() {
        return artificialpersonname;
    }

    /**
     * 设置法定代表人/执行事务合伙人(委派代表)姓名:
     *
     * @param artificialpersonname 法定代表人/执行事务合伙人(委派代表)姓名:
     */
    public void setArtificialpersonname(String artificialpersonname) {
        this.artificialpersonname = artificialpersonname;
    }

    /**
     * 获取是否有从业资格:
     *
     * @return isHasCredit - 是否有从业资格:
     */
    public String getIshascredit() {
        return ishascredit;
    }

    /**
     * 设置是否有从业资格:
     *
     * @param ishascredit 是否有从业资格:
     */
    public void setIshascredit(String ishascredit) {
        this.ishascredit = ishascredit;
    }

    /**
     * 获取资格取得方式:
     *
     * @return creditGetWay - 资格取得方式:
     */
    public String getCreditgetway() {
        return creditgetway;
    }

    /**
     * 设置资格取得方式:
     *
     * @param creditgetway 资格取得方式:
     */
    public void setCreditgetway(String creditgetway) {
        this.creditgetway = creditgetway;
    }

    /**
     * 获取机构信息最后更新时间:
     *
     * @return lastUpdatedDate - 机构信息最后更新时间:
     */
    public String getLastupdateddate() {
        return lastupdateddate;
    }

    /**
     * 设置机构信息最后更新时间:
     *
     * @param lastupdateddate 机构信息最后更新时间:
     */
    public void setLastupdateddate(String lastupdateddate) {
        this.lastupdateddate = lastupdateddate;
    }

    /**
     * 获取特别提示信息:
     *
     * @return specialTips - 特别提示信息:
     */
    public String getSpecialtips() {
        return specialtips;
    }

    /**
     * 设置特别提示信息:
     *
     * @param specialtips 特别提示信息:
     */
    public void setSpecialtips(String specialtips) {
        this.specialtips = specialtips;
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
    
    /**
     * 管理的基金
     */
    @Transient
    private List<PofInfoFund> infoFunds = new ArrayList<>();
    /**
     * 私募基金管理人-高管
     */
    @Transient
    private List<PofInfoManager> fundManagers = new ArrayList<>();
    /**
     * 私募基金管理人公示信息法人的工作履历
     */
    @Transient
    private List<PofInfoLegalpersonResume> personResumes = new ArrayList<>();
    /**
     * 管理的基金
     */
	public List<PofInfoFund> getInfoFunds() {
		return infoFunds;
	}
	/**
     * 管理的基金
     */
	public void setInfoFunds(List<PofInfoFund> infoFunds) {
		this.infoFunds = infoFunds;
	}
	/**
     * 私募基金管理人-高管
     */
	public List<PofInfoManager> getFundManagers() {
		return fundManagers;
	}
	/**
     * 私募基金管理人-高管
     */
	public void setFundManagers(List<PofInfoManager> fundManagers) {
		this.fundManagers = fundManagers;
	}
	/**
     * 私募基金管理人公示信息法人的工作履历
     */
	public List<PofInfoLegalpersonResume> getPersonResumes() {
		return personResumes;
	}
	/**
     * 私募基金管理人公示信息法人的工作履历
     */
	public void setPersonResumes(List<PofInfoLegalpersonResume> personResumes) {
		this.personResumes = personResumes;
	}
}