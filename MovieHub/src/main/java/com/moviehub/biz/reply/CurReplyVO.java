package com.moviehub.biz.reply;

import java.util.Date;

public class CurReplyVO {
	private String profile_img;
	private String nickname;
	private int reply_id;
	private String content;
	private int reply_cnt;
	private Date write_time;
	private Date modify_time;
	private int re_reply_id;
	private int comment_id;
	private String user_id;
	private int movie_id;

	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReply_cnt() {
		return reply_cnt;
	}
	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}
	public Date getWrite_time() {
		return write_time;
	}
	public void setWrite_time(Date write_time) {
		this.write_time = write_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public int getRe_reply_id() {
		return re_reply_id;
	}
	public void setRe_reply_id(int re_reply_id) {
		this.re_reply_id = re_reply_id;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	@Override
	public String toString() {
	    return "CurReplyVO{" +
	            "profile_img='" + profile_img + '\'' +
	            ", nickname='" + nickname + '\'' +
	            ", reply_id=" + reply_id +
	            ", content='" + content + '\'' +
	            ", reply_cnt=" + reply_cnt +
	            ", write_time=" + write_time +
	            ", modify_time=" + modify_time +
	            ", re_reply_id=" + re_reply_id +
	            ", comment_id=" + comment_id +
	            ", user_id='" + user_id + '\'' +
	            ", movie_id=" + movie_id +
	            '}';
	}
}
