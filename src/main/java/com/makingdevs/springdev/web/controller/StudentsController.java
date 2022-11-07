package com.makingdevs.springdev.web.controller;

import com.makingdevs.springdev.domain.entity.Student;
import com.makingdevs.springdev.service.StudentService;
import com.makingdevs.springdev.web.model.StudentRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

  private final StudentService studentService;

  public StudentsController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  @ResponseBody
  public List<Student> findAllStudents() {
    return studentService.findAllStudents();
  }

  @PostMapping
  @ResponseBody
  public Student saveStudent(@RequestBody StudentRequest studentRequest) {
    return studentService.saveStudent(studentRequest);
  }
}
