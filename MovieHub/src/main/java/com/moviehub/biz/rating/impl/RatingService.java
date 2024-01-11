package com.moviehub.biz.rating.impl;

import com.moviehub.biz.rating.RatingVO;

public interface RatingService {
	public void insertStar(RatingVO rating);
	public RatingVO getRating(RatingVO rating);
}
