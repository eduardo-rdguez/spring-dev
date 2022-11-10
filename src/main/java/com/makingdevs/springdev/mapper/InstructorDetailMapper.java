package com.makingdevs.springdev.mapper;

import com.makingdevs.springdev.domain.courses.InstructorDetail;
import com.makingdevs.springdev.model.request.InstructorRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
