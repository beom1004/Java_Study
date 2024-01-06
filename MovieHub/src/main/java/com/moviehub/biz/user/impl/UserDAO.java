package com.moviehub.biz.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moviehub.biz.user.UserVO;

@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void registerUser(UserVO vo) {
		sqlSessionTemplate.insert("user.registerUser", vo);
	}
	
	public String emailCheck(String email) {
		return sqlSessionTemplate.selectOne("user.emailCheck", email);
	}
	
	public UserVO getUser(UserVO vo) {
		UserVO user = sqlSessionTemplate.selectOne("user.getUser", vo);
		return user;
	}
}
