package com.chinaventure.webspider.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_hx_financial_ratios")
public class XsbHxFinancialRatios {
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
     * 流动比率(%)
     */
    @Column(name = "current_ratio")
    private BigDecimal currentRatio;

    /**
     * 速动比率(%)
     */
    @Column(name = "quick_ratio")
    private BigDecimal quickRatio;

    /**
     * 债务权益比率(%)
     */
    @Column(name = "debt_equity_ratio")
    private BigDecimal debtEquityRatio;

    /**
     * 债务偿付比率(%)
     */
    @Column(name = "debt_solvency_ratio")
    private BigDecimal debtSolvencyRatio;

    /**
     * 负债结构比率(%)
     */
    @Column(name = "debt_structure_ratio")
    private BigDecimal debtStructureRatio;

    /**
     * 利息支付倍数
     */
    @Column(name = "interest_coverage_ratio")
    private BigDecimal interestCoverageRatio;

    /**
     * 净资产收益率(%)
     */
    private BigDecimal roe;

    /**
     * 总资产收益率(%)
     */
    private BigDecimal rota;

    /**
     * 主营收入毛利润率(%)
     */
    @Column(name = "gross_profit_margin")
    private BigDecimal grossProfitMargin;

    /**
     * 营业利润率(%)
     */
    @Column(name = "operating_profit_ratio")
    private BigDecimal operatingProfitRatio;

    /**
     * 股利支付比率(%)
     */
    @Column(name = "dividend_payout_ratio")
    private BigDecimal dividendPayoutRatio;

    /**
     * 收益留存比率(%)
     */
    @Column(name = "earnings_retention_ratio")
    private BigDecimal earningsRetentionRatio;

    /**
     * 应收账款周转率(%)
     */
    @Column(name = "accounts_receivable_turnover_ratio")
    private BigDecimal accountsReceivableTurnoverRatio;

    /**
     * 流动资产周转率(%)
     */
    @Column(name = "current_assets_turnover_rate")
    private BigDecimal currentAssetsTurnoverRate;

    /**
     * 固定资产周转率(%)
     */
    @Column(name = "fixed_asset_turnover")
    private BigDecimal fixedAssetTurnover;

    /**
     * 存货周转率(%)
     */
    @Column(name = "inventory_turnover_ratio")
    private BigDecimal inventoryTurnoverRatio;

    /**
     * 总资产周转率(%)
     */
    @Column(name = "total_asset_turnover_ratio")
    private BigDecimal totalAssetTurnoverRatio;

    /**
     * 净资产周转率(%)
     */
    @Column(name = "net_asset_turnover_ratio")
    private BigDecimal netAssetTurnoverRatio;

    /**
     * 流动资产对总资产的比率(%)
     */
    @Column(name = "current_to_total_assets_ratio")
    private BigDecimal currentToTotalAssetsRatio;

    /**
     * 资产负债率(%)
     */
    @Column(name = "asset_liability_ratio")
    private BigDecimal assetLiabilityRatio;

    /**
     * 资本固定化比率(%)
     */
    @Column(name = "capital_immobilized_ratio")
    private BigDecimal capitalImmobilizedRatio;

    /**
     * 权益系数(%)
     */
    @Column(name = "rights_coefficient")
    private BigDecimal rightsCoefficient;

    /**
     * 产权比率(%)
     */
    @Column(name = "equity_ratio")
    private BigDecimal equityRatio;

    /**
     * 股东权益比率(%)
     */
    @Column(name = "shareholders_equity_ratio")
    private BigDecimal shareholdersEquityRatio;

    /**
     * 营业收入增长率(%)
     */
    @Column(name = "operating_income_growth_rate")
    private BigDecimal operatingIncomeGrowthRate;

    /**
     * 净利润增长率(%)
     */
    @Column(name = "net_profit_growth_rate")
    private BigDecimal netProfitGrowthRate;

    /**
     * 总资产扩张率(%)
     */
    @Column(name = "total_assets_expansion_rate")
    private BigDecimal totalAssetsExpansionRate;

    /**
     * 每股收益增长率(%)
     */
    @Column(name = "earnings_per_share_growth_rate")
    private BigDecimal earningsPerShareGrowthRate;

    /**
     * 净资产增长率(%)
     */
    @Column(name = "net_asset_growth_rate")
    private BigDecimal netAssetGrowthRate;

    /**
     * 每股经营现金净流量(元)
     */
    @Column(name = "operating_cash_flows_per_share")
    private BigDecimal operatingCashFlowsPerShare;

