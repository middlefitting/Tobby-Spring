package com.example.springproject.section1.section1_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * NConnectionMaker.
 *
 * <p>
 *	클래스의 분리
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/21
 */
public class NConnectionMaker implements ConnectionMaker{
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
			"jdbc:mysql://localhost/tobby", "tobby", "Hello@1234");
		return c;
	}
}
