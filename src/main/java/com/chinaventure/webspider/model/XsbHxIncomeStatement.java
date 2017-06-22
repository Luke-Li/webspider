package com.chinaventure.webspider.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_hx_income_statement")
public class XsbHxIncomeStatement {
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
     * 净利润(万元)
     */
    @Column(name = "net_income")
    private BigDecimal netIncome;

    /**
     * 净利润增长率(%)
     */
    @Column(name = "net_profit_growth_rate")
    private BigDecimal netProfitGrowthRate;

    /**
     * 营业总收入(万元)
     */
    @Column(name = "operating_revenue")
    private BigDecimal operatingRevenue;

    /**
     * 利润率(%)
     */
    @Column(name = "profit_margin")
    private BigDecimal profitMargin;

    /**
     * 营业总收入增长率(%)
     */
    @Column(name = "operating_income_growth_rate")
    private BigDecimal operatingIncomeGrowthRate;

    /**
     * 营业总成本(万元)
     */
    @Column(name = "total_operating_cost")
    private BigDecimal totalOperatingCost;

    /**
     * 营业利润(万元)
     */
    @Column(name = "operating_profit")
    private BigDecimal operatingProfit;

    /**
     * 投资收益(万元)
     */
    @Column(name = "return_on_investment")
    private BigDecimal returnOnInvestment;

    /**
     * 资产减值损失(万元)
     */
    @Column(name = "asset_impairment_loss")
    private BigDecimal assetImpairmentLoss;

    /**
     * 管理费用(万元)
     */
    @Column(name = "management_fee")
    private BigDecimal managementFee;

    /**
     * 销售费用(万元)
     */
    @Column(name = "sales_cost")
    private BigDecimal salesCost;

    /**
     * 财务费用(万元)
     */
    @Column(name = "financial_expenses")
    private BigDecimal financialExpenses;

    /**
     * 营业外收入(万元)
     */
    @Column(name = "non_operating_revenue")
    private BigDecimal nonOperatingRevenue;

    /**
     * 营业外支出(万元)
     */
    @Column(name = "non_business_expenses")
    private BigDecimal nonBusinessExpenses;

    /**
     * 营业税金及附加(万元)
     */
    @Column(name = "business_tax_additional")
    private BigDecimal businessTaxAdditional;

    /**
     * 利润总额(万元)
     */
    @Column(name = "profit_total")
    private BigDecimal profitTotal;

    /**
     * 所得税(万元)
     */
    @Column(name = "income_tax")
    private BigDecimal incomeTax;

    /**
     * 综合收益总额(万元)
     */
    @Column(name = "total_amount_comprehensive_income")
    private BigDecimal totalAmountComprehensiveIncome;

    /**
     * 归属于母公司股东的综合收益总额(万元)
     */
    @Column(name = "total_comprehensive_income_attributable_parent_shareholders")
    private BigDecimal totalComprehensiveIncomeAttributableParentShareholders;

    /**
     * 基本每股收益(元)
     */
    @Column(name = "basic_earnings_per_share")
    private BigDecimal basicEarningsPerShare;

    /**
     * 稀释后每股收益(元)
     */
    @Column(name = "diluted_earnings_per_share")
    private BigDecimal dilutedEarningsPerShare;

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
     * 获取净利润(万元)
     *
     * @return net_income - 净利润(万元)
     */
    public BigDecimal getNetIncome() {
        return netIncome;
    }

