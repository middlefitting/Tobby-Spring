package com.example.springproject.section1.제어의역전.팩토리개선;

import com.example.springproject.section1.DAO의확장.인터페이스도입.ConnectionMaker;
import com.example.springproject.section1.DAO의확장.인터페이스도입.UserDao;
import com.example.springproject.section1.제어의역전.팩토리.NConnectionMaker;

/**
 * DaoFactory.
 *
 * <p>
 *  생성 로직을 분리해서 dao가 종류가 많아져도 중복을 제거
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/11/02
 */
public class DaoFactory {
  public UserDao userDao() {
    return new UserDao(connectionMaker());
  }

  private ConnectionMaker connectionMaker() {
    return (ConnectionMaker) new NConnectionMaker();
  }
}
