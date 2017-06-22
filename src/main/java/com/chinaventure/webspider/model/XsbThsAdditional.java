package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_additional")
public class XsbThsAdditional {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司关联表
     */
    @Column(name = "ent_id")
    private Integer entId;

    /**
     * 实际发行价格(元)
     */
    @Column(name = "actual_issue_price")
    private String actualIssuePrice;

    /**
     * 实际发行数量(万股)
     */
    @Column(name = "actual_number_issued")
    private String actualNumberIssued;

    /**
     * 实际募集净额(万元)
     */
    @Column(name = "actual_raised_net")
    private String actualRaisedNet;

    /**
     * 预案发行价格(元)
     */
    @Column(name = "plan_issue_price")
    private String planIssuePrice;

    /**
     * 预案发行数量(万股)
     */
    @Column(name = "plan_issue_number")
    private String planIssueNumber;

    /**
     * 预案募资金额(万元)
     */
    @Column(name = "plan_raised_net")
    private String planRaisedNet;

    /**
     * 新股上市公告日
     */
    @Column(name = "ipo_report_day")
    private Date ipoReportDay;

    /**
     * 发行新股日
     */
    @Column(name = "new_shares_day")
    private Date newSharesDay;

    /**
     * 证监会核准公告日
     */
    @Column(name = "csrc_report_day")
    private Date csrcReportDay;

    /**
     * 发审委公告日
     */
    @Column(name = "iec_report_day")
    private Date iecReportDay;

    /**
     * 股东大会公告日
     */
    @Column(name = "shareholders_meeting_day")
    private Date shareholdersMeetingDay;

    /**
     * 预案公布日/董事会公告日
     */
    @Column(name = "plan_announced_day")
    private Date planAnnouncedDay;

    /**
     * 方案进度(如 已实施,进行中)
     */
    @Column(name = "scheme_progress")
    private String schemeProgress;

    /**
     * 发行类型(非公开增发,公开增发)
     */
    @Column(name = "release_type")
    private String releaseType;

    /**
     * 发行方式(定向,非定向)
     */
    @Column(name = "release_mode")
    private String releaseMode;

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
     * 获取公司关联表
     *
     * @return ent_id - 公司关联表
     */
    public Integer getEntId() {
        return entId;
    }

    /**
     * 设置公司关联表
     *
     * @param entId 公司关联表
     */
    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    /**
     * 获取实际发行价格(元)
     *
     * @return actual_issue_price - 实际发行价格(元)
     */
    public String getActualIssuePrice() {
        return actualIssuePrice;
    }

    /**
     * 设置实际发行价格(元)
     *
     * @param actualIssuePrice 实际发行价格(元)
     */
    public void setActualIssuePrice(String actualIssuePrice) {
        this.actualIssuePrice = actualIssuePrice;
    }

    /**
     * 获取实际发行数量(万股)
     *
     * @return actual_number_issued - 实际发行数量(万股)
     */
    public String getActualNumberIssued() {
        return actualNumberIssued;
    }

    /**
     * 设置实际发行数量(万股)
     *
     * @param actualNumberIssued 实际发行数量(万股)
     */
    public void setActualNumberIssued(String actualNumberIssued) {
        this.actualNumberIssued = actualNumberIssued;
    }

    /**
     * 获取实际募集净额(万元)
     *
     * @return actual_raised_net - 实际募集净额(万元)
     */
    public String getActualRaisedNet() {
        return actualRaisedNet;
    }

    /**
     * 设置实际募集净额(万元)
     *
     * @param actualRaisedNet 实际募集净额(万元)
     */
    public void setActualRaisedNet(String actualRaisedNet) {
        this.actualRaisedNet = actualRaisedNet;
    }

    /**
     * 获取预案发行价格(元)
     *
     * @return plan_issue_price - 预案发行价格(元)
     */
    public String getPlanIssuePrice() {
        return planIssuePrice;
    }

    /**
     * 设置预案发行价格(元)
     *
     * @param planIssuePrice 预案发行价格(元)
     */
    public void setPlanIssuePrice(String planIssuePrice) {
        this.planIssuePrice = planIssuePrice;
    }

    /**
     * 获取预案发行数量(万股)
     *
     * @return plan_issue_number - 预案发行数量(万股)
     */
    public String getPlanIssueNumber() {
        return planIssueNumber;
    }

    /**
     * 设置预案发行数量(万股)
     *
     * @param planIssueNumber 预案发行数量(万股)
     */
    public void setPlanIssueNumber(String planIssueNumber) {
        this.planIssueNumber = planIssueNumber;
    }

