package com.chinaventure.webspider.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_hx_cash_flow_statement")
public class XsbHxCashFlowStatement {
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
     * 销售商品、提供劳务收到的现金(万元)
     */
    @Column(name = "selling_providing_labor_received_cash")
    private BigDecimal sellingProvidingLaborReceivedCash;

    /**
     * 收到的税费与返还(万元)
     */
    @Column(name = "receiving_tax_return")
    private BigDecimal receivingTaxReturn;

    /**
     * 支付的各项税费(万元)
     */
    @Column(name = "pay_taxes")
    private BigDecimal payTaxes;

    /**
     * 支付给职工以及为职工支付的现金(万元)
     */
    @Column(name = "paid_worker_cash")
    private BigDecimal paidWorkerCash;

    /**
     * 经营现金流入(万元)
     */
    @Column(name = "operating_cash_flows")
    private BigDecimal operatingCashFlows;

    /**
     * 经营现金流出(万元)
     */
    @Column(name = "operating_cash_outflows")
    private BigDecimal operatingCashOutflows;

    /**
     * 经营现金流量净额(万元)
     */
    @Column(name = "net_operating_cash_flow")
    private BigDecimal netOperatingCashFlow;

    /**
     * 处置固定资产、无形资产的现金(万元)
     */
    @Column(name = "fixed_intangible_assets_cash")
    private BigDecimal fixedIntangibleAssetsCash;

    /**
     * 购建固定资产和其他支付的现金(万元)
     */
    @Column(name = "fixed_or_other_assets_cash")
    private BigDecimal fixedOrOtherAssetsCash;

    /**
     * 投资现金流入(万元)
     */
    @Column(name = "investment_cash_inflows")
    private BigDecimal investmentCashInflows;

    /**
     * 投资现金流出(万元)
     */
    @Column(name = "investment_cash_outflows")
    private BigDecimal investmentCashOutflows;

    /**
     * 投资现金流量净额(万元)
     */
    @Column(name = "investment_net_cash_flow")
    private BigDecimal investmentNetCashFlow;

    /**
     * 吸收投资收到现金(万元)
     */
    @Column(name = "absorb_investment_receive_cash")
    private BigDecimal absorbInvestmentReceiveCash;

    /**
     * 取得借款的现金(万元)
     */
    @Column(name = "borrow_money_cash")
    private BigDecimal borrowMoneyCash;

    /**
     * 收到其他与筹资的现金(万元)
     */
    @Column(name = "other_and_raise_cash")
    private BigDecimal otherAndRaiseCash;

    /**
     * 偿还债务支付现金(万元)
     */
    @Column(name = "repayment_debt_pay_cash")
    private BigDecimal repaymentDebtPayCash;

    /**
     * 分配股利、利润或偿付利息支付的现金(万元)
     */
    @Column(name = "distribution_dividends_profits_or_interest_payments_cash")
    private BigDecimal distributionDividendsProfitsOrInterestPaymentsCash;

    /**
     * 支付其他与筹资的现金(万元)
     */
    @Column(name = "payment_and_other_financing_cash")
    private BigDecimal paymentAndOtherFinancingCash;

    /**
     * 筹资现金流入(万元)
     */
    @Column(name = "raise_cash_inflows")
    private BigDecimal raiseCashInflows;

    /**
     * 筹资现金流出(万元)
     */
    @Column(name = "raise_cash_outflows")
    private BigDecimal raiseCashOutflows;

    /**
     * 筹资现金流量净额(万元)
     */
    @Column(name = "raise_net_cash_flow")
    private BigDecimal raiseNetCashFlow;

    /**
     * 现金及现金等价物净增加额(万元)
     */
    @Column(name = "net_increase_cash_cash_equivalents")
    private BigDecimal netIncreaseCashCashEquivalents;

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
     * 获取销售商品、提供劳务收到的现金(万元)
     *
     * @return selling_providing_labor_received_cash - 销售商品、提供劳务收到的现金(万元)
     */
    public BigDecimal getSellingProvidingLaborReceivedCash() {
        return sellingProvidingLaborReceivedCash;
    }

