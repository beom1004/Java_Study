package com.moviehub.biz.comment.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviehub.biz.comment.CommentVO;


@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO commentDAO;

	@Override
	public CommentVO getComment(CommentVO comment) {
		return commentDAO.getComment(comment);
	}

	@Override
	public void insertComment(CommentVO comment) {
		commentDAO.insertComment(comment);
	}
}
