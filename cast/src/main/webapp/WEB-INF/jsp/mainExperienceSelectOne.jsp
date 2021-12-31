<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Cast Shop - About Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/resources/assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/assets/img/favicon.ico">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/templatemo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/custom.css">

    <!-- 레이아웃 렌더링한 후 폰트 스타일 로드 -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/fontawesome.min.css">
</head>

<body>
    <!-- 최상단 네비게이션 -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
        <div class="container text-light">
            <div class="w-100 d-flex justify-content-between">
                <div>
                    <i class="fa fa-envelope mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">info@company.com</a>
                    <i class="fa fa-phone mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                </div>
                <div>
                    <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i class="fab fa-linkedin fa-sm fa-fw"></i></a>
                </div>
            </div>
        </div>
    </nav>
    <!-- 최상단 네비게이션 끝 -->


    <!-- 최상단 목록 선택 웬만하면 통일 -->
	<!-- header include -->
   <%@ include file="/WEB-INF/jsp/header.jsp"%>
    <!-- Close Header -->

    <!-- Modal -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>
	
    <section class="bg-success py-5" style="text-align: center;">
        여행작가가 추천하는 호텔 추천! & 체험 추천!
    </section>
    <!-- Close Banner -->		
    <!-- Start Section -->
    <section class="container py-5">              
    <ul>
      <li class="list-inline-item">
          <a class="h3 text-dark text-decoration-none mr-3" href="${pageContext.request.contextPath}/mainRoomSelect">숙소</a>
      </li>                       
      <li class="list-inline-item">
          <a class="h3 text-dark text-decoration-none" href="${pageContext.request.contextPath}/mainExperienceSelect">체험</a>
      </li>
    </ul>
   	<div style="text-align:center">
   		<table class="table mb-0">
			<thead class="thead-light">
				<tr>
					<th width="10%">번호</th>
					<th width="60%">제목</th>
					<th width="10%">작성자</th>
					<th width="20%">작성날짜</th>
				</tr>
			</thead>
			<tbody>
				<tr style="text-align:center">
					<td>${experienceSelect.experienceSelectId}</td>
					<td>${experienceSelect.experienceSelectTitle}</td>
					<td>${experienceSelect.traveler.travelerName}</td>
					<td>${fn:substring(experienceSelect.createDate,0,10)}</td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td colspan="5"><textarea class="content" style="border: none; text-align:center; resize: none;" rows="10" cols="100" readonly="readonly">${experienceSelect.experienceSelectContent}</textarea></td>		
				</tr>
			</tbody>
		</table>
		<p></p>
			<div style="text-align:center; float:center;">
				<c:forEach items="${experienceSelectImageList}"  var="experienceSelectImage">
					<img src="${pageContext.request.contextPath}/upload/${experienceSelectImage.imageName}.${experienceSelectImage.imageExt}" style="width:400px; height:400px;"/>
				</c:forEach>
			</div>
		<p></p>
		<div>
			<input class="btn btn-outline-success" type="button" value="이전" onclick="history.back(-1)">
			<c:if test="${loginTravelerId == experienceSelect.travelerId}">
					<a href="${pageContext.request.contextPath}/modifyExperienceSelect?experienceSelectId=${experienceSelect.experienceSelectId}&travelerId=${loginTravelerId}" id="insertBtn" style="text-align:right;" class="btn btn-outline-success">수정</a>
					<a href="${pageContext.request.contextPath}/removeExperienceSelect?experienceSelectId=${experienceSelect.experienceSelectId}&travelerId=${loginTravelerId}" id="insertBtn" style="text-align:right;" class="btn btn-outline-success">삭제</a>
			</c:if>
		</div>
		<table style="text-align:center" class="table table-hover mb-0">
			<thead>
				<tr>
					<th>작성자</th>
					<th>내용</th>
					<th>작성 날짜</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
 				<c:forEach items="${selectCommentList}"  var="comment">
					<tr>
						<td>${comment.customerId}</td>
						<td>${comment.experienceSelectContent}</td>
						<td>${comment.createDate.substring(0,10)}</td>
						<c:choose>
						<c:when test="${loginCustomerId == comment.customerId}">
						<td>
							<a href="${pageContext.request.contextPath}/updateMainExperienceSelectComment?experienceSelectCommentId=${comment.experienceSelectCommentId}&currentPage=${currentPage}&customerId=${comment.customerId}&experienceSelectId=${comment.experienceSelectId}">수정</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/deleteMainExperienceSelectComment?experienceSelectCommentId=${comment.experienceSelectCommentId}&currentPage=${currentPage}&experienceSelectId=${comment.experienceSelectId}">삭제</a>
						</td>
						</c:when>
							<c:otherwise>
								<td>-</td>
								<td>-</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="text-align: right;">
			<a class="btn btn-outline-success" href="${pageContext.request.contextPath}/addMainExperienceSelectComment?customerId=${loginCustomerId}&experienceSelectId=${experienceSelect.experienceSelectId}&currentPage=${currentPage}">댓글작성</a>
		</div>
		<br>
		<div style="text-align: center;">
			<c:if test="${startPage > 1}">
				<a href="${pageContext.request.contextPath}/mainExperienceSelectOne?experienceSelectId=${experienceSelect.experienceSelectId}&currentPage=${startPage-1}" class="btn btn-outline-light text-dark">◁</a>
			</c:if>
			<c:forEach begin="${startPage}" end="${lastPage}" var="i">
				<c:choose>
					<c:when test="${i == currentPage}">
						<a href="${pageContext.request.contextPath}/mainExperienceSelectOne?experienceSelectId=${experienceSelect.experienceSelectId}&currentPage=${i}" class="btn btn-secondary">${i}</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/mainExperienceSelectOne?experienceSelectId=${experienceSelect.experienceSelectId}&currentPage=${i}" class="btn btn-outline-light text-dark">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
				<c:if test="${lastPage != totalPage}">
				<a href="${pageContext.request.contextPath}/mainExperienceSelectOne?experienceSelectId=${experienceSelect.experienceSelectId}&currentPage=${lastPage+1}" class="btn btn-outline-light text-dark">▷</a>
				</c:if>
		</div>
	</div>
    </section>
    <!-- End Section -->
	<section class="container py-5" >
    </section>
    <!-- Start Footer -->
    <footer class="bg-dark" id="tempaltemo_footer">
        <div class="container">
            <div class="row">

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-success border-bottom pb-3 border-light logo">Cast Shop</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li>
                            <i class="fas fa-map-marker-alt fa-fw"></i>
                            123 Consectetur at ligula 10660
                        </li>
                        <li>
                            <i class="fa fa-phone fa-fw"></i>
                            <a class="text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                        </li>
                        <li>
                            <i class="fa fa-envelope fa-fw"></i>
                            <a class="text-decoration-none" href="mailto:info@company.com">info@company.com</a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Products</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="#">Luxury</a></li>
                        <li><a class="text-decoration-none" href="#">Sport Wear</a></li>
                        <li><a class="text-decoration-none" href="#">Men's Shoes</a></li>
                        <li><a class="text-decoration-none" href="#">Women's Shoes</a></li>
                        <li><a class="text-decoration-none" href="#">Popular Dress</a></li>
                        <li><a class="text-decoration-none" href="#">Gym Accessories</a></li>
                        <li><a class="text-decoration-none" href="#">Sport Shoes</a></li>
                    </ul>
                </div>
                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Further Info</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="#">Home</a></li>
                        <li><a class="text-decoration-none" href="#">About Us</a></li>
                        <li><a class="text-decoration-none" href="#">Shop Locations</a></li>
                        <li><a class="text-decoration-none" href="#">FAQs</a></li>
                        <li><a class="text-decoration-none" href="#">Contact</a></li>
                    </ul>
                </div>
            </div>
            <div class="row text-light mb-4">
                <div class="col-12 mb-3">
                    <div class="w-100 my-3 border-top border-light"></div>
                </div>
                <div class="col-auto me-auto">
                    <ul class="list-inline text-left footer-icons">
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a rel="nofollow" class="text-light text-decoration-none" target="_blank" href="http://fb.com/templatemo"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="col-auto">
                    <label class="sr-only" for="subscribeEmail">Email address</label>
                    <div class="input-group mb-2">
                        <input type="text" class="form-control bg-dark border-light" id="subscribeEmail" placeholder="Email address">
                        <div class="input-group-text btn-success text-light">Subscribe</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="w-100 bg-black py-3">
            <div class="container">
                <div class="row pt-2">
                    <div class="col-12">
                        <p class="text-left text-light">
                            &copy; 2021 CAST
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/templatemo.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/custom.js"></script>
    <!-- End Script -->
</body>
</html>