    /**
     * 获取预案募资金额(万元)
     *
     * @return plan_raised_net - 预案募资金额(万元)
     */
    public String getPlanRaisedNet() {
        return planRaisedNet;
    }

    /**
     * 设置预案募资金额(万元)
     *
     * @param planRaisedNet 预案募资金额(万元)
     */
    public void setPlanRaisedNet(String planRaisedNet) {
        this.planRaisedNet = planRaisedNet;
    }

    /**
     * 获取新股上市公告日
     *
     * @return ipo_report_day - 新股上市公告日
     */
    public Date getIpoReportDay() {
        return ipoReportDay;
    }

    /**
     * 设置新股上市公告日
     *
     * @param ipoReportDay 新股上市公告日
     */
    public void setIpoReportDay(Date ipoReportDay) {
        this.ipoReportDay = ipoReportDay;
    }

    /**
     * 获取发行新股日
     *
     * @return new_shares_day - 发行新股日
     */
    public Date getNewSharesDay() {
        return newSharesDay;
    }

    /**
     * 设置发行新股日
     *
     * @param newSharesDay 发行新股日
     */
    public void setNewSharesDay(Date newSharesDay) {
        this.newSharesDay = newSharesDay;
    }

    /**
     * 获取证监会核准公告日
     *
     * @return csrc_report_day - 证监会核准公告日
     */
    public Date getCsrcReportDay() {
        return csrcReportDay;
    }

    /**
     * 设置证监会核准公告日
     *
     * @param csrcReportDay 证监会核准公告日
     */
    public void setCsrcReportDay(Date csrcReportDay) {
        this.csrcReportDay = csrcReportDay;
    }

    /**
     * 获取发审委公告日
     *
     * @return iec_report_day - 发审委公告日
     */
    public Date getIecReportDay() {
        return iecReportDay;
    }

    /**
     * 设置发审委公告日
     *
     * @param iecReportDay 发审委公告日
     */
    public void setIecReportDay(Date iecReportDay) {
        this.iecReportDay = iecReportDay;
    }

    /**
     * 获取股东大会公告日
     *
     * @return shareholders_meeting_day - 股东大会公告日
     */
    public Date getShareholdersMeetingDay() {
        return shareholdersMeetingDay;
    }

    /**
     * 设置股东大会公告日
     *
     * @param shareholdersMeetingDay 股东大会公告日
     */
    public void setShareholdersMeetingDay(Date shareholdersMeetingDay) {
        this.shareholdersMeetingDay = shareholdersMeetingDay;
    }

    /**
     * 获取预案公布日/董事会公告日
     *
     * @return plan_announced_day - 预案公布日/董事会公告日
     */
    public Date getPlanAnnouncedDay() {
        return planAnnouncedDay;
    }

    /**
     * 设置预案公布日/董事会公告日
     *
     * @param planAnnouncedDay 预案公布日/董事会公告日
     */
    public void setPlanAnnouncedDay(Date planAnnouncedDay) {
        this.planAnnouncedDay = planAnnouncedDay;
    }

    /**
     * 获取方案进度(如 已实施,进行中)
     *
     * @return scheme_progress - 方案进度(如 已实施,进行中)
     */
    public String getSchemeProgress() {
        return schemeProgress;
    }

    /**
     * 设置方案进度(如 已实施,进行中)
     *
     * @param schemeProgress 方案进度(如 已实施,进行中)
     */
    public void setSchemeProgress(String schemeProgress) {
        this.schemeProgress = schemeProgress;
    }

    /**
     * 获取发行类型(非公开增发,公开增发)
     *
     * @return release_type - 发行类型(非公开增发,公开增发)
     */
    public String getReleaseType() {
        return releaseType;
    }

    /**
     * 设置发行类型(非公开增发,公开增发)
     *
     * @param releaseType 发行类型(非公开增发,公开增发)
     */
    public void setReleaseType(String releaseType) {
        this.releaseType = releaseType;
    }

    /**
     * 获取发行方式(定向,非定向)
     *
     * @return release_mode - 发行方式(定向,非定向)
     */
    public String getReleaseMode() {
        return releaseMode;
    }

    /**
     * 设置发行方式(定向,非定向)
     *
     * @param releaseMode 发行方式(定向,非定向)
     */
    public void setReleaseMode(String releaseMode) {
        this.releaseMode = releaseMode;
    }
}