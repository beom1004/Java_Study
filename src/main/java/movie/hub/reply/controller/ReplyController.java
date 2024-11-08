package movie.hub.reply.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import movie.hub.reply.entity.CurReplyVO;
import movie.hub.reply.entity.ReplyVO;
import movie.hub.reply.service.ReplyService;
import movie.hub.user.entity.LoginUserVO;

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
		user = (LoginUserVO) session.getAttribute("user_id");
		curReply.setUser_id(user.getUser_id());
		replyService.deleteReply(curReply);
		return "movieComment.do";
	}
	@RequestMapping("/deleteReReply.do")
	public String deleteReReply(CurReplyVO curReply,@RequestParam String comment_id, @RequestParam int movie_id,
			HttpSession session, LoginUserVO user,@RequestParam int re_reply_id, @RequestParam int reply_id) {
		user = (LoginUserVO) session.getAttribute("user_id");
		curReply.setComment_id(comment_id);
		curReply.setMovie_id(movie_id);
		curReply.setUser_id(user.getUser_id());
		curReply.setRe_reply_id(re_reply_id);
		curReply.setReply_id(reply_id);
		replyService.deleteReReply(curReply);
		return "movieComment.do";
	}
	@RequestMapping("/insertReply.do")
	public String insertReply(ReplyVO reply, @RequestParam String user_id, @RequestParam int movie_id, @RequestParam String comment_id) {
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
		user = (LoginUserVO) session.getAttribute("user_id");
		reply.setUser_id(user.getUser_id());
		replyService.insertReReply(reply);
		return "movieComment.do";
	}
}
















