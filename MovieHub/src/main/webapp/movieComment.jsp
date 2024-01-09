<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${curComment.nickname }님이 ${movie.title }(${movie.release_year })에 남긴 코멘트</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
	        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="styleSheet" href="static/css/styles/common.css">
    <link rel="styleSheet" href="static/css/header.css">
    <link rel="styleSheet" href="static/css/footer.css">
    <link rel="styleSheet" href="static/css/movieComment.css">
</head>
<body>
	<jsp:include page="header.jsp" />
    <div class="root">
        <div class="wrap">
            <div class="review_wrapper">
                <ul class="reviewList">
                    <li class="reviewItem">
                        <div class="item">
                            <div class="review_header">
                                <div class="pic_div">
                                    <div id="user_pic">
                                        <img src="static/images/profile/${commentList.profile_img }" alt="pic">
                                    </div>
                                    <div id="nickname">${curComment.nickname }</div>
                                    <div class="star_div">
                                        <div id="user_star">
                                            <span>★</span>
                                            <span>3.5</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="poster_path">
                                    <img src="${movie.poster_path }" alt="poster">
                                </div>
                            </div>
                            <div class="review_content">
                                <div id="movie_comment">
                                    ${commentList.comment }
                                </div>
                            </div>
                            <div class="likes">
                                <div id="likeNum">
                                    <span>좋아요</span>&nbsp;<span>${curComment.like_cnt }</span>
                                </div>
                                <!-- 누르면 replyLists 나타남 -->
                                <div id="review_comment">
                                    <span>댓글</span>&nbsp; <span>${curComment.comment_cnt }</span>
                                </div>
                            </div>
                            <div class="block">
                                <div class="like_btn"><i class="bi bi-hand-thumbs-up"></i>&nbsp;좋아요</div>
                                <div class="comment_btn"><i class="bi bi-chat"></i>&nbsp;댓글</div>
                            </div>
                        </div>
                    </li>
                </ul>
                <ul class="replyLists hide">
                    <li class="replyList">
                        <div class="reply_wrap">
                            <div class="img_wrap">
                                <div class="profile_img">
                                    <img src="" alt="pic">
                                </div>
                            </div>
                            <div class="reply_wrap_right">
                                <div class="user_nickname">nickname</div>
                                <div class="reply_content">
                                    야만과 무능의 분노...정말 인상적이네요
                                </div>
                                <div class="reply_likes">
                                    <div class="reply_thumb">
                                        <i class="bi bi-hand-thumbs-up">&nbsp;</i>
                                        <div class="like">6</div>
                                    </div>
                                </div>
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
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
    <script src="static/js/header.js"></script>
    <script src="static/js/modal.js"></script>
    <script src="static/js/jQuery.js"></script>
</body>
</html>