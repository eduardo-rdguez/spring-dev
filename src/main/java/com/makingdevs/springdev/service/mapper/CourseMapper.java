package com.makingdevs.springdev.service.mapper;

import com.makingdevs.springdev.domain.entity.Course;
import com.makingdevs.springdev.web.model.CourseRequest;

public class CourseMapper {

  public static Course toEntity(CourseRequest courseRequest) {
    return new Course(courseRequest.getTitle());
  }

}
