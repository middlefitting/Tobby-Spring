package com.example.springproject.learningtest.junit;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * EveryTestDifferentObject.
 *
 * <p>
 *   모든 테스트는
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/11/22
 */
@DisplayName("모든 테스트는 다른 객체를 사용한다.")
public class EveryTestDifferentObject {
  private static EveryTestDifferentObject testObject;

  @Test
  @DisplayName("test1")
  void test() {
    //Arrange
    //Act
    //Assert
    assertNotEquals(testObject, this);
    testObject = this;
  }

  @Test
  @DisplayName("test2")
  void test2() {
    //Arrange
    //Act
    //Assert
    assertNotEquals(testObject, this);
    testObject = this;
  }

  @Test
  @DisplayName("test3")
  void test3() {
    //Arrange
    //Act
    //Assert
    assertNotEquals(testObject, this);
    testObject = this;
  }
}
