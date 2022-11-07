package com.makingdevs.springdev.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CourseRequest {

  @JsonProperty("title")
  @NotBlank
  private String title;

  @JsonProperty("instructor_id")
  @NotNull
  private Long instructorId;

}
