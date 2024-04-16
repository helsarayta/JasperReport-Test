package com.poc.work.jasper.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ReportConfig {

	@Bean
    public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:7823/cvm_plat_ft_mt02");
        dataSource.setUsername("tracking");
        dataSource.setPassword("tracking");
		return dataSource;
	}
	
}
