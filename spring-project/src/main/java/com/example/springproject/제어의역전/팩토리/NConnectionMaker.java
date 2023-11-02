package com.example.springproject.제어의역전.팩토리;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * NConnectionMaker.
 *
 * <p>
 *  DB 연결 작업을 구현한 NConnectionMaker
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/11/02
 */
public class NConnectionMaker implements ConnectionMaker{

  @Override
  public Connection getConnection() throws ClassNotFoundException, SQLException {
    return null;
  }
}