    /**
     * 设置销售商品、提供劳务收到的现金(万元)
     *
     * @param sellingProvidingLaborReceivedCash 销售商品、提供劳务收到的现金(万元)
     */
    public void setSellingProvidingLaborReceivedCash(BigDecimal sellingProvidingLaborReceivedCash) {
        this.sellingProvidingLaborReceivedCash = sellingProvidingLaborReceivedCash;
    }

    /**
     * 获取收到的税费与返还(万元)
     *
     * @return receiving_tax_return - 收到的税费与返还(万元)
     */
    public BigDecimal getReceivingTaxReturn() {
        return receivingTaxReturn;
    }

    /**
     * 设置收到的税费与返还(万元)
     *
     * @param receivingTaxReturn 收到的税费与返还(万元)
     */
    public void setReceivingTaxReturn(BigDecimal receivingTaxReturn) {
        this.receivingTaxReturn = receivingTaxReturn;
    }

    /**
     * 获取支付的各项税费(万元)
     *
     * @return pay_taxes - 支付的各项税费(万元)
     */
    public BigDecimal getPayTaxes() {
        return payTaxes;
    }

    /**
     * 设置支付的各项税费(万元)
     *
     * @param payTaxes 支付的各项税费(万元)
     */
    public void setPayTaxes(BigDecimal payTaxes) {
        this.payTaxes = payTaxes;
    }

    /**
     * 获取支付给职工以及为职工支付的现金(万元)
     *
     * @return paid_worker_cash - 支付给职工以及为职工支付的现金(万元)
     */
    public BigDecimal getPaidWorkerCash() {
        return paidWorkerCash;
    }

    /**
     * 设置支付给职工以及为职工支付的现金(万元)
     *
     * @param paidWorkerCash 支付给职工以及为职工支付的现金(万元)
     */
    public void setPaidWorkerCash(BigDecimal paidWorkerCash) {
        this.paidWorkerCash = paidWorkerCash;
    }

    /**
     * 获取经营现金流入(万元)
     *
     * @return operating_cash_flows - 经营现金流入(万元)
     */
    public BigDecimal getOperatingCashFlows() {
        return operatingCashFlows;
    }

    /**
     * 设置经营现金流入(万元)
     *
     * @param operatingCashFlows 经营现金流入(万元)
     */
    public void setOperatingCashFlows(BigDecimal operatingCashFlows) {
        this.operatingCashFlows = operatingCashFlows;
    }

    /**
     * 获取经营现金流出(万元)
     *
     * @return operating_cash_outflows - 经营现金流出(万元)
     */
    public BigDecimal getOperatingCashOutflows() {
        return operatingCashOutflows;
    }

    /**
     * 设置经营现金流出(万元)
     *
     * @param operatingCashOutflows 经营现金流出(万元)
     */
    public void setOperatingCashOutflows(BigDecimal operatingCashOutflows) {
        this.operatingCashOutflows = operatingCashOutflows;
    }

    /**
     * 获取经营现金流量净额(万元)
     *
     * @return net_operating_cash_flow - 经营现金流量净额(万元)
     */
    public BigDecimal getNetOperatingCashFlow() {
        return netOperatingCashFlow;
    }

    /**
     * 设置经营现金流量净额(万元)
     *
     * @param netOperatingCashFlow 经营现金流量净额(万元)
     */
    public void setNetOperatingCashFlow(BigDecimal netOperatingCashFlow) {
        this.netOperatingCashFlow = netOperatingCashFlow;
    }

    /**
     * 获取处置固定资产、无形资产的现金(万元)
     *
     * @return fixed_intangible_assets_cash - 处置固定资产、无形资产的现金(万元)
     */
    public BigDecimal getFixedIntangibleAssetsCash() {
        return fixedIntangibleAssetsCash;
    }

    /**
     * 设置处置固定资产、无形资产的现金(万元)
     *
     * @param fixedIntangibleAssetsCash 处置固定资产、无形资产的现金(万元)
     */
    public void setFixedIntangibleAssetsCash(BigDecimal fixedIntangibleAssetsCash) {
        this.fixedIntangibleAssetsCash = fixedIntangibleAssetsCash;
    }

