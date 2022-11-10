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
public class StudentDto implements Serializable {

  private Long id;
  private String dni;
  private String firstName;
  private String lastName;
  private String email;
  private List<CourseDto> courses;

}
