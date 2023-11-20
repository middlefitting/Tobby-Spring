package com.example.springproject.section1.dao;

import com.example.springproject.section1.초난감DAO.dao.UserDao;
import com.example.springproject.section1.초난감DAO.domain.User;
import java.sql.SQLException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * UserDaoTest.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/27
 */

class UserDaoTest {

  /**
   * JDBC 관리를 직접하기 때문에 테스트 성공을 보장할 수 없다. 트랜잭션 처리가 어렵다
   */
  @Test
  @DisplayName("")
  void test() {
    //Arrange
    //Act
    //Assert
    UserDao userDao = new UserDao();
    User user = new User();
    user.setId("3");
    user.setName("middlefitting");
    user.setPassword("1234");

    try {
      userDao.addUser(user);
      System.out.println(user.getId() + " 등록 성공");
      User user2 = userDao.getUser(user.getId());
      System.out.println(user2.getName());
      System.out.println(user2.getPassword());
      System.out.println(user2.getId() + " 조회 성공");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}