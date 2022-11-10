package com.makingdevs.springdev.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.makingdevs.springdev.constant.Constants;
import com.makingdevs.springdev.util.enums.BloodType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class InstructorRequest {

  @JsonProperty("first_name")
  @NotBlank
  @Size(max = 45)
  @Pattern(regexp = Constants.LETTERS_REGEX)
  private String firstName;

  @JsonProperty("last_name")
  @NotBlank
  @Size(max = 45)
  @Pattern(regexp = Constants.LETTERS_REGEX)
  private String lastName;

  @JsonProperty("email")
  @NotBlank
  @Size(max = 45)
  @Email(regexp = Constants.EMAIL_REGEX)
  private String email;

  @JsonProperty("birthdate")
  @NotNull
  @JsonFormat(pattern = Constants.ISO_DATE_FORMAT)
  private Date birthdate;

  @JsonProperty("blood_type")
  @NotNull
  private BloodType bloodType;

}
