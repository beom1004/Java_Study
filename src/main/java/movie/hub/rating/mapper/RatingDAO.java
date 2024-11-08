package movie.hub.rating.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import movie.hub.rating.entity.MyRatingVO;
import movie.hub.rating.entity.RatingVO;

@Repository
public class RatingDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void deleteRating(RatingVO rating) {
		sqlSessionTemplate.delete("rating.deleteRating", rating);
	}
	public List<RatingVO> getAllRatingList(RatingVO rating){
		return sqlSessionTemplate.selectList("rating.getAllRatingList", rating);
	}
	public List<MyRatingVO> getAllRating(MyRatingVO rating){
		List<MyRatingVO> list = new ArrayList<MyRatingVO>();
		if(rating.getSortType().equals("wordAsc")) {
			list = sqlSessionTemplate.selectList("rating.ratingListByWordAsc", rating);
		}else if(rating.getSortType().equals("ratingDesc")) {
			list = sqlSessionTemplate.selectList("rating.ratingListByRatingDesc", rating);
		}
		return list;
	}
	public void insertStar(RatingVO rating) {
		sqlSessionTemplate.insert("rating.insertStar", rating);
	}
	public void updateStar(RatingVO rating) {
		sqlSessionTemplate.update("rating.updateStar", rating);
	}
	public RatingVO getRating(RatingVO rating) {
		return sqlSessionTemplate.selectOne("rating.getRating", rating);
	}
}
