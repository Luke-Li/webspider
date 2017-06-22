package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pedaily_company")
public class PedailyCompany {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 产品名称
     */
    @Column(name = "pro_name")
    private String proName;

    /**
     * 地区
     */
    private String area;

    /**
     * 行业
     */
    private String industry;

    /**
     * 详细信息链接
     */
    @Column(name = "detail_url")
    private String detailUrl;

    /**
     * 公司简介
     */
    private String brief;

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
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取产品名称
     *
     * @return pro_name - 产品名称
     */
    public String getProName() {
        return proName;
    }

    /**
     * 设置产品名称
     *
     * @param proName 产品名称
     */
    public void setProName(String proName) {
        this.proName = proName;
    }

    /**
     * 获取地区
     *
     * @return area - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area;
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