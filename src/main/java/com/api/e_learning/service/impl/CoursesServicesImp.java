package com.api.e_learning.service.impl;

import com.api.e_learning.model.Courses;
import com.api.e_learning.repository.CoursesRepository;
import com.api.e_learning.service.CoursesServices;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class CoursesServicesImp implements CoursesServices {

  private final CoursesRepository coursesRepository;

  public CoursesServicesImp(CoursesRepository coursesRepository) {
    this.coursesRepository = coursesRepository;
  }

  @Override
  public Courses findById(String id) {
    return coursesRepository
      .findById(id)
      .orElseThrow(NoSuchElementException::new);
  }

  @Override
  public Courses create(Courses coursesToCreate) {
    return coursesRepository.save(coursesToCreate);
  }

  @Override
  public List<Courses> findAll() {
    return coursesRepository.findAll();
  }
}
