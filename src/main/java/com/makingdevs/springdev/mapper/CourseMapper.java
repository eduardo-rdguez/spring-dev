package com.makingdevs.springdev.mapper;

import com.makingdevs.springdev.domain.courses.Course;
import com.makingdevs.springdev.domain.courses.Instructor;
import com.makingdevs.springdev.domain.departments.Department;
import com.makingdevs.springdev.dto.CourseDto;
import com.makingdevs.springdev.dto.InstructorDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.dto.StudentDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

  public static PageDto<CourseDto> toPage(Page<Course> page) {
    return new PageDto<>(
      toDtoList(page.getContent()),
      page.getTotalPages(),
      page.getTotalElements()
    );
  }

}
