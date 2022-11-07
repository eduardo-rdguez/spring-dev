package com.makingdevs.springdev.service.mapper;

import com.makingdevs.springdev.domain.entity.Student;
import com.makingdevs.springdev.web.model.StudentRequest;

public class StudentMapper {

  public static Student toEntity(StudentRequest studentRequest) {
    return new Student(
      studentRequest.getFirstName(),
      studentRequest.getLastName(),
      studentRequest.getEmail()
    );
  }

}
