package com.makingdevs.springdev.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto implements Serializable {

  private Long id;
  private String dni;
  private String firstName;
  private String lastName;
  private String email;
  private List<CourseDto> courses;

}
