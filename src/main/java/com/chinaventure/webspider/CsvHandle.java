package com.chinaventure.webspider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**
 * 因果树创业数据去重处理
 * @author Administrator
 *
 */
public class CsvHandle {

	public static void main(String[] args) {
		try {
			JFConfig.start();

			List<Record> records = Db.find("select * from raw_startups_info");

			HashMap<String, List<Record>> result = new HashMap<>();

			for (int i = 0; i < records.size(); i++) {
				Record record = records.get(i);

				String proName = record.getStr("brand");
				String brief = record.getStr("brief");

				String comName = record.getStr("ent_name");

				if(StringUtils.isBlank(comName))continue;
				
				if (result.containsKey(comName)) {
					// 去重逻辑 两步操作，一步是可以合并结果的，一步是不能自动合并结果的
					List<Record> temps = result.get(comName);
					int currentSize = temps.size();
					
					boolean isContains = false;
					for (int j = 0; j < currentSize; j++) {
						Record strings = temps.get(j);
						String brand = strings.getStr("brand");
						
						if (StringUtils.equalsIgnoreCase(brand, proName)) {
							if (brief.length() > strings.getStr("brief").length()) {
								strings.set("brief", brief);
							}
							isContains = true;
						}else if(brand.contains(proName)|| proName.contains(brand)){
							String brand_alias = strings.get("brand_alias");
							
							if(StringUtils.isBlank(brand_alias)){
								brand_alias = proName;
							}else{
								brand_alias += ","+proName;
							}
							
							
							strings.set("brand_alias", brand_alias);
							
							if (brief.length() > strings.getStr("brief").length()) {
								strings.set("brief", brief);
							}
							isContains = true;
						}
					}
					
					if(!isContains)temps.add(record);
					
				} else {
					List<Record> temps = new ArrayList<>();
					temps.add(record);

					result.put(comName, temps);
				}
				
				System.out.println(i);
			}

			for (List<Record> resultField : result.values()) {

				for (Record record : resultField) {
					record.remove("id");
					record.set("is_repeat", resultField.size() > 1 ? true : false);
					record.set("createTime", new Date());
					record.set("updateTime", new Date());

					Db.save("raw_startups_info_semi", record);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
