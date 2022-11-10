package com.makingdevs.springdev.repository.departments;

import com.makingdevs.springdev.domain.departments.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  @Query("SELECT d FROM Department d WHERE d.name = :name")
  Optional<Department> findByNameIgnoreCase(@Param("name") String name);

  Page<Department> findAll(Pageable pageable);

}
