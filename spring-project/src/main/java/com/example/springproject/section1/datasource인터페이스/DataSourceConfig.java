package com.example.springproject.section1.datasource인터페이스;

import java.sql.Driver;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * DataSourceConfig.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/11/20
 */
//@ComponentScan
public class DataSourceConfig {
  @Bean
  public DataSource dataSource() throws ClassNotFoundException {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

    dataSource.setDriverClass((Class<? extends Driver>) Class.forName("org.h2.Driver"));
    dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
    dataSource.setUsername("sa");
    dataSource.setPassword("");
    return dataSource;
  }
}
