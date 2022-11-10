package com.makingdevs.springdev.service;

import com.makingdevs.springdev.dto.CourseDto;

public interface CourseStudentService {

  CourseDto assignStudentToCourse(Long courseId, Long studentId);

}
