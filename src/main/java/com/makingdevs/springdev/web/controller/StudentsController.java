package com.makingdevs.springdev.web.controller;

import com.makingdevs.springdev.domain.courses.entity.Student;
import com.makingdevs.springdev.service.StudentService;
import com.makingdevs.springdev.service.dto.StudentDto;
import com.makingdevs.springdev.service.mapper.StudentMapper;
import com.makingdevs.springdev.web.model.request.StudentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
  public List<StudentDto> findAllStudents() {
    return studentService.findAllStudents();
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
