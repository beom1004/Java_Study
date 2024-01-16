package com.moviehub.biz.reply.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moviehub.biz.reply.CurReplyVO;
import com.moviehub.biz.reply.ReplyVO;

@Repository
public class ReplyDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void modifyReply(ReplyVO reply) {
		sqlSessionTemplate.update("reply.modifyReply", reply);
	}
	public void deleteReply(CurReplyVO curReply) {
		sqlSessionTemplate.delete("reply.deleteReply", curReply);
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
