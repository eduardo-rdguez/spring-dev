package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.InstructorDetail;
import com.makingdevs.springdev.model.request.InstructorRequest;

public interface InstructorDetailService {

  InstructorDetail saveInstructorDetail(InstructorRequest instructorRequest);

}
