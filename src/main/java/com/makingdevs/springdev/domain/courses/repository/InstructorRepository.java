package com.makingdevs.springdev.domain.courses.repository;

import com.makingdevs.springdev.domain.courses.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
