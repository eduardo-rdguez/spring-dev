package com.makingdevs.springdev.controller;

import com.makingdevs.springdev.dto.CourseDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.mapper.CourseMapper;
import com.makingdevs.springdev.model.request.CourseRequest;
import com.makingdevs.springdev.service.CourseService;
import com.makingdevs.springdev.service.CourseStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Tag(name = "Courses Controller")
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CoursesController {

  private final CourseService courseService;
  private final CourseStudentService courseStudentService;

  @Operation(summary = "Get all courses")
  @GetMapping
  public PageDto<CourseDto> findAllCourses(@ParameterObject Pageable pageable) {
    return courseService.findAllCourses(pageable);
  }

  @Operation(summary = "Get a course by id")
  @GetMapping("/{id}")
  public CourseDto findCourseById(@PathVariable("id") Long id) {
    return CourseMapper.toDetailedDto(courseService.findCourseById(id));
  }

  @Operation(summary = "Save a course")
  @PostMapping
  public CourseDto saveCourse(@Valid @RequestBody CourseRequest courseRequest) {
    return courseService.saveCourse(courseRequest);
  }

  @Operation(summary = "Assign a course to a student")
  @PostMapping("/{course_id}/students/{student_id}")
  @ResponseBody
  public CourseDto assignStudentToCourse(
    @PathVariable("course_id") Long courseId,
    @PathVariable("student_id") Long studentId
  ) {
    return courseStudentService.assignCourseToStudent(courseId, studentId);
  }

}
