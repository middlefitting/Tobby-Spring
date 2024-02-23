package com.example.springproject.section1.section1_5;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ConnectionMaker.
 *
 * <p>
 *	makeConnection의 추상화
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/21
 */
public interface ConnectionMaker {
	Connection makeConnection() throws ClassNotFoundException, SQLException;
}
