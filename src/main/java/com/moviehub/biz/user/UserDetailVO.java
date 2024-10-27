package com.moviehub.biz.user;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class UserDetailVO {
	private String profile_id;
	private String user_id;
	private String profile_img;
	private String profile_msg;
	private Date reg_date;
	private MultipartFile file;
	
	public String getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getProfile_msg() {
		return profile_msg;
	}
	public void setProfile_msg(String profile_msg) {
		this.profile_msg = profile_msg;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}
