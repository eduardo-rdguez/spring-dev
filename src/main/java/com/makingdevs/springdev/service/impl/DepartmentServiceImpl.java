package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.departments.entity.Department;
import com.makingdevs.springdev.domain.departments.repository.DepartmentRepository;
import com.makingdevs.springdev.exception.NotFoundException;
import com.makingdevs.springdev.service.DepartmentService;
import com.makingdevs.springdev.service.dto.DepartmentDto;
import com.makingdevs.springdev.service.mapper.DepartmentMapper;
import com.makingdevs.springdev.web.model.request.DepartmentRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public List<DepartmentDto> findAllDepartments() {
    List<Department> departments = departmentRepository.findAll();
    return DepartmentMapper.toDtoList(departments);
  }

  @Override
  @Transactional(readOnly = true)
  public Department findDepartmentById(Long id) {
    Optional<Department> department = departmentRepository.findById(id);

    if (department.isPresent()) {
      return department.get();
    }

    throw new NotFoundException(Department.class);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Department> findDepartmentByName(String name) {
    return departmentRepository.findByNameIgnoreCase(name);
  }

  @Override
  public DepartmentDto saveDepartment(DepartmentRequest departmentRequest) {
    Optional<Department> departmentFound = findDepartmentByName(departmentRequest.getName());

    if (!departmentFound.isPresent()) {
      Department department = DepartmentMapper.toEntity(departmentRequest);
      return DepartmentMapper.toDto(departmentRepository.save(department));
    }

    return DepartmentMapper.toDto(departmentFound.get());
  }
}
