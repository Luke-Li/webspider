package com.chinaventure.webspider.bean;

import java.util.Date;

import javax.persistence.Column;

import com.chinaventure.webspider.util.KeyValuePair;

/**
 * 启信宝企业基本格式
 * @author Administrator
 *
 */
public class QxbEntBean {
	/**
	 * 公司需要抓取的项  
	 */
	@SuppressWarnings("unchecked")
	public static KeyValuePair<String, String>[] EntItems = new KeyValuePair[]{
			new KeyValuePair<String,String>("risk","http://www.qixin.com/service/getRiskInfo?eid={0}&_={1,number,#}"),
			new KeyValuePair<String,String>("ability","http://www.qixin.com/service/getAbilityInfo?eid={0}&_={1,number,#}"),
			new KeyValuePair<String,String>("report","http://www.qixin.com/service/getAnnualReport?eid={0}&_={1,number,#}"),
			new KeyValuePair<String,String>("operation","http://www.qixin.com/service/getOperationInfo?eid={0}&_={1,number,#}"),
			new KeyValuePair<String,String>("investment","http://www.qixin.com/service/getInvestedCompaniesById?eid={0}&_={1,number,#}")
	};
	
	/**
	 * 公司各项的数量,如果等于0表明这个项是不需要抓取的
	 */
	public int[] EntItemCount = new int[EntItems.length];

	/**
     * 下载使用的COOKIE编号
     */
    private String cookie;
	
	/**
     * 下载使用的COOKIE编号
     */
	public String getCookie() {
		return cookie;
	}

	/**
     * 下载使用的COOKIE编号
     */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	/**
     * 启信宝的UUID(公司ID)
     */
    private String uuid;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
    
    /*----------------------------------公司基本信息------------------------------*/
    
    /**
     * 公司基本信息
     */
    private String entInfo;
    
    /**
     * 股东信息
     */
    private String shareholder;
    
    /**
     * 主要人员
     */
    private String personnel;

    /**
     * 分支机构
     */
    private String branch;
    
    
    /*----------------------------------风险信息------------------------------*/
    /**
     * 风险信息
     */
    private String riskInfo;
    
    /*----------------------------------知识产权------------------------------*/
    /**
     * 知识产权
     */
    private String intellectualProperty;
    
    /*----------------------------------对外投资------------------------------*/
    /**
     * 对外投资
     */
    private String investedCompanies;
    
    /*----------------------------------企业年报------------------------------*/
    /**
     * 企业年报
     */
    private String annualReport;

	/*----------------------------------企业年报------------------------------*/
    /**
     * 经营信息
     */
    private String operationInfo;
    
    /**
     * 企业链图
     */
    private String rootNodeInfo;
    /**
     * 关联公司
     */
    private String entClan;

	/**
     * 获取启信宝的UUID(公司ID)
     *
     * @return uuid - 启信宝的UUID(公司ID)
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置启信宝的UUID(公司ID)
     *
     * @param uuid 启信宝的UUID(公司ID)
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取公司名称
     *
     * @return name - 公司名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司名称
     *
     * @param name 公司名称
     */
    public void setName(String name) {
        this.name = name;
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
    
    public String getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(String entInfo) {
		this.entInfo = entInfo;
	}

	public String getShareholder() {
		return shareholder;
	}

	public void setShareholder(String shareholder) {
		this.shareholder = shareholder;
	}

	public String getPersonnel() {
		return personnel;
	}

	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRiskInfo() {
		return riskInfo;
	}

	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

	public String getIntellectualProperty() {
		return intellectualProperty;
	}

	public void setIntellectualProperty(String intellectualProperty) {
		this.intellectualProperty = intellectualProperty;
	}

	public String getInvestedCompanies() {
		return investedCompanies;
	}

	public void setInvestedCompanies(String investedCompanies) {
		this.investedCompanies = investedCompanies;
	}

	public String getAnnualReport() {
		return annualReport;
	}

	public void setAnnualReport(String annualReport) {
		this.annualReport = annualReport;
	}

	public String getOperationInfo() {
		return operationInfo;
	}

	public void setOperationInfo(String operationInfo) {
		this.operationInfo = operationInfo;
	}
	public String getRootNodeInfo() {
		return rootNodeInfo;
	}

	public void setRootNodeInfo(String rootNodeInfo) {
		this.rootNodeInfo = rootNodeInfo;
	}

	public String getEntClan() {
		return entClan;
	}

	public void setEntClan(String entClan) {
		this.entClan = entClan;
	}

}
