package com.moviehub.biz.comment;

import java.util.Date;

public class CommentVO {
	private int comment_id;
	private String comment;
	private Date write_time;
	private Date modify_time;
	private int views;
	private int like_cnt;
	private int comment_cnt;
	private String user_id;
	private int movie_id;
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	public int getComment_cnt() {
		return comment_cnt;
	}
	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
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
}