    /**
     * 设置净利润(万元)
     *
     * @param netIncome 净利润(万元)
     */
    public void setNetIncome(BigDecimal netIncome) {
        this.netIncome = netIncome;
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
     * 获取营业总收入(万元)
     *
     * @return operating_revenue - 营业总收入(万元)
     */
    public BigDecimal getOperatingRevenue() {
        return operatingRevenue;
    }

    /**
     * 设置营业总收入(万元)
     *
     * @param operatingRevenue 营业总收入(万元)
     */
    public void setOperatingRevenue(BigDecimal operatingRevenue) {
        this.operatingRevenue = operatingRevenue;
    }

    /**
     * 获取利润率(%)
     *
     * @return profit_margin - 利润率(%)
     */
    public BigDecimal getProfitMargin() {
        return profitMargin;
    }

    /**
     * 设置利润率(%)
     *
     * @param profitMargin 利润率(%)
     */
    public void setProfitMargin(BigDecimal profitMargin) {
        this.profitMargin = profitMargin;
    }

    /**
     * 获取营业总收入增长率(%)
     *
     * @return operating_income_growth_rate - 营业总收入增长率(%)
     */
    public BigDecimal getOperatingIncomeGrowthRate() {
        return operatingIncomeGrowthRate;
    }

    /**
     * 设置营业总收入增长率(%)
     *
     * @param operatingIncomeGrowthRate 营业总收入增长率(%)
     */
    public void setOperatingIncomeGrowthRate(BigDecimal operatingIncomeGrowthRate) {
        this.operatingIncomeGrowthRate = operatingIncomeGrowthRate;
    }

    /**
     * 获取营业总成本(万元)
     *
     * @return total_operating_cost - 营业总成本(万元)
     */
    public BigDecimal getTotalOperatingCost() {
        return totalOperatingCost;
    }

    /**
     * 设置营业总成本(万元)
     *
     * @param totalOperatingCost 营业总成本(万元)
     */
    public void setTotalOperatingCost(BigDecimal totalOperatingCost) {
        this.totalOperatingCost = totalOperatingCost;
    }

    /**
     * 获取营业利润(万元)
     *
     * @return operating_profit - 营业利润(万元)
     */
    public BigDecimal getOperatingProfit() {
        return operatingProfit;
    }

    /**
     * 设置营业利润(万元)
     *
     * @param operatingProfit 营业利润(万元)
     */
    public void setOperatingProfit(BigDecimal operatingProfit) {
        this.operatingProfit = operatingProfit;
    }

    /**
     * 获取投资收益(万元)
     *
     * @return return_on_investment - 投资收益(万元)
     */
    public BigDecimal getReturnOnInvestment() {
        return returnOnInvestment;
    }

    /**
     * 设置投资收益(万元)
     *
     * @param returnOnInvestment 投资收益(万元)
     */
    public void setReturnOnInvestment(BigDecimal returnOnInvestment) {
        this.returnOnInvestment = returnOnInvestment;
    }

    /**
     * 获取资产减值损失(万元)
     *
     * @return asset_impairment_loss - 资产减值损失(万元)
     */
    public BigDecimal getAssetImpairmentLoss() {
        return assetImpairmentLoss;
    }

    /**
     * 设置资产减值损失(万元)
     *
     * @param assetImpairmentLoss 资产减值损失(万元)
     */
    public void setAssetImpairmentLoss(BigDecimal assetImpairmentLoss) {
        this.assetImpairmentLoss = assetImpairmentLoss;
    }

    /**
     * 获取管理费用(万元)
     *
     * @return management_fee - 管理费用(万元)
     */
    public BigDecimal getManagementFee() {
        return managementFee;
    }

    /**
     * 设置管理费用(万元)
     *
     * @param managementFee 管理费用(万元)
     */
    public void setManagementFee(BigDecimal managementFee) {
        this.managementFee = managementFee;
    }

    /**
     * 获取销售费用(万元)
     *
     * @return sales_cost - 销售费用(万元)
     */
    public BigDecimal getSalesCost() {
        return salesCost;
    }

    /**
     * 设置销售费用(万元)
     *
     * @param salesCost 销售费用(万元)
     */
    public void setSalesCost(BigDecimal salesCost) {
        this.salesCost = salesCost;
    }

    /**
     * 获取财务费用(万元)
     *
     * @return financial_expenses - 财务费用(万元)
     */
    public BigDecimal getFinancialExpenses() {
        return financialExpenses;
    }

    /**
     * 设置财务费用(万元)
     *
     * @param financialExpenses 财务费用(万元)
     */
    public void setFinancialExpenses(BigDecimal financialExpenses) {
        this.financialExpenses = financialExpenses;
    }

    /**
     * 获取营业外收入(万元)
     *
     * @return non_operating_revenue - 营业外收入(万元)
     */
    public BigDecimal getNonOperatingRevenue() {
        return nonOperatingRevenue;
    }

    /**
     * 设置营业外收入(万元)
     *
     * @param nonOperatingRevenue 营业外收入(万元)
     */
    public void setNonOperatingRevenue(BigDecimal nonOperatingRevenue) {
        this.nonOperatingRevenue = nonOperatingRevenue;
    }

    /**
     * 获取营业外支出(万元)
     *
     * @return non_business_expenses - 营业外支出(万元)
     */
    public BigDecimal getNonBusinessExpenses() {
        return nonBusinessExpenses;
    }

    /**
     * 设置营业外支出(万元)
     *
     * @param nonBusinessExpenses 营业外支出(万元)
     */
    public void setNonBusinessExpenses(BigDecimal nonBusinessExpenses) {
        this.nonBusinessExpenses = nonBusinessExpenses;
    }

    /**
     * 获取营业税金及附加(万元)
     *
     * @return business_tax_additional - 营业税金及附加(万元)
     */
    public BigDecimal getBusinessTaxAdditional() {
        return businessTaxAdditional;
    }

    /**
     * 设置营业税金及附加(万元)
     *
     * @param businessTaxAdditional 营业税金及附加(万元)
     */
    public void setBusinessTaxAdditional(BigDecimal businessTaxAdditional) {
        this.businessTaxAdditional = businessTaxAdditional;
    }

    /**
     * 获取利润总额(万元)
     *
     * @return profit_total - 利润总额(万元)
     */
    public BigDecimal getProfitTotal() {
        return profitTotal;
    }

    /**
     * 设置利润总额(万元)
     *
     * @param profitTotal 利润总额(万元)
     */
    public void setProfitTotal(BigDecimal profitTotal) {
        this.profitTotal = profitTotal;
    }

    /**
     * 获取所得税(万元)
     *
     * @return income_tax - 所得税(万元)
     */
    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    /**
     * 设置所得税(万元)
     *
     * @param incomeTax 所得税(万元)
     */
    public void setIncomeTax(BigDecimal incomeTax) {
        this.incomeTax = incomeTax;
    }

    /**
     * 获取综合收益总额(万元)
     *
     * @return total_amount_comprehensive_income - 综合收益总额(万元)
     */
    public BigDecimal getTotalAmountComprehensiveIncome() {
        return totalAmountComprehensiveIncome;
    }

    /**
     * 设置综合收益总额(万元)
     *
     * @param totalAmountComprehensiveIncome 综合收益总额(万元)
     */
    public void setTotalAmountComprehensiveIncome(BigDecimal totalAmountComprehensiveIncome) {
        this.totalAmountComprehensiveIncome = totalAmountComprehensiveIncome;
    }

    /**
     * 获取归属于母公司股东的综合收益总额(万元)
     *
     * @return total_comprehensive_income_attributable_parent_shareholders - 归属于母公司股东的综合收益总额(万元)
     */
    public BigDecimal getTotalComprehensiveIncomeAttributableParentShareholders() {
        return totalComprehensiveIncomeAttributableParentShareholders;
    }

    /**
     * 设置归属于母公司股东的综合收益总额(万元)
     *
     * @param totalComprehensiveIncomeAttributableParentShareholders 归属于母公司股东的综合收益总额(万元)
     */
    public void setTotalComprehensiveIncomeAttributableParentShareholders(BigDecimal totalComprehensiveIncomeAttributableParentShareholders) {
        this.totalComprehensiveIncomeAttributableParentShareholders = totalComprehensiveIncomeAttributableParentShareholders;
    }

    /**
     * 获取基本每股收益(元)
     *
     * @return basic_earnings_per_share - 基本每股收益(元)
     */
    public BigDecimal getBasicEarningsPerShare() {
        return basicEarningsPerShare;
    }

    /**
     * 设置基本每股收益(元)
     *
     * @param basicEarningsPerShare 基本每股收益(元)
     */
    public void setBasicEarningsPerShare(BigDecimal basicEarningsPerShare) {
        this.basicEarningsPerShare = basicEarningsPerShare;
    }

    /**
     * 获取稀释后每股收益(元)
     *
     * @return diluted_earnings_per_share - 稀释后每股收益(元)
     */
    public BigDecimal getDilutedEarningsPerShare() {
        return dilutedEarningsPerShare;
    }

    /**
     * 设置稀释后每股收益(元)
     *
     * @param dilutedEarningsPerShare 稀释后每股收益(元)
     */
    public void setDilutedEarningsPerShare(BigDecimal dilutedEarningsPerShare) {
        this.dilutedEarningsPerShare = dilutedEarningsPerShare;
    }
}