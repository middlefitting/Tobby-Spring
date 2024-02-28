package com.example.springproject.section3.section3_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * UserDaoDeleteAll.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/29
 */
public class UserDaoDeleteAll extends UserDao {

	public UserDaoDeleteAll(DataSource dataSource) {
		super(dataSource);
	}
	@Override
	protected PreparedStatement makeStatement(Connection c) throws SQLException {
		PreparedStatement ps = c.prepareStatement("delete from users");
		ps.executeUpdate();
		return ps;
	}
}
