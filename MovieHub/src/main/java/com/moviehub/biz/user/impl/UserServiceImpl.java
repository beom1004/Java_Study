package com.moviehub.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviehub.biz.user.UserDetailVO;
import com.moviehub.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void registerUser(UserVO user, UserDetailVO detail) {
		userDAO.registerUser(user, detail);
	}

	@Override
	public String emailCheck(String email) {
		return userDAO.emailCheck(email);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public UserDetailVO getDetail(UserDetailVO detail) {
		return userDAO.getDetail(detail);
	}

	@Override
	public void widthdrawlUser(String id) {
		userDAO.widthdrawl(id);
	}

	@Override
	public void userModify(UserVO user) {
		userDAO.modifyUser(user);
	}
	
}
