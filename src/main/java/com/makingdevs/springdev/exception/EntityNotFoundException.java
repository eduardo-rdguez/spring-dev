package com.makingdevs.springdev.exception;

public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException(Class entity) {
    super(entity.getSimpleName() + " was not found");
  }

}
