package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.Course;
import com.makingdevs.springdev.domain.courses.Student;
import com.makingdevs.springdev.dto.CourseDto;
import com.makingdevs.springdev.mapper.CourseMapper;
import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.service.CourseStudentService;
import com.makingdevs.springdev.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class CourseStudentServiceImpl implements CourseStudentService {

  @Autowired
  private CourseService courseService;
  @Autowired
  private StudentService studentService;

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public CourseDto assignCourseToStudent(Long courseId, Long studentId) {
    log.info("Assign course with id: " + courseId + " to student with id: " + studentId);

    Course courseFound = courseService.findCourseById(courseId);
    Student studentFound = studentService.findStudentById(studentId);

    courseFound.getStudents().add(studentFound);
    return CourseMapper.toDetailedDto(courseService.saveCourse(courseFound));
  }

}
