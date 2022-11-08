package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.courses.entity.Instructor;
import com.makingdevs.springdev.service.dto.InstructorDto;
import com.makingdevs.springdev.web.model.InstructorRequest;

import java.util.List;

public interface InstructorService {

  List<InstructorDto> findAllInstructors();

  Instructor findInstructorById(Long id);

  InstructorDto saveInstructor(InstructorRequest instructorRequest);

}
