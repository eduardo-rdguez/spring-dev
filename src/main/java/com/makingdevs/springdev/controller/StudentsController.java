package com.makingdevs.springdev.controller;

import com.makingdevs.springdev.domain.courses.Student;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.dto.StudentDto;
import com.makingdevs.springdev.mapper.StudentMapper;
import com.makingdevs.springdev.model.request.StudentRequest;
import com.makingdevs.springdev.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Tag(name = "Students Controller")
@RequestMapping("/api/v1/students")
public class StudentsController {

  private final StudentService studentService;

  public StudentsController(StudentService studentService) {
    this.studentService = studentService;
  }

  @Operation(summary = "Get all students")
  @GetMapping
  public PageDto<StudentDto> findAllStudents(@ParameterObject Pageable pageable) {
    return studentService.findAllStudents(pageable);
  }

  @Operation(summary = "Get a student by id")
  @GetMapping("/{id}")
  public StudentDto findStudentById(@PathVariable("id") Long id) {
    Student student = studentService.findStudentById(id);
    return StudentMapper.toDetailedDto(student);
  }

  @Operation(summary = "Save a student by request")
  @PostMapping
  public StudentDto saveStudent(@Valid @RequestBody StudentRequest studentRequest) {
    return studentService.saveStudent(studentRequest);
  }
}
