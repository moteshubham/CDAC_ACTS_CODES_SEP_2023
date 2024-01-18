package com.app.services;

import java.util.List;

import com.app.dto.ReviewDto;
import com.app.entities.Review;

public interface ReviewService {
	ReviewDto addReviewDetails(ReviewDto dto);

	List<Review> getAllReviews();

	ReviewDto updateReviewDetails(Long id, ReviewDto dto);

	String deleteReviewDetails(Long id);
}
