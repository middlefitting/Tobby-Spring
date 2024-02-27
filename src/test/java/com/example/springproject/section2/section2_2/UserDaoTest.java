package com.example.springproject.section2.section2_2;

import java.sql.SQLException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserDaoTest.
 *
 * <p>
 *   아주 편리한 Junit 단위 테스트
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/27
 */
@Transactional
class UserDaoTest {
  @Test
  @DisplayName("첫 Junit 테스트!")
  void test() throws SQLException, ClassNotFoundException {
	  ApplicationContext context = new AnnotationConfigApplicationContext(DataFactory.class);
	  UserDao dao = context.getBean("userDao", UserDao.class);

	  User user = new User();
	  user.setId("middle");
	  user.setName("정승철");
	  user.setPassword("springno1");
	  dao.add(user);
	  System.out.println(user.getName() + user.getPassword());

	  User user2 = dao.get("middle");
	  System.out.println(user2.getName() + user.getPassword());
	  Assertions.assertThat(user.getId()).isEqualTo(user2.getId());
	  Assertions.assertThat(user.getName()).isEqualTo(user2.getName());
	  Assertions.assertThat(user.getPassword()).isEqualTo(user2.getPassword());
  }
}
