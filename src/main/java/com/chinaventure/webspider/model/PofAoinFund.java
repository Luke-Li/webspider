package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pof_aoin_fund")
public class PofAoinFund {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品编码
     */
    private String code;

    /**
     * 设立日期
     */
    @Column(name = "createDate")
    private Long createdate;

    /**
     * 直投子公司
     */
    @Column(name = "aoinName")
    private String aoinname;

    /**
     * 管理机构
     */
    @Column(name = "managerName")
    private String managername;

    /**
     * 内部id
     */
    @Column(name = "innerId")
    private String innerid;

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
     * 获取产品名称
     *
     * @return name - 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品名称
     *
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取产品编码
     *
     * @return code - 产品编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置产品编码
     *
     * @param code 产品编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取设立日期
     *
     * @return createDate - 设立日期
     */
    public Long getCreatedate() {
        return createdate;
    }

    /**
     * 设置设立日期
     *
     * @param createdate 设立日期
     */
    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取直投子公司
     *
     * @return aoinName - 直投子公司
     */
    public String getAoinname() {
        return aoinname;
    }

    /**
     * 设置直投子公司
     *
     * @param aoinname 直投子公司
     */
    public void setAoinname(String aoinname) {
        this.aoinname = aoinname;
    }

    /**
     * 获取管理机构
     *
     * @return managerName - 管理机构
     */
    public String getManagername() {
        return managername;
    }

    /**
     * 设置管理机构
     *
     * @param managername 管理机构
     */
    public void setManagername(String managername) {
        this.managername = managername;
    }

    /**
     * 获取内部id
     *
     * @return innerId - 内部id
     */
    public String getInnerid() {
        return innerid;
    }

    /**
     * 设置内部id
     *
     * @param innerid 内部id
     */
    public void setInnerid(String innerid) {
        this.innerid = innerid;
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
}