    /**
     * 获取购建固定资产和其他支付的现金(万元)
     *
     * @return fixed_or_other_assets_cash - 购建固定资产和其他支付的现金(万元)
     */
    public BigDecimal getFixedOrOtherAssetsCash() {
        return fixedOrOtherAssetsCash;
    }

    /**
     * 设置购建固定资产和其他支付的现金(万元)
     *
     * @param fixedOrOtherAssetsCash 购建固定资产和其他支付的现金(万元)
     */
    public void setFixedOrOtherAssetsCash(BigDecimal fixedOrOtherAssetsCash) {
        this.fixedOrOtherAssetsCash = fixedOrOtherAssetsCash;
    }

    /**
     * 获取投资现金流入(万元)
     *
     * @return investment_cash_inflows - 投资现金流入(万元)
     */
    public BigDecimal getInvestmentCashInflows() {
        return investmentCashInflows;
    }

    /**
     * 设置投资现金流入(万元)
     *
     * @param investmentCashInflows 投资现金流入(万元)
     */
    public void setInvestmentCashInflows(BigDecimal investmentCashInflows) {
        this.investmentCashInflows = investmentCashInflows;
    }

    /**
     * 获取投资现金流出(万元)
     *
     * @return investment_cash_outflows - 投资现金流出(万元)
     */
    public BigDecimal getInvestmentCashOutflows() {
        return investmentCashOutflows;
    }

    /**
     * 设置投资现金流出(万元)
     *
     * @param investmentCashOutflows 投资现金流出(万元)
     */
    public void setInvestmentCashOutflows(BigDecimal investmentCashOutflows) {
        this.investmentCashOutflows = investmentCashOutflows;
    }

    /**
     * 获取投资现金流量净额(万元)
     *
     * @return investment_net_cash_flow - 投资现金流量净额(万元)
     */
    public BigDecimal getInvestmentNetCashFlow() {
        return investmentNetCashFlow;
    }

    /**
     * 设置投资现金流量净额(万元)
     *
     * @param investmentNetCashFlow 投资现金流量净额(万元)
     */
    public void setInvestmentNetCashFlow(BigDecimal investmentNetCashFlow) {
        this.investmentNetCashFlow = investmentNetCashFlow;
    }

    /**
     * 获取吸收投资收到现金(万元)
     *
     * @return absorb_investment_receive_cash - 吸收投资收到现金(万元)
     */
    public BigDecimal getAbsorbInvestmentReceiveCash() {
        return absorbInvestmentReceiveCash;
    }

    /**
     * 设置吸收投资收到现金(万元)
     *
     * @param absorbInvestmentReceiveCash 吸收投资收到现金(万元)
     */
    public void setAbsorbInvestmentReceiveCash(BigDecimal absorbInvestmentReceiveCash) {
        this.absorbInvestmentReceiveCash = absorbInvestmentReceiveCash;
    }

    /**
     * 获取取得借款的现金(万元)
     *
     * @return borrow_money_cash - 取得借款的现金(万元)
     */
    public BigDecimal getBorrowMoneyCash() {
        return borrowMoneyCash;
    }

    /**
     * 设置取得借款的现金(万元)
     *
     * @param borrowMoneyCash 取得借款的现金(万元)
     */
    public void setBorrowMoneyCash(BigDecimal borrowMoneyCash) {
        this.borrowMoneyCash = borrowMoneyCash;
    }

    /**
     * 获取收到其他与筹资的现金(万元)
     *
     * @return other_and_raise_cash - 收到其他与筹资的现金(万元)
     */
    public BigDecimal getOtherAndRaiseCash() {
        return otherAndRaiseCash;
    }

    /**
     * 设置收到其他与筹资的现金(万元)
     *
     * @param otherAndRaiseCash 收到其他与筹资的现金(万元)
     */
    public void setOtherAndRaiseCash(BigDecimal otherAndRaiseCash) {
        this.otherAndRaiseCash = otherAndRaiseCash;
    }

    /**
     * 获取偿还债务支付现金(万元)
     *
     * @return repayment_debt_pay_cash - 偿还债务支付现金(万元)
     */
    public BigDecimal getRepaymentDebtPayCash() {
        return repaymentDebtPayCash;
    }

