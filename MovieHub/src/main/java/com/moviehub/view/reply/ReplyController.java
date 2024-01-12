package com.moviehub.view.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moviehub.biz.reply.ReplyVO;
import com.moviehub.biz.reply.Impl.ReplyService;

@Controller
public class ReplyController {
	@Autowired
	ReplyService replyService;
	
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
}
















