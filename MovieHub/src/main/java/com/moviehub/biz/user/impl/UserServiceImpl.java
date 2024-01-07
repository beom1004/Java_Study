package com.moviehub.biz.user.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public void detailModify(UserVO user, UserDetailVO detail) {
		String folder = "C:/Users/hello/git/MovieHub/MovieHub/src/main/webapp/static/images/profile/";
		MultipartFile uploadFile = detail.getFile()	;
		String profile_img = "";
		
		if(!uploadFile.isEmpty()) {
			profile_img = uploadFile.getOriginalFilename();
			try {
				uploadFile.transferTo(new File(folder+profile_img));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		detail.setProfile_img(profile_img);
		userDAO.detailModify(user, detail);
	}
	
}
