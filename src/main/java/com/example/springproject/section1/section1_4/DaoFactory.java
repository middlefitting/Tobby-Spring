package com.example.springproject.section1.section1_4;

/**
 * CountingDaoFactory.
 *
 * <p>
 *	UserDao 오브젝트를 어떻게 만들고 준비시킬지 결정
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/23
 */
public class DaoFactory {
	public UserDao userDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}

	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
