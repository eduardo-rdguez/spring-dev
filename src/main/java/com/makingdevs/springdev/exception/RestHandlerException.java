package com.makingdevs.springdev.exception;

import com.makingdevs.springdev.model.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestHandlerException extends ResponseEntityExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
    return buildResponseEntity(new ApiErrorResponse(HttpStatus.NOT_FOUND, ex));
  }

  private ResponseEntity<Object> buildResponseEntity(ApiErrorResponse apiErrorResponse) {
    return new ResponseEntity<>(apiErrorResponse, apiErrorResponse.getStatus());
  }

}
