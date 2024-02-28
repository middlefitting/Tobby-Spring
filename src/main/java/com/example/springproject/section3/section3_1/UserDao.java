package com.example.springproject.section3.section3_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

import lombok.Setter;

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
@Setter
public class UserDao {
	// 읽기 전용임을 보장해주자
	private DataSource dataSource;

	public UserDao(DataSource dataSource) {
		// 의존관계 검색
		// ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		// this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
		this.dataSource = dataSource;
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
		Connection c = dataSource.getConnection();
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
		Connection c = dataSource.getConnection();
		PreparedStatement ps = c.prepareStatement(
			"select * from users where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
		rs.close();
		ps.close();
		c.close();

		if (user == null)
			throw new EmptyResultDataAccessException(1);

		return user;
	}

	/**
	 * 자원을 안전하게 반환하도록 try/catch 블록을 사용
	 * @throws SQLException
	 */
	public void deleteAll() throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = dataSource.getConnection();
			ps = c.prepareStatement("delete from users");
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * 만들어준 ResultSet도 닫아주기, close 는 생성의 역순으로 하는 것이 원칙
	 * @return
	 * @throws SQLException
	 */
	public int getCount() throws SQLException {

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = dataSource.getConnection();
			ps = c.prepareStatement("select count(*) from users");

			rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			return count;
		} catch (SQLException e) {
			throw e;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}

