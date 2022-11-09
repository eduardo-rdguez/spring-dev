package com.makingdevs.springdev.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.makingdevs.springdev.constant.Constants;
import com.makingdevs.springdev.util.enums.BloodType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@Data
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
