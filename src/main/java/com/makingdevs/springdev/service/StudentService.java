package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.entity.Student;
import com.makingdevs.springdev.web.model.StudentRequest;

import java.util.List;

public interface StudentService {

  List<Student> findAllStudents();

  Student saveStudent(StudentRequest studentRequest);

}
