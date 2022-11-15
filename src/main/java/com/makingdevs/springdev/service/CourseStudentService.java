package com.makingdevs.springdev.service;

import com.makingdevs.springdev.dto.CourseDto;

public interface CourseStudentService {

  CourseDto assignCourseToStudent(Long courseId, Long studentId);

}
