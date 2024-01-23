<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MovieHub 관리자 페이지</title>
    <link rel="styleSheet" href="common.css">
    <link rel="styleSheet" href="static/css/admin.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
</head>
<body>
    <div class="root">
        <div class="wrap">
            <div class="menu_wrap">
                <div class="icon">MovieHub</div>
                <div class="menu_inner">
                    <div class="admin_menu">
                    	<div class="movies" onclick="showTab('movies_tab')">
                            <i class="bi bi-film"></i>영화 목록
                        </div>
                        <div class="users" onclick="showTab('users_tab')">
                            <i class="bi bi-person-vcard"></i>유저 관리
                        </div>
                        <div class="ratings" onclick="showTab('ratings_tab')">
                            <i class="bi bi-star-half"></i>평점 관리
                        </div>
                        <div class="comments" onclick="showTab('comments_tab')">
                            <i class="bi bi-clipboard-check-fill"></i>리뷰 관리
                        </div>
                        <div class="replys" onclick="showTab('replys_tab')">
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
                        <form action="" method="get">
                            <select>
                                <option>제목</option>
                                <option>영화 코드</option>
                            </select>
                            <input type="text" class="searchForm" name="search">
                            <input type="submit" class="searchBtn" value="검색">
                        </form>
                    </div>
                    <div class="wrap_right_inner">
                        <table class="users_wrap">
                            <tr class="users_header">
                                <td class="number">#</td>
                                <td class="id">영화 코드</td>
                                <td class="nickname">제목</td>
                                <td>평균 평점</td>
                                <td>평가 수</td>
                                <td>인기도</td>
                            </tr>
                            <c:forEach var="movie" items="${movieList }" varStatus="status">
	                            <tr class="users_data">
	                                <td class="number">${status.index + 1}</td>
	                                <td class="id">${movie.movie_id }</td>
	                                <td class="nickname">${movie.title }</td>
	                                <td>${movie.vote_average }</td>
	                                <td>${movie.vote_count }</td>
	                                <td>${movie.popularity }</td>
	                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="tab_content users_tab">
                    <div class="search_wrap">
                        <form action="" method="get">
                            <select>
                                <option>아이디</option>
                                <option>닉네임</option>
                                <option>이메일</option>
                            </select>
                            <input type="text" class="searchForm" name="search">
                            <input type="submit" class="searchBtn" value="검색">
                        </form>
                    </div>
                    <div class="wrap_right_inner">
                        <table class="users_wrap">
                            <tr class="users_header">
                                <td class="number">#</td>
                                <td class="id">아이디</td>
                                <td class="nickname">닉네임</td>
                                <td>이메일</td>
                                <td>회원 권한</td>
                                <td>가입 날짜</td>
                                <td>계정 삭제</td>
                            </tr>
                            <c:forEach var="user" items="${userList }" varStatus="status">
                            	<tr class="users_data">
	                                <td class="number">${status.index + 1}</td>
	                                <td class="id">${user.id }</td>
	                                <td class="nickname">${user.nickname }</td>
	                                <td>${user.email }</td>
	                                <td>${user.auth }</td>
	                                <td>
	                                	<fmt:formatDate value="${user.reg_date }" pattern="yyyy.MM.dd. HH:mm" />
	                                </td>
	                                <td>
	                                    <button class="userDeleteBtn">삭제</button>
	                                </td>
                            	</tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="tab_content ratings_tab">
                    <div class="search_wrap">
                        <form action="" method="get">
                            <select>
                                <option>아이디</option>
                                <option>영화코드</option>
                                <option>내용</option>
                            </select>
                            <input type="text" class="searchForm" name="search">
                            <input type="submit" class="searchBtn" value="검색">
                        </form>
                    </div>
                    <div class="wrap_right_inner">
                        <table class="users_wrap">
                            <tr class="users_header">
                                <td class="number">#</td>
                                <td>영화 코드</td>
                                <td class="id">아이디</td>
                                <td>평점</td>
                                <td>평점 삭제</td>
                            </tr>
                            <c:forEach var="rating" items="${ratingList }" varStatus="status">
                            	<tr class="users_data">
	                                <td class="number">${status.index + 1}</td>
	                                <td>${rating.movie_id }</td>
	                                <td class="id">${rating.user_id }</td>
	                                <td>${rating.rating }</td>
	                                <td>
	                                    <button class="userDeleteBtn">삭제</button>
	                                </td>
	                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="tab_content comments_tab">
                    <div class="search_wrap">
                        <form action="" method="get">
                            <select>
                                <option>아이디</option>
                                <option>영화 코드</option>
                                <option>내용</option>
                            </select>
                            <input type="text" class="searchForm" name="search">
                            <input type="submit" class="searchBtn" value="검색">
                        </form>
                    </div>
                    <div class="wrap_right_inner">
                        <table class="users_wrap">
                            <tr class="users_header">
                                <td class="number">#</td>
                                <td>영화 코드</td>
                                <td class="id">아이디</td>
                                <td>코멘트 내용</td>
                                <td>작성 시간</td>
                                <td>조회수</td>
                                <td>댓글 수</td>
                                <td>코멘트 삭제</td>
                            </tr>
                            <c:forEach var="comment" items="${commentList }" varStatus="status">
                            	<tr class="users_data">
	                                <td class="number">${status.index + 1}</td>
	                                <td>${comment.movie_id }</td>
	                                <td class="id">${comment.user_id }</td>
	                                <td>${comment.comment }</td>
	                                <td>
	                                	<fmt:formatDate value="${comment.write_time }" pattern="yyyy.MM.dd. HH:mm" />
	                                </td>
	                                <td>${comment.views }</td>
	                                <td>${comment.reply_cnt }</td>
	                                <td>
	                                    <button class="userDeleteBtn">삭제</button>
	                                </td>
	                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="tab_content replys_tab">
                    <div class="search_wrap">
                        <form action="" method="get">
                            <select>
                                <option>아이디</option>
                                <option>닉네임</option>
                                <option>내용</option>
                            </select>
                            <input type="text" class="searchForm" name="search">
                            <input type="submit" class="searchBtn" value="검색">
                        </form>
                    </div>
                    <div class="wrap_right_inner">
                        <table class="users_wrap">
                            <tr class="users_header">
                                <td class="number">#</td>
                                <td>영화 코드</td>
                                <td class="id">아이디</td>
                                <td>댓글 내용</td>
                                <td>댓글 삭제</td>
                            </tr>
                            <c:forEach var="reply" items="${replyList }" varStatus="status">
                            	<tr class="users_data">
                                <td class="number">${status.index + 1}</td>
                                <td>${reply.movie_id }</td>
                                <td class="id">${reply.user_id }</td>
                                <td>${reply.content }</td>
                                <td>
                                    <button class="userDeleteBtn">삭제</button>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="static/js/admin.js"></script>
</body>
</html>