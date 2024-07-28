package com.api.e_learning.service;

import com.api.e_learning.model.Courses;
import java.util.List;

public interface CoursesServices {
  List<Courses> findAll();
  Courses findById(String id);
  Courses create(Courses coursesToCreate);
}
