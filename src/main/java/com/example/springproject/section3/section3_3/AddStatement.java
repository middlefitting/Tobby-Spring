package com.example.springproject.section3.section3_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.springproject.section3.section3_2.StatementStrategy;

// /**
//  * AddStatement.
//  *
//  * <p>
//  *	부가정보가 필요한 전략
//  * </p>
//  * @see             :
//  * @author          : middlefitting
//  * @since           : 2024/02/29
//  */
// public class AddStatement implements StatementStrategy {
// 	User user;
//
// 	public AddStatement(User user) {
// 		this.user = user;
// 	}
// 	@Override
// 	public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
// 		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
// 		ps.setString(1, user.getId());
// 		ps.setString(2, user.getName());
// 		ps.setString(3, user.getPassword());
// 		return ps;
// 	}
// }
