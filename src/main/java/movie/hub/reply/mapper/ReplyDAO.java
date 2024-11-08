package movie.hub.reply.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import movie.hub.reply.entity.CurReplyVO;
import movie.hub.reply.entity.ReplyVO;

@Repository
public class ReplyDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void deleteReplyByAdmin(ReplyVO reply) {
		sqlSessionTemplate.delete("reply.deleteReplyByAdmin", reply);
	}
	public List<ReplyVO> getAllReplyList(ReplyVO reply){
		return sqlSessionTemplate.selectList("reply.getAllReplyList", reply);
	}
	public void modifyReply(ReplyVO reply) {
		sqlSessionTemplate.update("reply.modifyReply", reply);
	}
	public void deleteReply(CurReplyVO curReply) {
		sqlSessionTemplate.delete("reply.deleteReply", curReply);
	}
	public void deleteReReply(CurReplyVO curReply) {
		sqlSessionTemplate.delete("reply.deleteReReply", curReply);
	}
	public void insertReply(ReplyVO reply) {
		sqlSessionTemplate.update("comment.updateReplyCnt", reply);
		sqlSessionTemplate.insert("reply.insertReply", reply);
	}
	public void insertReReply(ReplyVO reply) {
		sqlSessionTemplate.insert("reply.insertReReply", reply);
	}
	public CurReplyVO getCurReply(CurReplyVO curReply) {
		return sqlSessionTemplate.selectOne("reply.getCurReply", curReply);
	}
	public List<CurReplyVO> getReplyList(CurReplyVO replyList){
		return sqlSessionTemplate.selectList("reply.getReplyList", replyList);
	}
	public List<CurReplyVO> getReReplyListByReplyId(int reply_id) {
		return sqlSessionTemplate.selectList("reply.getReReplyListByReplyId", reply_id);
	}
}
