package com.example.springproject.section1.section1_7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springproject.section1.section1_5.DaoFactory;

/**
 * UserDao.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/21
 */
public class UserDao {
	// 읽기 전용임을 보장해주자
	private final ConnectionMaker connectionMaker;

	public UserDao(ConnectionMaker connectionMaker) {
		// 의존관계 검색
		// ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		// this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
		this.connectionMaker = connectionMaker;
	}

	/**
	 * <br>템플릿 메서드 패턴을 활용<br/>
	 *
	 *
	 * @param user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement(
			"insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();
		c.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement(
			"select * from users where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return user;
	}
}

