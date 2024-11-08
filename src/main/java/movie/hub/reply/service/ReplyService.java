package movie.hub.reply.service;

import java.util.List;

import movie.hub.reply.entity.CurReplyVO;
import movie.hub.reply.entity.ReplyVO;

public interface ReplyService {
	void deleteReplyByAdmin(ReplyVO reply);
	void insertReply(ReplyVO reply);
	void insertReReply(ReplyVO reply);
	CurReplyVO getCurReply(CurReplyVO curReply);
	List<ReplyVO> getAllReplyList(ReplyVO reply);
	List<CurReplyVO> getReplyList(CurReplyVO replyList);
	List<CurReplyVO> getReReplyListByReplyId(int reply_id);
	void deleteReply(CurReplyVO curReply);
	void deleteReReply(CurReplyVO curReply);
	void modifyReply(ReplyVO reply);
}
