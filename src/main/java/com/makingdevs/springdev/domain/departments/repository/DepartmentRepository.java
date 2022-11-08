package com.makingdevs.springdev.domain.departments.repository;

import com.makingdevs.springdev.domain.departments.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
