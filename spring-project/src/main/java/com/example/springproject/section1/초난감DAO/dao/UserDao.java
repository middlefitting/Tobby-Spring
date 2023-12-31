package com.example.springproject.section1.초난감DAO.dao;

import com.example.springproject.section1.초난감DAO.domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDao.
 *
 * <p>
 *  말 그대로 초난감 DAO, JDBC 관리를 직접하기 때문에 테스트 성공을 보장할 수 없다. 트랜잭션 처리가 어렵다
 *  코드도 객체지향적 코드라고 볼 수가 없다.
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/27
 */
public class UserDao {

  public void addUser(User user) throws ClassNotFoundException, SQLException {
    /**
     * 드라이버 선택
     */
    Class.forName("com.mysql.cj.jdbc.Driver");

    /**
     * DB 연결, 커넥션 가져오기
     */
    Connection c = DriverManager.getConnection(
        "jdbc:mysql://localhost/tobby",
        "middle",
        "HelloWorld@1234");

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
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection c = DriverManager.getConnection(
        "jdbc:mysql://localhost/tobby",
        "middle",
        "HelloWorld@1234");

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
