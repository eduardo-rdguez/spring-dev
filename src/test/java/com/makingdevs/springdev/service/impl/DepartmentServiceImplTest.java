package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.departments.Department;
import com.makingdevs.springdev.dto.DepartmentDto;
import com.makingdevs.springdev.dto.PageDto;
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

import java.util.Collections;
import java.util.List;

@SpringBootTest
class DepartmentServiceImplTest {

  @InjectMocks
  private DepartmentServiceImpl departmentService;

  @Mock
  private DepartmentRepository departmentRepository;

  @Test
  void findAllDepartments() {
    Pageable pageable = PageRequest.of(1, 10);
    List<Department> departmentsFound = Collections.singletonList(new Department());
    Page<Department> departmentPage = new PageImpl<>(departmentsFound);

    Mockito
      .when(departmentRepository.findAll(pageable))
      .thenReturn(departmentPage);

    PageDto<DepartmentDto> departments = departmentService.findAllDepartments(pageable);

    Assertions.assertNotNull(departments);
    Assertions.assertNotNull(departments.getData());
  }

}