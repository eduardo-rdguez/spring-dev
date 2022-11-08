package com.makingdevs.springdev.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DepartmentRequest {

  @JsonProperty("name")
  @NotBlank
  private String name;

}
