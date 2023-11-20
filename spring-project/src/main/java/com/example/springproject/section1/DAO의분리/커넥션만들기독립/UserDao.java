package com.example.springproject.section1.DAO의분리.커넥션만들기독립;

import com.example.springproject.section1.초난감DAO.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDao.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/31
 */
public abstract class UserDao {

  public void addUser(User user) throws ClassNotFoundException, SQLException {
    /**
     * 드라이버 선택
     */
    Connection c = getConnection();

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
    Connection c = getConnection();

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

  /**
   * 추상 메서드로 선언
   * @return
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  protected abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}
