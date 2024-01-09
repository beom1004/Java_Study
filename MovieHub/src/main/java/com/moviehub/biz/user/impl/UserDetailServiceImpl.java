package com.moviehub.biz.user.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moviehub.biz.user.UserDetailVO;

@Service("detailService")
public class UserDetailServiceImpl implements UserDetailService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void detailModify(UserDetailVO detail) {
		String folder = "C:/Users/hello/git/MovieHub/MovieHub/src/main/webapp/static/images/profile/";
		MultipartFile uploadFile = detail.getFile()	;
		System.out.println("파일 있는지 확인 : "+uploadFile.getOriginalFilename());
		
		if(!uploadFile.isEmpty()) {
			String profile_img = uploadFile.getOriginalFilename();
			try {
				uploadFile.transferTo(new File(folder+profile_img));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			detail.setProfile_img(profile_img);
			userDAO.detailModify(detail);
		}else {
			userDAO.modifyProfileMsg(detail);
		}
	}

}
