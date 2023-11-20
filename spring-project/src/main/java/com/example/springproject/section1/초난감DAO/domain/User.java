package com.example.springproject.section1.초난감DAO.domain;

/**
 * User.
 *
 * <p>
 *  User 도메인 객체
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/27
 */
public class User {

  String id;
  String name;
  String password;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
