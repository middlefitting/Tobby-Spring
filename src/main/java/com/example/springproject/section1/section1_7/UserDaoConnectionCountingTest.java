package com.example.springproject.section1.section1_7;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * UserDaoConnectionCountingTest.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/24
 */
public class UserDaoConnectionCountingTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);

		dao.get("1");
		dao.get("1");
		dao.get("2");
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection Counter : " + ccm.getCounter());
	}
}
