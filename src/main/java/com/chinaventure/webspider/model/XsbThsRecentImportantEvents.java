package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_recent_important_events")
public class XsbThsRecentImportantEvents {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联公司ID
     */
    @Column(name = "ent_id")
    private Integer entId;

    /**
     * 事件日期
     */
    @Column(name = "report_date")
    private Date reportDate;

    /**
     * 事件链接
     */
    @Column(name = "event_url")
    private String eventUrl;

    /**
     * 事件说明
     */
    @Column(name = "event_description")
    private String eventDescription;

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
     * 获取关联公司ID
     *
     * @return ent_id - 关联公司ID
     */
    public Integer getEntId() {
        return entId;
    }

    /**
     * 设置关联公司ID
     *
     * @param entId 关联公司ID
     */
    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    /**
     * 获取事件日期
     *
     * @return report_date - 事件日期
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * 设置事件日期
     *
     * @param reportDate 事件日期
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * 获取事件链接
     *
     * @return event_url - 事件链接
     */
    public String getEventUrl() {
        return eventUrl;
    }

    /**
     * 设置事件链接
     *
     * @param eventUrl 事件链接
     */
    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    /**
     * 获取事件说明
     *
     * @return event_description - 事件说明
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * 设置事件说明
     *
     * @param eventDescription 事件说明
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}