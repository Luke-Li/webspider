package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_ent_manageteam")
public class XsbThsEntManageteam {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联企业ID
     */
    @Column(name = "ent_id")
    private Integer entId;

    /**
     * 职务类型:董事会，监事会，高管
     */
    @Column(name = "position_type")
    private String positionType;

    /**
     * 高管名称
     */
    private String personagename;

    /**
     * 是否离职 1-是;2-否;
     */
    private Integer leaveoffice;

    /**
     * 报告日期
     */
    @Column(name = "report_date")
    private String reportDate;

    /**
     * 本届任期
     */
    @Column(name = "office_term")
    private String officeTerm;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 职位名称
     */
    private String position;

    /**
     * 受教育程度
     */
    private String education;

    /**
     * 年薪
     */
    @Column(name = "annual_salary")
    private String annualSalary;

    /**
     * 持股数量
     */
    private String shares;

    /**
     * 所占总股东本比率%
     */
    @Column(name = "shareholders_ratio")
    private Double shareholdersRatio;

    /**
     * 排序
     */
    private Integer ordered;

    /**
     * 高管介绍
     */
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取关联企业ID
     *
     * @return ent_id - 关联企业ID
     */
    public Integer getEntId() {
        return entId;
    }

    /**
     * 设置关联企业ID
     *
     * @param entId 关联企业ID
     */
    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    /**
     * 获取职务类型:董事会，监事会，高管
     *
     * @return position_type - 职务类型:董事会，监事会，高管
     */
    public String getPositionType() {
        return positionType;
    }

    /**
     * 设置职务类型:董事会，监事会，高管
     *
     * @param positionType 职务类型:董事会，监事会，高管
     */
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    /**
     * 获取高管名称
     *
     * @return personagename - 高管名称
     */
    public String getPersonagename() {
        return personagename;
    }

    /**
     * 设置高管名称
     *
     * @param personagename 高管名称
     */
    public void setPersonagename(String personagename) {
        this.personagename = personagename;
    }

    /**
     * 获取是否离职 1-是;2-否;
     *
     * @return leaveoffice - 是否离职 1-是;2-否;
     */
    public Integer getLeaveoffice() {
        return leaveoffice;
    }

    /**
     * 设置是否离职 1-是;2-否;
     *
     * @param leaveoffice 是否离职 1-是;2-否;
     */
    public void setLeaveoffice(Integer leaveoffice) {
        this.leaveoffice = leaveoffice;
    }

    /**
     * 获取报告日期
     *
     * @return report_date - 报告日期
     */
    public String getReportDate() {
        return reportDate;
    }

    /**
     * 设置报告日期
     *
     * @param reportDate 报告日期
     */
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * 获取本届任期
     *
     * @return office_term - 本届任期
     */
    public String getOfficeTerm() {
        return officeTerm;
    }

    /**
     * 设置本届任期
     *
     * @param officeTerm 本届任期
     */
    public void setOfficeTerm(String officeTerm) {
        this.officeTerm = officeTerm;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 获取职位名称
     *
     * @return position - 职位名称
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位名称
     *
     * @param position 职位名称
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取受教育程度
     *
     * @return education - 受教育程度
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置受教育程度
     *
     * @param education 受教育程度
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取年薪
     *
     * @return annual_salary - 年薪
     */
    public String getAnnualSalary() {
        return annualSalary;
    }

    /**
     * 设置年薪
     *
     * @param annualSalary 年薪
     */
    public void setAnnualSalary(String annualSalary) {
        this.annualSalary = annualSalary;
    }

    /**
     * 获取持股数量
     *
     * @return shares - 持股数量
     */
    public String getShares() {
        return shares;
    }

    /**
     * 设置持股数量
     *
     * @param shares 持股数量
     */
    public void setShares(String shares) {
        this.shares = shares;
    }

    /**
     * 获取所占总股东本比率%
     *
     * @return shareholders_ratio - 所占总股东本比率%
     */
    public Double getShareholdersRatio() {
        return shareholdersRatio;
    }

    /**
     * 设置所占总股东本比率%
     *
     * @param shareholdersRatio 所占总股东本比率%
     */
    public void setShareholdersRatio(Double shareholdersRatio) {
        this.shareholdersRatio = shareholdersRatio;
    }

    /**
     * 获取排序
     *
     * @return ordered - 排序
     */
    public Integer getOrdered() {
        return ordered;
    }

    /**
     * 设置排序
     *
     * @param ordered 排序
     */
    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    /**
     * 获取高管介绍
     *
     * @return description - 高管介绍
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置高管介绍
     *
     * @param description 高管介绍
     */
    public void setDescription(String description) {
        this.description = description;
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
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}