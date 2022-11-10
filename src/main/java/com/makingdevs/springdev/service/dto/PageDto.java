package com.makingdevs.springdev.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class PageDto<T> implements Serializable {

  private List<T> data;
  private int pages;
  private long total;
  private int page;

  public PageDto(List<T> data, int pages, long total, int page) {
    this.data = data;
    this.pages = pages;
    this.total = total;
    this.page = page;
  }

}
