<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${movie.title }(${movie.release_year })</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <link rel="styleSheet" href="static/css/styles/common.css">
    <link rel="styleSheet" href="static/css/header.css">
    <link rel="styleSheet" href="static/css/footer.css">
    <link rel="styleSheet" href="static/css/comments.css">
</head>

<body>
    <jsp:include page="header.jsp" />
    <div class="root">
        <div class="wrap">
            <div class="wrap_inner">
                <aside class="left_side">
                    <div class="askBox">
                        <i class="bi bi-search"></i>
                        <input type="text" name="search_input" class="search_input" placeholder="제목, 닉네임, 내용으로 검색하세요">
                        <input type="submit" class="search_button" value="검색">
                    </div>
                </aside>
                <section>
                    <div class="order_div dropdown">
                        <button class="dropdown-btn" onclick="toggleDropdown()">
                            정렬
                            <span class="material-symbols-outlined expand-icon" onclick="toggleDropdown()">
                                expand_more
                            </span>
                        </button>
                        <div class="dropdown_content" id="myDropdown">
                            <a href="comments.do?movie_id=${movie.movie_id }&sortType=reply_cnt">
                                <div class="sortByCommentCnt">댓글 순</div>
                            </a>
                            <a href="comments.do?movie_id=${movie.movie_id }&sortType=views">
                                <div class="sortByCommentViews">조회 순</div>
                            </a>
                            <a href="comments.do?movie_id=${movie.movie_id }&sortType=write_time">
                                <div class="sortByCommentWriteTime">최신 순</div>
                            </a>
                        </div>
                    </div>
                    <div class="review_wrapper">
                        <ul class="reviewList">
                            <c:forEach var="commentList" items="${commentLists }">
                                <li class="reviewItem">
                                    <div class="item">
                                        <div class="review_header">
                                            <div class="pic_div">
                                                <div id="user_pic">
                                                    <img src="static/images/profile/${commentList.profile_img }"
                                                        alt="pic">
                                                </div>
                                                <div id="nickname">${commentList.nickname }</div>
                                            </div>
                                            <div class="star_div">
                                                <div id="user_star">
                                                    <span>★</span>
                                                    <span>${commentList.rating }</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="review_content">
                                            <div id="movie_comment">
                                                ${commentList.comment }
                                            </div>
                                        </div>
                                        <div class="likes">
                                            <div id="review_comment">
                                                <span>댓글</span>&nbsp; <span>${commentList.reply_cnt }</span>
                                            </div>
                                        </div>
                                        <ul class="replyLists hide">
	                                     <c:set var="replyListVar" value="${replyList_${comment.comment_id}}" />
	                                     <c:forEach var="reply" items="${replyListVar}">
	                                    	<c:if test="${reply.comment_id eq commentList.comment_id}">
		                                        <li class="replyList">
		                                            <div class="replyList_wrap">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		                                                <div class="img_wrap">
		                                                    <div class="profile_img">
		                                                        <img src="static/images/profile/${reply.profile_img }"
		                                                            alt="pic">
		                                                    </div>
		                                                </div>
		                                                <div class="reply_wrap_right">
		                                                    <div class="user_nickname">${reply.nickname }</div>
		                                                    <div class="my_reply_content">
		                                                        ${reply.content }
		                                                    </div>
		                                                    <div class="reply_writeTime">
		                                                        <div id="viewReply" class="viewReply">
		                                                            답글 보기
		                                                        </div>
		                                                        <div>
		                                                            <fmt:formatDate value="${reply.write_time}"
		                                                                pattern="yyyy년 MM월 dd일 hh시 mm분" />
		                                                        </div>
		                                                    </div>
		                                                </div>
		                                            </div>
		                                            <div class="re_reply_container re_reply_hide">
		                                                <div class="re_reply_block">
		                                                    <c:if test="${user == null }">
		                                                        <form>
		                                                            <input type="text" name="content"
		                                                                placeholder="${reply.nickname }(으)로 답글 달기">
		                                                            <input type="submit" name="reReplySave"
		                                                                onclick="return loginRequire()" value="게시">
		                                                        </form>
		                                                    </c:if>
		                                                    <c:if test="${user != null }">
		                                                        <form action="reReplyInsert.do" method="get">
		                                                            <input type="text" name="content"
		                                                                placeholder="${reply.nickname }(으)로 답글 달기">
		                                                            <input type="submit" name="reReplySave" value="게시">
		                                                            <input type="hidden" name="reply_id"
		                                                                value="${reply.reply_id }">
		                                                            <input type="hidden" name="comment_id"
		                                                                value="${curComment.comment_id }">
		                                                            <input type="hidden" name="movie_id"
		                                                                value="${movie.movie_id }">
		                                                        </form>
		                                                    </c:if>
		                                                </div>
		                                                <c:set var="reReplyMapVar" value="${reReplyMap_${comment.comment_id}}" />
		                                                <c:forEach var="reReply" items="${reReplyMap_${comment.comment_id}[reply.reply_id]}">
		                                                    <div class="re_reply_section">
		                                                        <div class="profile_img">
		                                                            <img src="static/images/profile/${reReply.profile_img}"
		                                                                alt="pic">
		                                                        </div>
		                                                        <div>
		                                                            <div class="user_nickname">${reReply.nickname}</div>
		                                                            <div class="re_reply_content">
		                                                                <div>${reReply.content}</div>
		                                                                <div class="write_time">
		                                                                    <fmt:formatDate value="${reReply.write_time}"
		                                                                        pattern="yyyy년 MM월 dd일 hh시 mm분" />
		                                                                </div>
		                                                            </div>
		                                                            <div id="reReplyRemove">삭제하기</div>
		                                                        </div>
		                                                    </div>
		                                                </c:forEach>
		                                            </div>
		                                        </li>
		                                    </c:if>
	                                    </c:forEach>
	                                	</ul>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </section>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach var="page" begin="1" end="${commentCnt }">
                        <li class="page-item"><a class="page-link" href="#">${page }</a></li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <jsp:include page="footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="static/js/header.js"></script>
    <script src="static/js/modal.js"></script>
    <script src="static/js/header_jQuery.js"></script>
    <script src="static/js/comments.js"></script>
</body>

</html>