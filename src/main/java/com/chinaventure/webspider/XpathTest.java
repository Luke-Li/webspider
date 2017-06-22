package com.chinaventure.webspider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chinaventure.webspider.service.QxbEnterpriseService;
import com.google.common.io.Files;

//import org.apache.log4j.Logger;

public class XpathTest {
	static Logger logger = Logger.getLogger(XpathTest.class);
	/**
	 * spring
	 */
	private static ApplicationContext context;

	/**
	 * 服务类
	 */
	private QxbEnterpriseService service;

	public static void main(String[] args) throws IOException, InterruptedException {
		new XpathTest().excute();
	}

	public void excute() {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(new Date()));
		
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.HOUR_OF_DAY, 10);
		System.out.println(format.format(rightNow.getTime()));
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = context.getBean(QxbEnterpriseService.class);

		/*
		ConcurrentSkipListSet<String> sets = new ConcurrentSkipListSet<>();
		
		service.selectAll().forEach(item -> {
			sets.add(item.getUuid());
		});
		*/

		try {
			List<String> lines = Files.readLines(new File("C:\\Users\\Administrator\\Desktop\\未抓取的公司信息(1).csv"), Charset.forName("UTF-8"));

			boolean isBreak = true;
			for (String line : lines) {
				if (StringUtils.isNotBlank(line)) {
					String[] fields = line.split(",");
					
					if(fields.length < 2){
						isBreak = false;
					}
					
					if (!isBreak && fields.length > 1) {
						String uuid = fields[1];
						String companyName = fields[0];

						if (StringUtils.isNotBlank(uuid) && StringUtils.isNotBlank(companyName)) {
							service.InsertErrorLog(uuid, companyName, StringUtils.EMPTY);
						}
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
