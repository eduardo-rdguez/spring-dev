package com.makingdevs.springdev.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
public class ReviewDto implements Serializable {

  private Long id;
  private String comment;

}
