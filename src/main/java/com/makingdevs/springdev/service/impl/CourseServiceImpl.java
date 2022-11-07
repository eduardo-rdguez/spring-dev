package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.entity.Course;
import com.makingdevs.springdev.domain.repository.CourseRepository;
import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.service.mapper.CourseMapper;
import com.makingdevs.springdev.web.model.CourseRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;

  public CourseServiceImpl(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Course> findAllCourses() {
    return courseRepository.findAll();
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Course saveCourse(CourseRequest courseRequest) {
    Optional<Course> courseFound = findCourseByTitle(courseRequest.getTitle());

    if (!courseFound.isPresent()) {
      Course course = CourseMapper.toEntity(courseRequest);
      return courseRepository.save(course);
    }

    return courseFound.get();
  }

  @Transactional(readOnly = true)
  private Optional<Course> findCourseByTitle(String title) {
    return courseRepository.findOneByTitleIgnoreCase(title);
  }
}
