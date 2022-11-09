package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.entity.Course;
import com.makingdevs.springdev.domain.courses.entity.Student;
import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.service.CourseStudentService;
import com.makingdevs.springdev.service.StudentService;
import com.makingdevs.springdev.service.dto.CourseDto;
import com.makingdevs.springdev.service.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

  @Autowired
  private CourseService courseService;
  @Autowired
  private StudentService studentService;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public CourseDto assignStudentToCourse(Long courseId, Long studentId) {
    Course courseFound = courseService.findCourseById(courseId);
    Student studentFound = studentService.findStudentById(studentId);

    courseFound.getStudents().add(studentFound);
    return CourseMapper.toDetailedDto(courseService.saveCourse(courseFound));
  }
}
