package com.example.springproject.제어의역전.팩토리;

import com.example.springproject.초난감DAO.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * UserDao.
 *
 * <p>
 *  DB 연결 작업을 분리하고 인터페이스를 동해 다양한 구현체들을 사용할 수 있도록 한 UserDao
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/11/02
 */
public class UserDao {

  private ConnectionMaker connectionMaker;

  /**
   * 오브젝트의 관계는 런타임 시에만 맺어주면 된다. 그래서 생성자를 통해 오브젝트를 주입받는다.
   * 이렇게 다형성을 활용할 수 있다.
   * 관계의 책임을 클라이언트에 위임
   * @param connectionMaker
   */
  public UserDao(ConnectionMaker connectionMaker) {
    this.connectionMaker = connectionMaker;
  }

  public void addUser(User user) throws ClassNotFoundException, SQLException {
    /**
     * 드라이버 선택
     */
    Connection c = connectionMaker.getConnection();

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
    Connection c = connectionMaker.getConnection();

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

