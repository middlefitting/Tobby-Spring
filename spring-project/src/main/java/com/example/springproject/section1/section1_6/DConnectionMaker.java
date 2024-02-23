package com.example.springproject.section1.section1_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DConnectionMaker.
 *
 * <p>
 *	클래스의 분리
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/21
 */
public class DConnectionMaker implements ConnectionMaker {
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
			"jdbc:mysql://localhost/tobby", "tobby", "Hello@1234");
		return c;
	}
}