    /**
     * 资产的经营现金流量回报率(%)
     */
    @Column(name = "operating_cash_flow_return_assets")
    private BigDecimal operatingCashFlowReturnAssets;

    /**
     * 经营现金净流量对负债的比率(%)
     */
    @Column(name = "operating_cash_flows_liabilities_ratio")
    private BigDecimal operatingCashFlowsLiabilitiesRatio;

    /**
     * 经营活动产生的现金净流量增长率(%)
     */
    @Column(name = "business_activities_generated_cash_flows_growth_rate")
    private BigDecimal businessActivitiesGeneratedCashFlowsGrowthRate;

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
     * 获取流动比率(%)
     *
     * @return current_ratio - 流动比率(%)
     */
    public BigDecimal getCurrentRatio() {
        return currentRatio;
    }

    /**
     * 设置流动比率(%)
     *
     * @param currentRatio 流动比率(%)
     */
    public void setCurrentRatio(BigDecimal currentRatio) {
        this.currentRatio = currentRatio;
    }

    /**
     * 获取速动比率(%)
     *
     * @return quick_ratio - 速动比率(%)
     */
    public BigDecimal getQuickRatio() {
        return quickRatio;
    }

    /**
     * 设置速动比率(%)
     *
     * @param quickRatio 速动比率(%)
     */
    public void setQuickRatio(BigDecimal quickRatio) {
        this.quickRatio = quickRatio;
    }

    /**
     * 获取债务权益比率(%)
     *
     * @return debt_equity_ratio - 债务权益比率(%)
     */
    public BigDecimal getDebtEquityRatio() {
        return debtEquityRatio;
    }

    /**
     * 设置债务权益比率(%)
     *
     * @param debtEquityRatio 债务权益比率(%)
     */
    public void setDebtEquityRatio(BigDecimal debtEquityRatio) {
        this.debtEquityRatio = debtEquityRatio;
    }

    /**
     * 获取债务偿付比率(%)
     *
     * @return debt_solvency_ratio - 债务偿付比率(%)
     */
    public BigDecimal getDebtSolvencyRatio() {
        return debtSolvencyRatio;
    }

    /**
     * 设置债务偿付比率(%)
     *
     * @param debtSolvencyRatio 债务偿付比率(%)
     */
    public void setDebtSolvencyRatio(BigDecimal debtSolvencyRatio) {
        this.debtSolvencyRatio = debtSolvencyRatio;
    }

    /**
     * 获取负债结构比率(%)
     *
     * @return debt_structure_ratio - 负债结构比率(%)
     */
    public BigDecimal getDebtStructureRatio() {
        return debtStructureRatio;
    }

    /**
     * 设置负债结构比率(%)
     *
     * @param debtStructureRatio 负债结构比率(%)
     */
    public void setDebtStructureRatio(BigDecimal debtStructureRatio) {
        this.debtStructureRatio = debtStructureRatio;
    }

    /**
     * 获取利息支付倍数
     *
     * @return interest_coverage_ratio - 利息支付倍数
     */
    public BigDecimal getInterestCoverageRatio() {
        return interestCoverageRatio;
    }

    /**
     * 设置利息支付倍数
     *
     * @param interestCoverageRatio 利息支付倍数
     */
    public void setInterestCoverageRatio(BigDecimal interestCoverageRatio) {
        this.interestCoverageRatio = interestCoverageRatio;
    }

    /**
     * 获取净资产收益率(%)
     *
     * @return roe - 净资产收益率(%)
     */
    public BigDecimal getRoe() {
        return roe;
    }

    /**
     * 设置净资产收益率(%)
     *
     * @param roe 净资产收益率(%)
     */
    public void setRoe(BigDecimal roe) {
        this.roe = roe;
    }

    /**
     * 获取总资产收益率(%)
     *
     * @return rota - 总资产收益率(%)
     */
    public BigDecimal getRota() {
        return rota;
    }

    /**
     * 设置总资产收益率(%)
     *
     * @param rota 总资产收益率(%)
     */
    public void setRota(BigDecimal rota) {
        this.rota = rota;
    }

    /**
     * 获取主营收入毛利润率(%)
     *
     * @return gross_profit_margin - 主营收入毛利润率(%)
     */
    public BigDecimal getGrossProfitMargin() {
        return grossProfitMargin;
    }

