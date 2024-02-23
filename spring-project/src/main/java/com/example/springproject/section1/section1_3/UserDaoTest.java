package com.example.springproject.section1.section1_3;

import java.sql.SQLException;

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
		UserDao dao = new UserDao(new DConnectionMaker());
		User user = new User();
		user.setId("whiteship6");
		user.setName("김영한6");
		user.setPassword("married");

		dao.add(user);

		System.out.println(user.getId() + "등록 성공");
	}
}
