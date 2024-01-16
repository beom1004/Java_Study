package com.moviehub.biz.movie.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.moviehub.biz.movie.MovieGenreVO;
import com.moviehub.biz.movie.MovieVO;


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
		
		// countries
		String countryURL = "https://api.themoviedb.org/3/configuration/countries?api_key="+API_KEY+"&language=ko-KR";
		try {
			URI uri = new URI(countryURL);
			URL url = uri.toURL();
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String result = bf.readLine();
			List<String> isoNameList = new ArrayList<String>();
			List<String> nativeNameList = new ArrayList<String>();
			
			JSONArray jsonArray = new JSONArray(result);
			for(int i=0; i<jsonArray.length(); i++) {
				JSONObject jsonObejct = jsonArray.getJSONObject(i);
				try {
					String isoItem = jsonObejct.getString("iso_3166_1");
					isoNameList.add(isoItem);
					String nativeNameItem = jsonObejct.getString("native_name");
					nativeNameList.add(nativeNameItem);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(isoNameList);
			System.out.println(nativeNameList);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
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
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		final String prefix_url = "https://image.tmdb.org/t/p/original";
		JSONObject detailObject = null;
		
		for(int j=0; j < detailLists.size(); j++) {
			try {
				MovieVO movie = new MovieVO();
				URI detailURI = new URI(detailLists.get(j));
				URL detailURL = detailURI.toURL();
				BufferedReader br = new BufferedReader(new InputStreamReader(detailURL.openStream(), "UTF-8"));
				String str = br.readLine();
				detailObject = new JSONObject(str);
				
				double num = detailObject.getDouble("vote_average") / 2;
				movie.setVote_average(Math.floor(num * 10) / 10);
				
				JSONArray countryJSON = (JSONArray) detailObject.get("production_countries");
				String country = "";

				for(int k=0; k < countryJSON.length(); k++) {
					JSONObject countryObject = (JSONObject) countryJSON.get(k);
					country += countryObject.getString("iso_3166_1");
					
					if (k < countryJSON.length() - 1) {
				        country += ", ";
				    }
				}
				movie.setProduction_countries(country.trim());
				
				JSONArray genre_list = (JSONArray) detailObject.get("genres");

				for(int k=0; k < genre_list.length(); k++) {
					MovieGenreVO detailVO = new MovieGenreVO();
					JSONObject genreObject = genre_list.getJSONObject(k);
					
					detailVO.setGenre_id(genreObject.getInt("id"));
					detailVO.setGenre_name(String.valueOf(genreObject.get("name")));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
