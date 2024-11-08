package movie.hub.movie.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import movie.hub.movie.mapper.MovieDAO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.hub.movie.entity.MovieVO;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDAO movieDAO;
	
	@Override
	public List<MovieVO> getAllMovieList(MovieVO movie) {
		return movieDAO.getAllMovieList(movie);
	}

	@Override
	public MovieVO getMovie(MovieVO movie) {
		return movieDAO.getMovie(movie);
	}
	
	@Override
	public List<MovieVO> getSearchMovieTitle(String searchKeyword) {
		return movieDAO.getSearchMovieTitle(searchKeyword);
	}
	@Override
	public void saveMovie() {
		final String API_KEY = "729201bdf1f62b5e99c9816a70e5d445";
		List<String> apiURL_list = new ArrayList<>();
	    List<Integer> movieIdLists = new ArrayList<>();
	    List<String> detailLists = new ArrayList<>();
		
		apiURL_list.add("https://api.themoviedb.org/3/movie/now_playing?api_key="
				+ API_KEY+"&language=ko-KR&page=1");

		apiURL_list.add("https://api.themoviedb.org/3/discover/movie?api_key="
				+ API_KEY+"&language=ko-KR&page=1&sort_by=popularity.desc&watch_region=KR&with_watch_providers=8");

		apiURL_list.add("https://api.themoviedb.org/3/discover/movie?api_key="
				+ API_KEY+"&language=ko-KR&page=1&sort_by=popularity.desc&watch_region=KR&with_watch_providers=97");
		
		StringBuilder detailStringBuilder = new StringBuilder();
		
		for(String apiURL : apiURL_list) {
			try {
				URI uri = new URI(apiURL);
				URL url = uri.toURL();
				BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				String result = bf.readLine();
				movieIdLists.clear();
				
				JSONObject jsonObject = new JSONObject(result);
	            JSONArray list = jsonObject.getJSONArray("results");
				
				for(int j=0; j < list.length(); j++) {
	                JSONObject contents = list.getJSONObject(j);
	                int movie_id = contents.getInt("id");
	                movieIdLists.add(movie_id);
	                detailStringBuilder.append("https://api.themoviedb.org/3/movie/").append(movieIdLists.get(j))
	                		.append("?api_key=").append(API_KEY).append("&language=ko-KR").append("\n");
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		detailLists.addAll(Arrays.asList(detailStringBuilder.toString().split("\n")));
		getDetailMovie(detailLists);
		
	}
	public void getDetailMovie(List<String> detailLists) {
		final String API_KEY = "729201bdf1f62b5e99c9816a70e5d445";
		final String prefix_url = "https://image.tmdb.org/t/p/original";
		JSONObject detailObject = null;
		
		for(String detailURLString : detailLists) {
			try {
				MovieVO movie = new MovieVO();
				URI detailURI = new URI(detailURLString);
				URL detailURL = detailURI.toURL();
				BufferedReader br = new BufferedReader(new InputStreamReader(detailURL.openStream(), "UTF-8"));
				String rs = br.readLine();
				
				detailObject = new JSONObject(rs);
				movie.setMovie_id(detailObject.getInt("id"));
				movie.setTitle(detailObject.getString("title"));
				movie.setBackdrop_path(prefix_url+detailObject.getString("backdrop_path"));
				movie.setOriginal_title(detailObject.getString("original_title"));
				movie.setRelease_year(Integer.parseInt(detailObject.getString("release_date").substring(0, 4)));
				movie.setPoster_path(prefix_url+detailObject.getString("poster_path"));
				movie.setVote_count(detailObject.getInt("vote_count"));
				movie.setTagline(detailObject.getString("tagline"));
				movie.setOverview(detailObject.getString("overview"));
				movie.setPopularity(detailObject.getDouble("popularity"));
				movie.setGroupNum((detailLists.indexOf(detailURLString) / 20) + 1);
				
				int runtime = detailObject.getInt("runtime");
				int runtime_hour = runtime / 60;
				int runtime_minute = runtime % 60;
				
				if(runtime_hour == 0) {
					movie.setRuntime(runtime+"분");
				}else {
					movie.setRuntime(runtime_hour+"시간 "+runtime_minute+"분");
				}

				double num = detailObject.getDouble("vote_average") / 2;
				movie.setVote_average(Math.floor(num * 10) / 10);
				
				// 나라
				JSONArray country_list = (JSONArray) detailObject.get("production_countries");
				String iso_3166_1 = "";
				for(int i=0; i<country_list.length(); i++) {
					JSONObject countryObject = country_list.getJSONObject(i);
					iso_3166_1 += countryObject.get("iso_3166_1");
					if(i < country_list.length() - 1) {
						iso_3166_1 += " · ";
                	}
 				}
				List<String> isoList = getIsoList(API_KEY);
				List<String> nativeNameList = getNativeNameList(API_KEY);
				for(int i=0; i<isoList.size(); i++) {
					if(iso_3166_1.contains(isoList.get(i))) {
						iso_3166_1 = iso_3166_1.replace(isoList.get(i), nativeNameList.get(i));
					}
				}
				movie.setProduction_countries(iso_3166_1);
				
				// 장르
				JSONArray genre_list = (JSONArray) detailObject.get("genres");
				String genre = "";
				for(int i=0; i<genre_list.length(); i++) {
					JSONObject genreObject = genre_list.getJSONObject(i);
					genre += genreObject.getString("name");
					if(i < genre_list.length() - 1) {
						genre += " · ";
                	}
 				}
				movie.setGenre_ids(genre);
				// movieVO 삽입
				movieDAO.insertMovie(movie);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public List<MovieVO> getMovieList(String type){
		final String API_KEY = "729201bdf1f62b5e99c9816a70e5d445";
		List<String> apiURLList = new ArrayList<>();
		List<List<Integer>> allMovieIdList = new ArrayList<>();
		List<Integer> movieIdLists = null;
		
		StringBuilder boxOfficeURL = new StringBuilder("https://api.themoviedb.org/3/movie/now_playing?api_key="
	            + API_KEY + "&language=ko-KR&page=1");
	    StringBuilder netflixURL = new StringBuilder("https://api.themoviedb.org/3/discover/movie?api_key="
	            + API_KEY + "&language=ko-KR&page=1&sort_by=popularity.desc&watch_region=KR&with_watch_providers=8");
	    StringBuilder watchaURL = new StringBuilder("https://api.themoviedb.org/3/discover/movie?api_key="
	            + API_KEY + "&language=ko-KR&page=1&sort_by=popularity.desc&watch_region=KR&with_watch_providers=97");
		
	    apiURLList.add(boxOfficeURL.toString());
	    apiURLList.add(netflixURL.toString());
	    apiURLList.add(watchaURL.toString());
	    
		for(String apiURL : apiURLList) {
			try {
				URI uri = new URI(apiURL);
				URL url = uri.toURL();
				BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				String result = bf.readLine();
				movieIdLists = new ArrayList<>();
				
				JSONObject jsonObject = new JSONObject(result);
	            JSONArray list = jsonObject.getJSONArray("results");
				
				for(int j=0; j < list.length(); j++) {
	                JSONObject contents = list.getJSONObject(j);
	                int movid_id = contents.getInt("id");
	                movieIdLists.add(movid_id);
	            }
				allMovieIdList.add(movieIdLists);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		List<MovieVO> returnList = new ArrayList<>();
		if(type.equals("boxoffice")) {
			returnList = getBoxOffice(movieDAO.getMovieList(), allMovieIdList);
		}else if(type.equals("netflix")) {
			returnList = getNetflix(movieDAO.getMovieList(), allMovieIdList);
		}else if(type.equals("watcha")) {
			returnList = getWatcha(movieDAO.getMovieList(), allMovieIdList);
		}
		return returnList;
	}
	public List<MovieVO> getNetflix(List<MovieVO> movieList, List<List<Integer>> allMovieIdList){
		List<MovieVO> netflixList = new ArrayList<MovieVO>();
		
		for(MovieVO movie : movieList) {
			for(int j=0; j<allMovieIdList.get(1).size(); j++) {
				if(movie.getMovie_id() == allMovieIdList.get(1).get(j)) {
					netflixList.add(movie);
				}
			}
		}
		return netflixList;
	}
	public List<MovieVO> getWatcha(List<MovieVO> movieList, List<List<Integer>> allMovieIdList){
		List<MovieVO> watchaList = new ArrayList<MovieVO>();
		
		for(MovieVO movie : movieList) {
			for(int j=0; j<allMovieIdList.get(2).size(); j++) {
				if(movie.getMovie_id() == allMovieIdList.get(2).get(j)) {
					watchaList.add(movie);
				}
			}
		}
		return watchaList;
	}
	public List<MovieVO> getBoxOffice(List<MovieVO> movieList, List<List<Integer>> allMovieIdList){
		List<MovieVO> boxofficeList = new ArrayList<MovieVO>();
		
		for(MovieVO movie : movieList) {
			for(int j=0; j<allMovieIdList.get(0).size(); j++) {
				if(movie.getMovie_id() == allMovieIdList.get(0).get(j)) {
					boxofficeList.add(movie);
				}
			}
		}
		return boxofficeList;
	}
	public static List<String> getIsoList(String API_KEY){
		String countryURL = "https://api.themoviedb.org/3/configuration/countries?api_key="+API_KEY+"&language=ko-KR";
		List<String> isoList = new ArrayList<String>();
		
		try {
			URI uri = new URI(countryURL);
			URL url = uri.toURL();
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String result = bf.readLine();
            JSONArray jsonArray = new JSONArray(result);
            
			for(int i=0; i<jsonArray.length(); i++) {
				JSONObject jsonObejct = jsonArray.getJSONObject(i);
				try {
					String iso_3166_1 = jsonObejct.getString("iso_3166_1");
					isoList.add(iso_3166_1);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return isoList;
	}
	
	public static List<String> getNativeNameList(String API_KEY){
		String countryURL = "https://api.themoviedb.org/3/configuration/countries?api_key="+API_KEY+"&language=ko-KR";
		List<String> nativeNameList = new ArrayList<String>();
		
		try {
			URI uri = new URI(countryURL);
			URL url = uri.toURL();
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String result = bf.readLine();
            JSONArray jsonArray = new JSONArray(result);
            
			for(int i=0; i<jsonArray.length(); i++) {
				JSONObject jsonObejct = jsonArray.getJSONObject(i);
				try {
					String native_name = jsonObejct.getString("native_name");
					nativeNameList.add(native_name);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return nativeNameList;
	}

}
