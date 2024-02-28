package com.example.springproject.section2.section2_5;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnitTest.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/28
 */
public class JUnitTest {
	static Set<JUnitTest> testObject = new HashSet<>();

	@Test
	@DisplayName("JUnit 테스트 오브젝트 생성 테스트1")
	void test1() {
		Assertions.assertThat(testObject.contains(this)).isFalse();
		testObject.add(this);
	}

	@Test
	@DisplayName("JUnit 테스트 오브젝트 생성 테스트2")
	void test2() {
		Assertions.assertThat(testObject.contains(this)).isFalse();
		testObject.add(this);
	}

	@Test
	@DisplayName("JUnit 테스트 오브젝트 생성 테스트3")
	void test3() {
		Assertions.assertThat(testObject.contains(this)).isFalse();
		testObject.add(this);
	}
}
