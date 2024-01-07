package com.moviehub.biz.user.impl;

import com.moviehub.biz.user.UserDetailVO;
import com.moviehub.biz.user.UserVO;

public interface UserService {
	void registerUser(UserVO vo, UserDetailVO detail);
	String emailCheck(String email);
	UserVO getUser(UserVO vo);
	UserDetailVO getDetail(UserDetailVO detail);
	void widthdrawlUser(String id);
	void detailModify(UserVO user, UserDetailVO detail);
}
