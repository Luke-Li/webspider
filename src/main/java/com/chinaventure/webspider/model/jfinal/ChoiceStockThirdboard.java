package com.chinaventure.webspider.model.jfinal;

import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.bean.ChoiceEntXsbBean;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

public class ChoiceStockThirdboard extends Model<ChoiceStockThirdboard>{

	private static final long serialVersionUID = -2939316598987104545L;
	
	public static String TableName = JFConfig.getTableName(ChoiceStockThirdboard.class);
	
	public static ChoiceStockThirdboard dao = new ChoiceStockThirdboard();

	public void insertOrUpdate(ChoiceEntXsbBean bean) {
		
		ChoiceStockThirdboard model = new ChoiceStockThirdboard();
		
		model.set("code",(bean.getCode()));
		model.set("name",(bean.getName()));
		model.set("cookie",(bean.getCookie()));
		model.set("info",(bean.getInfo().toJSONString()));
		
		model.set("IndustryInfo",(bean.IndustryInfo));
		model.set("MainBusinessStructReport_ProjectName",(bean.MainBusinessStructReport_ProjectName));
		model.set("MainBusinessStructReport_Industy",(bean.MainBusinessStructReport_Industy));
		model.set("MainBusinessStructReport_Product",(bean.MainBusinessStructReport_Product));
		model.set("MainBusinessStructReport_Area",(bean.MainBusinessStructReport_Area));
		model.set("EquityCnotrolledCompany",(bean.EquityCnotrolledCompany));
		model.set("StockStructure",(bean.StockStructure));
		model.set("Top10Holder",(bean.Top10Holder));
		model.set("Top10CirculationShareHolder",(bean.Top10CirculationShareHolder));
		model.set("ManagerInfoType1",(bean.ManagerInfoType1));
		model.set("ManagerInfoType2",(bean.ManagerInfoType2));
		model.set("ManagerInfoType3",(bean.ManagerInfoType3));
		model.set("ManagerInfoType4",(bean.ManagerInfoType4));
		model.set("DailyMarketData",(bean.DailyMarketData));
		
		
		model.set("AssetDebtOrdinary",bean.AssetDebtOrdinary);
		model.set("AssetDebtSales",bean.AssetDebtSales);
		model.set("AssetDebtAssets",bean.AssetDebtAssets);
		model.set("AssetDebtGrowth",bean.AssetDebtGrowth);

		model.set("ProfitTableOrdinary",bean.ProfitTableOrdinary);
		model.set("ProfitTableSales",bean.ProfitTableSales);
		model.set("ProfitTableGrowth",bean.ProfitTableGrowth);

		model.set("CashFlowTableOrdinary",bean.CashFlowTableOrdinary);
		model.set("CashFlowTableGrowth",bean.CashFlowTableGrowth);
		
		
		model.set("ShareRed",(bean.ShareRed));
		model.set("ZengFa",(bean.ZengFa));
		model.set("EachStockIndex",(bean.EachStockIndex));
		model.set("ProfitAndQuantity",(bean.ProfitAndQuantity));
		model.set("CapitalAndRepay",(bean.CapitalAndRepay));
		model.set("BussinessAbility",(bean.BussinessAbility));
		model.set("GrowthAbility",(bean.GrowthAbility));
		model.set("CashFlow",(bean.CashFlow));
		model.set("DuBangAnaysis",(bean.DuBangAnaysis));
		model.set("SingleMonthFinanceIndex",(bean.SingleMonthFinanceIndex));		
		
		
		Record record = Db.findFirst(String.format("select * from %s where code = ? ", TableName),bean.getCode());
		if(record == null){
			model.set("create_time", bean.getCreateTime());
			model.save();
		}else{
			model.set("id", record.getInt("id"));
			model.set("update_time", bean.getUpdateTime());
			
			model.update();
		}
	}
}
