package com.moviehub.biz.comment.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moviehub.biz.comment.CommentVO;

@Repository
public class CommentDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertComment(CommentVO comment) {
		sqlSessionTemplate.insert("comment.insertComment", comment);
	}
	public CommentVO getComment(CommentVO comment) {
		return sqlSessionTemplate.selectOne("comment.getComment", comment);
	}
}
