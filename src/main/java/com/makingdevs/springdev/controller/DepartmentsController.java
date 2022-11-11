package com.makingdevs.springdev.controller;

import com.makingdevs.springdev.domain.departments.Department;
import com.makingdevs.springdev.dto.DepartmentDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.mapper.DepartmentMapper;
import com.makingdevs.springdev.model.request.DepartmentRequest;
import com.makingdevs.springdev.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
@Tag(name = "Departments Controller")
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentsController {

  private final DepartmentService departmentService;

  @Operation(summary = "Get all departments")
  @GetMapping
  public PageDto<DepartmentDto> findAllDepartments(@ParameterObject Pageable pageable) {
    return departmentService.findAllDepartments(pageable);
  }

  @Operation(summary = "Get a department by id")
  @GetMapping("/{id}")
  public DepartmentDto findDepartmentById(@PathVariable("id") Long id) {
    Department department = departmentService.findDepartmentById(id);
    return DepartmentMapper.toDto(department);
  }

  @Operation(summary = "Save a department")
  @PostMapping
  public DepartmentDto saveDepartment(@Valid @RequestBody DepartmentRequest departmentRequest) {
    return departmentService.saveDepartment(departmentRequest);
  }

}
