package com.moviehub.biz.user.impl;

import java.util.List;

import com.moviehub.biz.user.LoginUserVO;
import com.moviehub.biz.user.UserCommentVO;
import com.moviehub.biz.user.UserDetailVO;
import com.moviehub.biz.user.UserVO;

public interface UserService {
	void registerUser(UserVO vo, UserDetailVO detail);
	String emailCheck(String email);
	LoginUserVO getUser(LoginUserVO user);
	UserDetailVO getDetail(UserDetailVO detail);
	void widthdrawlUser(String id);
	void modifyUser(LoginUserVO user, LoginUserVO loginUser);
	LoginUserVO getUserData(LoginUserVO user);
	Double getAvgRating(LoginUserVO user);
	List<UserCommentVO> getUserCommentList(UserCommentVO userComment);
}
