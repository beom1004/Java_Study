package com.moviehub.biz.reply.Impl;

import java.util.List;

import com.moviehub.biz.reply.CurReplyVO;
import com.moviehub.biz.reply.ReplyVO;

public interface ReplyService {
	void insertReply(ReplyVO reply);
	CurReplyVO getCurReply(CurReplyVO curReply);
	List<CurReplyVO> getReplyList(CurReplyVO replyList);
	void deleteReply(CurReplyVO curReply);
}
