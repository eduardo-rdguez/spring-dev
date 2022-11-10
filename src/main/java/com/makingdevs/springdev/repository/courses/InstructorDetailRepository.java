package com.makingdevs.springdev.repository.courses;

import com.makingdevs.springdev.domain.courses.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {
}
