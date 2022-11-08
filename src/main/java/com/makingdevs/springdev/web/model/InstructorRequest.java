package com.makingdevs.springdev.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.makingdevs.springdev.constants.Constants;
import com.makingdevs.springdev.util.enums.BloodType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class InstructorRequest {

  @JsonProperty("first_name")
  @NotBlank
  @Size(max = 45)
  private String firstName;

  @JsonProperty("last_name")
  @NotBlank
  @Size(max = 45)
  private String lastName;

  @JsonProperty("email")
  @NotBlank
  @Size(max = 45)
  @Email(regexp = Constants.EMAIL_REGEX)
  private String email;

  @JsonProperty("birthdate")
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date birthdate;

  @JsonProperty("blood_type")
  @Size(max = 1)
  private BloodType bloodType;

}
