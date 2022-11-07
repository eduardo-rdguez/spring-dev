package com.makingdevs.springdev.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.makingdevs.springdev.constants.Constants;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class StudentRequest {

  @JsonProperty("dni")
  @NotBlank
  private String dni;

  @JsonProperty("first_name")
  @NotBlank
  private String firstName;

  @JsonProperty("last_name")
  @NotBlank
  private String lastName;

  @JsonProperty("email")
  @NotBlank
  @Email(regexp = Constants.EMAIL_REGEX)
  private String email;

}
