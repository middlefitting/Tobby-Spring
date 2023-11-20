package com.example.springproject.section1.DAO의확장.클래스의분리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.NoArgsConstructor;

/**
 * SimpleConnectionWorker.
 *
 * <p>
 *  DB 연결 작업을 분리한 SimpleConnectionWorker
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/31
 */
@NoArgsConstructor
public class SimpleConnectionWorker {
  public Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection c = DriverManager.getConnection(
        "jdbc:mysql://localhost/tobby",
        "middle",
        "HelloWorld@1234");
    return c;
  }
}
