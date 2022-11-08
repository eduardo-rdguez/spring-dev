package com.makingdevs.springdev.service.mapper;

import com.makingdevs.springdev.domain.departments.entity.Department;
import com.makingdevs.springdev.service.dto.DepartmentDto;
import com.makingdevs.springdev.web.model.DepartmentRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentMapper {

  public static Department toEntity(
    DepartmentRequest departmentRequest
  ) {
    return new Department(
      departmentRequest.getName()
    );
  }

  public static DepartmentDto toDto(Department department) {
    return DepartmentDto.builder()
      .id(department.getId())
      .name(department.getName())
      .build();
  }

  public static List<DepartmentDto> toDtoList(List<Department> departments) {
    return departments.stream().map(DepartmentMapper::toDto).collect(Collectors.toList());
  }

}
