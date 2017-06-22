package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_ent")
public class XsbThsEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 中文全称
     */
    @Column(name = "cn_name")
    private String cnName;

    /**
     * 中文简称
     */
    @Column(name = "cn_short")
    private String cnShort;

    /**
     * 中文曾用名
     */
    @Column(name = "cn_once")
    private String cnOnce;

    /**
     * 英文全称
     */
    @Column(name = "en_name")
    private String enName;

    /**
     * 英文简称
     */
    @Column(name = "en_short")
    private String enShort;

    /**
     * 英文曾用名
     */
    @Column(name = "en_once")
    private String enOnce;

    /**
     * 企业关键字
     */
    private String keywords;

    /**
     * 企业网站
     */
    private String web;

    /**
     * logo
     */
    private String logo;

    /**
     * 地域
     */
    private String area;

    /**
     * 成立时间
     */
    @Column(name = "setup_time")
    private Date setupTime;

    /**
     * 停业时间
     */
    @Column(name = "stop_time")
    private Date stopTime;

    /**
     * 企业状态
     */
    private Byte status;

    /**
     * 上市日期
     */
    @Column(name = "appearmarkethappen_date")
    private String appearmarkethappenDate;

    /**
     * 交易所中文名
     */
    @Column(name = "exchange_cnname")
    private String exchangeCnname;

    /**
     * 交易所英文名
     */
    @Column(name = "exchange_enname")
    private String exchangeEnname;

    /**
     * 组织机构代码
     */
    @Column(name = "organize_code")
    private String organizeCode;

    /**
     * 股票代码
     */
    @Column(name = "stock_code")
    private Integer stockCode;

    /**
     * 企业性质
     */
    @Column(name = "character_id")
    private Byte characterId;

    /**
     * 企业所属行业
     */
    @Column(name = "industry_type")
    private String industryType;

    /**
     * 主营业务
     */
    @Column(name = "main_business")
    private String mainBusiness;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 控股股东
     */
    @Column(name = "controlling_shareholders")
    private String controllingShareholders;

    /**
     * 实际控制人
     */
    @Column(name = "actual_controller")
    private String actualController;

    /**
     * 最终控制人
     */
    @Column(name = "ultimate_controller")
    private String ultimateController;

    /**
     * 法定代表人
     */
    @Column(name = "legal_person")
    private String legalPerson;

    /**
     * 董事长
     */
    private String chairman;

    /**
     * 董秘
     */
    private String secretaries;

    /**
     * 董秘传真
     */
    @Column(name = "cs_fax")
    private String csFax;

    /**
     * 董秘邮箱
     */
    @Column(name = "cs_email")
    private String csEmail;

    /**
     * 董秘电话
     */
    @Column(name = "cs_tel")
    private String csTel;

    /**
     * 总经理
     */
    @Column(name = "general_manager")
    private String generalManager;

    /**
     * 注册资金
     */
    @Column(name = "registered_capital")
    private String registeredCapital;

    /**
     * 员工人数
     */
    @Column(name = "employees_number")
    private String employeesNumber;

    /**
     * 注册地址
     */
    @Column(name = "reg_addr")
    private String regAddr;

    /**
     * 地址 - 中文
     */
    @Column(name = "cn_addr")
    private String cnAddr;

    /**
     * 地址 - 英文
     */
    @Column(name = "en_addr")
    private String enAddr;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 交易所类型  新三板,证券交易所,商品交易所,黄金交易所
     */
    @Column(name = "exchange_type")
    private String exchangeType;

    /**
     * 企业工商注册号
     */
    @Column(name = "business_registration_id")
    private String businessRegistrationId;

    /**
     * 企业注册类型 1,内资企业 2,国有企业 3,集体企业 4,股份合作企业
     */
    @Column(name = "registered_type")
    private String registeredType;

    /**
     * 企业上市信息ID
     */
    @Column(name = "app_id")
    private Integer appId;

    /**
     * 证监会所属行业
     */
    @Column(name = "management_industry")
    private String managementIndustry;

    /**
     * 转让类型
     */
    @Column(name = "transfer_type")
    private String transferType;

    /**
     * 主办券商
     */
    @Column(name = "sponsored_broker")
    private String sponsoredBroker;

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
     * 中文描述
     */
    @Column(name = "cn_desc")
    private String cnDesc;

    /**
     * 英文描述
     */
    @Column(name = "en_desc")
    private String enDesc;

    /**
     * 备注
     */
    private String content;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取中文全称
     *
     * @return cn_name - 中文全称
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * 设置中文全称
     *
     * @param cnName 中文全称
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * 获取中文简称
     *
     * @return cn_short - 中文简称
     */
    public String getCnShort() {
        return cnShort;
    }

    /**
     * 设置中文简称
     *
     * @param cnShort 中文简称
     */
    public void setCnShort(String cnShort) {
        this.cnShort = cnShort;
    }

    /**
     * 获取中文曾用名
     *
     * @return cn_once - 中文曾用名
     */
    public String getCnOnce() {
        return cnOnce;
    }

    /**
     * 设置中文曾用名
     *
     * @param cnOnce 中文曾用名
     */
    public void setCnOnce(String cnOnce) {
        this.cnOnce = cnOnce;
    }

    /**
     * 获取英文全称
     *
     * @return en_name - 英文全称
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置英文全称
     *
     * @param enName 英文全称
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * 获取英文简称
     *
     * @return en_short - 英文简称
     */
    public String getEnShort() {
        return enShort;
    }

    /**
     * 设置英文简称
     *
     * @param enShort 英文简称
     */
    public void setEnShort(String enShort) {
        this.enShort = enShort;
    }

    /**
     * 获取英文曾用名
     *
     * @return en_once - 英文曾用名
     */
    public String getEnOnce() {
        return enOnce;
    }

    /**
     * 设置英文曾用名
     *
     * @param enOnce 英文曾用名
     */
    public void setEnOnce(String enOnce) {
        this.enOnce = enOnce;
    }

    /**
     * 获取企业关键字
     *
     * @return keywords - 企业关键字
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * 设置企业关键字
     *
     * @param keywords 企业关键字
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * 获取企业网站
     *
     * @return web - 企业网站
     */
    public String getWeb() {
        return web;
    }

    /**
     * 设置企业网站
     *
     * @param web 企业网站
     */
    public void setWeb(String web) {
        this.web = web;
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
     * 获取地域
     *
     * @return area - 地域
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地域
     *
     * @param area 地域
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取成立时间
     *
     * @return setup_time - 成立时间
     */
    public Date getSetupTime() {
        return setupTime;
    }

    /**
     * 设置成立时间
     *
     * @param setupTime 成立时间
     */
    public void setSetupTime(Date setupTime) {
        this.setupTime = setupTime;
    }

    /**
     * 获取停业时间
     *
     * @return stop_time - 停业时间
     */
    public Date getStopTime() {
        return stopTime;
    }

    /**
     * 设置停业时间
     *
     * @param stopTime 停业时间
     */
    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * 获取企业状态
     *
     * @return status - 企业状态
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置企业状态
     *
     * @param status 企业状态
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取上市日期
     *
     * @return appearmarkethappen_date - 上市日期
     */
    public String getAppearmarkethappenDate() {
        return appearmarkethappenDate;
    }

    /**
     * 设置上市日期
     *
     * @param appearmarkethappenDate 上市日期
     */
    public void setAppearmarkethappenDate(String appearmarkethappenDate) {
        this.appearmarkethappenDate = appearmarkethappenDate;
    }

    /**
     * 获取交易所中文名
     *
     * @return exchange_cnname - 交易所中文名
     */
    public String getExchangeCnname() {
        return exchangeCnname;
    }

    /**
     * 设置交易所中文名
     *
     * @param exchangeCnname 交易所中文名
     */
    public void setExchangeCnname(String exchangeCnname) {
        this.exchangeCnname = exchangeCnname;
    }

    /**
     * 获取交易所英文名
     *
     * @return exchange_enname - 交易所英文名
     */
    public String getExchangeEnname() {
        return exchangeEnname;
    }

    /**
     * 设置交易所英文名
     *
     * @param exchangeEnname 交易所英文名
     */
    public void setExchangeEnname(String exchangeEnname) {
        this.exchangeEnname = exchangeEnname;
    }

    /**
     * 获取组织机构代码
     *
     * @return organize_code - 组织机构代码
     */
    public String getOrganizeCode() {
        return organizeCode;
    }

    /**
     * 设置组织机构代码
     *
     * @param organizeCode 组织机构代码
     */
    public void setOrganizeCode(String organizeCode) {
        this.organizeCode = organizeCode;
    }

    /**
     * 获取股票代码
     *
     * @return stock_code - 股票代码
     */
    public Integer getStockCode() {
        return stockCode;
    }

    /**
     * 设置股票代码
     *
     * @param stockCode 股票代码
     */
    public void setStockCode(Integer stockCode) {
        this.stockCode = stockCode;
    }

    /**
     * 获取企业性质
     *
     * @return character_id - 企业性质
     */
    public Byte getCharacterId() {
        return characterId;
    }

    /**
     * 设置企业性质
     *
     * @param characterId 企业性质
     */
    public void setCharacterId(Byte characterId) {
        this.characterId = characterId;
    }

    /**
     * 获取企业所属行业
     *
     * @return industry_type - 企业所属行业
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * 设置企业所属行业
     *
     * @param industryType 企业所属行业
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    /**
     * 获取主营业务
     *
     * @return main_business - 主营业务
     */
    public String getMainBusiness() {
        return mainBusiness;
    }

    /**
     * 设置主营业务
     *
     * @param mainBusiness 主营业务
     */
    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取控股股东
     *
     * @return controlling_shareholders - 控股股东
     */
    public String getControllingShareholders() {
        return controllingShareholders;
    }

    /**
     * 设置控股股东
     *
     * @param controllingShareholders 控股股东
     */
    public void setControllingShareholders(String controllingShareholders) {
        this.controllingShareholders = controllingShareholders;
    }

    /**
     * 获取实际控制人
     *
     * @return actual_controller - 实际控制人
     */
    public String getActualController() {
        return actualController;
    }

    /**
     * 设置实际控制人
     *
     * @param actualController 实际控制人
     */
    public void setActualController(String actualController) {
        this.actualController = actualController;
    }

    /**
     * 获取最终控制人
     *
     * @return ultimate_controller - 最终控制人
     */
    public String getUltimateController() {
        return ultimateController;
    }

    /**
     * 设置最终控制人
     *
     * @param ultimateController 最终控制人
     */
    public void setUltimateController(String ultimateController) {
        this.ultimateController = ultimateController;
    }

    /**
     * 获取法定代表人
     *
     * @return legal_person - 法定代表人
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法定代表人
     *
     * @param legalPerson 法定代表人
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 获取董事长
     *
     * @return chairman - 董事长
     */
    public String getChairman() {
        return chairman;
    }

    /**
     * 设置董事长
     *
     * @param chairman 董事长
     */
    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    /**
     * 获取董秘
     *
     * @return secretaries - 董秘
     */
    public String getSecretaries() {
        return secretaries;
    }

    /**
     * 设置董秘
     *
     * @param secretaries 董秘
     */
    public void setSecretaries(String secretaries) {
        this.secretaries = secretaries;
    }

    /**
     * 获取董秘传真
     *
     * @return cs_fax - 董秘传真
     */
    public String getCsFax() {
        return csFax;
    }

    /**
     * 设置董秘传真
     *
     * @param csFax 董秘传真
     */
    public void setCsFax(String csFax) {
        this.csFax = csFax;
    }

    /**
     * 获取董秘邮箱
     *
     * @return cs_email - 董秘邮箱
     */
    public String getCsEmail() {
        return csEmail;
    }

    /**
     * 设置董秘邮箱
     *
     * @param csEmail 董秘邮箱
     */
    public void setCsEmail(String csEmail) {
        this.csEmail = csEmail;
    }

    /**
     * 获取董秘电话
     *
     * @return cs_tel - 董秘电话
     */
    public String getCsTel() {
        return csTel;
    }

    /**
     * 设置董秘电话
     *
     * @param csTel 董秘电话
     */
    public void setCsTel(String csTel) {
        this.csTel = csTel;
    }

    /**
     * 获取总经理
     *
     * @return general_manager - 总经理
     */
    public String getGeneralManager() {
        return generalManager;
    }

    /**
     * 设置总经理
     *
     * @param generalManager 总经理
     */
    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager;
    }

    /**
     * 获取注册资金
     *
     * @return registered_capital - 注册资金
     */
    public String getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * 设置注册资金
     *
     * @param registeredCapital 注册资金
     */
    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    /**
     * 获取员工人数
     *
     * @return employees_number - 员工人数
     */
    public String getEmployeesNumber() {
        return employeesNumber;
    }

    /**
     * 设置员工人数
     *
     * @param employeesNumber 员工人数
     */
    public void setEmployeesNumber(String employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    /**
     * 获取注册地址
     *
     * @return reg_addr - 注册地址
     */
    public String getRegAddr() {
        return regAddr;
    }

    /**
     * 设置注册地址
     *
     * @param regAddr 注册地址
     */
    public void setRegAddr(String regAddr) {
        this.regAddr = regAddr;
    }

    /**
     * 获取地址 - 中文
     *
     * @return cn_addr - 地址 - 中文
     */
    public String getCnAddr() {
        return cnAddr;
    }

    /**
     * 设置地址 - 中文
     *
     * @param cnAddr 地址 - 中文
     */
    public void setCnAddr(String cnAddr) {
        this.cnAddr = cnAddr;
    }

    /**
     * 获取地址 - 英文
     *
     * @return en_addr - 地址 - 英文
     */
    public String getEnAddr() {
        return enAddr;
    }

    /**
     * 设置地址 - 英文
     *
     * @param enAddr 地址 - 英文
     */
    public void setEnAddr(String enAddr) {
        this.enAddr = enAddr;
    }

    /**
     * 获取邮编
     *
     * @return postcode - 邮编
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 设置邮编
     *
     * @param postcode 邮编
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * 获取电话
     *
     * @return telephone - 电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话
     *
     * @param telephone 电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取传真
     *
     * @return fax - 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真
     *
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取交易所类型  新三板,证券交易所,商品交易所,黄金交易所
     *
     * @return exchange_type - 交易所类型  新三板,证券交易所,商品交易所,黄金交易所
     */
    public String getExchangeType() {
        return exchangeType;
    }

    /**
     * 设置交易所类型  新三板,证券交易所,商品交易所,黄金交易所
     *
     * @param exchangeType 交易所类型  新三板,证券交易所,商品交易所,黄金交易所
     */
    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    /**
     * 获取企业工商注册号
     *
     * @return business_registration_id - 企业工商注册号
     */
    public String getBusinessRegistrationId() {
        return businessRegistrationId;
    }

    /**
     * 设置企业工商注册号
     *
     * @param businessRegistrationId 企业工商注册号
     */
    public void setBusinessRegistrationId(String businessRegistrationId) {
        this.businessRegistrationId = businessRegistrationId;
    }

    /**
     * 获取企业注册类型 1,内资企业 2,国有企业 3,集体企业 4,股份合作企业
     *
     * @return registered_type - 企业注册类型 1,内资企业 2,国有企业 3,集体企业 4,股份合作企业
     */
    public String getRegisteredType() {
        return registeredType;
    }

    /**
     * 设置企业注册类型 1,内资企业 2,国有企业 3,集体企业 4,股份合作企业
     *
     * @param registeredType 企业注册类型 1,内资企业 2,国有企业 3,集体企业 4,股份合作企业
     */
    public void setRegisteredType(String registeredType) {
        this.registeredType = registeredType;
    }

    /**
     * 获取企业上市信息ID
     *
     * @return app_id - 企业上市信息ID
     */
    public Integer getAppId() {
        return appId;
    }

    /**
     * 设置企业上市信息ID
     *
     * @param appId 企业上市信息ID
     */
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    /**
     * 获取证监会所属行业
     *
     * @return management_industry - 证监会所属行业
     */
    public String getManagementIndustry() {
        return managementIndustry;
    }

    /**
     * 设置证监会所属行业
     *
     * @param managementIndustry 证监会所属行业
     */
    public void setManagementIndustry(String managementIndustry) {
        this.managementIndustry = managementIndustry;
    }

    /**
     * 获取转让类型
     *
     * @return transfer_type - 转让类型
     */
    public String getTransferType() {
        return transferType;
    }

    /**
     * 设置转让类型
     *
     * @param transferType 转让类型
     */
    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    /**
     * 获取主办券商
     *
     * @return sponsored_broker - 主办券商
     */
    public String getSponsoredBroker() {
        return sponsoredBroker;
    }

    /**
     * 设置主办券商
     *
     * @param sponsoredBroker 主办券商
     */
    public void setSponsoredBroker(String sponsoredBroker) {
        this.sponsoredBroker = sponsoredBroker;
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

    /**
     * 获取中文描述
     *
     * @return cn_desc - 中文描述
     */
    public String getCnDesc() {
        return cnDesc;
    }

    /**
     * 设置中文描述
     *
     * @param cnDesc 中文描述
     */
    public void setCnDesc(String cnDesc) {
        this.cnDesc = cnDesc;
    }

    /**
     * 获取英文描述
     *
     * @return en_desc - 英文描述
     */
    public String getEnDesc() {
        return enDesc;
    }

    /**
     * 设置英文描述
     *
     * @param enDesc 英文描述
     */
    public void setEnDesc(String enDesc) {
        this.enDesc = enDesc;
    }

    /**
     * 获取备注
     *
     * @return content - 备注
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置备注
     *
     * @param content 备注
     */
    public void setContent(String content) {
        this.content = content;
    }
}