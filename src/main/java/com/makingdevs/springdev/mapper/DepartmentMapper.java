package com.makingdevs.springdev.mapper;

import com.makingdevs.springdev.domain.departments.Department;
import com.makingdevs.springdev.dto.DepartmentDto;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.model.request.DepartmentRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

  public static PageDto<DepartmentDto> toPage(Page<Department> page) {
    return new PageDto<>(
      toDtoList(page.getContent()),
      page.getTotalPages(),
      page.getTotalElements()
    );
  }

}
