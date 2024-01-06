package com.moviehub.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviehub.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void registerUser(UserVO vo) {
		userDAO.registerUser(vo);
	}

	@Override
	public String emailCheck(String email) {
		return userDAO.emailCheck(email);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
}
