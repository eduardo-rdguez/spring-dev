package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.entity.Course;
import com.makingdevs.springdev.domain.courses.entity.Instructor;
import com.makingdevs.springdev.domain.courses.repository.CourseRepository;
import com.makingdevs.springdev.domain.departments.entity.Department;
import com.makingdevs.springdev.exception.NotFoundException;
import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.service.DepartmentService;
import com.makingdevs.springdev.service.InstructorService;
import com.makingdevs.springdev.service.dto.CourseDto;
import com.makingdevs.springdev.service.mapper.CourseMapper;
import com.makingdevs.springdev.web.model.request.CourseRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;
  private final InstructorService instructorService;
  private final DepartmentService departmentService;

  public CourseServiceImpl(
    CourseRepository courseRepository,
    InstructorService instructorService,
    DepartmentService departmentService
  ) {
    this.courseRepository = courseRepository;
    this.instructorService = instructorService;
    this.departmentService = departmentService;
  }

  @Override
  @Transactional(readOnly = true)
  public List<CourseDto> findAllCourses() {
    List<Course> courses = courseRepository.findAll();
    return CourseMapper.toDtoList(courses);
  }

  @Transactional(readOnly = true)
  public Course findCourseById(Long id) {
    Optional<Course> course = courseRepository.findById(id);

    if (course.isPresent()) {
      return course.get();
    }

    throw new NotFoundException(Course.class);
  }

  @Transactional(readOnly = true)
  private Optional<Course> findCourseByTitle(String title) {
    return courseRepository.findOneByTitleIgnoreCase(title);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public CourseDto saveCourse(CourseRequest courseRequest) {
    String courseTitle = courseRequest.getTitle();
    Long instructorId = courseRequest.getInstructorId();
    Long departmentId = courseRequest.getDepartmentId();

    Optional<Course> courseFound = findCourseByTitle(courseTitle);
    Instructor instructorFound = instructorService.findInstructorById(instructorId);
    Department departmentFound = departmentService.findDepartmentById(departmentId);

    if (!courseFound.isPresent()) {
      Course course = CourseMapper.toEntity(
        courseTitle,
        instructorFound,
        departmentFound
      );
      return CourseMapper.toDetailedDto(saveCourse(course));
    }

    return CourseMapper.toDetailedDto(courseFound.get());
  }

  @Override
  @Transactional(propagation = Propagation.MANDATORY)
  public Course saveCourse(Course course) {
    return courseRepository.save(course);
  }
}
