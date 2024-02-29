package com.example.springproject.section3.section3_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

import com.example.springproject.section3.section3_2.DeleteAllStatement;
import com.example.springproject.section3.section3_2.StatementStrategy;

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
	 * <br>로컬 클래스를 활용<br/>
	 *
	 *
	 * @param user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addLocalClass(User user) throws ClassNotFoundException, SQLException {
		class AddStatement implements StatementStrategy {
			// private final User user;
			//
			// public AddStatement(User user) {
			// 	this.user = user;
			// }

			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());
				return ps;
			}
		}

		StatementStrategy st = new AddStatement();
		jdbcContextWithStatementStrategy(st);

	}

	/**
	 * <br>익명 클래스를 활용<br/>
	 *
	 *
	 * @param user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void add(User user) throws ClassNotFoundException, SQLException {
		StatementStrategy st = new StatementStrategy() {
			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());
				return ps;
			}
		};
		jdbcContextWithStatementStrategy(st);
	}

	/**
	 * <br>람다를 활용<br/>
	 *
	 *
	 * @param user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addLambda(User user) throws ClassNotFoundException, SQLException {
		StatementStrategy st = c -> {
			PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			return ps;
		};
		jdbcContextWithStatementStrategy(st);
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
	 * 메소드로 분리한 컨텍스트 코드
	 * @throws SQLException
	 */
	public void jdbcContextWithStatementStrategy(
		com.example.springproject.section3.section3_2.StatementStrategy stmt) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = dataSource.getConnection();
			ps = stmt.makePreparedStatement(c);
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
	 * 클라이언트 책임을 갖도록 재구성
	 * @throws SQLException
	 */
	public void deleteAll() throws SQLException {
		StatementStrategy st = new DeleteAllStatement();
		jdbcContextWithStatementStrategy(st);
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

