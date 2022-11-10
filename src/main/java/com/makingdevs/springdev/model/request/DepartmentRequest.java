package com.makingdevs.springdev.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.makingdevs.springdev.constant.Constants;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class DepartmentRequest {

  @JsonProperty("name")
  @NotBlank
  @Size(max = Constants.FIFTY)
  @Pattern(regexp = Constants.LETTERS_REGEX)
  private String name;

}
