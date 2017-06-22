package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_finance_json")
public class XsbThsFinanceJson {
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
     * 建立时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 主要指标
     */
    private String main;

    /**
     * 资产负债
     */
    private String debt;

    /**
     * 利润
     */
    private String benefit;

    /**
     * 现金流量
     */
    private String cash;

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
     * 获取建立时间
     *
     * @return create_time - 建立时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置建立时间
     *
     * @param createTime 建立时间
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
     * 获取主要指标
     *
     * @return main - 主要指标
     */
    public String getMain() {
        return main;
    }

    /**
     * 设置主要指标
     *
     * @param main 主要指标
     */
    public void setMain(String main) {
        this.main = main;
    }

    /**
     * 获取资产负债
     *
     * @return debt - 资产负债
     */
    public String getDebt() {
        return debt;
    }

    /**
     * 设置资产负债
     *
     * @param debt 资产负债
     */
    public void setDebt(String debt) {
        this.debt = debt;
    }

    /**
     * 获取利润
     *
     * @return benefit - 利润
     */
    public String getBenefit() {
        return benefit;
    }

    /**
     * 设置利润
     *
     * @param benefit 利润
     */
    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    /**
     * 获取现金流量
     *
     * @return cash - 现金流量
     */
    public String getCash() {
        return cash;
    }

    /**
     * 设置现金流量
     *
     * @param cash 现金流量
     */
    public void setCash(String cash) {
        this.cash = cash;
    }
}