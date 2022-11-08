package com.makingdevs.springdev.service.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class DepartmentDto implements Serializable {

  private Long id;
  private String name;

}
