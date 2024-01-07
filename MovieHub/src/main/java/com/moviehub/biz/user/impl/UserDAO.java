package com.moviehub.biz.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moviehub.biz.user.UserDetailVO;
import com.moviehub.biz.user.UserVO;

@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void registerUser(UserVO user, UserDetailVO detail) {
		sqlSessionTemplate.insert("user.registerUser", user);
		sqlSessionTemplate.insert("user.detailInsert", detail);
	}
	
	public String emailCheck(String email) {
		return sqlSessionTemplate.selectOne("user.emailCheck", email);
	}
	
	public UserVO getUser(UserVO vo) {
		return sqlSessionTemplate.selectOne("user.getUser", vo);
	}
	
	public UserDetailVO getDetail(UserDetailVO detail) {
		return sqlSessionTemplate.selectOne("user.getDetail", detail);
	}
	public void widthdrawl(String id) {
		sqlSessionTemplate.delete("user.widthdrawlUser", id);
	}
	public void detailModify(UserVO user, UserDetailVO detail) {
		sqlSessionTemplate.update("user.userModify", user);
		sqlSessionTemplate.update("user.detailModify", detail);
	}
}
