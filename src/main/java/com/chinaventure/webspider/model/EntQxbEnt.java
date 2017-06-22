package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ent_qxb_ent")
public class EntQxbEnt {
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
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 数据来源机器的IP
     */
    private String ip;

    /**
     * 下载数据使用的COOKIE
     */
    private String cookie;

    /**
     * 起源
     */
    private String parent;
    
    /**
     * 深度
     */
    private Integer depth;
    
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
     * 数据来源机器的IP
     * @return
     */
    public String getIp() {
		return ip;
	}

    /**
     * 数据来源机器的IP
     * @param ip
     */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
     * 下载数据使用的COOKIE
     * @return
     */
	public String getCookie() {
		return cookie;
	}
	
	/**
	 * 下载数据使用的COOKIE
	 * @param cookie
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	/**
     * 起源
     */
	public String getParent() {
		return parent;
	}

	/**
     * 起源
     */
	public void setParent(String parent) {
		this.parent = parent;
	}

    /**
     * 深度
     */
	public Integer getDepth() {
		return depth;
	}

    /**
     * 深度
     */
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	
}