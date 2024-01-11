package com.moviehub.biz.rating.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moviehub.biz.rating.RatingVO;

@Repository
public class RatingDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertStar(RatingVO rating) {
		sqlSessionTemplate.insert("rating.insertStar", rating);
	}
	public RatingVO getRating(RatingVO rating) {
		return sqlSessionTemplate.selectOne("rating.getRating", rating);
	}
}
