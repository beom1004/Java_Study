package movie.hub.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import movie.hub.comment.entity.CommentVO;
import movie.hub.comment.service.CommentService;
import movie.hub.movie.entity.MovieVO;
import movie.hub.movie.service.MovieService;
import movie.hub.rating.entity.RatingVO;
import movie.hub.rating.service.RatingService;
import movie.hub.reply.entity.ReplyVO;
import movie.hub.reply.service.ReplyService;
import movie.hub.user.entity.LoginUserVO;
import movie.hub.user.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private RatingService ratingService;
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping("/admin_main.do")
	public String viewAdminMain(Model model, MovieVO movie,
			@RequestParam(value = "searchCondition", defaultValue = "title", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword) {
		movie.setSearchKeyword(keyword);
        movie.setSearchCondition(condition);
        model.addAttribute("movieList", movieService.getAllMovieList(movie));
		return "WEB-INF/views/sys/admin_main.jsp";
	}
	
	@RequestMapping("/admin_user.do")
	public String viewAdminUser(Model model, LoginUserVO user,
			@RequestParam(value = "searchCondition", defaultValue = "id", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword) {
		user.setSearchKeyword(keyword);
		user.setSearchCondition(condition);
		model.addAttribute("userList", userService.getAllUserList(user));
		return "WEB-INF/views/sys/admin_user.jsp";
	}
	@RequestMapping("/admin_rating.do")
	public String viewAdminRating(Model model, RatingVO rating,
			@RequestParam(value = "searchCondition", defaultValue = "movie_id", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword) {
		rating.setSearchKeyword(keyword);
		rating.setSearchCondition(condition);
		model.addAttribute("ratingList", ratingService.getAllRatingList(rating));
		return "WEB-INF/views/sys/admin_rating.jsp";
	}
	@RequestMapping("/admin_comments.do")
	public String viewAdminComment(Model model, CommentVO comment,
			@RequestParam(value = "searchCondition", defaultValue = "movie_id", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword) {
		comment.setSearchKeyword(keyword);
		comment.setSearchCondition(condition);
		model.addAttribute("commentList", commentService.getAllCommentList(comment));
		return "WEB-INF/views/sys/admin_comments.jsp";
	}
	@RequestMapping("/admin_reply.do")
	public String viewAdminReply(Model model, ReplyVO reply,
			@RequestParam(value = "searchCondition", defaultValue = "title", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword) {
		
		reply.setSearchKeyword(keyword);
		reply.setSearchCondition(condition);
		model.addAttribute("replyList", replyService.getAllReplyList(reply));
		return "WEB-INF/views/sys/admin_reply.jsp";
	}
	@RequestMapping("/deleteUser.do")
	public String deleteUser(LoginUserVO user) {
		userService.deleteUser(user);
		return "admin_user.do";
	}
	@RequestMapping("/deleteRating.do")
	public String deleteRating(RatingVO rating) {
		ratingService.deleteRating(rating);
		return "admin_rating.do";
	}
	@RequestMapping("/deleteCommentByAdmin.do")
	public String deleteCommentByAdmin(CommentVO comment) {
		commentService.deleteCommentByAdmin(comment);
		return "admin_comments.do";
	}
	@RequestMapping("/deleteReplyByAdmin.do")
	public String deleteReplyByAdmin(ReplyVO reply) {
		replyService.deleteReplyByAdmin(reply);
		return "admin_reply.do";
	}
}
