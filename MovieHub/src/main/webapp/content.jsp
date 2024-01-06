<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Untitled(2023) - Untitled</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
	<link rel="styleSheet" href="static/css/styles/common.css">
    <link rel="styleSheet" href="static/css/header.css">
    <link rel="styleSheet" href="static/css/footer.css">
    <link rel="styleSheet" href="static/css/content.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="root">
        <div class="wrap">
            <div class="movie_info">
                <div class="backdrop_path container-fluid">
                    <div id="gradient">
                        <img src="../images/backdrop_path.jpg" alt="backdrop_path">
                    </div>
                </div>
                <div class="movie_desc">
                    <!-- TMDB API의 tag name 참고 -->
                    <div id="title">Title</div>
                    <div class="desc_detail">
                        <div id="original_title">original_title</div>
                        <div class="spans_div">
                            <!-- 동적 추가 : middle-dot은 year와 genre_ids 사이에 1개, genre 개수에 따라 genre 사이에 1개씩 -->
                            <div id="release_date">year(release_date)&nbsp;<span class="middle_dot">·</span>&nbsp;</div>
                            <div class="genres">
                                <div class="genre">genre1&nbsp;<span class="middle_slash">/</span>&nbsp;</div>
                                <div class="genre">genre2</div>
                            </div>
                            <div id="original_language">&nbsp;<span class="middle_dot">·</span>&nbsp;original_language
                            </div>
                        </div>
                        <!-- runtime 시간 환산 -->
                        <div id="runtime">runtime : 110 (hh시간 mm분)</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="section_1">
            <section>
                <div class="box">
                    <div class="box_left">
                        <div class="poster">
                            <img src="../images/poster.jpg" alt="poster">
                        </div>
                    </div>
                    <div class="box_right">
                        <div class="user_rate">
                            <div class="vote_divs">
                                <div class="rate_star_div">
                                    <div class="rate_star">
                                        <!-- rate_star : 로그인 안 하면 기록 불가능 -->
                                        <span class="starR on">⭐</span>
                                        <span class="starR">⭐</span>
                                        <span class="starR">⭐</span>
                                        <span class="starR">⭐</span>
                                        <span class="starR">⭐</span>
                                    </div>
                                    <div>평가하세요!</div>
                                </div>
                                <div class="vote_count">
                                    <div>3.9</div>
                                    <div>평균 별점(2708 ratings)</div>
                                </div>
                            </div>
                            <div class="rate_btns">
                                <!-- comment, wishlist : 로그인 안 하면 기록 불가능 -->
                                <div class="comment">comment</div>
                                <div class="wishList">wishList</div>
                            </div>
                        </div>
                        <!-- 코멘트를 등록하면 표시되는 div -->
                        <div class="comment_divs">
                            <div id="comment_title">
                                내가 남긴 코멘트
                            </div>
                            <div class="my_comment">
                                코멘트 내용
                                <div class="comment_btns">
                                    <div id="comment_remove">삭제</div>
                                    <div id="comment_modify">수정</div>
                                </div>
                            </div>
                        </div>
                        <div class="storyline">
                            <div id="tagline">
                                진짜 나를 만날 시간.
                            </div>
                            <div id="overview">
                                <!-- 마침표를 기준으로 잘라서 p태그로 묶어야 할 듯 -->
                                <p>모든 사람의 머릿속에 존재하는 감정 컨트롤 본부. 그곳에서 불철주야 열심히 일하는 기쁨, 슬픔, 버럭, 까칠, 소심 다섯 감정들. 정든 옛 동네를 떠나
                                    도시로
                                    이사하는 라일리 가족.</p>
                                <p>이사 후 새로운 환경에 적응해야
                                    하는 라일리를 위해 그 어느 때 보다 바쁘게 감정의 신호를 보내지만 우연한 실수로 기쁨과 슬픔이 본부를 이탈하게 되자 라일리의 마음 속에 큰 변화가
                                    찾아온다.
                                    라일리가 예전의 모습을 되찾기 위해서는 기쁨과 슬픔이
                                    본부로 돌아가야만 한다.</p>
                                <p>그러나 엄청난 기억들이 저장되어 있는 머릿속 세계에서 본부까지 가는 길은 험난하기만 한데...</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <div class="section_2">
            <section>
                <div class="review_div">
                    <div class="review_info">
                        <div id="review_title">
                            리뷰&nbsp;<span class="review_tot">10</span><span>+</span>
                        </div>
                        <!-- 리뷰 게시판 이동 -->
                        <div id="review_btn">
                            <button type="button">더보기</button>
                        </div>
                    </div>
                    <div class="review_list">
                        <!-- 좋아요 많이 받은 상위 리뷰 4개 (for문으로 4개 생성) -->
                        <div class="review_item">
                            <div class="review_header">
                                <div class="pic_div">
                                    <div id="user_pic">
                                        <img src="" alt="pic">
                                    </div>
                                    <div id="nickname">닉네임</div>
                                </div>
                                <div class="star_div">
                                    <div id="user_star">
                                        <span>★</span>
                                        <span>2.0</span>
                                    </div>
                                </div>
                            </div>
                            <div class="review_content">
                                <div id="movie_comment">movie comment</div>
                            </div>
                            <div class="likes">
                                <div id="like_count">
                                    <!-- 좋아요 누르면 heart-fill로 바뀜 -->
                                    <!-- <i class="bi bi-heart-fill"></i> -->
                                    <i class="bi bi-heart"></i>
                                    <span>0</span>
                                </div>
                                <div id="review_comment">
                                    <i class="bi bi-chat-fill"></i>
                                    <span>0</span>
                                </div>
                            </div>
                            <div class="like_btn">좋아요</div>
                        </div>
                        <div class="review_item">Review</div>
                        <div class="review_item">Review</div>
                        <div class="review_item">Review</div>
                    </div>
                </div>
            </section>
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
    <script src="static/js/header.js"></script>
    <script src="content.js"></script>
</body>
</html>