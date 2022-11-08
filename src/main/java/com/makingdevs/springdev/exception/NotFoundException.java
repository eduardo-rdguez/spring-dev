package com.makingdevs.springdev.exception;

public class NotFoundException extends RuntimeException {

  public NotFoundException(Class clazz) {
    super(clazz.getSimpleName() + " was not found");
  }

}
