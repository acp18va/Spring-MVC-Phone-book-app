package com.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com")

public class SpringRootConfig {
//TODO: Dao, Services, DataSources Email Sender, Business layer Beans 
	
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/capp_db");
		ds.setUsername("root");
		ds.setPassword("Msspl#109");
		ds.setMaxTotal(2);
		ds.setInitialSize(1);
		ds.setTestOnBorrow(true);
		ds.setValidationQuery("SELECT 1");
		ds.setDefaultAutoCommit(true);
		return ds;
		
	}
}

