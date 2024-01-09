package com.moviehub.biz.comment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviehub.biz.comment.CommentVO;
import com.moviehub.biz.comment.CurCommentVO;


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

	@Override
	public List<CurCommentVO> getCommentList(CurCommentVO curComment) {
		return commentDAO.getCommentList(curComment);
	}

	@Override
	public CurCommentVO getCurComment(CurCommentVO curComment) {
		return commentDAO.getCurComment(curComment);
	}
	
}
