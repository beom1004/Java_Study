package com.moviehub.view.movie;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moviehub.biz.comment.CommentVO;
import com.moviehub.biz.comment.CurCommentVO;
import com.moviehub.biz.comment.impl.CommentService;
import com.moviehub.biz.movie.MovieVO;
import com.moviehub.biz.movie.impl.MovieService;
import com.moviehub.biz.user.UserVO;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/test.do")
	public String saveMovie() {
       movieService.saveMovie();
       return "index.jsp";
	}
	
	@RequestMapping("/index.do")
	public String getMovieList(Model boxofficeModel, Model netflixModel, Model watchaModel) {
		boxofficeModel.addAttribute("boxofficeList", movieService.getMovieList("boxoffice"));
		netflixModel.addAttribute("netflixList", movieService.getMovieList("netflix"));
		watchaModel.addAttribute("watchaList", movieService.getMovieList("watcha"));
		return "index.jsp";
	}
	
	@RequestMapping(value="/content.do")
	public String getContentView(HttpSession session, UserVO user, Model model, 
			MovieVO movie, CommentVO comment, CommentVO commentList, CurCommentVO curComment) {
		
		user = (UserVO) session.getAttribute("user");
		if(user != null) {
			model.addAttribute("movie", movieService.getMovie(movie));
			String user_id = user.getId();
		    int movie_id = movieService.getMovie(movie).getMovie_id();
			
		    comment.setUser_id(user_id);
		    comment.setMovie_id(movie_id);
		    
		    if(commentService.getComment(comment) != null) {
		    	model.addAttribute("comment", commentService.getComment(comment));
		    }else {
		    	model.addAttribute("comment_null", "이 작품에 대한 코멘트를 남겨주세요.");
		    	System.out.println("comment null 발생");
		    }
		}else {
			model.addAttribute("movie", movieService.getMovie(movie));
			model.addAttribute("comment_null", "이 작품에 대한 코멘트를 남겨주세요.");
		}
		
		curComment.setMovie_id(movieService.getMovie(movie).getMovie_id());
		List<CurCommentVO> commentLists = commentService.getCommentList(curComment);
		model.addAttribute("commentCnt", commentLists.size());
		model.addAttribute("commentLists", commentLists);
		
		return "content.jsp";
	}
}









