package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ReviewDao;
import com.app.dto.ReviewDto;
import com.app.entities.Review;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ReviewDto addReviewDetails(ReviewDto dto) {
		System.out.println("in add review service");

		Review review = mapper.map(dto, Review.class);
		System.out.println("dto after creating review obj" + dto);

		return mapper.map(reviewDao.save(review), ReviewDto.class);
	}

	@Override
	public List<Review> getAllReviews() {

		return reviewDao.findAll();
	}

	@Override
	public ReviewDto updateReviewDetails(Long id, ReviewDto dto) {
		dto.setId(id);

		Review review = mapper.map(dto, Review.class);
		return mapper.map(reviewDao.save(review), ReviewDto.class);
	}

	@Override
	public String deleteReviewDetails(Long id) {

				reviewDao.deleteById(id);
				return "Deleted Succesfully";
	}

}
