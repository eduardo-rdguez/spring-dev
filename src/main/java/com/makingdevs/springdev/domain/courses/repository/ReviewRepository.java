package com.makingdevs.springdev.domain.courses.repository;

import com.makingdevs.springdev.domain.courses.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
