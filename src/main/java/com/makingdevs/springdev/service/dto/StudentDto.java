package com.makingdevs.springdev.service.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class StudentDto implements Serializable {

  private Long id;
  private String dni;
  private String firstName;
  private String lastName;
  private String email;
  private List<CourseDto> courses;

}
