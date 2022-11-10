package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.entity.Instructor;
import com.makingdevs.springdev.service.dto.InstructorDto;
import com.makingdevs.springdev.service.dto.PageDto;
import com.makingdevs.springdev.web.model.request.InstructorRequest;
import org.springframework.data.domain.Pageable;

public interface InstructorService {

  PageDto<InstructorDto> findAllInstructors(Pageable pageable);

  Instructor findInstructorById(Long id);

  InstructorDto saveInstructor(InstructorRequest instructorRequest);

}
