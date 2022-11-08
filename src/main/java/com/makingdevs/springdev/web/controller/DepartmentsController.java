package com.makingdevs.springdev.web.controller;

import com.makingdevs.springdev.domain.departments.entity.Department;
import com.makingdevs.springdev.service.DepartmentService;
import com.makingdevs.springdev.service.dto.DepartmentDto;
import com.makingdevs.springdev.service.mapper.DepartmentMapper;
import com.makingdevs.springdev.web.model.DepartmentRequest;
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
@RequestMapping("/api/v1/departments")
public class DepartmentsController {

  private final DepartmentService departmentService;

  public DepartmentsController(
    DepartmentService departmentService
  ) {
    this.departmentService = departmentService;
  }

  @GetMapping
  @ResponseBody
  public List<DepartmentDto> findAllDepartments() {
    return departmentService.findAllDepartments();
  }

  @GetMapping("/{id}")
  @ResponseBody
  public DepartmentDto findDepartmentById(@PathVariable("id") Long id) {
    Optional<Department> course = departmentService.findDepartmentById(id);
    return course.map(DepartmentMapper::toDto).orElse(null);
  }

  @PostMapping
  @ResponseBody
  public DepartmentDto saveDepartment(@Valid @RequestBody DepartmentRequest departmentRequest) {
    return departmentService.saveDepartment(departmentRequest);
  }
}
