package com.moviehub.biz.rating.impl;

import java.util.List;

import com.moviehub.biz.rating.MyRatingVO;
import com.moviehub.biz.rating.RatingVO;

public interface RatingService {
	public void insertStar(RatingVO rating);
	public void updateStar(RatingVO rating);
	public RatingVO getRating(RatingVO rating);
	public List<MyRatingVO> getAllRating(MyRatingVO rating);
	public List<RatingVO> getAllRatingList(RatingVO rating);
}
