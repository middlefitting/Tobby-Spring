package com.example.springproject.section3.section3_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * StatementStrategy.
 *	Connection을 전달받아서 PreparedStatement를 반환하는 전략.
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/29
 */
public interface StatementStrategy {
	PreparedStatement makePreparedStatement(Connection c) throws SQLException;
}
