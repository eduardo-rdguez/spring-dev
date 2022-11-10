package com.makingdevs.springdev.mapper;

import com.makingdevs.springdev.domain.courses.Student;
import com.makingdevs.springdev.dto.CourseDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.dto.StudentDto;
import com.makingdevs.springdev.model.request.StudentRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
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
    if (!ObjectUtils.isEmpty(students)) {
      return students.stream().map(StudentMapper::toDto).collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

  public static PageDto<StudentDto> toPage(Page<Student> page) {
    return new PageDto<>(
      toDtoList(page.getContent()),
      page.getTotalPages(),
      page.getTotalElements()
    );
  }
}
