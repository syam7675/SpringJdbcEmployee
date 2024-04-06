package com.hcl.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.hcl.DAO")
public class JdbcConfig {
	static String url="jdbc:mysql://localhost:3306/example";
	static String driver="com.mysql.cj.jdbc.Driver";
	static String userName="root";
	static String passWord="Chinni@123";
	
	
	@Bean("dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(passWord);
		return dataSource;
	}
	
	@Bean("JdbcTemplate")
	public JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		//datasource is injected in jdbctemplate
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	
	
	

}
