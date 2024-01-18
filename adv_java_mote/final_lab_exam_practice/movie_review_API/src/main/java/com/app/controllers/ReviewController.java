package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ReviewDto;
import com.app.entities.Review;
import com.app.services.ReviewService;


@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	public ReviewController() {
		System.out.println("in ctor review controleler");
	}

	@PostMapping
	public ResponseEntity<?> addNewReview(@RequestBody ReviewDto dto) {
		try {
			System.out.println("reqq  ");
			System.out.println("dto in postmapping" + dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.addReviewDetails(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erroror");
		}
	}

	@GetMapping
	public List<Review> getAllReviews() {

		return reviewService.getAllReviews();

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateReview(@PathVariable Long id, @RequestBody ReviewDto dto){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(reviewService.updateReviewDetails(id,dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SOme err");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteReview(@PathVariable Long id, @RequestBody ReviewDto dto){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(reviewService.deleteReviewDetails(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't delete");
		}
	}
}
