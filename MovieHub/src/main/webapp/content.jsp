<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${movie.title }(${movie.release_year })</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
	<link rel="styleSheet" href="static/css/styles/common.css">
    <link rel="styleSheet" href="static/css/header.css">
    <link rel="styleSheet" href="static/css/footer.css">
    <link rel="styleSheet" href="static/css/content.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="commentModal comment_black-bg comment_hide">
        <div class="comment_white-bg">
            <div>
                <div>${movie.title }</div>
                <div id="comment_close">X</div>
            </div>
            <div>
                <form action="commentInsert.do" method="post">
                	<input type="hidden" name="id" value="${user.id }">
                	<input type="hidden" name="movie_id" value="${movie.movie_id }">
                    <textarea name="comment" placeholder="이 작품에 대한 리뷰를 남겨주세요."></textarea>
                    <div>
                        <div class="textCnt">
                            <span>0</span>/10000
                        </div>
                        <input type="submit" class="btn" class="commentSave" value="저장">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="commentModifyModal commentModify_black-bg commentModify_hide">
        <div class="commentModify_white-bg">
            <div>
                <div>${movie.title }</div>
                <div id="commentModify_close">X</div>
            </div>
            <div>
                <form action="commentModify.do" method="post">
                	<input type="hidden" name="id" value="${user.id }">
                	<input type="hidden" name="movie_id" value="${movie.movie_id }">
                    <textarea name="comment" >${comment.comment }</textarea>
                    <div>
                        <div class="textCnt">
                            <span>0</span>/10000
                        </div>
                        <input type="submit" class="btn" class="commentSave" value="수정">
                    </div>
                </form>
            </div>
        </div>
    </div>
	<div class="root">
        <div class="wrap">
            <div class="movie_info">
                <div class="backdrop_path">
                    <div id="gradient">
                        <img src="${movie.backdrop_path }" alt="backdrop_path">
                    </div>
                </div>
                <div class="movie_desc">
                    <div id="title">${movie.title }</div>
                    <div class="desc_detail">
                        <div id="original_title">${movie.original_title }</div>
                        <div class="spans_div">
                            <div id="release_date">${movie.release_year }&nbsp;<span class="middle_dot">·</span>&nbsp;</div>
                            <div class="genres">
                                <div class="genre">genre1&nbsp;<span class="middle_slash">/</span>&nbsp;</div>
                                <div class="genre">genre2</div>
                            </div>
                            <div id="original_language">&nbsp;<span class="middle_dot">·</span>&nbsp;${original_language }
                            </div>
                        </div>
                        <div id="runtime">${movie.runtime }</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="section_1">
            <section>
                <div class="box">
                    <div class="box_left">
                        <div class="poster">
                            <img src="${movie.poster_path }" alt="poster">
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
                                    <div>${movie.vote_average }</div>
                                    <div>평균 별점(${movie.vote_count} ratings)</div>
                                </div>
                            </div>
                            <div class="rate_btns">
                                <c:if test="${user != null }">
                                	<c:if test="${comment == null and empty comment.comment}">
		                                <button class="comment" onclick="commentFunc()">comment</button>
		                                <div class="wishList">wishList</div>
	                                </c:if>
	                                <c:if test="${comment != null and not empty comment.comment}">
           								 <button class="comment" onclick="commentModify()">comment</button>
           								 <div class="wishList">wishList</div>
        							</c:if>
                                </c:if>
                                <c:if test="${user == null }">
	                                <button class="comment" onclick="loginRequire()">comment</button>
	                                <div class="wishList" onclick="loginRequire()">wishList</div>
	                            </c:if>
                            </div>
                        </div>
                        <c:if test="${comment != null }">
	                        <div class="comment_divs">
	                            <div id="comment_title">
	                                내가 남긴 코멘트
	                            </div>
	                            <div class="my_comment">
	                                ${comment.comment }
	                                <div class="comment_btns">
	                                    <div id="comment_remove" onclick="commentDelete()">삭제</div>
	                                    <div id="comment_modify" onclick="commentModify()">수정</div>
	                                </div>
	                            </div>
	                        </div>
                        </c:if>
                        <c:if test="${comment == null }">
                        	<div class="comment_divs">
                        		<div class="my_comment">${comment_null }</div>
                        	</div>
                        </c:if>
                        <div class="storyline">
                            <div id="tagline">
                                ${movie.tagline }
                            </div>
                            <div id="overview">
                                <!-- 마침표를 기준으로 잘라서 p태그로 묶어야 할 듯 -->
                                ${movie.overview }
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
                            코멘트&nbsp;<span class="review_tot">${commentCnt }</span><span>+</span>
                        </div>
                        <div id="review_btn">
                            <a href="review.do?movie_id=${movie.movie_id }">더보기</a>
                        </div>
                    </div>
                    <div class="review_list">
                    	<c:if test="${commentCnt == 0 }">
                    		아직 등록된 코멘트가 없습니다.
                    	</c:if>
                    	<c:if test="${commentCnt != 0 }">
	                        <c:forEach var="commentList" items="${commentLists }">
		                        <div class="review_item">
		                            <div class="review_header">
		                                <div class="pic_div">
		                                    <div id="user_pic">
		                                        <img src="static/images/profile/${commentList.profile_img }" alt="pic">
		                                    </div>
		                                    <div id="nickname">${commentList.nickname }</div>
		                                </div>
		                                <div class="star_div">
		                                    <div id="user_star">
		                                        <span>★</span>
		                                        <span>2.0</span>
		                                    </div>
		                                </div>
		                            </div>
		                            <div class="review_content">
		                                <div id="movie_comment"><a href="movieComment.do?movie_id=${movie.movie_id }">${commentList.comment }</a></div>
		                            </div>
		                            <div class="likes">
		                                <div id="like_count">
		                                    <!-- 좋아요 누르면 heart-fill로 바뀜 -->
		                                    <!-- <i class="bi bi-heart-fill"></i> -->
		                                    <i class="bi bi-heart"></i>
		                                    <span>${commentList.like_cnt }</span>
		                                </div>
		                                <div id="review_comment">
		                                    <i class="bi bi-chat-fill"></i>
		                                    <span>${commentList.comment_cnt }</span>
		                                </div>
		                            </div>
		                            <div class="like_btn">좋아요</div>
		                        </div>
	                        </c:forEach>
	                    </c:if>
                    </div>
                </div>
            </section>
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
    <script src="static/js/header.js"></script>
    <script src="static/js/modal.js"></script>
    <script src="static/js/jQuery.js"></script>
    <script src="static/js/content.js"></script>
</body>
</html>