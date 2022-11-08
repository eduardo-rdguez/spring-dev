package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.entity.Course;
import com.makingdevs.springdev.domain.entity.Instructor;
import com.makingdevs.springdev.domain.repository.CourseRepository;
import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.service.InstructorService;
import com.makingdevs.springdev.service.dto.CourseDto;
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
  private final InstructorService instructorService;

  public CourseServiceImpl(
    CourseRepository courseRepository,
    InstructorService instructorService
  ) {
    this.courseRepository = courseRepository;
    this.instructorService = instructorService;
  }

  @Override
  @Transactional(readOnly = true)
  public List<CourseDto> findAllCourses() {
    List<Course> courses = courseRepository.findAll();
    return CourseMapper.toDtoList(courses);
  }

  @Transactional(readOnly = true)
  public Optional<Course> findCourseById(Long id) {
    return courseRepository.findById(id);
  }

  @Transactional(readOnly = true)
  private Optional<Course> findCourseByTitle(String title) {
    return courseRepository.findOneByTitleIgnoreCase(title);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Course saveCourse(CourseRequest courseRequest) {
    String courseTitle = courseRequest.getTitle();
    Long instructorId = courseRequest.getInstructorId();

    Optional<Course> courseFound = findCourseByTitle(courseTitle);
    Optional<Instructor> instructorFound = instructorService.findInstructorById(instructorId);

    if (!courseFound.isPresent() && instructorFound.isPresent()) {
      Course course = CourseMapper.toEntity(courseTitle, instructorFound.get());
      return saveCourse(course);
    }

    return null;
  }

  @Override
  @Transactional(propagation = Propagation.MANDATORY)
  public Course saveCourse(Course course) {
    return courseRepository.save(course);
  }
}
