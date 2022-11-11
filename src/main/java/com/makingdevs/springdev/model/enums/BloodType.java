package com.makingdevs.springdev.model.enums;

public enum BloodType {
  A("A+"),
  B("B-"),
  O("O+"),
  AB("AB+");

  private final String description;

  BloodType(String description) {
    this.description = description;
  }
}
