package com.lavir.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lavir.crudspring.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
