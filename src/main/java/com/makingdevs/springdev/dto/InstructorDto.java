package com.makingdevs.springdev.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.makingdevs.springdev.constant.Constants;
import com.makingdevs.springdev.model.enums.BloodType;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstructorDto implements Serializable {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;

  @JsonFormat(pattern = Constants.ISO_DATE_FORMAT)
  private Date birthdate;

  private BloodType bloodType;
  private List<CourseDto> courses;

}
