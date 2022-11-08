package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.entity.Instructor;
import com.makingdevs.springdev.domain.entity.InstructorDetail;
import com.makingdevs.springdev.domain.repository.InstructorRepository;
import com.makingdevs.springdev.service.InstructorDetailService;
import com.makingdevs.springdev.service.InstructorService;
import com.makingdevs.springdev.service.dto.InstructorDto;
import com.makingdevs.springdev.service.mapper.InstructorMapper;
import com.makingdevs.springdev.web.model.InstructorRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

  private final InstructorRepository instructorRepository;
  private final InstructorDetailService instructorDetailService;

  public InstructorServiceImpl(
    InstructorRepository instructorRepository,
    InstructorDetailService instructorDetailService
  ) {
    this.instructorRepository = instructorRepository;
    this.instructorDetailService = instructorDetailService;
  }

  @Override
  @Transactional(readOnly = true)
  public List<InstructorDto> findAllInstructors() {
    List<Instructor> instructors = instructorRepository.findAll();
    return InstructorMapper.toDtoList(instructors);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Instructor> findInstructorById(Long id) {
    return instructorRepository.findById(id);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Instructor saveInstructor(InstructorRequest instructorRequest) {
    InstructorDetail instructorDetail =
      instructorDetailService.saveInstructorDetail(instructorRequest);
    Instructor instructor = InstructorMapper.toEntity(instructorRequest, instructorDetail);

    return instructorRepository.save(instructor);
  }
}
