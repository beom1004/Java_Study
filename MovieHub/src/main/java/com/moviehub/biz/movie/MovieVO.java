package com.moviehub.biz.movie;

public class MovieVO {
	private int movie_id;
	private String title;
	private String backdrop_path;
	private String original_title;
	private int release_year;
	private String production_countries;
	private String runtime;
	private String poster_path;
	private double vote_average;
	private int vote_count;
	private String tagline;
	private String overview;
	private double popularity;
	private int groupNum;
	private String genre_ids;
	private String searchCondition;
	private String searchKeyword;
	
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBackdrop_path() {
		return backdrop_path;
	}
	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	public String getProduction_countries() {
		return production_countries;
	}
	public void setProduction_countries(String production_countries) {
		this.production_countries = production_countries;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public double getVote_average() {
		return vote_average;
	}
	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}
	public int getVote_count() {
		return vote_count;
	}
	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	public double getPopularity() {
		return popularity;
	}
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}
	
	public int getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}
	
	public String getGenre_ids() {
		return genre_ids;
	}
	public void setGenre_ids(String genre_ids) {
		this.genre_ids = genre_ids;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	@Override
	public String toString() {
		return "MovieVO{" +
            "movie_id=" + movie_id +
            ", title='" + title + '\'' +
            ", backdrop_path='" + backdrop_path + '\'' +
            ", original_title='" + original_title + '\'' +
            ", release_year='" + release_year + '\'' +
            ", runtime=" + runtime +
            ", poster_path='" + poster_path + '\'' +
            ", vote_average=" + vote_average +
            ", vote_count=" + vote_count +
            ", tagline='" + tagline + '\'' +
            ", overview='" + overview + '\'' +
            ", popularity='" + popularity + '\''+
            '}';
	}
	
}
