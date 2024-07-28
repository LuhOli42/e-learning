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
public class Courses {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String title;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Classes> classes;

  public Courses() {}

  public Courses(String title, List<Classes> classes) {
    this.title = title;
    this.classes = classes;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Classes> getClasses() {
    return classes;
  }

  public void setClasses(List<Classes> classes) {
    this.classes = classes;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