    /**
     * 设置偿还债务支付现金(万元)
     *
     * @param repaymentDebtPayCash 偿还债务支付现金(万元)
     */
    public void setRepaymentDebtPayCash(BigDecimal repaymentDebtPayCash) {
        this.repaymentDebtPayCash = repaymentDebtPayCash;
    }

    /**
     * 获取分配股利、利润或偿付利息支付的现金(万元)
     *
     * @return distribution_dividends_profits_or_interest_payments_cash - 分配股利、利润或偿付利息支付的现金(万元)
     */
    public BigDecimal getDistributionDividendsProfitsOrInterestPaymentsCash() {
        return distributionDividendsProfitsOrInterestPaymentsCash;
    }

    /**
     * 设置分配股利、利润或偿付利息支付的现金(万元)
     *
     * @param distributionDividendsProfitsOrInterestPaymentsCash 分配股利、利润或偿付利息支付的现金(万元)
     */
    public void setDistributionDividendsProfitsOrInterestPaymentsCash(BigDecimal distributionDividendsProfitsOrInterestPaymentsCash) {
        this.distributionDividendsProfitsOrInterestPaymentsCash = distributionDividendsProfitsOrInterestPaymentsCash;
    }

    /**
     * 获取支付其他与筹资的现金(万元)
     *
     * @return payment_and_other_financing_cash - 支付其他与筹资的现金(万元)
     */
    public BigDecimal getPaymentAndOtherFinancingCash() {
        return paymentAndOtherFinancingCash;
    }

    /**
     * 设置支付其他与筹资的现金(万元)
     *
     * @param paymentAndOtherFinancingCash 支付其他与筹资的现金(万元)
     */
    public void setPaymentAndOtherFinancingCash(BigDecimal paymentAndOtherFinancingCash) {
        this.paymentAndOtherFinancingCash = paymentAndOtherFinancingCash;
    }

    /**
     * 获取筹资现金流入(万元)
     *
     * @return raise_cash_inflows - 筹资现金流入(万元)
     */
    public BigDecimal getRaiseCashInflows() {
        return raiseCashInflows;
    }

    /**
     * 设置筹资现金流入(万元)
     *
     * @param raiseCashInflows 筹资现金流入(万元)
     */
    public void setRaiseCashInflows(BigDecimal raiseCashInflows) {
        this.raiseCashInflows = raiseCashInflows;
    }

    /**
     * 获取筹资现金流出(万元)
     *
     * @return raise_cash_outflows - 筹资现金流出(万元)
     */
    public BigDecimal getRaiseCashOutflows() {
        return raiseCashOutflows;
    }

    /**
     * 设置筹资现金流出(万元)
     *
     * @param raiseCashOutflows 筹资现金流出(万元)
     */
    public void setRaiseCashOutflows(BigDecimal raiseCashOutflows) {
        this.raiseCashOutflows = raiseCashOutflows;
    }

    /**
     * 获取筹资现金流量净额(万元)
     *
     * @return raise_net_cash_flow - 筹资现金流量净额(万元)
     */
    public BigDecimal getRaiseNetCashFlow() {
        return raiseNetCashFlow;
    }

    /**
     * 设置筹资现金流量净额(万元)
     *
     * @param raiseNetCashFlow 筹资现金流量净额(万元)
     */
    public void setRaiseNetCashFlow(BigDecimal raiseNetCashFlow) {
        this.raiseNetCashFlow = raiseNetCashFlow;
    }

    /**
     * 获取现金及现金等价物净增加额(万元)
     *
     * @return net_increase_cash_cash_equivalents - 现金及现金等价物净增加额(万元)
     */
    public BigDecimal getNetIncreaseCashCashEquivalents() {
        return netIncreaseCashCashEquivalents;
    }

    /**
     * 设置现金及现金等价物净增加额(万元)
     *
     * @param netIncreaseCashCashEquivalents 现金及现金等价物净增加额(万元)
     */
    public void setNetIncreaseCashCashEquivalents(BigDecimal netIncreaseCashCashEquivalents) {
        this.netIncreaseCashCashEquivalents = netIncreaseCashCashEquivalents;
    }
}