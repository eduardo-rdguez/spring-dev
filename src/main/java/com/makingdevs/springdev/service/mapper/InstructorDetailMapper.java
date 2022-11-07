package com.makingdevs.springdev.service.mapper;

import com.makingdevs.springdev.domain.entity.InstructorDetail;
import com.makingdevs.springdev.web.model.InstructorRequest;
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