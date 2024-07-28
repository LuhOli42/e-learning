package com.api.e_learning.controller;

import com.api.e_learning.model.Courses;
import com.api.e_learning.service.CoursesServices;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/course")
public class CourseController {

  private final CoursesServices coursesServices;

  public CourseController(CoursesServices coursesServices) {
    this.coursesServices = coursesServices;
  }

  @GetMapping
  public ResponseEntity<List<Courses>> courseList() {
    List<Courses> courseList = coursesServices.findAll();

    return ResponseEntity.ok(courseList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Courses> findById(@PathVariable String id) {
    var course = coursesServices.findById(id);

    return ResponseEntity.ok(course);
  }

  @PostMapping
  public ResponseEntity<Courses> createAccount(@RequestBody Courses course) {
    var courseCreated = coursesServices.create(course);
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(courseCreated.getId())
      .toUri();

    return ResponseEntity.created(location).body(courseCreated);
  }
}
