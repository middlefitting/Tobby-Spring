package com.example.springproject.section1.제어의역전.팩토리;

import java.sql.Connection;

/**
 * ConnectionMaker.
 *
 * <p>
 *  connection을 제공한다는 인터페이스
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/11/02
 */
public interface ConnectionMaker {
  public Connection getConnection() throws ClassNotFoundException, java.sql.SQLException;
}
