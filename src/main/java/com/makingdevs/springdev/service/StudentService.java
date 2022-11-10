package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.Student;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.dto.StudentDto;
import com.makingdevs.springdev.model.request.StudentRequest;
import org.springframework.data.domain.Pageable;

public interface StudentService {

  PageDto<StudentDto> findAllStudents(Pageable pageable);

  StudentDto saveStudent(StudentRequest studentRequest);

  Student findStudentById(Long id);

}
