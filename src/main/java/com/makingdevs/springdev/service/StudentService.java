package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.entity.Student;
import com.makingdevs.springdev.service.dto.StudentDto;
import com.makingdevs.springdev.web.model.request.StudentRequest;

import java.util.List;

public interface StudentService {

  List<StudentDto> findAllStudents();

  StudentDto saveStudent(StudentRequest studentRequest);

  Student findStudentById(Long id);

}
