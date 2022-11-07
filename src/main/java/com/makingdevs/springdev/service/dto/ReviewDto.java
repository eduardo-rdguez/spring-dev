package com.makingdevs.springdev.service.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ReviewDto implements Serializable {

  private Long id;
  private String comment;

}
