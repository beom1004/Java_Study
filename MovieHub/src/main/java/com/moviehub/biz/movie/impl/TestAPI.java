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
		String genreURL = "https://api.themoviedb.org/3/genre/movie/list?api_key="+API_KEY+"&language=ko-KR";
		List<String> genreNameList = new ArrayList<String>();
		
		try {
			URI uri = new URI(genreURL);
			URL url = uri.toURL();
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String result = bf.readLine();
			
			JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("genres");
            
			for(int i=0; i<jsonArray.length(); i++) {
				JSONObject jsonObejct = jsonArray.getJSONObject(i);
				try {
					String genreNameItem = String.valueOf(jsonObejct.getInt("id"));
					genreNameList.add(genreNameItem);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(genreNameList);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
