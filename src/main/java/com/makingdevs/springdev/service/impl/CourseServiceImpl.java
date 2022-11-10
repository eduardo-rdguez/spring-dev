package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.entity.Course;
import com.makingdevs.springdev.domain.courses.entity.Instructor;
import com.makingdevs.springdev.domain.courses.repository.CourseRepository;
import com.makingdevs.springdev.domain.departments.entity.Department;
import com.makingdevs.springdev.exception.EntityNotFoundException;
import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.service.DepartmentService;
import com.makingdevs.springdev.service.InstructorService;
import com.makingdevs.springdev.service.dto.CourseDto;
import com.makingdevs.springdev.service.dto.PageDto;
import com.makingdevs.springdev.service.mapper.CourseMapper;
import com.makingdevs.springdev.web.model.request.CourseRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
  public PageDto<CourseDto> findAllCourses(Pageable pageable) {
    Page<Course> page = courseRepository.findAll(pageable);
    return CourseMapper.toPage(page);
  }

  @Transactional(readOnly = true)
  public Course findCourseById(Long id) {
    Optional<Course> course = courseRepository.findById(id);

    if (course.isPresent()) {
      return course.get();
    }

    throw new EntityNotFoundException(Course.class);
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
