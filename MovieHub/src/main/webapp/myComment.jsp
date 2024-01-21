<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${user.nickname }님의 영화 코멘트</title>
	<link rel="styleSheet" href="static/css/styles/common.css">
    <link rel="styleSheet" href="static/css/header.css">
    <link rel="styleSheet" href="static/css/footer.css">
    <link rel="styleSheet" href="static/css/myComment.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="root">
        <div class="wrap">
            <div class="wrap_inner">
                <div class="wrap_header">
                    ${user.nickname }님의 코멘트
                </div>
                <div class="wrap_main">
                    <div class="main_section">
                        <div class="order_div dropdown">
                            <button class="dropdown-btn" onclick="toggleDropdown()">
                                정렬
                                <span class="material-symbols-outlined expand-icon" onclick="toggleDropdown()">
                                    expand_more
                                </span>
                            </button>
                            <div class="dropdown_content" id="myDropdown">
                                <a href="myComment.do?nickname=${user.nickname }}&sortType=write_time">
                                    <div class="sortByWriteTime">작성 순</div>
                                </a>
                                <a href="myComment.do?nickname=${user.nickname }}&sortType=ratingDesc">
                                    <div class="sortByRatingDesc">별점 높은 순</div>
                                </a>
                                <a href="myComment.do?nickname=${user.nickname }}&sortType=ratingAvg">
                                    <div class="sortByRatingAvg">댓글 순</div>
                                </a>
                            </div>
                        </div>
                        <div class="allMyCommentList">
                            <div class="myRatingMovie">
                                <div class="poster_wrap">
                                    <div class="poster">
                                        <img src="" alt="poster">
                                    </div>
                                </div>
                                <div class="comment_tap">
                                    <div class="title">미라큘러스: 레이디버그와 블랙캣, 더 무비</div>
                                    <div class="release_year">2023</div>
                                    <div class="ratingDesc">comment</div>
                                    <div class="reply">
                                    	<i class="bi bi-chat-fill"></i>&nbsp;
                                    	<div class="replyCnt">0</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
    <script src="static/js/header.js"></script>
    <script src="static/js/modal.js"></script>
    <script src="static/js/myRating.js"></script>
</body>
</html>