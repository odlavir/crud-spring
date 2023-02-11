package com.lavir.crudspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavir.crudspring.model.Course;
import com.lavir.crudspring.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

  private final CourseRepository courseRepository;

  // public CourseController(CourseRepository courseRepository) {
  // this.courseRepository = courseRepository;
  // }

  @GetMapping
  public List<Course> list() {
    return courseRepository.findAll();
  }

}
