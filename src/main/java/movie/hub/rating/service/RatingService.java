package movie.hub.rating.service;

import java.util.List;

import movie.hub.rating.entity.MyRatingVO;
import movie.hub.rating.entity.RatingVO;

public interface RatingService {
	public void deleteRating(RatingVO rating);
	public void insertStar(RatingVO rating);
	public void updateStar(RatingVO rating);
	public RatingVO getRating(RatingVO rating);
	public List<MyRatingVO> getAllRating(MyRatingVO rating);
	public List<RatingVO> getAllRatingList(RatingVO rating);
}
