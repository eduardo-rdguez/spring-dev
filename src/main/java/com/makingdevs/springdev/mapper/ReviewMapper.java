package com.makingdevs.springdev.mapper;

import com.makingdevs.springdev.domain.courses.Review;
import com.makingdevs.springdev.dto.ReviewDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewMapper {

  public static ReviewDto toDto(Review review) {
    return ReviewDto.builder()
      .id(review.getId())
      .comment(review.getComment())
      .build();
  }

  public static List<ReviewDto> toDtoList(List<Review> reviews) {
    return reviews.stream().map(ReviewMapper::toDto).collect(Collectors.toList());
  }

}
