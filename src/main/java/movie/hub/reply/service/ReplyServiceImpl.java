package movie.hub.reply.service;

import java.util.ArrayList;
import java.util.List;

import movie.hub.reply.mapper.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.hub.reply.entity.CurReplyVO;
import movie.hub.reply.entity.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public void deleteReplyByAdmin(ReplyVO reply) {
		replyDAO.deleteReplyByAdmin(reply);
	}
	@Override
	public List<ReplyVO> getAllReplyList(ReplyVO reply) {
		return replyDAO.getAllReplyList(reply);
	}
	@Override
	public void modifyReply(ReplyVO reply) {
		replyDAO.modifyReply(reply);
	}
	@Override
	public void deleteReply(CurReplyVO curReply) {
		replyDAO.deleteReply(curReply);
	}
	
	@Override
	public void deleteReReply(CurReplyVO curReply) {
		replyDAO.deleteReReply(curReply);
	}
	public void insertReply(ReplyVO reply) {
		replyDAO.insertReply(reply);
	}
	@Override
	public void insertReReply(ReplyVO reply) {
		replyDAO.insertReReply(reply);
	}
	public CurReplyVO getCurReply(CurReplyVO curReply) {
		return replyDAO.getCurReply(curReply);
	}
	@Override
	public List<CurReplyVO> getReplyList(CurReplyVO replyList) {
		return replyDAO.getReplyList(replyList);
	}
	@Override
	public List<CurReplyVO> getReReplyListByReplyId(int reply_id) {
		List<CurReplyVO> resultList = new ArrayList<>();
		resultList = replyDAO.getReReplyListByReplyId(reply_id);
		return resultList;
	}
	
}
