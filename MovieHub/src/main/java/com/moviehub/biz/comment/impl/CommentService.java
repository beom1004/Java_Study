package com.moviehub.biz.comment.impl;

import com.moviehub.biz.comment.CommentVO;

public interface CommentService {
	void insertComment(CommentVO comment);
	CommentVO getComment(CommentVO comment);
}
