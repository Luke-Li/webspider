package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pof_list")
public class PofList {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 法定代表人/执行事务合伙人(委派代表)姓名
     */
    @Column(name = "artificialPersonName")
    private String artificialpersonname;

    /**
     * 成立日期
     */
    @Column(name = "establishDate")
    private Long establishdate;

    /**
     * 基金数量
     */
    @Column(name = "fundCount")
    private Integer fundcount;

    /**
     * 基金规模
     */
    @Column(name = "fundScale")
    private Double fundscale;

    /**
     * 信用提示
     */
    @Column(name = "hasCreditTips")
    private Boolean hascredittips;

    /**
     * 特别提示
     */
    @Column(name = "hasSpecialTips")
    private Boolean hasspecialtips;

    /**
     * 网站上的编号
     */
    @Column(name = "siteId")
    private String siteid;

    /**
     * 是否在黑名单
     */
    @Column(name = "inBlacklist")
    private Boolean inblacklist;

    /**
     * managerHasProduct
     */
    @Column(name = "managerHasProduct")
    private String managerhasproduct;

    /**
     * 私募基金管理人名称
     */
    @Column(name = "managerName")
    private String managername;

    /**
     * 办公地址
     */
    @Column(name = "officeAddress")
    private String officeaddress;

    /**
     * 办公城市
     */
    @Column(name = "officeCity")
    private String officecity;

    /**
     * 办公坐标
     */
    @Column(name = "officeCoordinate")
    private String officecoordinate;

    /**
     * 办公省份
     */
    @Column(name = "officeProvince")
    private String officeprovince;

    /**
     * 基金主要类别
     */
    @Column(name = "primaryInvestType")
    private String primaryinvesttype;

    /**
     * regAdrAgg
     */
    @Column(name = "regAdrAgg")
    private String regadragg;

    /**
     * 注册坐标(经纬度)
     */
    @Column(name = "regCoordinate")
    private String regcoordinate;

    /**
     * 注册地址
     */
    @Column(name = "registerAddress")
    private String registeraddress;

    /**
     * 注册地市
     */
    @Column(name = "registerCity")
    private String registercity;

    /**
     * 登记日期
     */
    @Column(name = "registerDate")
    private Long registerdate;

    /**
     * 登记编号
     */
    @Column(name = "registerNo")
    private String registerno;

    /**
     * 注册省份
     */
    @Column(name = "registerProvince")
    private String registerprovince;

    /**
     * 详细地址的链接
     */
    private String url;

    /**
     * 创建时间
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
     * 获取法定代表人/执行事务合伙人(委派代表)姓名
     *
     * @return artificialPersonName - 法定代表人/执行事务合伙人(委派代表)姓名
     */
    public String getArtificialpersonname() {
        return artificialpersonname;
    }

    /**
     * 设置法定代表人/执行事务合伙人(委派代表)姓名
     *
     * @param artificialpersonname 法定代表人/执行事务合伙人(委派代表)姓名
     */
    public void setArtificialpersonname(String artificialpersonname) {
        this.artificialpersonname = artificialpersonname;
    }

    /**
     * 获取成立日期
     *
     * @return establishDate - 成立日期
     */
    public Long getEstablishdate() {
        return establishdate;
    }

    /**
     * 设置成立日期
     *
     * @param establishdate 成立日期
     */
    public void setEstablishdate(Long establishdate) {
        this.establishdate = establishdate;
    }

    /**
     * 获取基金数量
     *
     * @return fundCount - 基金数量
     */
    public Integer getFundcount() {
        return fundcount;
    }

    /**
     * 设置基金数量
     *
     * @param fundcount 基金数量
     */
    public void setFundcount(Integer fundcount) {
        this.fundcount = fundcount;
    }

    /**
     * 获取基金规模
     *
     * @return fundScale - 基金规模
     */
    public Double getFundscale() {
        return fundscale;
    }

    /**
     * 设置基金规模
     *
     * @param fundscale 基金规模
     */
    public void setFundscale(Double fundscale) {
        this.fundscale = fundscale;
    }

    /**
     * 获取信用提示
     *
     * @return hasCreditTips - 信用提示
     */
    public Boolean getHascredittips() {
        return hascredittips;
    }

    /**
     * 设置信用提示
     *
     * @param hascredittips 信用提示
     */
    public void setHascredittips(Boolean hascredittips) {
        this.hascredittips = hascredittips;
    }

    /**
     * 获取特别提示
     *
     * @return hasSpecialTips - 特别提示
     */
    public Boolean getHasspecialtips() {
        return hasspecialtips;
    }

