package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pof_manager")
public class PofManager {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 所属类别
     */
    @Column(name = "groupName")
    private String groupname;

    /**
     * 会员姓名
     */
    @Column(name = "memberName")
    private String membername;

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
     * 获取所属类别
     *
     * @return groupName - 所属类别
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * 设置所属类别
     *
     * @param groupname 所属类别
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    /**
     * 获取会员姓名
     *
     * @return memberName - 会员姓名
     */
    public String getMembername() {
        return membername;
    }

    /**
     * 设置会员姓名
     *
     * @param membername 会员姓名
     */
    public void setMembername(String membername) {
        this.membername = membername;
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