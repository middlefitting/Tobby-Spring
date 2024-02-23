package com.example.springproject.section1.section1_5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DaoFactory.
 *
 * <p>
 *	UserDao 오브젝트를 어떻게 만들고 준비시킬지 결정, bean 등록
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/23
 */
@Configuration
public class DaoFactory {
	// 기본적으로 메소드 이름이 빈이 된다.
	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
