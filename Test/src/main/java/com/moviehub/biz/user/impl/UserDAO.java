package com.moviehub.biz.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moviehub.biz.user.LoginUserVO;
import com.moviehub.biz.user.UserCommentVO;
import com.moviehub.biz.user.UserDetailVO;
import com.moviehub.biz.user.UserVO;

@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void deleteUser(LoginUserVO user) {
		sqlSessionTemplate.delete("user.deleteUser", user);
	}
	public int idCheck(String id) {
		return sqlSessionTemplate.selectOne("user.idCheck", id);
	}
	public LoginUserVO loginCheck(LoginUserVO user) {
		return sqlSessionTemplate.selectOne("user.loginCheck", user);
	}
	public int emailCheck(String email) {
		return sqlSessionTemplate.selectOne("user.emailCheck", email);
	}
	public List<LoginUserVO> getAllUserList(LoginUserVO user){
		return sqlSessionTemplate.selectList("user.getAllUserList", user);
	}
	public List<UserCommentVO> getUserCommentList(UserCommentVO userComment) {
		return sqlSessionTemplate.selectList("user.getUserComment", userComment);
	}
	public LoginUserVO getUserData(LoginUserVO user) {
		return sqlSessionTemplate.selectOne("user.getUserData", user);
	}
	public List<String> getAvgRating(LoginUserVO user) {
		return sqlSessionTemplate.selectList("user.getAvgRating", user);
	}
	public void registerUser(UserVO user, UserDetailVO detail) {
		sqlSessionTemplate.insert("user.registerUser", user);
		sqlSessionTemplate.insert("user.detailInsert", detail);
	}
	public UserVO getUserById(String id) {
		return sqlSessionTemplate.selectOne("user.getUserById", id);
	}
	public LoginUserVO getUser(LoginUserVO user) {
		return sqlSessionTemplate.selectOne("user.getUser", user);
	}
	
	public UserDetailVO getDetail(UserDetailVO detail) {
		return sqlSessionTemplate.selectOne("user.getDetail", detail);
	}
	public void widthdrawl(String id) {
		sqlSessionTemplate.delete("user.widthdrawlUser", id);
	}
	public void modifyUser(LoginUserVO user) {
		sqlSessionTemplate.update("user.modifyUser", user);
		sqlSessionTemplate.update("user.modifyUserDetail", user);
	}
}
