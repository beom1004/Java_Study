package com.moviehub.biz.rating.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviehub.biz.rating.MyRatingVO;
import com.moviehub.biz.rating.RatingVO;

@Service("rateService")
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingDAO ratingDAO;
	
	@Override
	public void deleteRating(RatingVO rating) {
		ratingDAO.deleteRating(rating);
	}
	@Override
	public List<RatingVO> getAllRatingList(RatingVO rating) {
		return ratingDAO.getAllRatingList(rating);
	}
	@Override
	public List<MyRatingVO> getAllRating(MyRatingVO rating) {
		return ratingDAO.getAllRating(rating);
	}
	@Override
	public void insertStar(RatingVO rating) {
		ratingDAO.insertStar(rating);
	}
	@Override
	public void updateStar(RatingVO rating) {
		ratingDAO.updateStar(rating);
	}
	@Override
	public RatingVO getRating(RatingVO rating) {
		return ratingDAO.getRating(rating);
	}
}
