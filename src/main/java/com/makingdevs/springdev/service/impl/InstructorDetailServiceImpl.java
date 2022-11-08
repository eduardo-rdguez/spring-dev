package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.entity.InstructorDetail;
import com.makingdevs.springdev.domain.courses.repository.InstructorDetailRepository;
import com.makingdevs.springdev.service.InstructorDetailService;
import com.makingdevs.springdev.service.mapper.InstructorDetailMapper;
import com.makingdevs.springdev.web.model.request.InstructorRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {

  private final InstructorDetailRepository instructorDetailRepository;

  public InstructorDetailServiceImpl(InstructorDetailRepository instructorDetailRepository) {
    this.instructorDetailRepository = instructorDetailRepository;
  }

  @Transactional(propagation = Propagation.MANDATORY)
  public InstructorDetail saveInstructorDetail(InstructorRequest instructorRequest) {
    InstructorDetail instructorDetail = InstructorDetailMapper.toEntity(instructorRequest);
    return instructorDetailRepository.save(instructorDetail);
  }
}
