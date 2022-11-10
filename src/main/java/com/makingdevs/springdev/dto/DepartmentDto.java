package com.makingdevs.springdev.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
public class DepartmentDto implements Serializable {

  private Long id;
  private String name;

}
