package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.departments.Department;
import com.makingdevs.springdev.dto.DepartmentDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.exception.EntityNotFoundException;
import com.makingdevs.springdev.mapper.DepartmentMapper;
import com.makingdevs.springdev.model.request.DepartmentRequest;
import com.makingdevs.springdev.repository.departments.DepartmentRepository;
import com.makingdevs.springdev.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

  private DepartmentRepository departmentRepository;

  public DepartmentRepository getDepartmentRepository() {
    return departmentRepository;
  }

  @Autowired
  public void setDepartmentRepository(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public PageDto<DepartmentDto> findAllDepartments(Pageable pageable) {
    log.info("Find all departments");

    Page<Department> page = departmentRepository.findAll(pageable);
    return DepartmentMapper.toPage(page);
  }

  @Override
  @Transactional(readOnly = true)
  public Department findDepartmentById(Long id) {
    log.info("Find department by id: " + id);

    Optional<Department> department = departmentRepository.findById(id);

    if (department.isPresent()) {
      return department.get();
    }

    throw new EntityNotFoundException(Department.class);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Department> findDepartmentByName(String name) {
    log.info("Find department by name: " + name);

    return departmentRepository.findByNameIgnoreCase(name);
  }

  @Override
  public DepartmentDto saveDepartment(DepartmentRequest departmentRequest) {
    log.info("Save department by request: " + departmentRequest.toString());

    Optional<Department> departmentFound = findDepartmentByName(departmentRequest.getName());

    if (!departmentFound.isPresent()) {
      Department department = DepartmentMapper.toEntity(departmentRequest);
      return DepartmentMapper.toDto(departmentRepository.save(department));
    }

    return DepartmentMapper.toDto(departmentFound.get());
  }

}
