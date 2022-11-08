package com.makingdevs.springdev.service;

import com.makingdevs.springdev.service.dto.CourseDto;

public interface CourseStudentService {

  CourseDto assignStudentToCourse(Long courseId, Long studentId);

}
