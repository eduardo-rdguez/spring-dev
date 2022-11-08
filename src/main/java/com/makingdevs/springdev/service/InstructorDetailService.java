package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.entity.InstructorDetail;
import com.makingdevs.springdev.web.model.request.InstructorRequest;

public interface InstructorDetailService {

  InstructorDetail saveInstructorDetail(InstructorRequest instructorRequest);

}
