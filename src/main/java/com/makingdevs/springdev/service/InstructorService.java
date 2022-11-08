package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.entity.Instructor;
import com.makingdevs.springdev.service.dto.InstructorDto;
import com.makingdevs.springdev.web.model.InstructorRequest;

import java.util.List;
import java.util.Optional;

public interface InstructorService {

  List<InstructorDto> findAllInstructors();

  Optional<Instructor> findInstructorById(Long id);

  Instructor saveInstructor(InstructorRequest instructorRequest);

}
