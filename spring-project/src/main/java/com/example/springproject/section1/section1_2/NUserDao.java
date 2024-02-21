package com.example.springproject.section1.section1_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.springproject.section1.section1_2.User;

/**
 * NUserDao.
 *
 * <p>
 *	상속을 활용한 추상화
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/21
 */
public class NUserDao extends UserDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
			"jdbc:mysql://localhost/tobby", "tobby", "Hello@1234");
		return c;
	}
}
