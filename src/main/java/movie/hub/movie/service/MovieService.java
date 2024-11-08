package movie.hub.movie.service;

import java.util.List;

import movie.hub.movie.entity.MovieVO;

public interface MovieService {
	void saveMovie();
	MovieVO getMovie(MovieVO movie);
	List<MovieVO> getMovieList(String type);
	List<MovieVO> getAllMovieList(MovieVO movie);
	List<MovieVO> getSearchMovieTitle(String searchKeyword);
}
