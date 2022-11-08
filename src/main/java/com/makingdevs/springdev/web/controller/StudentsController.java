package com.makingdevs.springdev.web.controller;

import com.makingdevs.springdev.domain.entity.Student;
import com.makingdevs.springdev.service.StudentService;
import com.makingdevs.springdev.service.dto.StudentDto;
import com.makingdevs.springdev.service.mapper.StudentMapper;
import com.makingdevs.springdev.web.model.StudentRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

  private final StudentService studentService;

  public StudentsController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  @ResponseBody
  public List<StudentDto> findAllStudents() {
    return studentService.findAllStudents();
  }

  @GetMapping("/{id}")
  @ResponseBody
  public StudentDto findStudentById(@PathVariable("id") Long id) {
    Optional<Student> student = studentService.findStudentById(id);
    return student.map(StudentMapper::toDetailedDto).orElse(null);
  }

  @PostMapping
  @ResponseBody
  public Student saveStudent(@Valid @RequestBody StudentRequest studentRequest) {
    return studentService.saveStudent(studentRequest);
  }
}
