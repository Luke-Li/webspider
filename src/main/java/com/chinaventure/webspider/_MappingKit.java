package com.chinaventure.webspider;

import com.chinaventure.webspider.model.jfinal.ChoiceErrorLog;
import com.chinaventure.webspider.model.jfinal.ChoiceReportBasic;
import com.chinaventure.webspider.model.jfinal.ChoiceReportType;
import com.chinaventure.webspider.model.jfinal.ChoiceStockA;
import com.chinaventure.webspider.model.jfinal.ChoiceStockANew;
import com.chinaventure.webspider.model.jfinal.ChoiceStockASeed;
import com.chinaventure.webspider.model.jfinal.ChoiceStockBizInfo;
import com.chinaventure.webspider.model.jfinal.ChoiceStockThirdboard;
import com.chinaventure.webspider.model.jfinal.ChoiceStockThirdboardSeed;
import com.chinaventure.webspider.model.jfinal.OpsMonitorMedia;
import com.chinaventure.webspider.model.jfinal.OpsMonitorMediaIndex;
import com.chinaventure.webspider.model.jfinal.OpsMonitorWechat;
import com.chinaventure.webspider.model.jfinal.StockSeed;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

public class _MappingKit {
	public static void mapping(String database,ActiveRecordPlugin arp) {
		switch (database){
			case JFConfig.Database.DataSource:

				arp.addMapping("choice_error_log",ChoiceErrorLog.class);
				arp.addMapping("choice_report_basic",ChoiceReportBasic.class);
				arp.addMapping("choice_report_type",ChoiceReportType.class);
				arp.addMapping("choice_stock_a",ChoiceStockA.class);
				arp.addMapping("choice_stock_a_new",ChoiceStockANew.class);
				arp.addMapping("choice_stock_a_seed",ChoiceStockASeed.class);
				arp.addMapping("choice_stock_thirdboard",ChoiceStockThirdboard.class);
				arp.addMapping("choice_stock_thirdboard_seed",ChoiceStockThirdboardSeed.class);

				arp.addMapping("choice_stock_biz_info","stock_code", ChoiceStockBizInfo.class);
				arp.addMapping("stock_seed",StockSeed.class);

//				arp.addMapping("dynamic_cookie", DynamicCookie.class);

				break;
			case JFConfig.Database.OpsRdd:

				arp.addMapping("ops_monitor_media",OpsMonitorMedia.class);
				arp.addMapping("ops_monitor_media_index",OpsMonitorMediaIndex.class);
				arp.addMapping("ops_monitor_wechat",OpsMonitorWechat.class);

//				arp.addMapping("dynamic_cookie", DynamicCookie.class);
				break;
			default:
				break;
		}
	}
}
