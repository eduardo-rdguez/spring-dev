package com.makingdevs.springdev.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CourseRequest {

  @JsonProperty("title")
  @NotBlank
  private String title;

}
