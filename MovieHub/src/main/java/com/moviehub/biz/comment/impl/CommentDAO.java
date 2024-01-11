package com.moviehub.biz.comment.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moviehub.biz.comment.CommentVO;
import com.moviehub.biz.comment.CurCommentVO;

@Repository
public class CommentDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void modifyComment(CommentVO comment) {
		sqlSessionTemplate.update("comment.modifyComment", comment);
	}
	public void deleteComment(CommentVO comment) {
		sqlSessionTemplate.delete("comment.deleteComment", comment);
	}
	public void insertComment(CommentVO comment) {
		sqlSessionTemplate.insert("comment.insertComment", comment);
	}
	public void updateLike(CurCommentVO curComment) {
		sqlSessionTemplate.update("comment.updateLike", curComment);
	}
	public CommentVO getComment(CommentVO comment) {
		return sqlSessionTemplate.selectOne("comment.getComment", comment);
	}
	public List<CurCommentVO> getCommentList(CurCommentVO curComment) {
		return sqlSessionTemplate.selectList("comment.getCommentList", curComment);
	}
	public CurCommentVO getCurComment(CurCommentVO curComment) {
		return sqlSessionTemplate.selectOne("comment.getCurComment", curComment);
	}
}
