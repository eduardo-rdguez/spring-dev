package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.entity.Student;
import com.makingdevs.springdev.service.dto.StudentDto;
import com.makingdevs.springdev.web.model.StudentRequest;

import java.util.List;
import java.util.Optional;

public interface StudentService {

  List<StudentDto> findAllStudents();

  StudentDto saveStudent(StudentRequest studentRequest);

  Optional<Student> findStudentById(Long studentId);

}
