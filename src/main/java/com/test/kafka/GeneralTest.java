package com.test.kafka;


import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.url.URLUtil;

import net.kernal.spiderman.worker.download.Downloader;

public class GeneralTest {
	public static void main(String[] args){
//		String url = "http://app.jg.eastmoney.com/F9Stock/AssetDebt.do?securityCode=900932.SH&companyType=127000000606281483&yearList=2017,2016,2015,2014&reportTypeList=1,5,3,6,7&dateSearchType=1&listedType=0,1&reportTypeInScope=1&reportType=2&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=2&CurrencySelect=0";
		String url = "http://app.jg.eastmoney.com/F9Stock/AssetDebt.do?securityCode=900932.SZ&companyType=127000000606281483&yearList=2017,2016,2015,2014&reportTypeList=1,5,3,6,7&dateSearchType=1&listedType=0,1&reportTypeInScope=1&reportType=1&rotate=0&seperate=0&order=desc&cashType=1&exchangeValue=1&customSelect=1&CurrencySelect=0";
		String referer = "http://app.jg.eastmoney.com/html_f9/index.html?securitycode=900932.SH&HeadHidden=1";
		Downloader.Request request = new Downloader.Request(url);
		URLUtil.fillRequestHeader(request, referer);
		HttpclientUtils.downloadHtmlRetry(request);
	} 
}
