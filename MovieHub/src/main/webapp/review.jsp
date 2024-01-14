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
                                <option>조회수 순</option>
                                <option>댓글 순</option>
                                <option>최신 순</option>
                            </select>
                        </div>
                    </div>
                </aside>
                <section>
                    <div class="review_wrapper">
                        <ul class="reviewList">
                        	<c:forEach var="commentList" items="${commentLists }">
	                            <li class="reviewItem">
	                                <div class="item">
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
    </div>
	<jsp:include page="footer.jsp"/>
    <script src="static/js/header.js"></script>
    <script src="static/js/modal.js"></script>
    <script src="static/js/jQuery.js"></script>
    <script src="static/js/content.js"></script>
</body>
</html>