package com.makingdevs.springdev.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class ReviewDto implements Serializable {

  private Long id;
  private String comment;

}
