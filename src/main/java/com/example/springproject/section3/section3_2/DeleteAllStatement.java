package com.example.springproject.section3.section3_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DeleteAllStatement.
 *
 * <p>
 *	StatementStrategy 전략 클래스
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/29
 */
public class DeleteAllStatement implements StatementStrategy{
	@Override
	public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
		PreparedStatement ps = c.prepareStatement("delete from users");
		return ps;
	}
}
