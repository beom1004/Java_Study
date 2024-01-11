package com.moviehub.view.rating;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moviehub.biz.rating.RatingVO;
import com.moviehub.biz.rating.impl.RatingService;
import com.moviehub.biz.user.UserVO;

@Controller
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	@RequestMapping("/insertStar.do")
	public String insertStar(HttpSession session, Model model, RatingVO rating, UserVO user, @RequestParam int movie_id) {
		user = (UserVO) session.getAttribute("user");
		rating.setUser_id(user.getId());
		rating.setMovie_id(movie_id);
		ratingService.insertStar(rating);
		return "content.do";
	}
}
