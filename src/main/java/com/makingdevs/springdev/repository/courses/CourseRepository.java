package com.makingdevs.springdev.repository.courses;

import com.makingdevs.springdev.domain.courses.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

  Optional<Course> findOneByTitleIgnoreCase(String title);

  Page<Course> findAll(Pageable pageable);

}
