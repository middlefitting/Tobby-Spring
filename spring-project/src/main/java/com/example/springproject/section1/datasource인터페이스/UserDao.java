package com.example.springproject.section1.datasource인터페이스;

import com.example.springproject.section1.초난감DAO.domain.User;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * UserDao.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/11/20
 */
public class UserDao {
  private DataSource dataSource;

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void add(User user) throws SQLException {
    Connection connection = dataSource.getConnection();
    /// ...
  }
}
