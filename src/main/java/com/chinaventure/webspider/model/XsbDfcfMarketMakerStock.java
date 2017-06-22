package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_dfcf_market_maker_stock")
public class XsbDfcfMarketMakerStock {
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
     * 做市商名称
     */
    @Column(name = "maker_name")
    private String makerName;

    /**
     * 做市商类型:主做市商,做市商
     */
    @Column(name = "maker_type")
    private String makerType;

    /**
     * 做市日期
     */
    @Column(name = "report_date")
    private Date reportDate;

    /**
     * 库存股
     */
    @Column(name = "stock_stock")
    private String stockStock;

    /**
     * 股本比例
     */
    @Column(name = "equity_ratio")
    private String equityRatio;

    /**
     * 股本来源
     */
    @Column(name = "capital_source")
    private String capitalSource;

    /**
     * 成本价格
     */
    @Column(name = "cost_price")
    private String costPrice;

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
     * 获取做市商名称
     *
     * @return maker_name - 做市商名称
     */
    public String getMakerName() {
        return makerName;
    }

    /**
     * 设置做市商名称
     *
     * @param makerName 做市商名称
     */
    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    /**
     * 获取做市商类型:主做市商,做市商
     *
     * @return maker_type - 做市商类型:主做市商,做市商
     */
    public String getMakerType() {
        return makerType;
    }

    /**
     * 设置做市商类型:主做市商,做市商
     *
     * @param makerType 做市商类型:主做市商,做市商
     */
    public void setMakerType(String makerType) {
        this.makerType = makerType;
    }

    /**
     * 获取做市日期
     *
     * @return report_date - 做市日期
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * 设置做市日期
     *
     * @param reportDate 做市日期
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * 获取库存股
     *
     * @return stock_stock - 库存股
     */
    public String getStockStock() {
        return stockStock;
    }

    /**
     * 设置库存股
     *
     * @param stockStock 库存股
     */
    public void setStockStock(String stockStock) {
        this.stockStock = stockStock;
    }

    /**
     * 获取股本比例
     *
     * @return equity_ratio - 股本比例
     */
    public String getEquityRatio() {
        return equityRatio;
    }

    /**
     * 设置股本比例
     *
     * @param equityRatio 股本比例
     */
    public void setEquityRatio(String equityRatio) {
        this.equityRatio = equityRatio;
    }

    /**
     * 获取股本来源
     *
     * @return capital_source - 股本来源
     */
    public String getCapitalSource() {
        return capitalSource;
    }

    /**
     * 设置股本来源
     *
     * @param capitalSource 股本来源
     */
    public void setCapitalSource(String capitalSource) {
        this.capitalSource = capitalSource;
    }

    /**
     * 获取成本价格
     *
     * @return cost_price - 成本价格
     */
    public String getCostPrice() {
        return costPrice;
    }

    /**
     * 设置成本价格
     *
     * @param costPrice 成本价格
     */
    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }
}