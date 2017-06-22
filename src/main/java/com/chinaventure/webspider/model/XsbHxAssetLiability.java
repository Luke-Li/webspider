package com.chinaventure.webspider.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_hx_asset_liability")
public class XsbHxAssetLiability {
    /**
     * 自增主键
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
     * 报告日期
     */
    @Column(name = "report_date")
    private Date reportDate;

    /**
     * 货币资金(万元)
     */
    @Column(name = "monetary_funds")
    private BigDecimal monetaryFunds;

    /**
     * 交易性金融资产(万元)
     */
    @Column(name = "transactional_financial_assets")
    private BigDecimal transactionalFinancialAssets;

    /**
     * 可出售金融资产(万元)
     */
    @Column(name = "can_sell_financial_assets")
    private BigDecimal canSellFinancialAssets;

    /**
     * 固定资产(万元)
     */
    @Column(name = "fixed_assets")
    private BigDecimal fixedAssets;

    /**
     * 无形资产(万元)
     */
    @Column(name = "intangible_assets")
    private BigDecimal intangibleAssets;

    /**
     * 长期股权投资(万元)
     */
    @Column(name = "long_term_equity_investment")
    private BigDecimal longTermEquityInvestment;

    /**
     * 总资产(万元)
     */
    @Column(name = "total_assets")
    private BigDecimal totalAssets;

    /**
     * 应付利息(万元)
     */
    @Column(name = "interest_payable")
    private BigDecimal interestPayable;

    /**
     * 应付职工薪酬(万元)
     */
    @Column(name = "handle_employee_compensation")
    private BigDecimal handleEmployeeCompensation;

    /**
     * 其他负债(万元)
     */
    @Column(name = "other_liabilities")
    private BigDecimal otherLiabilities;

    /**
     * 总负债(万元)
     */
    @Column(name = "total_liabilities")
    private BigDecimal totalLiabilities;

    /**
     * 未分配利润(万元)
     */
    @Column(name = "undistributed_profit")
    private BigDecimal undistributedProfit;

    /**
     * 归属于母公司股东权益合计(万元)
     */
    @Column(name = "parent_company_shareholders_equity")
    private BigDecimal parentCompanyShareholdersEquity;

    /**
     * 少数股东权益(万元)
     */
    @Column(name = "minority_shareholders_rights_interests")
    private BigDecimal minorityShareholdersRightsInterests;

    /**
     * 股东权益合计(万元)
     */
    @Column(name = "Shareholders_equity_combined")
    private BigDecimal shareholdersEquityCombined;

    /**
     * 资产负债率(%)
     */
    @Column(name = "asset_liability_ratio")
    private BigDecimal assetLiabilityRatio;

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
     * 获取货币资金(万元)
     *
     * @return monetary_funds - 货币资金(万元)
     */
    public BigDecimal getMonetaryFunds() {
        return monetaryFunds;
    }

    /**
     * 设置货币资金(万元)
     *
     * @param monetaryFunds 货币资金(万元)
     */
    public void setMonetaryFunds(BigDecimal monetaryFunds) {
        this.monetaryFunds = monetaryFunds;
    }

    /**
     * 获取交易性金融资产(万元)
     *
     * @return transactional_financial_assets - 交易性金融资产(万元)
     */
    public BigDecimal getTransactionalFinancialAssets() {
        return transactionalFinancialAssets;
    }

    /**
     * 设置交易性金融资产(万元)
     *
     * @param transactionalFinancialAssets 交易性金融资产(万元)
     */
    public void setTransactionalFinancialAssets(BigDecimal transactionalFinancialAssets) {
        this.transactionalFinancialAssets = transactionalFinancialAssets;
    }

    /**
     * 获取可出售金融资产(万元)
     *
     * @return can_sell_financial_assets - 可出售金融资产(万元)
     */
    public BigDecimal getCanSellFinancialAssets() {
        return canSellFinancialAssets;
    }

    /**
     * 设置可出售金融资产(万元)
     *
     * @param canSellFinancialAssets 可出售金融资产(万元)
     */
    public void setCanSellFinancialAssets(BigDecimal canSellFinancialAssets) {
        this.canSellFinancialAssets = canSellFinancialAssets;
    }

    /**
     * 获取固定资产(万元)
     *
     * @return fixed_assets - 固定资产(万元)
     */
    public BigDecimal getFixedAssets() {
        return fixedAssets;
    }

