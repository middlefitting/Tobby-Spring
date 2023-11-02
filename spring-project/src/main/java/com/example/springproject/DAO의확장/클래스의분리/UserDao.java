package com.example.springproject.DAO의확장.클래스의분리;

import com.example.springproject.초난감DAO.domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDao.
 *
 * <p>
 *  DB 연결 작업을 분리한 UserDao
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/31
 */
public class UserDao {

  private SimpleConnectionWorker simpleConnectionWorker;

  public UserDao(SimpleConnectionWorker simpleConnectionWorker) {
    this.simpleConnectionWorker = simpleConnectionWorker;
  }

  public void addUser(User user) throws ClassNotFoundException, SQLException {
    /**
     * 드라이버 선택
     */
    Connection c = simpleConnectionWorker.getConnection();

    /**
     * SQL 생성
     */
    PreparedStatement ps = c.prepareStatement(
        "insert into users(id, name, password) values(?,?,?)");
    // SQL에 파라미터 값 넣기
    ps.setString(1, user.getId());
    ps.setString(2, user.getName());
    ps.setString(3, user.getPassword());

    // SQL 실행
    ps.executeUpdate();
    // 리소스 반환
    ps.close();
    // 커넥션 반환
    c.close();
  }

  public User getUser(String id) throws ClassNotFoundException, SQLException {
    Connection c = simpleConnectionWorker.getConnection();

    PreparedStatement ps = c.prepareStatement(
        "select * from users where id = ?");
    ps.setString(1, id);

    ResultSet rs = ps.executeQuery();
    rs.next();
    User user = new User();
    user.setId(rs.getString("id"));
    user.setName(rs.getString("name"));
    user.setPassword(rs.getString("password"));

    rs.close();
    ps.close();
    c.close();
    return user;
  }
}

