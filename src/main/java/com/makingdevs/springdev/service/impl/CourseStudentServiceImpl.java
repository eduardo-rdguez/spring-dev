package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.entity.Course;
import com.makingdevs.springdev.domain.entity.Student;
import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.service.CourseStudentService;
import com.makingdevs.springdev.service.StudentService;
import com.makingdevs.springdev.service.dto.CourseDto;
import com.makingdevs.springdev.service.mapper.CourseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

  private final CourseService courseService;
  private final StudentService studentService;

  public CourseStudentServiceImpl(
    CourseService courseService,
    StudentService studentService
  ) {
    this.courseService = courseService;
    this.studentService = studentService;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public CourseDto assignStudentToCourse(Long courseId, Long studentId) {
    Optional<Course> courseFound = courseService.findCourseById(courseId);
    Optional<Student> studentFound = studentService.findStudentById(studentId);

    if (courseFound.isPresent() && studentFound.isPresent()) {
      Course course = courseFound.get();
      course.getStudents().add(studentFound.get());

      return CourseMapper.toDetailedDto(courseService.saveCourse(course));
    }

    return null;
  }
}