    /**
     * 设置固定资产(万元)
     *
     * @param fixedAssets 固定资产(万元)
     */
    public void setFixedAssets(BigDecimal fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    /**
     * 获取无形资产(万元)
     *
     * @return intangible_assets - 无形资产(万元)
     */
    public BigDecimal getIntangibleAssets() {
        return intangibleAssets;
    }

    /**
     * 设置无形资产(万元)
     *
     * @param intangibleAssets 无形资产(万元)
     */
    public void setIntangibleAssets(BigDecimal intangibleAssets) {
        this.intangibleAssets = intangibleAssets;
    }

    /**
     * 获取长期股权投资(万元)
     *
     * @return long_term_equity_investment - 长期股权投资(万元)
     */
    public BigDecimal getLongTermEquityInvestment() {
        return longTermEquityInvestment;
    }

    /**
     * 设置长期股权投资(万元)
     *
     * @param longTermEquityInvestment 长期股权投资(万元)
     */
    public void setLongTermEquityInvestment(BigDecimal longTermEquityInvestment) {
        this.longTermEquityInvestment = longTermEquityInvestment;
    }

    /**
     * 获取总资产(万元)
     *
     * @return total_assets - 总资产(万元)
     */
    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    /**
     * 设置总资产(万元)
     *
     * @param totalAssets 总资产(万元)
     */
    public void setTotalAssets(BigDecimal totalAssets) {
        this.totalAssets = totalAssets;
    }

    /**
     * 获取应付利息(万元)
     *
     * @return interest_payable - 应付利息(万元)
     */
    public BigDecimal getInterestPayable() {
        return interestPayable;
    }

    /**
     * 设置应付利息(万元)
     *
     * @param interestPayable 应付利息(万元)
     */
    public void setInterestPayable(BigDecimal interestPayable) {
        this.interestPayable = interestPayable;
    }

    /**
     * 获取应付职工薪酬(万元)
     *
     * @return handle_employee_compensation - 应付职工薪酬(万元)
     */
    public BigDecimal getHandleEmployeeCompensation() {
        return handleEmployeeCompensation;
    }

    /**
     * 设置应付职工薪酬(万元)
     *
     * @param handleEmployeeCompensation 应付职工薪酬(万元)
     */
    public void setHandleEmployeeCompensation(BigDecimal handleEmployeeCompensation) {
        this.handleEmployeeCompensation = handleEmployeeCompensation;
    }

    /**
     * 获取其他负债(万元)
     *
     * @return other_liabilities - 其他负债(万元)
     */
    public BigDecimal getOtherLiabilities() {
        return otherLiabilities;
    }

    /**
     * 设置其他负债(万元)
     *
     * @param otherLiabilities 其他负债(万元)
     */
    public void setOtherLiabilities(BigDecimal otherLiabilities) {
        this.otherLiabilities = otherLiabilities;
    }

    /**
     * 获取总负债(万元)
     *
     * @return total_liabilities - 总负债(万元)
     */
    public BigDecimal getTotalLiabilities() {
        return totalLiabilities;
    }

    /**
     * 设置总负债(万元)
     *
     * @param totalLiabilities 总负债(万元)
     */
    public void setTotalLiabilities(BigDecimal totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    /**
     * 获取未分配利润(万元)
     *
     * @return undistributed_profit - 未分配利润(万元)
     */
    public BigDecimal getUndistributedProfit() {
        return undistributedProfit;
    }

    /**
     * 设置未分配利润(万元)
     *
     * @param undistributedProfit 未分配利润(万元)
     */
    public void setUndistributedProfit(BigDecimal undistributedProfit) {
        this.undistributedProfit = undistributedProfit;
    }

    /**
     * 获取归属于母公司股东权益合计(万元)
     *
     * @return parent_company_shareholders_equity - 归属于母公司股东权益合计(万元)
     */
    public BigDecimal getParentCompanyShareholdersEquity() {
        return parentCompanyShareholdersEquity;
    }

    /**
     * 设置归属于母公司股东权益合计(万元)
     *
     * @param parentCompanyShareholdersEquity 归属于母公司股东权益合计(万元)
     */
    public void setParentCompanyShareholdersEquity(BigDecimal parentCompanyShareholdersEquity) {
        this.parentCompanyShareholdersEquity = parentCompanyShareholdersEquity;
    }

    /**
     * 获取少数股东权益(万元)
     *
     * @return minority_shareholders_rights_interests - 少数股东权益(万元)
     */
    public BigDecimal getMinorityShareholdersRightsInterests() {
        return minorityShareholdersRightsInterests;
    }

    /**
     * 设置少数股东权益(万元)
     *
     * @param minorityShareholdersRightsInterests 少数股东权益(万元)
     */
    public void setMinorityShareholdersRightsInterests(BigDecimal minorityShareholdersRightsInterests) {
        this.minorityShareholdersRightsInterests = minorityShareholdersRightsInterests;
    }

    /**
     * 获取股东权益合计(万元)
     *
     * @return Shareholders_equity_combined - 股东权益合计(万元)
     */
    public BigDecimal getShareholdersEquityCombined() {
        return shareholdersEquityCombined;
    }

    /**
     * 设置股东权益合计(万元)
     *
     * @param shareholdersEquityCombined 股东权益合计(万元)
     */
    public void setShareholdersEquityCombined(BigDecimal shareholdersEquityCombined) {
        this.shareholdersEquityCombined = shareholdersEquityCombined;
    }

    /**
     * 获取资产负债率(%)
     *
     * @return asset_liability_ratio - 资产负债率(%)
     */
    public BigDecimal getAssetLiabilityRatio() {
        return assetLiabilityRatio;
    }

    /**
     * 设置资产负债率(%)
     *
     * @param assetLiabilityRatio 资产负债率(%)
     */
    public void setAssetLiabilityRatio(BigDecimal assetLiabilityRatio) {
        this.assetLiabilityRatio = assetLiabilityRatio;
    }
}