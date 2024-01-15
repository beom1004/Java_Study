package com.moviehub.biz.user.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moviehub.biz.user.LoginUserVO;
import com.moviehub.biz.user.UserCommentVO;
import com.moviehub.biz.user.UserDetailVO;
import com.moviehub.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<UserCommentVO> getUserCommentList(UserCommentVO userComment) {
		return userDAO.getUserCommentList(userComment);
	}

	@Override
	public LoginUserVO getUserData(LoginUserVO user) {
		return userDAO.getUserData(user);
	}
	
	@Override
	public Double getAvgRating(LoginUserVO user) {
		List<String> list = userDAO.getAvgRating(user);
		System.out.println(list); // [3.0]이 ... 반환되네?
		Double db = 0.0;
		for(int i=0; i<list.size(); i++) {
			Double temp = Double.parseDouble(list.get(i));
			db += temp;
		}
		// 별점을 전부 더한 db를 총 rating 개수로 나누고 소수점 첫째 자리까지만
		db = Math.floor(db * 10) / (10 * list.size());
		return db;
	}

	@Override
	public void modifyUser(LoginUserVO user, LoginUserVO loginUser) {
		String folder = "C:/Users/hello/git/MovieHub/MovieHub/src/main/webapp/static/images/profile/";
		MultipartFile uploadFile = user.getFile();
		
		// 업로드한 파일이 있으면
		if(!uploadFile.isEmpty()) {
			String profile_img = uploadFile.getOriginalFilename();
			try {
				uploadFile.transferTo(new File(folder+profile_img));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			user.setProfile_img(profile_img);
		// 업로드한 파일이 없으면 로그인 한 사람의 profile_img를 세팅
		}else {
			user.setProfile_img(loginUser.getProfile_img());
		}
		userDAO.modifyUser(user);
	}
	@Override
	public void registerUser(UserVO user, UserDetailVO detail) {
		userDAO.registerUser(user, detail);
	}

	@Override
	public String emailCheck(String email) {
		return userDAO.emailCheck(email);
	}

	@Override
	public LoginUserVO getUser(LoginUserVO user) {
		return userDAO.getUser(user);
	}

	@Override
	public UserDetailVO getDetail(UserDetailVO detail) {
		return userDAO.getDetail(detail);
	}

	@Override
	public void widthdrawlUser(String id) {
		userDAO.widthdrawl(id);
	}
	
}
