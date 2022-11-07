package com.makingdevs.springdev.service.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class CourseDto implements Serializable {

  private Long id;
  private String title;
  private InstructorDto instructor;
  private List<StudentDto> students;

}
