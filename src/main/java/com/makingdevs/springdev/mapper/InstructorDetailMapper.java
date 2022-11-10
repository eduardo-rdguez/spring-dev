package com.makingdevs.springdev.mapper;

import com.makingdevs.springdev.domain.courses.InstructorDetail;
import com.makingdevs.springdev.model.request.InstructorRequest;
import org.springframework.stereotype.Component;

@Component
public class InstructorDetailMapper {

  public static InstructorDetail toEntity(
    InstructorRequest instructorRequest
  ) {
    return new InstructorDetail(
      instructorRequest.getBirthdate(),
      instructorRequest.getBloodType()
    );
  }

}
