package com.makingdevs.springdev.domain.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "instructor")
public class Instructor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false)
  private String email;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @Fetch(FetchMode.JOIN)
  @JoinColumn(name = "instructor_detail_id")
  private InstructorDetail instructorDetail;

  @OneToMany(
    fetch = FetchType.LAZY,
    mappedBy = "instructor",
    cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
  )
  private List<Course> courses;

  public Instructor(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

}
