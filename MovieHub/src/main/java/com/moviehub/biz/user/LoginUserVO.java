package com.moviehub.biz.user;

import org.springframework.web.multipart.MultipartFile;

public class LoginUserVO {
	private String id;
	private String nickname;
	private String password;
	private String email;
	private String profile_img;
	private String profile_msg;
	private MultipartFile file;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public String getProfile_msg() {
		return profile_msg;
	}
	public void setProfile_msg(String profile_msg) {
		this.profile_msg = profile_msg;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
