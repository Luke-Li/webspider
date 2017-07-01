package com.test.spider;

import java.util.Map;
import org.apache.log4j.Logger;
import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.jobs.ChoiceClientJob;
import com.chinaventure.webspider.model.jfinal.ChoiceStockASeed;
import sealion.core.Job;

public class ChoiceTestJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		JFConfig.start();
		ChoiceStockASeed stock = new ChoiceStockASeed();
		stock.set("code","300376");
		stock.set("name", "易事特");
		
		new ChoiceClientJob().handleStock(stock);
	}

	@Override
	public void execute(Map<String, String> arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
