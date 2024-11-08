package movie.hub.movie.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import movie.hub.movie.entity.MovieVO;

@Repository
public class MovieDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<MovieVO> getAllMovieList(MovieVO movie) {
		return sqlSessionTemplate.selectList("movieDAO.getAllMovieList", movie);
	}
	public void updateCountry(MovieVO allMovieList) {
		sqlSessionTemplate.update("movieDAO.updateCountry", allMovieList);
	}
	public List<MovieVO> getAllMovie(){
		return sqlSessionTemplate.selectList("movieDAO.getMovieList");
	}

	public List<MovieVO> getSearchMovieTitle(String searchKeyword) {
		return sqlSessionTemplate.selectList("movieDAO.getSearchMovieTitle", searchKeyword);
	}
	public void insertMovie(MovieVO movie) {	
		sqlSessionTemplate.insert("movieDAO.insertMovie", movie);
	}
	public MovieVO getMovie(MovieVO movie) {
		return sqlSessionTemplate.selectOne("movieDAO.getMovie", movie);
	}
	public List<MovieVO> getMovieList(){
		return sqlSessionTemplate.selectList("movieDAO.getMovieList");
	}
}