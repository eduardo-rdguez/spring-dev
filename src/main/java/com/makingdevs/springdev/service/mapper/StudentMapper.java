package com.makingdevs.springdev.service.mapper;

import com.makingdevs.springdev.domain.courses.entity.Student;
import com.makingdevs.springdev.service.dto.CourseDto;
import com.makingdevs.springdev.service.dto.StudentDto;
import com.makingdevs.springdev.web.model.StudentRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

  public static Student toEntity(StudentRequest studentRequest) {
    return new Student(
      studentRequest.getDni(),
      studentRequest.getFirstName(),
      studentRequest.getLastName(),
      studentRequest.getEmail()
    );
  }

  public static StudentDto toDto(Student student) {
    return StudentDto.builder()
      .id(student.getId())
      .dni(student.getDni())
      .firstName(student.getFirstName())
      .lastName(student.getLastName())
      .email(student.getEmail())
      .build();
  }

  public static StudentDto toDetailedDto(Student student) {
    List<CourseDto> courses = CourseMapper.toDtoList(student.getCourses());

    return StudentDto.builder()
      .id(student.getId())
      .dni(student.getDni())
      .firstName(student.getFirstName())
      .lastName(student.getLastName())
      .email(student.getEmail())
      .courses(courses)
      .build();
  }

  public static List<StudentDto> toDtoList(List<Student> students) {
    return students.stream().map(StudentMapper::toDto).collect(Collectors.toList());
  }

}
