package com.moviehub.view.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moviehub.biz.comment.CommentVO;
import com.moviehub.biz.comment.impl.CommentService;
import com.moviehub.biz.movie.MovieVO;
import com.moviehub.biz.user.UserVO;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/commentInsert.do")
	public String insertComment(Model model, CommentVO comment, UserVO user, MovieVO movie) {
		String userId = user.getId();
	    int movieId = movie.getMovie_id();
		
	    comment.setUser_id(userId);
	    comment.setMovie_id(movieId);
	    commentService.insertComment(comment);
	    return "content.do";
	}
	@RequestMapping(value="/review.do", method = RequestMethod.GET)
	public String movieReview() {
		return "review.jsp";
	}
}
