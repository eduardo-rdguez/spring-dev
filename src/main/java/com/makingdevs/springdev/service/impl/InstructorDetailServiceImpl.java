package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.InstructorDetail;
import com.makingdevs.springdev.mapper.InstructorDetailMapper;
import com.makingdevs.springdev.model.request.InstructorRequest;
import com.makingdevs.springdev.repository.courses.InstructorDetailRepository;
import com.makingdevs.springdev.service.InstructorDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InstructorDetailServiceImpl implements InstructorDetailService {

  private final InstructorDetailRepository instructorDetailRepository;

  @Transactional(propagation = Propagation.MANDATORY)
  public InstructorDetail saveInstructorDetail(InstructorRequest instructorRequest) {
    InstructorDetail instructorDetail = InstructorDetailMapper.toEntity(instructorRequest);
    return instructorDetailRepository.save(instructorDetail);
  }

}
