package com.makingdevs.springdev.domain.repository;

import com.makingdevs.springdev.domain.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

  Optional<Course> findOneByTitleIgnoreCase(String title);

}
