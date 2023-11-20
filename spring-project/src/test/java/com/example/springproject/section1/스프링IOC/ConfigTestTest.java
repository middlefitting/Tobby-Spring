package com.example.springproject.section1.스프링IOC;

import com.example.springproject.section1.스프링IOC.Animal;
import com.example.springproject.section1.스프링IOC.ConfigTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ConfigTestTest.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/11/09
 */

class ConfigTestTest {
  @Test
  @DisplayName("Ioc Bean 어노테이션 테스트")
  void test() {
    //Arrange
    //Act
    //Assert
    ApplicationContext context = new AnnotationConfigApplicationContext(ConfigTest.class);
    Animal animal = context.getBean("animal", Animal.class);
  }
}