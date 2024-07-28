package com.api.e_learning.repository;

import com.api.e_learning.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, String> {}
