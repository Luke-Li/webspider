package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pof_info_fund")
public class PofInfoFund {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * pof_info的外键
     */
    @Column(name = "pof_info_id")
    private Integer pofInfoId;

    /**
     * 基金名称:
     */
    private String name;

    /**
     * 基金编号:
     */
    @Column(name = "fundNo")
    private String fundno;

    /**
     * 成立时间:
     */
    @Column(name = "establishDate")
    private String establishdate;

    /**
     * 备案时间:
     */
    @Column(name = "registerDate")
    private String registerdate;

    /**
     * 基金备案阶段:
     */
    @Column(name = "filingPhase")
    private String filingphase;

    /**
     * 基金类型:
     */
    @Column(name = "fundType")
    private String fundtype;

    /**
     * 币种:
     */
    private String currency;

    /**
     * 基金管理人名称:
     */
    @Column(name = "pofManagerName")
    private String pofmanagername;

    /**
     * 管理类型:
     */
    @Column(name = "manageType")
    private String managetype;

    /**
     * 托管人名称:
     */
    @Column(name = "custodianName")
    private String custodianname;

    /**
     * 主要投资领域:	
     */
    @Column(name = "investmentField")
    private String investmentfield;

    /**
     * 运作状态:
     */
    @Column(name = "operationState")
    private String operationstate;

    /**
     * 基金信息最后更新时间:
     */
    @Column(name = "lastUpdatedDate")
    private String lastupdateddate;

    /**
     * 基金协会特别提示（针对基金）:	
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
     * 获取pof_info的外键
     *
     * @return pof_info_id - pof_info的外键
     */
    public Integer getPofInfoId() {
        return pofInfoId;
    }

    /**
     * 设置pof_info的外键
     *
     * @param pofInfoId pof_info的外键
     */
    public void setPofInfoId(Integer pofInfoId) {
        this.pofInfoId = pofInfoId;
    }

    /**
     * 获取基金名称:
     *
     * @return name - 基金名称:
     */
    public String getName() {
        return name;
    }

    /**
     * 设置基金名称:
     *
     * @param name 基金名称:
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取基金编号:
     *
     * @return fundNo - 基金编号:
     */
    public String getFundno() {
        return fundno;
    }

    /**
     * 设置基金编号:
     *
     * @param fundno 基金编号:
     */
    public void setFundno(String fundno) {
        this.fundno = fundno;
    }

    /**
     * 获取成立时间:
     *
     * @return establishDate - 成立时间:
     */
    public String getEstablishdate() {
        return establishdate;
    }

    /**
     * 设置成立时间:
     *
     * @param establishdate 成立时间:
     */
    public void setEstablishdate(String establishdate) {
        this.establishdate = establishdate;
    }

    /**
     * 获取备案时间:
     *
     * @return registerDate - 备案时间:
     */
    public String getRegisterdate() {
        return registerdate;
    }

    /**
     * 设置备案时间:
     *
     * @param registerdate 备案时间:
     */
    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    /**
     * 获取基金备案阶段:
     *
     * @return filingPhase - 基金备案阶段:
     */
    public String getFilingphase() {
        return filingphase;
    }

    /**
     * 设置基金备案阶段:
     *
     * @param filingphase 基金备案阶段:
     */
    public void setFilingphase(String filingphase) {
        this.filingphase = filingphase;
    }

    /**
     * 获取基金类型:
     *
     * @return fundType - 基金类型:
     */
    public String getFundtype() {
        return fundtype;
    }

    /**
     * 设置基金类型:
     *
     * @param fundtype 基金类型:
     */
    public void setFundtype(String fundtype) {
        this.fundtype = fundtype;
    }

    /**
     * 获取币种:
     *
     * @return currency - 币种:
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 设置币种:
     *
     * @param currency 币种:
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 获取基金管理人名称:
     *
     * @return pofManagerName - 基金管理人名称:
     */
    public String getPofmanagername() {
        return pofmanagername;
    }

    /**
     * 设置基金管理人名称:
     *
     * @param pofmanagername 基金管理人名称:
     */
    public void setPofmanagername(String pofmanagername) {
        this.pofmanagername = pofmanagername;
    }

    /**
     * 获取管理类型:
     *
     * @return manageType - 管理类型:
     */
    public String getManagetype() {
        return managetype;
    }

    /**
     * 设置管理类型:
     *
     * @param managetype 管理类型:
     */
    public void setManagetype(String managetype) {
        this.managetype = managetype;
    }

    /**
     * 获取托管人名称:
     *
     * @return custodianName - 托管人名称:
     */
    public String getCustodianname() {
        return custodianname;
    }

    /**
     * 设置托管人名称:
     *
     * @param custodianname 托管人名称:
     */
    public void setCustodianname(String custodianname) {
        this.custodianname = custodianname;
    }

    /**
     * 获取主要投资领域:	
     *
     * @return investmentField - 主要投资领域:	
     */
    public String getInvestmentfield() {
        return investmentfield;
    }

    /**
     * 设置主要投资领域:	
     *
     * @param investmentfield 主要投资领域:	
     */
    public void setInvestmentfield(String investmentfield) {
        this.investmentfield = investmentfield;
    }

    /**
     * 获取运作状态:
     *
     * @return operationState - 运作状态:
     */
    public String getOperationstate() {
        return operationstate;
    }

    /**
     * 设置运作状态:
     *
     * @param operationstate 运作状态:
     */
    public void setOperationstate(String operationstate) {
        this.operationstate = operationstate;
    }

    /**
     * 获取基金信息最后更新时间:
     *
     * @return lastUpdatedDate - 基金信息最后更新时间:
     */
    public String getLastupdateddate() {
        return lastupdateddate;
    }

    /**
     * 设置基金信息最后更新时间:
     *
     * @param lastupdateddate 基金信息最后更新时间:
     */
    public void setLastupdateddate(String lastupdateddate) {
        this.lastupdateddate = lastupdateddate;
    }

    /**
     * 获取基金协会特别提示（针对基金）:	
     *
     * @return specialTips - 基金协会特别提示（针对基金）:	
     */
    public String getSpecialtips() {
        return specialtips;
    }

    /**
     * 设置基金协会特别提示（针对基金）:	
     *
     * @param specialtips 基金协会特别提示（针对基金）:	
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
}