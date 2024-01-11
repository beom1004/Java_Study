package com.moviehub.biz.rating.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviehub.biz.rating.RatingVO;

@Service("rateService")
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingDAO ratingDAO;

	@Override
	public void insertStar(RatingVO rating) {
		ratingDAO.insertStar(rating);
	}

	@Override
	public RatingVO getRating(RatingVO rating) {
		return ratingDAO.getRating(rating);
	}
}
