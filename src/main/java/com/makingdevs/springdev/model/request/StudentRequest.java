package com.makingdevs.springdev.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.makingdevs.springdev.constant.Constants;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class StudentRequest {

  @JsonProperty("dni")
  @NotBlank
  @Size(min = Constants.DNI_LENGTH, max = Constants.DNI_LENGTH)
  private String dni;

  @JsonProperty("first_name")
  @NotBlank
  @Size(max = Constants.FIFTY)
  @Pattern(regexp = Constants.LETTERS_REGEX)
  private String firstName;

  @JsonProperty("last_name")
  @NotBlank
  @Size(max = Constants.FIFTY)
  @Pattern(regexp = Constants.LETTERS_REGEX)
  private String lastName;

  @JsonProperty("email")
  @NotBlank
  @Size(max = Constants.FIFTY)
  @Email(regexp = Constants.EMAIL_REGEX)
  private String email;

}
