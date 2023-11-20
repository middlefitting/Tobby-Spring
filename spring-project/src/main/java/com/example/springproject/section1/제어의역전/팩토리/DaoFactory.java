package com.example.springproject.section1.제어의역전.팩토리;

import com.example.springproject.section1.DAO의확장.인터페이스도입.ConnectionMaker;
import com.example.springproject.section1.DAO의확장.인터페이스도입.UserDao;

/**
 * DaoFactory.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/11/02
 */
public class DaoFactory {
  public UserDao userDao() {
    ConnectionMaker connectionMaker = (ConnectionMaker) new NConnectionMaker();
    return new UserDao(connectionMaker);
  }
}
