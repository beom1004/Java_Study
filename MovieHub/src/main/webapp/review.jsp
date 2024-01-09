<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${movie.title }(${movie.release_year })</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
	 	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
	<link rel="styleSheet" href="static/css/styles/common.css">
    <link rel="styleSheet" href="static/css/header.css">
    <link rel="styleSheet" href="static/css/footer.css">
    <link rel="styleSheet" href="static/css/review.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="root">
        <div class="wrap">
            <div class="wrap_inner">
                <aside class="left_side">
                    <div id="movieTitle"><span>|</span> 서울의 봄</div>
                    <div class="askBox">
                        <i class="bi bi-search"></i>
                        <input type="text" name="search_input" class="search_input" placeholder="검색할 내용을 입력하세요">
                        <input type="submit" class="search_botton" value="검색">
                    </div>
                    <div class="order_div">
                        <div class="orderName">
                            <div>정렬</div>
                        </div>
                        <!-- option에 name값 주고 체크된 정렬 기준으로 5개씩 페이징 -->
                        <div class="selectBox">
                            <select class="orderBy">
                                <option>좋아요 순</option>
                                <option>댓글 순</option>
                                <option>최신 순</option>
                            </select>
                        </div>
                    </div>
                </aside>
                <section>
                    <div class="review_wrapper">
                        <ul class="reviewList">
                            <li class="reviewItem">
                                <!-- a태그에 get방식으로 파라미터 전송 -> 리뷰 상세 페이지로 이동 -->
                                <a class="item" href="#">
                                    <div class="review_header">
                                        <div class="pic_div">
                                            <!-- 프로필 이미지 용량 제한 : 50MB, 500x500 -->
                                            <div id="user_pic">
                                                <img src="../images/profile.jpg" alt="pic">
                                            </div>
                                            <!-- 닉네임 누르면 해당 유저의 마이 페이지로 이동 -->
                                            <div id="nickname">이동진 평론가</div>
                                        </div>
                                        <div class="star_div">
                                            <div id="user_star">
                                                <span>★</span>
                                                <span>3.5</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="review_content">
                                        <div id="movie_comment">
                                            야만과 무능의 그 겨울밤에 대한 분노가 시종 팽팽한 긴장감 속에서 펄펄 끓는다.
                                        </div>
                                    </div>
                                    <div class="likes">
                                        <div id="likeNum">
                                            <span>좋아요</span>&nbsp;<span>929</span>
                                        </div>
                                        <!-- 누르면 replyLists 나타남 -->
                                        <div id="review_comment">
                                            <span>댓글</span>&nbsp; <span>24</span>
                                        </div>
                                    </div>
                                    <div class="block">
                                        <div class="like_btn"><i class="bi bi-hand-thumbs-up"></i>&nbsp;좋아요</div>
                                        <div class="comment_btn"><i class="bi bi-chat"></i>&nbsp;댓글</div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                        <ul class="replyLists hide">
                            <li class="replyList">
                                <!-- 누르면 해당 유저 프로필로 이동 -->
                                <div class="user_nickname">nickname</div>
                                <div class="reply_content">
                                    야만과 무능의 분노...정말 인상적이네요
                                </div>
                                <div class="reply_likes">
                                    <div>
                                        <div class="reply_like">좋아요</div>
                                    </div>
                                    <div class="reply_thumb">
                                        <i class="bi bi-hand-thumbs-up">&nbsp;</i>
                                        <div class="like">6</div>
                                    </div>
                                </div>
                                <div>
                                    <div class="write_time">yyyy년mm월dd일</div>
                                    <!-- 클릭 시 답글 취소로 변경 -->
                                    <div class="re_reply">답글 달기</div>
                                </div>
                                <div class="re_reply_container">
                                    <div class="re_reply_block">
                                        <!-- 답글 내용 -->
                                        <input type="text" placeholder="${nickname} (으)로 답글 달기">
                                        <input type="submit" value="게시">
                                    </div>
                                    <!-- 최신순 정렬 -->
                                    <div class="re_reply_section">
                                        <!-- 누르면 해당 유저 프로필로 이동 -->
                                        <div class="user_nickname">reply_nickname</div>
                                        <div class="re_reply_content">
                                            <div>공감합니다.</div>
                                            <div class="write_time">yyyy년mm월dd일</div>
                                        </div>
                                    </div>
                                    <div class="re_reply_section">
                                        <!-- 누르면 해당 유저 프로필로 이동 -->
                                        <div class="user_nickname">reply_nickname</div>
                                        <div class="re_reply_content">
                                            <div>공감합니다.</div>
                                            <div class="write_time">yyyy년mm월dd일</div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </section>
            </div>
        </div>
        <div class="replyModal black-bg close noShow">
            <div class="white-bg">
                <div class="modal_top">
                    <div>댓글</div>
                    <div class="close">X</div>
                </div>
                <textarea placeholder="생각을 자유롭게 표현해주세요."></textarea>
                <div class="modal_bottom">
                    <div>
                        <span class="charCount">0</span><span>/</span><span>10000</span>
                    </div>
                    <input type="submit" class="btn btn-primary" value="저장">
                </div>
            </div>
        </div>
        <!-- 페이징 -->
    </div>
	<jsp:include page="footer.jsp"/>
    <script src="static/js/header.js"></script>
    <script src="static/js/modal.js"></script>
    <script src="static/js/jQuery.js"></script>
    <script src="static/js/content.js"></script>
</body>
</html>