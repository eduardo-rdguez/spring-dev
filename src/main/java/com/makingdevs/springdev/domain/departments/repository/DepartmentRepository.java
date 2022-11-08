package com.makingdevs.springdev.domain.departments.repository;

import com.makingdevs.springdev.domain.departments.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  Optional<Department> findByNameIgnoreCase(String name);

}
