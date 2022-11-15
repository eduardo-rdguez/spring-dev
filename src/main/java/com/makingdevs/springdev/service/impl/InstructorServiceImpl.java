package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.Instructor;
import com.makingdevs.springdev.domain.courses.InstructorDetail;
import com.makingdevs.springdev.dto.InstructorDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.exception.EntityNotFoundException;
import com.makingdevs.springdev.mapper.InstructorMapper;
import com.makingdevs.springdev.model.request.InstructorRequest;
import com.makingdevs.springdev.repository.courses.InstructorRepository;
import com.makingdevs.springdev.service.InstructorDetailService;
import com.makingdevs.springdev.service.InstructorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstructorServiceImpl implements InstructorService {

  private final InstructorRepository instructorRepository;
  private final InstructorDetailService instructorDetailService;

  @Override
  @Transactional(readOnly = true)
  public PageDto<InstructorDto> findAllInstructors(Pageable pageable) {
    log.info("Find all instructors");

    Page<Instructor> page = instructorRepository.findAll(pageable);
    return InstructorMapper.toPage(page);
  }

  @Override
  @Transactional(readOnly = true)
  public Instructor findInstructorById(Long id) {
    log.info("Find instructor by id: " + id);

    Optional<Instructor> instructor = instructorRepository.findById(id);

    if (instructor.isPresent()) {
      return instructor.get();
    }

    throw new EntityNotFoundException(Instructor.class);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public InstructorDto saveInstructor(InstructorRequest instructorRequest) {
    log.info("Save instructor by request: " + instructorRequest.toString());

    InstructorDetail instructorDetail =
      instructorDetailService.saveInstructorDetail(instructorRequest);
    Instructor instructor = InstructorMapper.toEntity(instructorRequest, instructorDetail);

    return InstructorMapper.toDetailedDto(instructorRepository.save(instructor));
  }

}
