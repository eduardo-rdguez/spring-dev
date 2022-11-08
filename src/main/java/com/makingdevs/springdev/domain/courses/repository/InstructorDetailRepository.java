package com.makingdevs.springdev.domain.courses.repository;

import com.makingdevs.springdev.domain.courses.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {
}
