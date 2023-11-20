package com.example.springproject.section1.DAO의확장.인터페이스도입;

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
