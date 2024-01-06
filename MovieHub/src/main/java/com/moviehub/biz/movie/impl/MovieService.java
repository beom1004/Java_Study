package com.moviehub.biz.movie.impl;

import java.util.List;

import com.moviehub.biz.movie.MovieVO;

public interface MovieService {
	void saveMovie();
	List<MovieVO> getMovieList(String type);
}
