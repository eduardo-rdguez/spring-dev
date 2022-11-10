package com.makingdevs.springdev.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

  /* Regex */
  public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
  public static final String LETTERS_REGEX = "^[A-Za-zÀ-ÿ ]+$";

  /* Date Formats */
  public static final String ISO_DATE_FORMAT = "yyyy-MM-dd";

  /* Lengths */
  public static final int DNI_LENGTH = 18;

  /* Numbers */
  public static final int FIFTY = 50;
  public static final int ONE_HUNDRED = 100;

}
