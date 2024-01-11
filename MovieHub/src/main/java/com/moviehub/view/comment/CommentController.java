package com.moviehub.view.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.moviehub.biz.comment.CommentVO;
import com.moviehub.biz.comment.CurCommentVO;
import com.moviehub.biz.comment.impl.CommentService;
import com.moviehub.biz.movie.MovieVO;
import com.moviehub.biz.movie.impl.MovieService;
import com.moviehub.biz.reply.CurReplyVO;
import com.moviehub.biz.reply.Impl.ReplyService;
import com.moviehub.biz.user.UserVO;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping("/deleteComment.do")
	public String deleteComment(@RequestParam String user_id, @RequestParam int movie_id, CommentVO comment) {
		commentService.deleteComment(comment);
		return "content.do";
	}
	@RequestMapping("/modifyComment.do")
	public String modifyComment(@RequestParam String user_id, @RequestParam int movie_id, CommentVO comment) {
		commentService.modifyComment(comment);
		return "content.do";
	}
	@RequestMapping("/insertLike.do")
	public String insertLike(@RequestParam String user_id, CurCommentVO curComment) {
		curComment.setUser_id(user_id);
		commentService.updateLike(curComment);
		return "content.do";
	}
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
	public String movieReview(Model model, MovieVO movie, CurCommentVO curComment) {
		model.addAttribute("movie", movieService.getMovie(movie));
		curComment.setMovie_id(movieService.getMovie(movie).getMovie_id());
		List<CurCommentVO> commentLists = commentService.getCommentList(curComment);
		
		model.addAttribute("commentCnt", commentLists.size());
		model.addAttribute("commentLists", commentLists);
		return "review.jsp";
	}
	@RequestMapping(value="/movieComment.do", method = RequestMethod.GET)
	public String movieCommentView(Model model, MovieVO movie, CommentVO comment, 
			CurCommentVO curComment, @RequestParam String nickname, CurReplyVO curReply) {
		model.addAttribute("movie", movieService.getMovie(movie));
		curComment.setNickname(nickname);
		curComment.setMovie_id(movieService.getMovie(movie).getMovie_id());
		model.addAttribute("curComment", commentService.getCurComment(curComment));
		
		curReply.setComment_id(commentService.getCurComment(curComment).getComment_id());
		model.addAttribute("curReply", replyService.getCurReply(curReply));
		return "movieComment.jsp";
	}
}























