package com.makingdevs.springdev.web.controller;

import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.service.CourseStudentService;
import com.makingdevs.springdev.service.dto.CourseDto;
import com.makingdevs.springdev.service.mapper.CourseMapper;
import com.makingdevs.springdev.web.model.CourseRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {

  private final CourseService courseService;
  private final CourseStudentService courseStudentService;

  public CoursesController(
    CourseService courseService,
    CourseStudentService courseStudentService
  ) {
    this.courseService = courseService;
    this.courseStudentService = courseStudentService;
  }

  @GetMapping
  @ResponseBody
  public List<CourseDto> findAllCourses() {
    return courseService.findAllCourses();
  }

  @GetMapping("/{id}")
  @ResponseBody
  public CourseDto findCourseById(@PathVariable("id") Long id) {
    return CourseMapper.toDetailedDto(courseService.findCourseById(id));
  }

  @PostMapping
  @ResponseBody
  public CourseDto saveCourse(@Valid @RequestBody CourseRequest courseRequest) {
    return courseService.saveCourse(courseRequest);
  }

  @PostMapping("/{course_id}/students/{student_id}")
  @ResponseBody
  public CourseDto assignStudentToCourse(
    @PathVariable("course_id") Long courseId,
    @PathVariable("student_id") Long studentId
  ) {
    return courseStudentService.assignStudentToCourse(courseId, studentId);
  }
}
