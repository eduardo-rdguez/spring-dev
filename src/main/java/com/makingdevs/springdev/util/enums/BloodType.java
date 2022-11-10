package com.makingdevs.springdev.util.enums;

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
