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
		List<Integer> movieIdLists = null;
		
		apiURL_list.add("https://api.themoviedb.org/3/movie/now_playing?api_key="
				+ API_KEY+"&language=ko-KR&page=1");

		apiURL_list.add("https://api.themoviedb.org/3/discover/movie?api_key="
				+ API_KEY+"&language=ko-KR&page=1&sort_by=popularity.desc&watch_region=KR&with_watch_providers=8");

		apiURL_list.add("https://api.themoviedb.org/3/discover/movie?api_key="
				+ API_KEY+"&language=ko-KR&page=1&sort_by=popularity.desc&watch_region=KR&with_watch_providers=97");
		
		List<String> detailLists = new ArrayList<String>();
		final int URL_SIZE = apiURL_list.size();
		List<String> rs = new ArrayList<String>();
		
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
	                detailLists.add("https://api.themoviedb.org/3/movie/"+movieIdLists.get(j)+
	                		"?api_key="+API_KEY+"&language=ko-KR");
	                String genreId = "";
	                JSONArray genreIdList = (JSONArray) contents.get("genre_ids");
	                for(int k=0; k<genreIdList.length(); k++) {
	                	genreId += genreIdList.get(k);
	                	
	                	if(k < genreIdList.length() - 1) {
	                		genreId += ", ";
	                	}
	                }
	                rs.add(genreId);
	                System.out.println(genreIdList);
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
