<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MovieHub 관리자 페이지</title>
    <link rel="styleSheet" href="./static/css/admin.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
</head>
<body>
    <div class="root">
        <div class="wrap">
            <div class="menu_wrap">
                <div class="icon">
                	<a href="admin_main.do">MovieHub</a>
                </div>
                <div class="menu_inner">
                    <div class="admin_menu">
                    	<div class="movies" onclick="showMoviesTab()">
                            <i class="bi bi-film"></i>영화 목록
                        </div>
                        <div class="users" onclick="showUsersTab()">
                            <i class="bi bi-person-vcard"></i>유저 관리
                        </div>
                        <div class="ratings" onclick="showRatingsTab()">
                            <i class="bi bi-star-half"></i>평점 관리
                        </div>
                        <div class="comments" onclick="showCommentsTab()">
                            <i class="bi bi-clipboard-check-fill"></i>코멘트 관리
                        </div>
                        <div class="replys" onclick="showReplysTab()">
                            <i class="bi bi-wechat"></i>댓글 관리
                        </div>
                    </div>
                </div>
            </div>
            <div class="wrap_right">
                <div class="wrap_right_header">
                    <div class="welcome">
                        관리자님, 환영합니다.
                    </div>
                    <div class="admin_wrap">
                        <div class="admin_login">
                            <div class="admin_name">
                                <i class="bi bi-person-badge-fill"></i>
                                관리자 :
                            </div>
                            &nbsp;
                            <div class="admin_image">admin</div>
                        </div>
                        <div class="admin_logout">
                        	<a href="logout.do">
                        		<div class="logout">Log Out</div>
	                            <div class="logout_icon">
	                                <i class="bi bi-box-arrow-right"></i>
	                            </div>
                        	</a>
                        </div>
                    </div>
                </div>
                <div class="tab_content movies_tab">
                    <div class="search_wrap">
                        <form id="moviesForm" method="get">
                            <select class="searchCondition" name="searchCondition">
                                <option class="title">제목</option>
                                <option class="movie_id">영화코드</option>
                            </select>
                            <input type="text" class="searchKeyword" name="searchKeyword">
                            <input type="submit" class="searchBtn" value="검색">
                        </form>
                    </div>
                    <div class="wrap_right_inner">
                        <table class="users_wrap">
                            <tr class="users_header">
                                <td class="number">#</td>
                                <td class="movies_class">영화 코드</td>
                                <td class="movies_title">제목</td>
                                <td class="movies_class">평균 평점</td>
                                <td class="movies_class">평가 수</td>
                                <td class="movies_class">인기도</td>
                            </tr>
                            <c:forEach var="movie" items="${movieList }" varStatus="status">
	                            <tr class="users_data">
	                                <td class="number">${status.index + 1}</td>
	                                <td class="movies_class">${movie.movie_id }</td>
	                                <td class="movies_title">${movie.title }</td>
	                                <td class="movies_class">${movie.vote_average }</td>
	                                <td class="movies_class">${movie.vote_count }</td>
	                                <td class="movies_class">${movie.popularity }</td>
	                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="./static/js/admin.js"></script>
</body>
</html>