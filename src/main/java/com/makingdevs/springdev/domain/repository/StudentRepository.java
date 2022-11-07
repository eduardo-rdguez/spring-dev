package com.makingdevs.springdev.domain.repository;

import com.makingdevs.springdev.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  Optional<Student> findOneByDni(String dni);

}
