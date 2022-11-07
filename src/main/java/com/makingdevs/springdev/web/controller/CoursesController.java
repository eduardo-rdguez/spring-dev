package com.makingdevs.springdev.web.controller;

import com.makingdevs.springdev.domain.entity.Course;
import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.web.model.CourseRequest;
import com.makingdevs.springdev.web.model.StudentRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {

  private final CourseService courseService;

  public CoursesController(CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping
  @ResponseBody
  public List<Course> findAllCourses() {
    return courseService.findAllCourses();
  }

  @PostMapping
  @ResponseBody
  public Course saveCourse(@RequestBody CourseRequest courseRequest) {
    return courseService.saveCourse(courseRequest);
  }
}
