package com.chinaventure.webspider;

import com.alibaba.druid.filter.stat.StatFilter;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.TableMapping;
import com.jfinal.plugin.druid.DruidPlugin;


public class JFConfig{

	public class Database{
		public static final String DataSource= "data_source";

		public static final String OpsRdd= "ops_rdd";
	}

    static{
        //PropKit.use("appconfig.properties");
    }

    private static StatFilter getStatFilter() {
        StatFilter statFilter = new StatFilter();
        statFilter.setLogSlowSql(true);
        statFilter.setMergeSql(true);
        return statFilter;
    }
    /**
     * 获取表名
     * @param modelClass
     * @return
     */
	public static String getTableName(Class<? extends Model<?>> modelClass){
		String tableName = TableMapping.me().getTable(modelClass).getName();
		return tableName;
	}

	public static void start() {
		start(Database.DataSource);
	}

	/**
	 * 初始化JFinal
	 */
    public static void start(String database) {
        // mysql
        //String configName = PropKit.get("db.configName");
        String url = String.format("jdbc:mysql://10.26.252.50:3306/%s?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&autoReconnect=true",database);//PropKit.get("jdbcUrl");
        String username = "rdd";//PropKit.get("user");
        String password = "s6eN8HZTg9Sgr2kD";//PropKit.get("password");
        String driverClass = "com.mysql.jdbc.Driver";//PropKit.get("driverClass");
        String filters = "stat,wall";//PropKit.get("filters");

        // mysql 数据源
        DruidPlugin dsMysql = new DruidPlugin(url, username, password, driverClass, filters);
        dsMysql.addFilter(getStatFilter());
        dsMysql.setMaxActive(200);
        dsMysql.setValidationQuery(" SELECT 1 ");
        dsMysql.setTestOnBorrow(true);

        dsMysql.start();

        /**/
        ActiveRecordPlugin arpMysql = new ActiveRecordPlugin( dsMysql);
        arpMysql.setContainerFactory(new CaseInsensitiveContainerFactory(true));

        _MappingKit.mapping(database,arpMysql);

        arpMysql.start();

        /*AutoTableBindPlugin atbp = new AutoTableBindPlugin(dsMysql, SimpleNameStyles.LOWER);
        atbp.setShowSql(true);
        atbp.setDevMode(false);
        atbp.setDialect(new MysqlDialect());// 配置MySql方言

        atbp.start();*/
    }

}
