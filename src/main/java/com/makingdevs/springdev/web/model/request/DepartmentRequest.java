package com.makingdevs.springdev.web.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class DepartmentRequest {

  @JsonProperty("name")
  @NotBlank
  @Size(max = 45)
  private String name;

}
