package com.makingdevs.springdev.web.controller;

import com.makingdevs.springdev.domain.departments.entity.Department;
import com.makingdevs.springdev.service.DepartmentService;
import com.makingdevs.springdev.service.dto.DepartmentDto;
import com.makingdevs.springdev.service.mapper.DepartmentMapper;
import com.makingdevs.springdev.web.model.request.DepartmentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Departments Controller")
@RequestMapping("/api/v1/departments")
public class DepartmentsController {

  private final DepartmentService departmentService;

  public DepartmentsController(
    DepartmentService departmentService
  ) {
    this.departmentService = departmentService;
  }

  @Operation(summary = "Get all departments")
  @GetMapping
  public List<DepartmentDto> findAllDepartments() {
    return departmentService.findAllDepartments();
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
