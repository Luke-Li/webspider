package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "innotree_ent")
public class InnotreeEnt {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 因果树内部ID
     */
    @Column(name = "innerId")
    private Integer innerid;

    /**
     * 行业信息
     */
    private String industry;

    /**
     * 公司/商标名称
     */
    private String name;

    /**
     * logo
     */
    private String logo;

    /**
     * 融资阶段
     */
    private String period;

    /**
     * 公司评分
     */
    private Integer score;

    /**
     * 公司所在地区
     */
    private String area;

    /**
     * 创始人
     */
    private String founder;

    /**
     * 公司名称
     */
    @Column(name = "fullName")
    private String fullname;

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
     * 获取因果树内部ID
     *
     * @return innerId - 因果树内部ID
     */
    public Integer getInnerid() {
        return innerid;
    }

    /**
     * 设置因果树内部ID
     *
     * @param innerid 因果树内部ID
     */
    public void setInnerid(Integer innerid) {
        this.innerid = innerid;
    }

    /**
     * 获取行业信息
     *
     * @return industry - 行业信息
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置行业信息
     *
     * @param industry 行业信息
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 获取公司/商标名称
     *
     * @return name - 公司/商标名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司/商标名称
     *
     * @param name 公司/商标名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取融资阶段
     *
     * @return period - 融资阶段
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 设置融资阶段
     *
     * @param period 融资阶段
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * 获取公司评分
     *
     * @return score - 公司评分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置公司评分
     *
     * @param score 公司评分
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取公司所在地区
     *
     * @return area - 公司所在地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置公司所在地区
     *
     * @param area 公司所在地区
     */
    public void setArea(String area) {
        this.area = area;
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
     * 获取公司名称
     *
     * @return fullName - 公司名称
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * 设置公司名称
     *
     * @param fullname 公司名称
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
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