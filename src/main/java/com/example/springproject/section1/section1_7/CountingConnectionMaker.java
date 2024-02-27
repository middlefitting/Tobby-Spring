package com.example.springproject.section1.section1_7;

import java.sql.Connection;
import java.sql.SQLException;

import lombok.Getter;

/**
 * CountingConnectionMaker.
 *
 * <p>
 *	DI를 활용한 중간계층, 기존 기능의 수정될 내용은 아무것도 바뀔게 없다.
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/24
 */
@Getter
public class CountingConnectionMaker implements ConnectionMaker{
	private int counter = 0;
	private final ConnectionMaker realConnectionMaker;

	public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		this.counter++;
		return realConnectionMaker.makeConnection();
	}
}
