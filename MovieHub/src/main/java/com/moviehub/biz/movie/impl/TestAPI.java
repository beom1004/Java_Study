package com.moviehub.biz.movie.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class TestAPI {
	public static void main(String[] args) {
		final String API_KEY = "729201bdf1f62b5e99c9816a70e5d445";
		List<String> apiURL_list = new ArrayList<String>();
		List<List<Integer>> allMovieIdList = new ArrayList<List<Integer>>();
		List<Integer> movieIdLists = null;
		
		apiURL_list.add("https://api.themoviedb.org/3/movie/now_playing?api_key="
				+ API_KEY+"&language=ko-KR&page=1");

		apiURL_list.add("https://api.themoviedb.org/3/discover/movie?api_key="
				+ API_KEY+"&language=ko-KR&page=1&sort_by=popularity.desc&watch_region=KR&with_watch_providers=8");

		apiURL_list.add("https://api.themoviedb.org/3/discover/movie?api_key="
				+ API_KEY+"&language=ko-KR&page=1&sort_by=popularity.desc&watch_region=KR&with_watch_providers=97");
		
		final int URL_SIZE = apiURL_list.size();
		for(int i=0; i<URL_SIZE; i++) {
			try {
				URI uri = new URI(apiURL_list.get(i));
				URL url = uri.toURL();
				BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				String result = bf.readLine();
				movieIdLists = new ArrayList<Integer>();
				
				JSONObject jsonObject = new JSONObject(result);
	            JSONArray list = jsonObject.getJSONArray("results");
				
				for(int j=0; j < list.length(); j++) {
	                JSONObject contents = list.getJSONObject(j);
	                int movid_id = contents.getInt("id");
	                movieIdLists.add(movid_id);
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}
			allMovieIdList.add(movieIdLists);
		}
		for(int j=0; j<allMovieIdList.get(1).size(); j++) {
			System.out.println(allMovieIdList.get(1).get(j));
		}
	}
}
