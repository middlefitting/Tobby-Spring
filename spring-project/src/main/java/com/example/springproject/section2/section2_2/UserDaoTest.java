package com.example.springproject.section2.section2_2;

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
		User user2 = dao.get("1");
		if (!user.getName().equals(user2.getName())) {
			System.out.println("테스트 실패! (name)");
		} else if (!user.getPassword().equals(user2.getPassword())) {
			System.out.println("테스트 실패! (password)");
		} else {
			System.out.println("조회 테스트 성공!");
		}
	}
}
