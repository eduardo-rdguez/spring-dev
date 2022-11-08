package com.makingdevs.springdev.web.controller;

import com.makingdevs.springdev.domain.entity.Instructor;
import com.makingdevs.springdev.service.InstructorService;
import com.makingdevs.springdev.service.dto.InstructorDto;
import com.makingdevs.springdev.service.mapper.InstructorMapper;
import com.makingdevs.springdev.web.model.InstructorRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

  private final InstructorService instructorService;

  public InstructorController(InstructorService instructorService) {
    this.instructorService = instructorService;
  }

  @GetMapping
  @ResponseBody
  public List<InstructorDto> findAllInstructors() {
    return instructorService.findAllInstructors();
  }

  @GetMapping("/{id}")
  @ResponseBody
  public InstructorDto findInstructorById(
    @PathVariable(name = "id") Long id
  ) {
    Optional<Instructor> instructor = instructorService.findInstructorById(id);
    return instructor.map(InstructorMapper::toDetailedDto).orElse(null);
  }

  @PostMapping
  @ResponseBody
  public Instructor saveInstructor(@Valid @RequestBody InstructorRequest instructorRequest) {
    return instructorService.saveInstructor(instructorRequest);
  }
}
