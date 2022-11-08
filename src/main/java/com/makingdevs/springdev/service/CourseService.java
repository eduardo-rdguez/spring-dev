package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.entity.Course;
import com.makingdevs.springdev.service.dto.CourseDto;
import com.makingdevs.springdev.web.model.CourseRequest;

import java.util.List;
import java.util.Optional;

public interface CourseService {

  List<CourseDto> findAllCourses();

  Optional<Course> findCourseById(Long id);

  CourseDto saveCourse(CourseRequest courseRequest);

  Course saveCourse(Course course);

}
