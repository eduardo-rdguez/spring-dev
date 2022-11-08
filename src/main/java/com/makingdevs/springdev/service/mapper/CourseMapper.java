package com.makingdevs.springdev.service.mapper;

import com.makingdevs.springdev.domain.courses.entity.Course;
import com.makingdevs.springdev.domain.courses.entity.Instructor;
import com.makingdevs.springdev.domain.departments.entity.Department;
import com.makingdevs.springdev.service.dto.CourseDto;
import com.makingdevs.springdev.service.dto.InstructorDto;
import com.makingdevs.springdev.service.dto.StudentDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

  public static Course toEntity(String title, Instructor instructor, Department department) {
    return new Course(title, instructor, department.getId());
  }

  public static CourseDto toDto(Course course) {
    return CourseDto.builder()
      .id(course.getId())
      .title(course.getTitle())
      .build();
  }

  public static CourseDto toDetailedDto(Course course) {
    List<StudentDto> students = StudentMapper.toDtoList(course.getStudents());
    InstructorDto instructor = InstructorMapper.toDto(course.getInstructor());

    return CourseDto.builder()
      .id(course.getId())
      .title(course.getTitle())
      .instructor(instructor)
      .students(students)
      .build();
  }

  public static List<CourseDto> toDtoList(List<Course> courses) {
    if (!ObjectUtils.isEmpty(courses)) {
      return courses.stream().map(CourseMapper::toDto).collect(Collectors.toList());
    }
    return Collections.emptyList();
  }
}