    /**
     * 设置特别提示
     *
     * @param hasspecialtips 特别提示
     */
    public void setHasspecialtips(Boolean hasspecialtips) {
        this.hasspecialtips = hasspecialtips;
    }

    /**
     * 获取网站上的编号
     *
     * @return siteId - 网站上的编号
     */
    public String getSiteid() {
        return siteid;
    }

    /**
     * 设置网站上的编号
     *
     * @param siteid 网站上的编号
     */
    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    /**
     * 获取是否在黑名单
     *
     * @return inBlacklist - 是否在黑名单
     */
    public Boolean getInblacklist() {
        return inblacklist;
    }

    /**
     * 设置是否在黑名单
     *
     * @param inblacklist 是否在黑名单
     */
    public void setInblacklist(Boolean inblacklist) {
        this.inblacklist = inblacklist;
    }

    /**
     * 获取managerHasProduct
     *
     * @return managerHasProduct - managerHasProduct
     */
    public String getManagerhasproduct() {
        return managerhasproduct;
    }

    /**
     * 设置managerHasProduct
     *
     * @param managerhasproduct managerHasProduct
     */
    public void setManagerhasproduct(String managerhasproduct) {
        this.managerhasproduct = managerhasproduct;
    }

    /**
     * 获取私募基金管理人名称
     *
     * @return managerName - 私募基金管理人名称
     */
    public String getManagername() {
        return managername;
    }

    /**
     * 设置私募基金管理人名称
     *
     * @param managername 私募基金管理人名称
     */
    public void setManagername(String managername) {
        this.managername = managername;
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
     * 获取办公城市
     *
     * @return officeCity - 办公城市
     */
    public String getOfficecity() {
        return officecity;
    }

    /**
     * 设置办公城市
     *
     * @param officecity 办公城市
     */
    public void setOfficecity(String officecity) {
        this.officecity = officecity;
    }

    /**
     * 获取办公坐标
     *
     * @return officeCoordinate - 办公坐标
     */
    public String getOfficecoordinate() {
        return officecoordinate;
    }

    /**
     * 设置办公坐标
     *
     * @param officecoordinate 办公坐标
     */
    public void setOfficecoordinate(String officecoordinate) {
        this.officecoordinate = officecoordinate;
    }

    /**
     * 获取办公省份
     *
     * @return officeProvince - 办公省份
     */
    public String getOfficeprovince() {
        return officeprovince;
    }

    /**
     * 设置办公省份
     *
     * @param officeprovince 办公省份
     */
    public void setOfficeprovince(String officeprovince) {
        this.officeprovince = officeprovince;
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
     * 获取regAdrAgg
     *
     * @return regAdrAgg - regAdrAgg
     */
    public String getRegadragg() {
        return regadragg;
    }

    /**
     * 设置regAdrAgg
     *
     * @param regadragg regAdrAgg
     */
    public void setRegadragg(String regadragg) {
        this.regadragg = regadragg;
    }

    /**
     * 获取注册坐标(经纬度)
     *
     * @return regCoordinate - 注册坐标(经纬度)
     */
    public String getRegcoordinate() {
        return regcoordinate;
    }

    /**
     * 设置注册坐标(经纬度)
     *
     * @param regcoordinate 注册坐标(经纬度)
     */
    public void setRegcoordinate(String regcoordinate) {
        this.regcoordinate = regcoordinate;
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
     * 获取注册地市
     *
     * @return registerCity - 注册地市
     */
    public String getRegistercity() {
        return registercity;
    }

    /**
     * 设置注册地市
     *
     * @param registercity 注册地市
     */
    public void setRegistercity(String registercity) {
        this.registercity = registercity;
    }

    /**
     * 获取登记日期
     *
     * @return registerDate - 登记日期
     */
    public Long getRegisterdate() {
        return registerdate;
    }

    /**
     * 设置登记日期
     *
     * @param registerdate 登记日期
     */
    public void setRegisterdate(Long registerdate) {
        this.registerdate = registerdate;
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
     * 获取注册省份
     *
     * @return registerProvince - 注册省份
     */
    public String getRegisterprovince() {
        return registerprovince;
    }

    /**
     * 设置注册省份
     *
     * @param registerprovince 注册省份
     */
    public void setRegisterprovince(String registerprovince) {
        this.registerprovince = registerprovince;
    }

    /**
     * 获取详细地址的链接
     *
     * @return url - 详细地址的链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置详细地址的链接
     *
     * @param url 详细地址的链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
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
     * 基金管理人信息
     */
    @Transient
    private PofInfo info;
    /**
     * 基金管理人信息
     */
	public PofInfo getInfo() {
		return info;
	}
	/**
     * 基金管理人信息
     */
	public void setInfo(PofInfo info) {
		this.info = info;
	}
    
}