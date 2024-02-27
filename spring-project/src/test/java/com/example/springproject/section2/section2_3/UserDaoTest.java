package com.example.springproject.section2.section2_3;

import java.sql.SQLException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 * UserDaoTest.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/27
 */
class UserDaoTest {

	// 픽스처
	UserDao dao;
	User user1;
	User user2;
	User user3;

	@BeforeEach
	void setUp() {
		ApplicationContext context = new AnnotationConfigApplicationContext(DataFactory.class);
		dao = context.getBean("userDao", UserDao.class);
	}

	@Test
	@DisplayName("복합적인 테스트")
	void test() throws SQLException, ClassNotFoundException {
		dao.deleteAll();
		Assertions.assertThat(dao.getCount()).isEqualTo(0);

		user1 = new User();
		user1.setId("middle");
		user1.setName("정승철");
		user1.setPassword("springno1");
		dao.add(user1);
		Assertions.assertThat(dao.getCount()).isEqualTo(1);

		user2 = dao.get("middle");
		Assertions.assertThat(user1.getId()).isEqualTo(user2.getId());
		Assertions.assertThat(user1.getName()).isEqualTo(user2.getName());
		Assertions.assertThat(user1.getPassword()).isEqualTo(user2.getPassword());
	}

	@Test
	void getCountTest() throws SQLException, ClassNotFoundException {
		user1 = new User("middle", "정승철", "springno1");
		user2 = new User("code", "김민철", "springno2");
		user3 = new User("bj", "박철민", "springno3");

		dao.deleteAll();
		Assertions.assertThat(dao.getCount()).isEqualTo(0);

		dao.add(user1);
		Assertions.assertThat(dao.getCount()).isEqualTo(1);

		dao.add(user2);
		Assertions.assertThat(dao.getCount()).isEqualTo(2);

		dao.add(user3);
		Assertions.assertThat(dao.getCount()).isEqualTo(3);

		dao.deleteAll();
		Assertions.assertThat(dao.getCount()).isEqualTo(0);
	}

	@Test
	void getUserFailure() throws SQLException, ClassNotFoundException {
		dao.deleteAll();
		Assertions.assertThat(dao.getCount()).isEqualTo(0);

		Assertions.assertThatExceptionOfType(EmptyResultDataAccessException.class)
			.isThrownBy(() -> dao.get("unknownId"));

	}
}
