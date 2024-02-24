package com.example.springproject.section1.section1_8;

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
		ApplicationContext context = new AnnotationConfigApplicationContext(DataFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		User user = dao.get("1");

		System.out.println(user.getId() + "조회 성공");
	}
}