    /**
     * 设置主营收入毛利润率(%)
     *
     * @param grossProfitMargin 主营收入毛利润率(%)
     */
    public void setGrossProfitMargin(BigDecimal grossProfitMargin) {
        this.grossProfitMargin = grossProfitMargin;
    }

    /**
     * 获取营业利润率(%)
     *
     * @return operating_profit_ratio - 营业利润率(%)
     */
    public BigDecimal getOperatingProfitRatio() {
        return operatingProfitRatio;
    }

    /**
     * 设置营业利润率(%)
     *
     * @param operatingProfitRatio 营业利润率(%)
     */
    public void setOperatingProfitRatio(BigDecimal operatingProfitRatio) {
        this.operatingProfitRatio = operatingProfitRatio;
    }

    /**
     * 获取股利支付比率(%)
     *
     * @return dividend_payout_ratio - 股利支付比率(%)
     */
    public BigDecimal getDividendPayoutRatio() {
        return dividendPayoutRatio;
    }

    /**
     * 设置股利支付比率(%)
     *
     * @param dividendPayoutRatio 股利支付比率(%)
     */
    public void setDividendPayoutRatio(BigDecimal dividendPayoutRatio) {
        this.dividendPayoutRatio = dividendPayoutRatio;
    }

    /**
     * 获取收益留存比率(%)
     *
     * @return earnings_retention_ratio - 收益留存比率(%)
     */
    public BigDecimal getEarningsRetentionRatio() {
        return earningsRetentionRatio;
    }

    /**
     * 设置收益留存比率(%)
     *
     * @param earningsRetentionRatio 收益留存比率(%)
     */
    public void setEarningsRetentionRatio(BigDecimal earningsRetentionRatio) {
        this.earningsRetentionRatio = earningsRetentionRatio;
    }

    /**
     * 获取应收账款周转率(%)
     *
     * @return accounts_receivable_turnover_ratio - 应收账款周转率(%)
     */
    public BigDecimal getAccountsReceivableTurnoverRatio() {
        return accountsReceivableTurnoverRatio;
    }

    /**
     * 设置应收账款周转率(%)
     *
     * @param accountsReceivableTurnoverRatio 应收账款周转率(%)
     */
    public void setAccountsReceivableTurnoverRatio(BigDecimal accountsReceivableTurnoverRatio) {
        this.accountsReceivableTurnoverRatio = accountsReceivableTurnoverRatio;
    }

    /**
     * 获取流动资产周转率(%)
     *
     * @return current_assets_turnover_rate - 流动资产周转率(%)
     */
    public BigDecimal getCurrentAssetsTurnoverRate() {
        return currentAssetsTurnoverRate;
    }

    /**
     * 设置流动资产周转率(%)
     *
     * @param currentAssetsTurnoverRate 流动资产周转率(%)
     */
    public void setCurrentAssetsTurnoverRate(BigDecimal currentAssetsTurnoverRate) {
        this.currentAssetsTurnoverRate = currentAssetsTurnoverRate;
    }

    /**
     * 获取固定资产周转率(%)
     *
     * @return fixed_asset_turnover - 固定资产周转率(%)
     */
    public BigDecimal getFixedAssetTurnover() {
        return fixedAssetTurnover;
    }

    /**
     * 设置固定资产周转率(%)
     *
     * @param fixedAssetTurnover 固定资产周转率(%)
     */
    public void setFixedAssetTurnover(BigDecimal fixedAssetTurnover) {
        this.fixedAssetTurnover = fixedAssetTurnover;
    }

    /**
     * 获取存货周转率(%)
     *
     * @return inventory_turnover_ratio - 存货周转率(%)
     */
    public BigDecimal getInventoryTurnoverRatio() {
        return inventoryTurnoverRatio;
    }

    /**
     * 设置存货周转率(%)
     *
     * @param inventoryTurnoverRatio 存货周转率(%)
     */
    public void setInventoryTurnoverRatio(BigDecimal inventoryTurnoverRatio) {
        this.inventoryTurnoverRatio = inventoryTurnoverRatio;
    }

    /**
     * 获取总资产周转率(%)
     *
     * @return total_asset_turnover_ratio - 总资产周转率(%)
     */
    public BigDecimal getTotalAssetTurnoverRatio() {
        return totalAssetTurnoverRatio;
    }

    /**
     * 设置总资产周转率(%)
     *
     * @param totalAssetTurnoverRatio 总资产周转率(%)
     */
    public void setTotalAssetTurnoverRatio(BigDecimal totalAssetTurnoverRatio) {
        this.totalAssetTurnoverRatio = totalAssetTurnoverRatio;
    }

