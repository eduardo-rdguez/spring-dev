package com.makingdevs.springdev.domain.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "comment", nullable = false)
  private String comment;

}