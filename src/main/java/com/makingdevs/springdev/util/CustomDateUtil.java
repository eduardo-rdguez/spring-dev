package com.makingdevs.springdev.util;

import com.makingdevs.springdev.constant.Constants;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class CustomDateUtil {

  public static Date stringToDate(String dateString) {
    Date date = null;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat(
        Constants.ISO_DATE_FORMAT
      );
      date = formatter.parse(dateString);
    } catch (ParseException ex) {
      log.error(ex.getMessage());
    }
    return date;
  }

}
