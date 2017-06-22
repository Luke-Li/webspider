package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ent_qxb_ent_error_log")
public class EntQxbEntErrorLog {
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
     * 抓取的URL
     */
    private String url;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 错误描述
     */
    private String description;

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
     * 获取抓取的URL
     *
     * @return url - 抓取的URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置抓取的URL
     *
     * @param url 抓取的URL
     */
    public void setUrl(String url) {
        this.url = url;
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
     * 获取错误描述
     *
     * @return description - 错误描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置错误描述
     *
     * @param description 错误描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}