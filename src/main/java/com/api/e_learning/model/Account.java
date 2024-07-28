package com.api.e_learning.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String role;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Courses> coursesRegistered;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Courses> coursesConcludes;

  public Account() {}

  public Account(
    String name,
    String username,
    String password,
    String role,
    List<Courses> coursesRegistered
  ) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.role = role;
    this.coursesRegistered = coursesRegistered;
  }

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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public List<Courses> getCoursesRegistered() {
    return coursesRegistered;
  }

  public void setCoursesRegistered(List<Courses> coursesRegistered) {
    this.coursesRegistered = coursesRegistered;
  }

  public List<Courses> getCoursesConcludes() {
    return coursesConcludes;
  }

  public void setCoursesConcludes(List<Courses> coursesConcludes) {
    this.coursesConcludes = coursesConcludes;
  }
}
