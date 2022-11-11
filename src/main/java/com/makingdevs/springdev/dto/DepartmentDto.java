package com.makingdevs.springdev.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class DepartmentDto implements Serializable {

  private Long id;
  private String name;

}