    /**
     * 获取净资产周转率(%)
     *
     * @return net_asset_turnover_ratio - 净资产周转率(%)
     */
    public BigDecimal getNetAssetTurnoverRatio() {
        return netAssetTurnoverRatio;
    }

    /**
     * 设置净资产周转率(%)
     *
     * @param netAssetTurnoverRatio 净资产周转率(%)
     */
    public void setNetAssetTurnoverRatio(BigDecimal netAssetTurnoverRatio) {
        this.netAssetTurnoverRatio = netAssetTurnoverRatio;
    }

    /**
     * 获取流动资产对总资产的比率(%)
     *
     * @return current_to_total_assets_ratio - 流动资产对总资产的比率(%)
     */
    public BigDecimal getCurrentToTotalAssetsRatio() {
        return currentToTotalAssetsRatio;
    }

    /**
     * 设置流动资产对总资产的比率(%)
     *
     * @param currentToTotalAssetsRatio 流动资产对总资产的比率(%)
     */
    public void setCurrentToTotalAssetsRatio(BigDecimal currentToTotalAssetsRatio) {
        this.currentToTotalAssetsRatio = currentToTotalAssetsRatio;
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

    /**
     * 获取资本固定化比率(%)
     *
     * @return capital_immobilized_ratio - 资本固定化比率(%)
     */
    public BigDecimal getCapitalImmobilizedRatio() {
        return capitalImmobilizedRatio;
    }

    /**
     * 设置资本固定化比率(%)
     *
     * @param capitalImmobilizedRatio 资本固定化比率(%)
     */
    public void setCapitalImmobilizedRatio(BigDecimal capitalImmobilizedRatio) {
        this.capitalImmobilizedRatio = capitalImmobilizedRatio;
    }

    /**
     * 获取权益系数(%)
     *
     * @return rights_coefficient - 权益系数(%)
     */
    public BigDecimal getRightsCoefficient() {
        return rightsCoefficient;
    }

    /**
     * 设置权益系数(%)
     *
     * @param rightsCoefficient 权益系数(%)
     */
    public void setRightsCoefficient(BigDecimal rightsCoefficient) {
        this.rightsCoefficient = rightsCoefficient;
    }

    /**
     * 获取产权比率(%)
     *
     * @return equity_ratio - 产权比率(%)
     */
    public BigDecimal getEquityRatio() {
        return equityRatio;
    }

    /**
     * 设置产权比率(%)
     *
     * @param equityRatio 产权比率(%)
     */
    public void setEquityRatio(BigDecimal equityRatio) {
        this.equityRatio = equityRatio;
    }

    /**
     * 获取股东权益比率(%)
     *
     * @return shareholders_equity_ratio - 股东权益比率(%)
     */
    public BigDecimal getShareholdersEquityRatio() {
        return shareholdersEquityRatio;
    }

    /**
     * 设置股东权益比率(%)
     *
     * @param shareholdersEquityRatio 股东权益比率(%)
     */
    public void setShareholdersEquityRatio(BigDecimal shareholdersEquityRatio) {
        this.shareholdersEquityRatio = shareholdersEquityRatio;
    }

    /**
     * 获取营业收入增长率(%)
     *
     * @return operating_income_growth_rate - 营业收入增长率(%)
     */
    public BigDecimal getOperatingIncomeGrowthRate() {
        return operatingIncomeGrowthRate;
    }

    /**
     * 设置营业收入增长率(%)
     *
     * @param operatingIncomeGrowthRate 营业收入增长率(%)
     */
    public void setOperatingIncomeGrowthRate(BigDecimal operatingIncomeGrowthRate) {
        this.operatingIncomeGrowthRate = operatingIncomeGrowthRate;
    }

    /**
     * 获取净利润增长率(%)
     *
     * @return net_profit_growth_rate - 净利润增长率(%)
     */
    public BigDecimal getNetProfitGrowthRate() {
        return netProfitGrowthRate;
    }

    /**
     * 设置净利润增长率(%)
     *
     * @param netProfitGrowthRate 净利润增长率(%)
     */
    public void setNetProfitGrowthRate(BigDecimal netProfitGrowthRate) {
        this.netProfitGrowthRate = netProfitGrowthRate;
    }

    /**
     * 获取总资产扩张率(%)
     *
     * @return total_assets_expansion_rate - 总资产扩张率(%)
     */
    public BigDecimal getTotalAssetsExpansionRate() {
        return totalAssetsExpansionRate;
    }

    /**
     * 设置总资产扩张率(%)
     *
     * @param totalAssetsExpansionRate 总资产扩张率(%)
     */
    public void setTotalAssetsExpansionRate(BigDecimal totalAssetsExpansionRate) {
        this.totalAssetsExpansionRate = totalAssetsExpansionRate;
    }

    /**
     * 获取每股收益增长率(%)
     *
     * @return earnings_per_share_growth_rate - 每股收益增长率(%)
     */
    public BigDecimal getEarningsPerShareGrowthRate() {
        return earningsPerShareGrowthRate;
    }

    /**
     * 设置每股收益增长率(%)
     *
     * @param earningsPerShareGrowthRate 每股收益增长率(%)
     */
    public void setEarningsPerShareGrowthRate(BigDecimal earningsPerShareGrowthRate) {
        this.earningsPerShareGrowthRate = earningsPerShareGrowthRate;
    }

    /**
     * 获取净资产增长率(%)
     *
     * @return net_asset_growth_rate - 净资产增长率(%)
     */
    public BigDecimal getNetAssetGrowthRate() {
        return netAssetGrowthRate;
    }

    /**
     * 设置净资产增长率(%)
     *
     * @param netAssetGrowthRate 净资产增长率(%)
     */
    public void setNetAssetGrowthRate(BigDecimal netAssetGrowthRate) {
        this.netAssetGrowthRate = netAssetGrowthRate;
    }

    /**
     * 获取每股经营现金净流量(元)
     *
     * @return operating_cash_flows_per_share - 每股经营现金净流量(元)
     */
    public BigDecimal getOperatingCashFlowsPerShare() {
        return operatingCashFlowsPerShare;
    }

    /**
     * 设置每股经营现金净流量(元)
     *
     * @param operatingCashFlowsPerShare 每股经营现金净流量(元)
     */
    public void setOperatingCashFlowsPerShare(BigDecimal operatingCashFlowsPerShare) {
        this.operatingCashFlowsPerShare = operatingCashFlowsPerShare;
    }

    /**
     * 获取资产的经营现金流量回报率(%)
     *
     * @return operating_cash_flow_return_assets - 资产的经营现金流量回报率(%)
     */
    public BigDecimal getOperatingCashFlowReturnAssets() {
        return operatingCashFlowReturnAssets;
    }

    /**
     * 设置资产的经营现金流量回报率(%)
     *
     * @param operatingCashFlowReturnAssets 资产的经营现金流量回报率(%)
     */
    public void setOperatingCashFlowReturnAssets(BigDecimal operatingCashFlowReturnAssets) {
        this.operatingCashFlowReturnAssets = operatingCashFlowReturnAssets;
    }

    /**
     * 获取经营现金净流量对负债的比率(%)
     *
     * @return operating_cash_flows_liabilities_ratio - 经营现金净流量对负债的比率(%)
     */
    public BigDecimal getOperatingCashFlowsLiabilitiesRatio() {
        return operatingCashFlowsLiabilitiesRatio;
    }

    /**
     * 设置经营现金净流量对负债的比率(%)
     *
     * @param operatingCashFlowsLiabilitiesRatio 经营现金净流量对负债的比率(%)
     */
    public void setOperatingCashFlowsLiabilitiesRatio(BigDecimal operatingCashFlowsLiabilitiesRatio) {
        this.operatingCashFlowsLiabilitiesRatio = operatingCashFlowsLiabilitiesRatio;
    }

    /**
     * 获取经营活动产生的现金净流量增长率(%)
     *
     * @return business_activities_generated_cash_flows_growth_rate - 经营活动产生的现金净流量增长率(%)
     */
    public BigDecimal getBusinessActivitiesGeneratedCashFlowsGrowthRate() {
        return businessActivitiesGeneratedCashFlowsGrowthRate;
    }

    /**
     * 设置经营活动产生的现金净流量增长率(%)
     *
     * @param businessActivitiesGeneratedCashFlowsGrowthRate 经营活动产生的现金净流量增长率(%)
     */
    public void setBusinessActivitiesGeneratedCashFlowsGrowthRate(BigDecimal businessActivitiesGeneratedCashFlowsGrowthRate) {
        this.businessActivitiesGeneratedCashFlowsGrowthRate = businessActivitiesGeneratedCashFlowsGrowthRate;
    }
}