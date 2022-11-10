package com.makingdevs.springdev.service;

import com.makingdevs.springdev.domain.departments.entity.Department;
import com.makingdevs.springdev.service.dto.DepartmentDto;
import com.makingdevs.springdev.service.dto.PageDto;
import com.makingdevs.springdev.web.model.request.DepartmentRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DepartmentService {

  Department findDepartmentById(Long id);

  Optional<Department> findDepartmentByName(String name);

  DepartmentDto saveDepartment(DepartmentRequest departmentRequest);

  PageDto<DepartmentDto> findAllDepartments(Pageable pageable);

}
