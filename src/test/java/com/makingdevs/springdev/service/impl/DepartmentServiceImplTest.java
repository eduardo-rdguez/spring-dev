package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.departments.Department;
import com.makingdevs.springdev.dto.DepartmentDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.exception.EntityNotFoundException;
import com.makingdevs.springdev.model.request.DepartmentRequest;
import com.makingdevs.springdev.repository.departments.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("dev")
class DepartmentServiceImplTest {

  @InjectMocks
  private DepartmentServiceImpl departmentService;

  @Mock
  private DepartmentRepository departmentRepository;

  @Test
  void findAllDepartments() {
    Pageable pageable = PageRequest.of(1, 10);
    List<Department> departmentsFound = Collections.singletonList(buildDepartment());
    Page<Department> departmentPage = new PageImpl<>(departmentsFound);

    Mockito
      .when(departmentService.getDepartmentRepository().findAll(pageable))
      .thenReturn(departmentPage);

    PageDto<DepartmentDto> departments = departmentService.findAllDepartments(pageable);

    Assertions.assertNotNull(departments);
    Assertions.assertNotNull(departments.getData());
  }

  @Test
  void findDepartmentById() {
    Mockito
      .when(departmentRepository.findById(Mockito.anyLong()))
      .thenReturn(Optional.of(buildDepartment()));

    Department department = departmentService.findDepartmentById(1L);

    Assertions.assertNotNull(department);
    Assertions.assertEquals(department.getId(), 1L);
  }

  @Test
  void findDepartmentByIdThrows() {
    Mockito
      .when(departmentRepository.findById(Mockito.anyLong()))
      .thenReturn(Optional.empty());

    Assertions.assertThrows(
      EntityNotFoundException.class,
      () -> departmentService.findDepartmentById(999L)
    );
  }

  @Test
  void findDepartmentByName() {
    Mockito
      .when(departmentRepository.findByNameIgnoreCase(Mockito.anyString()))
      .thenReturn(Optional.of(buildDepartment()));

    Optional<Department> department = departmentService.findDepartmentByName("Department");

    Assertions.assertTrue(department.isPresent());
    Assertions.assertEquals(department.get().getId(), 1L);
    Assertions.assertEquals(department.get().getName(), "Department");
  }

  @Test
  void saveDepartment() {
    DepartmentRequest departmentRequest = buildDepartmentRequest();
    Department newDepartment = buildDepartment();

    Mockito
      .when(departmentService.findDepartmentByName(Mockito.anyString()))
      .thenReturn(Optional.empty());

    Mockito
      .when(departmentRepository.save(Mockito.any(Department.class)))
      .thenReturn(newDepartment);

    DepartmentDto department = departmentService.saveDepartment(departmentRequest);

    Assertions.assertNotNull(department);
    Assertions.assertEquals(department.getId(), 1L);
    Assertions.assertEquals(department.getName(), departmentRequest.getName());
  }

  @Test
  void trySaveDepartment() {
    DepartmentRequest departmentRequest = buildDepartmentRequest();
    Department newDepartment = buildDepartment();

    Mockito
      .when(departmentService.findDepartmentByName(Mockito.anyString()))
      .thenReturn(Optional.of(newDepartment));

    Mockito
      .when(departmentRepository.save(Mockito.any(Department.class)))
      .thenReturn(newDepartment);

    DepartmentDto departmentDto = departmentService.saveDepartment(departmentRequest);

    Assertions.assertNotNull(departmentDto);
    Assertions.assertEquals(departmentDto.getId(), 1L);
    Assertions.assertEquals(departmentDto.getName(), departmentRequest.getName());
  }

  DepartmentRequest buildDepartmentRequest() {
    DepartmentRequest departmentRequest = new DepartmentRequest();
    departmentRequest.setName("Department");
    return departmentRequest;
  }

  Department buildDepartment() {
    Department department = new Department("Department");
    department.setId(1L);
    return department;
  }

}