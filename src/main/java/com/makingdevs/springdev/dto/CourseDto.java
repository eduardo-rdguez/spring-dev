package com.makingdevs.springdev.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class CourseDto implements Serializable {

  private Long id;
  private String title;
  private InstructorDto instructor;
  private List<StudentDto> students;

}
