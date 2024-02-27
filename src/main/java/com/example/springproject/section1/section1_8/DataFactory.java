package com.example.springproject.section1.section1_8;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * DataFactory.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/24
 */
// @Configuration
public class DataFactory {
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/tobby");
		dataSource.setUsername("tobby");
		dataSource.setPassword("Hello@1234");
		return dataSource;
	}

	@Bean
	public UserDao userDao() {
		return new UserDao(dataSource());
	}
}
