package com.moviehub.biz.comment.impl;

import java.util.List;

import com.moviehub.biz.comment.CommentVO;
import com.moviehub.biz.comment.CurCommentVO;
import com.moviehub.biz.comment.MyCommentVO;

public interface CommentService {
	void insertComment(CommentVO comment);
	CommentVO getComment(CommentVO comment);
	CurCommentVO getCurComment(CurCommentVO curComment);
	List<CurCommentVO> getCommentList(CurCommentVO curComment);
	List<CurCommentVO> sortComments(CurCommentVO curComment);
	List<MyCommentVO> getMyCommentList(MyCommentVO comment);
	void modifyComment(CommentVO comment);
	void deleteComment(CommentVO comment);
}
