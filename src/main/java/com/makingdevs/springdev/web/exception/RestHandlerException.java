package com.makingdevs.springdev.web.exception;

import com.makingdevs.springdev.exception.NotFoundException;
import com.makingdevs.springdev.web.model.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestHandlerException extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  protected ResponseEntity<Object> handleEntityNotFound(NotFoundException ex) {
    return buildResponseEntity(new ApiErrorResponse(HttpStatus.NOT_FOUND, ex));
  }

  private ResponseEntity<Object> buildResponseEntity(ApiErrorResponse apiErrorResponse) {
    return new ResponseEntity<>(apiErrorResponse, apiErrorResponse.getStatus());
  }

}
