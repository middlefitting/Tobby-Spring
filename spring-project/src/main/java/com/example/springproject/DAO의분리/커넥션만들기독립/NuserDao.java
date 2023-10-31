package com.example.springproject.DAO의분리.커넥션만들기독립;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * NuserDao.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/31
 */
public class NuserDao extends UserDao{

  /**
   * 원하는 내용을 구현하면 된다
   * @return
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  @Override
  protected Connection getConnection() throws ClassNotFoundException, SQLException {
    return null;
  }
}
