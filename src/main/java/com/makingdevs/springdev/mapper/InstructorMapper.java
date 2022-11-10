package com.makingdevs.springdev.mapper;

import com.makingdevs.springdev.domain.courses.Instructor;
import com.makingdevs.springdev.domain.courses.InstructorDetail;
import com.makingdevs.springdev.dto.CourseDto;
import com.makingdevs.springdev.dto.InstructorDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.model.request.InstructorRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InstructorMapper {

  public static Instructor toEntity(
    InstructorRequest instructorRequest,
    InstructorDetail instructorDetail
  ) {
    Instructor instructor = new Instructor(
      instructorRequest.getFirstName(),
      instructorRequest.getLastName(),
      instructorRequest.getEmail()
    );
    instructor.setInstructorDetail(instructorDetail);

    return instructor;
  }

  public static InstructorDto toDto(Instructor instructor) {
    return InstructorDto.builder()
      .id(instructor.getId())
      .firstName(instructor.getFirstName())
      .lastName(instructor.getLastName())
      .email(instructor.getEmail())
      .birthdate(instructor.getInstructorDetail().getBirthdate())
      .bloodType(instructor.getInstructorDetail().getBloodType())
      .build();
  }

  public static InstructorDto toDetailedDto(Instructor instructor) {
    List<CourseDto> courses = CourseMapper.toDtoList(instructor.getCourses());

    return InstructorDto.builder()
      .id(instructor.getId())
      .firstName(instructor.getFirstName())
      .lastName(instructor.getLastName())
      .birthdate(instructor.getInstructorDetail().getBirthdate())
      .bloodType(instructor.getInstructorDetail().getBloodType())
      .email(instructor.getEmail())
      .courses(courses)
      .build();
  }

  public static List<InstructorDto> toDtoList(List<Instructor> instructors) {
    return instructors.stream().map(InstructorMapper::toDto).collect(Collectors.toList());
  }

  public static PageDto<InstructorDto> toPage(Page<Instructor> page) {
    return new PageDto<>(
      toDtoList(page.getContent()),
      page.getTotalPages(),
      page.getTotalElements()
    );
  }

}
