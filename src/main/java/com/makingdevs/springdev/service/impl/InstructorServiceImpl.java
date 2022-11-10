package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.entity.Instructor;
import com.makingdevs.springdev.domain.courses.entity.InstructorDetail;
import com.makingdevs.springdev.domain.courses.repository.InstructorRepository;
import com.makingdevs.springdev.exception.EntityNotFoundException;
import com.makingdevs.springdev.service.InstructorDetailService;
import com.makingdevs.springdev.service.InstructorService;
import com.makingdevs.springdev.service.dto.InstructorDto;
import com.makingdevs.springdev.service.dto.PageDto;
import com.makingdevs.springdev.service.mapper.InstructorMapper;
import com.makingdevs.springdev.web.model.request.InstructorRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
  public PageDto<InstructorDto> findAllInstructors(Pageable pageable) {
    Page<Instructor> page = instructorRepository.findAll(pageable);
    return InstructorMapper.toPage(page);
  }

  @Override
  @Transactional(readOnly = true)
  public Instructor findInstructorById(Long id) {
    Optional<Instructor> instructor = instructorRepository.findById(id);

    if (instructor.isPresent()) {
      return instructor.get();
    }

    throw new EntityNotFoundException(Instructor.class);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public InstructorDto saveInstructor(InstructorRequest instructorRequest) {
    InstructorDetail instructorDetail =
      instructorDetailService.saveInstructorDetail(instructorRequest);
    Instructor instructor = InstructorMapper.toEntity(instructorRequest, instructorDetail);

    return InstructorMapper.toDetailedDto(instructorRepository.save(instructor));
  }
}
