package com.moviehub.biz.movie.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moviehub.biz.movie.MovieGenreVO;
import com.moviehub.biz.movie.MovieVO;

@Repository
public class MovieDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void insertMovie(MovieVO movie) {	
		sqlSessionTemplate.insert("movieDAO.insertMovie", movie);
	}
	public void insertGenre(MovieGenreVO genre) {
		sqlSessionTemplate.insert("movieDAO.insertGenre", genre);
	}
	public MovieVO getMovie(MovieVO movie) {
		return sqlSessionTemplate.selectOne("movieDAO.getMovie", movie);
	}
	public List<MovieVO> getMovieList(){
		return sqlSessionTemplate.selectList("movieDAO.getMovieList");
	}
}