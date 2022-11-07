package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.entity.Course;
import com.makingdevs.springdev.web.model.CourseRequest;

import java.util.List;

public interface CourseService {

  List<Course> findAllCourses();

  Course saveCourse(CourseRequest courseRequest);

}
