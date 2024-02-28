package com.example.springproject.section2.section2_5;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import config.TestDataSource;

/**
 * SpringTestContextTest.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/28
 */
@SpringBootTest
@Import(TestDataSource.class)
public class SpringTestContextTest {

	@Autowired
	ApplicationContext context;

	static ApplicationContext contextObject = null;

	@Autowired
	DataSource dataSource;
	static Set<String> dataSources = new LinkedHashSet<>();

	@Test
	@DisplayName("스프링 컨텍스트가 동일한지 확인1")
	void test1() {
		Assertions.assertThat(contextObject == null || context == this.context).isTrue();
		contextObject = this.context;
	}

	@Test
	@DisplayName("스프링 컨텍스트가 동일한지 확인2")
	void test2() {
		Assertions.assertThat(contextObject == null || context == this.context).isTrue();
		contextObject = this.context;
	}

	@Test
	@DisplayName("스프링 컨텍스트가 동일한지 확인3")
	void test3() {
		Assertions.assertThat(contextObject == null || context == this.context).isTrue();
		contextObject = this.context;
	}

	@Test
	@DisplayName("싱글톤 테스트1")
	void singleton1() {
		dataSources.add(dataSource.toString());
		Assertions.assertThat(dataSources.size()).isEqualTo(1);
	}

	@Test
	@DisplayName("싱글톤 테스트2")
	void singleton2() {
		dataSources.add(dataSource.toString());
		Assertions.assertThat(dataSources.size()).isEqualTo(1);
	}

	@Test
	@DisplayName("싱글톤 테스트3")
	void singleton3() {
		dataSources.add(dataSource.toString());
		Assertions.assertThat(dataSources.size()).isEqualTo(1);
	}
}
