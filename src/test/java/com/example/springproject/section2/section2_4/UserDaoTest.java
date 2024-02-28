package com.example.springproject.section2.section2_4;

import java.sql.SQLException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;

import config.TestDataSource;

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
@SpringBootTest
@Import(TestDataSource.class)
// @DirtiesContext // 해당 테스트 클래스에서 컨텍스트를 변경한다는 것을 알림
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserDaoTest {

	// @Autowired
	// ApplicationContext context;
	// 픽스처
	@Autowired
	UserDao dao;
	User user1;
	User user2;
	User user3;

	// @BeforeEach
	// void setUp() {
	// 	// 컨텍스트가 동일한 것을 확인 가능
	// 	System.out.println(context);
	// 	dao = context.getBean("userDao", UserDao.class);
	// }

	// @BeforeAll
	// public void setUp() {
	// 	DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/tobby", "tobby",
	// 		"Hello@1234", true);
	// 	dao.setDataSource(dataSource);
	// }

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
	void getUserFailure() throws SQLException {
		dao.deleteAll();
		Assertions.assertThat(dao.getCount()).isEqualTo(0);

		Assertions.assertThatExceptionOfType(EmptyResultDataAccessException.class)
			.isThrownBy(() -> dao.get("unknownId"));

	}
}
