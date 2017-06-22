package com.chinaventure.webspider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xsb_ths_dividends")
public class XsbThsDividends {
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
     * 懂事会日期
     */
    @Column(name = "directors_board_date")
    private Date directorsBoardDate;

    /**
     * 股东大会日期
     */
    @Column(name = "shareholders_meeting_date")
    private Date shareholdersMeetingDate;

    /**
     * 实施日期
     */
    @Column(name = "impl_date")
    private Date implDate;

    /**
     * 分红方案
     */
    @Column(name = "dividends_scheme")
    private String dividendsScheme;

    /**
     * 股权登记日
     */
    @Column(name = "register_day")
    private String registerDay;

    /**
     * 除权除息日
     */
    @Column(name = "except_authority_day")
    private String exceptAuthorityDay;

    /**
     * A股派息日
     */
    @Column(name = "send_launch_stock_day")
    private String sendLaunchStockDay;

    /**
     * 方案进度
     */
    @Column(name = "scheme_progress")
    private String schemeProgress;

    /**
     * 股利支付率(%)
     */
    @Column(name = "bonus_payout_rate")
    private String bonusPayoutRate;

    /**
     * 分红率(%)
     */
    @Column(name = "bonus_rate")
    private String bonusRate;

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
     * 获取懂事会日期
     *
     * @return directors_board_date - 懂事会日期
     */
    public Date getDirectorsBoardDate() {
        return directorsBoardDate;
    }

    /**
     * 设置懂事会日期
     *
     * @param directorsBoardDate 懂事会日期
     */
    public void setDirectorsBoardDate(Date directorsBoardDate) {
        this.directorsBoardDate = directorsBoardDate;
    }

    /**
     * 获取股东大会日期
     *
     * @return shareholders_meeting_date - 股东大会日期
     */
    public Date getShareholdersMeetingDate() {
        return shareholdersMeetingDate;
    }

    /**
     * 设置股东大会日期
     *
     * @param shareholdersMeetingDate 股东大会日期
     */
    public void setShareholdersMeetingDate(Date shareholdersMeetingDate) {
        this.shareholdersMeetingDate = shareholdersMeetingDate;
    }

    /**
     * 获取实施日期
     *
     * @return impl_date - 实施日期
     */
    public Date getImplDate() {
        return implDate;
    }

    /**
     * 设置实施日期
     *
     * @param implDate 实施日期
     */
    public void setImplDate(Date implDate) {
        this.implDate = implDate;
    }

    /**
     * 获取分红方案
     *
     * @return dividends_scheme - 分红方案
     */
    public String getDividendsScheme() {
        return dividendsScheme;
    }

    /**
     * 设置分红方案
     *
     * @param dividendsScheme 分红方案
     */
    public void setDividendsScheme(String dividendsScheme) {
        this.dividendsScheme = dividendsScheme;
    }

    /**
     * 获取股权登记日
     *
     * @return register_day - 股权登记日
     */
    public String getRegisterDay() {
        return registerDay;
    }

    /**
     * 设置股权登记日
     *
     * @param registerDay 股权登记日
     */
    public void setRegisterDay(String registerDay) {
        this.registerDay = registerDay;
    }

    /**
     * 获取除权除息日
     *
     * @return except_authority_day - 除权除息日
     */
    public String getExceptAuthorityDay() {
        return exceptAuthorityDay;
    }

    /**
     * 设置除权除息日
     *
     * @param exceptAuthorityDay 除权除息日
     */
    public void setExceptAuthorityDay(String exceptAuthorityDay) {
        this.exceptAuthorityDay = exceptAuthorityDay;
    }

    /**
     * 获取A股派息日
     *
     * @return send_launch_stock_day - A股派息日
     */
    public String getSendLaunchStockDay() {
        return sendLaunchStockDay;
    }

    /**
     * 设置A股派息日
     *
     * @param sendLaunchStockDay A股派息日
     */
    public void setSendLaunchStockDay(String sendLaunchStockDay) {
        this.sendLaunchStockDay = sendLaunchStockDay;
    }

    /**
     * 获取方案进度
     *
     * @return scheme_progress - 方案进度
     */
    public String getSchemeProgress() {
        return schemeProgress;
    }

    /**
     * 设置方案进度
     *
     * @param schemeProgress 方案进度
     */
    public void setSchemeProgress(String schemeProgress) {
        this.schemeProgress = schemeProgress;
    }

    /**
     * 获取股利支付率(%)
     *
     * @return bonus_payout_rate - 股利支付率(%)
     */
    public String getBonusPayoutRate() {
        return bonusPayoutRate;
    }

    /**
     * 设置股利支付率(%)
     *
     * @param bonusPayoutRate 股利支付率(%)
     */
    public void setBonusPayoutRate(String bonusPayoutRate) {
        this.bonusPayoutRate = bonusPayoutRate;
    }

    /**
     * 获取分红率(%)
     *
     * @return bonus_rate - 分红率(%)
     */
    public String getBonusRate() {
        return bonusRate;
    }

    /**
     * 设置分红率(%)
     *
     * @param bonusRate 分红率(%)
     */
    public void setBonusRate(String bonusRate) {
        this.bonusRate = bonusRate;
    }
}