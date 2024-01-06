package com.moviehub.biz.user.impl;

import com.moviehub.biz.user.UserVO;

public interface UserService {
	void registerUser(UserVO vo);
	String emailCheck(String email);
	UserVO getUser(UserVO vo);
}
