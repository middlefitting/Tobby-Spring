package com.example.springproject.section1.section1_7;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * UserDaoTest.
 *
 * <p>
 *	UserDao의 클라이언트
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/21
 */
public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		User user = new User();
		user.setId("whiteship8");
		user.setName("김영한8");
		user.setPassword("married");

		dao.add(user);

		System.out.println(user.getId() + "등록 성공");
	}
}
