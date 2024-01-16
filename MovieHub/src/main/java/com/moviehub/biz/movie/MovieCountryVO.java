package com.moviehub.biz.movie;

public class MovieCountryVO {
	private int countryNum;
	private String iso_3166_1;
	private String native_name;
	
	public int getCountryNum() {
		return countryNum;
	}
	public void setCountryNum(int countryNum) {
		this.countryNum = countryNum;
	}
	public String getIso_3166_1() {
		return iso_3166_1;
	}
	public void setIso_3166_1(String iso_3166_1) {
		this.iso_3166_1 = iso_3166_1;
	}
	public String getNative_name() {
		return native_name;
	}
	public void setNative_name(String native_name) {
		this.native_name = native_name;
	}
}
