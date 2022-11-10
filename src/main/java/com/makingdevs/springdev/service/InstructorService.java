package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.Instructor;
import com.makingdevs.springdev.dto.InstructorDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.model.request.InstructorRequest;
import org.springframework.data.domain.Pageable;

public interface InstructorService {

  PageDto<InstructorDto> findAllInstructors(Pageable pageable);

  Instructor findInstructorById(Long id);

  InstructorDto saveInstructor(InstructorRequest instructorRequest);

}
