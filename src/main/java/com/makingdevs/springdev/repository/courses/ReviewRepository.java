package com.makingdevs.springdev.repository.courses;

import com.makingdevs.springdev.domain.courses.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
