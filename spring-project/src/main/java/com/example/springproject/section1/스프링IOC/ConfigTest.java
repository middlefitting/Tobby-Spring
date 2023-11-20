package com.example.springproject.section1.스프링IOC;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ConfigTest.
 *
 * <p>
 *  IOC 어노테이션 테스트
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/11/09
 */
@Configuration
@NoArgsConstructor
public class ConfigTest {
  @Bean
  public Animal animal() {
    return new Animal();
  }
}
