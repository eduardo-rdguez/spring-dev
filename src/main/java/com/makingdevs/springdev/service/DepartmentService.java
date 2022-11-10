package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.departments.Department;
import com.makingdevs.springdev.dto.DepartmentDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.model.request.DepartmentRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DepartmentService {

  Department findDepartmentById(Long id);

  Optional<Department> findDepartmentByName(String name);

  DepartmentDto saveDepartment(DepartmentRequest departmentRequest);

  PageDto<DepartmentDto> findAllDepartments(Pageable pageable);

}
