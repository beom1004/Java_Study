package com.moviehub.view.reply;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moviehub.biz.reply.CurReplyVO;
import com.moviehub.biz.reply.ReplyVO;
import com.moviehub.biz.reply.Impl.ReplyService;
import com.moviehub.biz.user.LoginUserVO;

@Controller
public class ReplyController {
	@Autowired
	ReplyService replyService;
	
	@RequestMapping("/modifyReply.do")
	public String modifyReply(ReplyVO reply) {
		replyService.modifyReply(reply);
		return "movieComment.do";
	}
	@RequestMapping("/deleteReply.do")
	public String deleteReply(HttpSession session, LoginUserVO user, CurReplyVO curReply) {
		user = (LoginUserVO) session.getAttribute("user");
		curReply.setUser_id(user.getId());
		replyService.deleteReply(curReply);
		return "movieComment.do";
	}
	@RequestMapping("/deleteReReply.do")
	public String deleteReReply(CurReplyVO curReply,@RequestParam int comment_id, @RequestParam int movie_id,
			HttpSession session, LoginUserVO user,@RequestParam int re_reply_id, @RequestParam int reply_id) {
		user = (LoginUserVO) session.getAttribute("user");
		curReply.setComment_id(comment_id);
		curReply.setMovie_id(movie_id);
		curReply.setUser_id(user.getId());
		curReply.setRe_reply_id(re_reply_id);
		curReply.setReply_id(reply_id);
		replyService.deleteReReply(curReply);
		return "movieComment.do";
	}
	@RequestMapping("/insertReply.do")
	public String insertReply(ReplyVO reply, @RequestParam String user_id, @RequestParam int movie_id, @RequestParam int comment_id) {
		reply.setComment_id(comment_id);
		reply.setUser_id(user_id);
		reply.setMovie_id(movie_id);
		
		System.out.println("댓글 insert comment_id : "+comment_id);
		System.out.println("댓글 insert user_id : "+user_id);
		System.out.println("댓글 insert movie_ : "+movie_id);
		replyService.insertReply(reply);
	
		return "movieComment.do";
	}
	@RequestMapping("/reReplyInsert.do")
	public String insertReReply(HttpSession session, LoginUserVO user, ReplyVO reply) {
		user = (LoginUserVO) session.getAttribute("user");
		reply.setUser_id(user.getId());
		replyService.insertReReply(reply);
		return "movieComment.do";
	}
}
















