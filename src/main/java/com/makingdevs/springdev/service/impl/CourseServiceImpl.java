package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.Course;
import com.makingdevs.springdev.domain.courses.Instructor;
import com.makingdevs.springdev.domain.departments.Department;
import com.makingdevs.springdev.dto.CourseDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.exception.EntityNotFoundException;
import com.makingdevs.springdev.mapper.CourseMapper;
import com.makingdevs.springdev.model.request.CourseRequest;
import com.makingdevs.springdev.repository.courses.CourseRepository;
import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.service.DepartmentService;
import com.makingdevs.springdev.service.InstructorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;
  private final InstructorService instructorService;
  private final DepartmentService departmentService;

  @Override
  @Transactional(readOnly = true)
  public PageDto<CourseDto> findAllCourses(Pageable pageable) {
    log.info("Find all courses");

    Page<Course> page = courseRepository.findAll(pageable);
    return CourseMapper.toPage(page);
  }

  @Transactional(readOnly = true)
  public Course findCourseById(Long id) {
    log.info("Find course by id: " + id);

    Optional<Course> course = courseRepository.findById(id);

    if (course.isPresent()) {
      return course.get();
    }

    throw new EntityNotFoundException(Course.class);
  }

  @Transactional(readOnly = true)
  private Optional<Course> findCourseByTitle(String title) {
    log.info("Find course by title: " + title);

    return courseRepository.findOneByTitleIgnoreCase(title);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public CourseDto saveCourse(CourseRequest courseRequest) {
    log.info("Save a course by request: " + courseRequest.toString());

    String courseTitle = courseRequest.getTitle();
    Optional<Course> courseFound = findCourseByTitle(courseTitle);

    if (!courseFound.isPresent()) {
      Instructor instructorFound = instructorService.findInstructorById(
        courseRequest.getInstructorId()
      );
      Department departmentFound = departmentService.findDepartmentById(
        courseRequest.getDepartmentId()
      );

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
    log.info("Save a course by entity: " + course.toString());

    return courseRepository.save(course);
  }

}
