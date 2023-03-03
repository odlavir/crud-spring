package com.lavir.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.lavir.crudspring.dto.CourseDTO;
import com.lavir.crudspring.model.Course;

@Component
public class CourseMapper {

  public CourseDTO toDTO(Course course) {
    if (course == null) {
      return null;
    }
    return new CourseDTO(course.getId(), course.getName(), course.getCategory());
  }

  public Course toEntity(CourseDTO courseDTO) {
    Course course = new Course();
    if (courseDTO.id() != null) {
      course.setId(courseDTO.id());
    }
    ;
    course.setCategory(courseDTO.category());
    course.setName(courseDTO.name());
    return course;
  }
}
