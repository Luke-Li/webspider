package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pof_info_legalperson_resume")
public class PofInfoLegalpersonResume {
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
     * 时间
     */
    @Column(name = "tenureOffice")
    private String tenureoffice;

    /**
     * 任职单位
     */
    @Column(name = "tenureEnt")
    private String tenureent;

    /**
     * 职务
     */
    private String position;

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
     * 获取时间
     *
     * @return tenureOffice - 时间
     */
    public String getTenureoffice() {
        return tenureoffice;
    }

    /**
     * 设置时间
     *
     * @param tenureoffice 时间
     */
    public void setTenureoffice(String tenureoffice) {
        this.tenureoffice = tenureoffice;
    }

    /**
     * 获取任职单位
     *
     * @return tenureEnt - 任职单位
     */
    public String getTenureent() {
        return tenureent;
    }

    /**
     * 设置任职单位
     *
     * @param tenureent 任职单位
     */
    public void setTenureent(String tenureent) {
        this.tenureent = tenureent;
    }

    /**
     * 获取职务
     *
     * @return position - 职务
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职务
     *
     * @param position 职务
     */
    public void setPosition(String position) {
        this.position = position;
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