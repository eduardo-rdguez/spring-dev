package com.makingdevs.springdev.controller;

import com.makingdevs.springdev.domain.courses.Instructor;
import com.makingdevs.springdev.dto.InstructorDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.mapper.InstructorMapper;
import com.makingdevs.springdev.model.request.InstructorRequest;
import com.makingdevs.springdev.service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Tag(name = "Instructors Controller")
@RequestMapping("/api/v1/instructors")
public class InstructorsController {

  private final InstructorService instructorService;

  public InstructorsController(InstructorService instructorService) {
    this.instructorService = instructorService;
  }

  @Operation(summary = "Get all instructors")
  @GetMapping
  public PageDto<InstructorDto> findAllInstructors(@ParameterObject Pageable pageable) {
    return instructorService.findAllInstructors(pageable);
  }

  @Operation(summary = "Find a instructor by id")
  @GetMapping("/{id}")
  public InstructorDto findInstructorById(
    @PathVariable(name = "id") Long id
  ) {
    Instructor instructor = instructorService.findInstructorById(id);
    return InstructorMapper.toDetailedDto(instructor);
  }

  @Operation(summary = "Save a instructor")
  @PostMapping
  public InstructorDto saveInstructor(@Valid @RequestBody InstructorRequest instructorRequest) {
    return instructorService.saveInstructor(instructorRequest);
  }

}
