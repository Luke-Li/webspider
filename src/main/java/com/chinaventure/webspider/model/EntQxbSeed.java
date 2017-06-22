package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ent_qxb_seed")
public class EntQxbSeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 启信宝的UUID(公司ID)
     */
    private String uuid;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 是否已经抓取
     */
    private Boolean state;

    /**
     * 搜索的关键词
     */
    private String keywords;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 创建时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取启信宝的UUID(公司ID)
     *
     * @return uuid - 启信宝的UUID(公司ID)
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置启信宝的UUID(公司ID)
     *
     * @param uuid 启信宝的UUID(公司ID)
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取公司名称
     *
     * @return name - 公司名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司名称
     *
     * @param name 公司名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取是否已经抓取
     *
     * @return state - 是否已经抓取
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置是否已经抓取
     *
     * @param state 是否已经抓取
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * 获取搜索的关键词
     *
     * @return keywords - 搜索的关键词
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * 设置搜索的关键词
     *
     * @param keywords 搜索的关键词
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * 获取优先级
     *
     * @return priority - 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置优先级
     *
     * @param priority 优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取创建时间
     *
     * @return update_time - 创建时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置创建时间
     *
     * @param updateTime 创建时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}