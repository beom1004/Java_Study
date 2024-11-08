package movie.hub.rating.service;

import java.util.List;

import movie.hub.rating.mapper.RatingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.hub.rating.entity.MyRatingVO;
import movie.hub.rating.entity.RatingVO;

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
