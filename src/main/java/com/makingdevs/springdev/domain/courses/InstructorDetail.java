package com.makingdevs.springdev.domain.courses;

import com.makingdevs.springdev.util.enums.BloodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "birthdate", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date birthdate;

  @Column(name = "blood_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private BloodType bloodType;

  public InstructorDetail(Date birthdate, BloodType bloodType) {
    this.birthdate = birthdate;
    this.bloodType = bloodType;
  }

}
