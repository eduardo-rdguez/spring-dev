package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.entity.Course;
import com.makingdevs.springdev.service.dto.CourseDto;
import com.makingdevs.springdev.service.dto.PageDto;
import com.makingdevs.springdev.web.model.request.CourseRequest;
import org.springframework.data.domain.Pageable;

public interface CourseService {

  PageDto<CourseDto> findAllCourses(Pageable pageable);

  Course findCourseById(Long id);

  CourseDto saveCourse(CourseRequest courseRequest);

  Course saveCourse(Course course);

}
