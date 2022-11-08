package com.makingdevs.springdev.web.model.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiErrorResponse {

  private HttpStatus status;
  private String message;

  public ApiErrorResponse(HttpStatus status, Throwable ex) {
    this.status = status;
    this.message = ex.getMessage();
  }

}
