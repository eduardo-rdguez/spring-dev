package com.makingdevs.springdev.repository.courses;

import com.makingdevs.springdev.domain.courses.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

  Page<Instructor> findAll(Pageable pageable);

}
