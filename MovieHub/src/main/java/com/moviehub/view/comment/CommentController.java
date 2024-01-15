package com.moviehub.view.comment;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.moviehub.biz.user.LoginUserVO;

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
	@RequestMapping("/insertComment.do")
	public String insertComment(HttpSession session, HttpServletRequest request, LoginUserVO user, CommentVO comment) {
		user = (LoginUserVO) session.getAttribute("user");
	    comment.setUser_id(user.getId());
	    commentService.insertComment(comment);
	    // 코멘트 입력 후 뒤로 가기
	    String referer = request.getHeader("Referer");
	    if (referer == null || referer.isEmpty()) {
	        return "redirect:/content.do";
	    }
	    return "redirect:" + referer;
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
	public String movieCommentView(HttpSession session, Model model, MovieVO movie, CommentVO comment, 
			CurCommentVO curComment, CurReplyVO curReply, CurReplyVO replyList, ArrayList<CurReplyVO> reReplyList) {
		model.addAttribute("movie", movieService.getMovie(movie));
		int movie_id = movieService.getMovie(movie).getMovie_id();
		curComment.setMovie_id(movie_id);
		curComment = commentService.getCurComment(curComment);
		model.addAttribute("curComment", curComment);
		
		LoginUserVO user = (LoginUserVO) session.getAttribute("user");
		if(user != null) {
			curReply.setUser_id(user.getId());
			curReply.setComment_id(curComment.getComment_id());
			model.addAttribute("curReply", replyService.getCurReply(curReply));
		}
		replyList.setComment_id(curComment.getComment_id());
		replyList.setMovie_id(movie_id);
		model.addAttribute("replyCnt", replyService.getReplyList(replyList).size());
		
		Map<Integer, List<CurReplyVO>> reReplyMap = new HashMap<>();
		List<CurReplyVO> replyLists = replyService.getReplyList(replyList);

		for (CurReplyVO reply : replyLists) {
		    List<CurReplyVO> reReplyLists = replyService.getReReplyListByReplyId(reply.getReply_id());
		    reReplyMap.put(reply.getReply_id(), reReplyLists);
		}
		model.addAttribute("replyList", replyLists);
		model.addAttribute("reReplyMap", reReplyMap);
		return "movieComment.jsp";
	}
}























