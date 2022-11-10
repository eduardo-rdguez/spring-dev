package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.entity.Student;
import com.makingdevs.springdev.service.dto.PageDto;
import com.makingdevs.springdev.service.dto.StudentDto;
import com.makingdevs.springdev.web.model.request.StudentRequest;
import org.springframework.data.domain.Pageable;

public interface StudentService {

  PageDto<StudentDto> findAllStudents(Pageable pageable);

  StudentDto saveStudent(StudentRequest studentRequest);

  Student findStudentById(Long id);

}
