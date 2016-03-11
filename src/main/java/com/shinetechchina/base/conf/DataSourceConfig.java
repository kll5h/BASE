package com.shinetechchina.base.conf;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DataSourceConfig {
	@Bean
	public DataSource dataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl(
				"jdbc:mysql://localhost:3306/base?useSSL=false&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false");
		druidDataSource.setUsername("xuht");
		druidDataSource.setPassword("xuht1234");
		try {
			druidDataSource.setFilters("stat");
		} catch (SQLException e) {
			log.warn(e.getMessage());
		}
		druidDataSource.setMaxActive(20);
		druidDataSource.setInitialSize(1);
		druidDataSource.setMaxWait(60000L);
		druidDataSource.setMinIdle(1);
		druidDataSource.setTimeBetweenEvictionRunsMillis(60000L);
		druidDataSource.setMinEvictableIdleTimeMillis(300000L);
		druidDataSource.setValidationQuery("SELECT 'x'");
		druidDataSource.setTestWhileIdle(true);
		druidDataSource.setTestOnBorrow(false);
		druidDataSource.setTestOnReturn(false);
		druidDataSource.setPoolPreparedStatements(true);
		druidDataSource.setMaxOpenPreparedStatements(20);

		return druidDataSource;
	}
}
