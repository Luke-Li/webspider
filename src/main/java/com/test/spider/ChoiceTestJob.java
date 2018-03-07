package com.test.spider;

import java.util.Map;
import org.apache.log4j.Logger;
import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.jobs.ChoiceAStockJob;
import com.chinaventure.webspider.model.jfinal.StockSeed;

import sealion.core.Job;

public class ChoiceTestJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		JFConfig.start();
		StockSeed stock = new StockSeed();
		stock.set("code","300373.SZ");
		stock.set("name", "扬杰科技");
		
		new ChoiceAStockJob().handleStock(stock);
	}

	@Override
	public void execute(Map<String, String> arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
