package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.Course;
import com.makingdevs.springdev.dto.CourseDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.model.request.CourseRequest;
import org.springframework.data.domain.Pageable;

public interface CourseService {

  PageDto<CourseDto> findAllCourses(Pageable pageable);

  Course findCourseById(Long id);

  CourseDto saveCourse(CourseRequest courseRequest);

  Course saveCourse(Course course);

}
