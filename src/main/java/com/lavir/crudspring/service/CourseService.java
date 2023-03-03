package com.lavir.crudspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.lavir.crudspring.dto.CourseDTO;
import com.lavir.crudspring.dto.mapper.CourseMapper;
import com.lavir.crudspring.exception.RecordNotFoundException;
import com.lavir.crudspring.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CourseService {
  private final CourseRepository courseRepository;
  private final CourseMapper courseMapper;

  public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
    this.courseRepository = courseRepository;
    this.courseMapper = courseMapper;
  }

  public List<CourseDTO> list() {
    return courseRepository.findAll()
        .stream()
        .map(courseMapper::toDTO)
        .collect(Collectors.toList());
  }

  public CourseDTO findById(@PathVariable @NotNull @Positive Long id) {
    return courseRepository.findById(id)
        .map(courseMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
  }

  public CourseDTO create(@Valid @NotNull CourseDTO course) {
    return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
  }

  public CourseDTO update(@NotNull @Positive Long id, @Valid @NotNull CourseDTO course) {
    return courseRepository.findById(id)
        .map(data -> {
          data.setName(course.name());
          data.setCategory(course.category());
          return courseMapper.toDTO(courseRepository.save(data));
        }).orElseThrow(() -> new RecordNotFoundException(id));
  }

  public void delete(@PathVariable @NotNull @Positive Long id) {

    courseRepository.delete(courseRepository.findById(id)
        .orElseThrow(() -> new RecordNotFoundException(id)));
  }

}
