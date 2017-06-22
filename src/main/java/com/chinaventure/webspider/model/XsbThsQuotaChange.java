package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_quota_change")
public class XsbThsQuotaChange {
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
     * 报告日期
     */
    @Column(name = "report_date")
    private Date reportDate;

    /**
     * 变动科目
     */
    @Column(name = "change_item")
    private String changeItem;

    /**
     * 本期数值(万)
     */
    @Column(name = "this_period")
    private String thisPeriod;

    /**
     * 上期数值(万)
     */
    @Column(name = "pre_period")
    private String prePeriod;

    /**
     * 变动幅度
     */
    @Column(name = "change_width")
    private String changeWidth;

    /**
     * 变动原因
     */
    @Column(name = "change_reason")
    private String changeReason;

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
     * 获取报告日期
     *
     * @return report_date - 报告日期
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * 设置报告日期
     *
     * @param reportDate 报告日期
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * 获取变动科目
     *
     * @return change_item - 变动科目
     */
    public String getChangeItem() {
        return changeItem;
    }

    /**
     * 设置变动科目
     *
     * @param changeItem 变动科目
     */
    public void setChangeItem(String changeItem) {
        this.changeItem = changeItem;
    }

    /**
     * 获取本期数值(万)
     *
     * @return this_period - 本期数值(万)
     */
    public String getThisPeriod() {
        return thisPeriod;
    }

    /**
     * 设置本期数值(万)
     *
     * @param thisPeriod 本期数值(万)
     */
    public void setThisPeriod(String thisPeriod) {
        this.thisPeriod = thisPeriod;
    }

    /**
     * 获取上期数值(万)
     *
     * @return pre_period - 上期数值(万)
     */
    public String getPrePeriod() {
        return prePeriod;
    }

    /**
     * 设置上期数值(万)
     *
     * @param prePeriod 上期数值(万)
     */
    public void setPrePeriod(String prePeriod) {
        this.prePeriod = prePeriod;
    }

    /**
     * 获取变动幅度
     *
     * @return change_width - 变动幅度
     */
    public String getChangeWidth() {
        return changeWidth;
    }

    /**
     * 设置变动幅度
     *
     * @param changeWidth 变动幅度
     */
    public void setChangeWidth(String changeWidth) {
        this.changeWidth = changeWidth;
    }

    /**
     * 获取变动原因
     *
     * @return change_reason - 变动原因
     */
    public String getChangeReason() {
        return changeReason;
    }

    /**
     * 设置变动原因
     *
     * @param changeReason 变动原因
     */
    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
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