package com.makingdevs.springdev.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.makingdevs.springdev.constant.Constants;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CourseRequest {

  @JsonProperty("title")
  @NotBlank
  @Size(max = Constants.ONE_HUNDRED)
  private String title;

  @JsonProperty("instructor_id")
  @NotNull
  private Long instructorId;

  @JsonProperty("department_id")
  @NotNull
  private Long departmentId;

}
