<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체험 리스트</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ceo_template/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ceo_template/vendors/base/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ceo_template/css/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/ceo_template/images/favicon.png" />
</head>
<body>
	<div class="col-lg-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">사업체 목록</h4>
				<p class="card-description">등록한 사업체 목록입니다</p>
				<div class="table-responsive pt-3">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>#</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성날짜</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${experienceList}" var="experience">
								<tr>
									<td>${experience.experienceId}</td>
									<td><a
										href="/experienceOne?experienceId=${experience.experienceId}">${experience.experienceName}</a></td>
									<td>${experience.ceoId}</td>
									<td>${experience.createDate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						<c:if test="${startPage > 1}">
							<a
								href="/experienceList?currentPage=${startPage-1}&searchTitle=${searchTitle}"
								class="btn btn-outline-light text-dark">처음으로</a>
						</c:if>
						<c:forEach begin="${startPage}" end="${lastPage}" var="i">
							<c:choose>
								<c:when test="${i == currentPage}">
									<a
										href="/experienceList?currentPage=${i}&searchTitle=${searchTitle}"
										class="btn btn-secondary">${i}</a>
								</c:when>
								<c:otherwise>
									<a
										href="/experienceList?currentPage=${i}&searchTitle=${searchTitle}"
										class="btn btn-outline-light text-dark">${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${lastPage != totalPage}">
							<a
								href="/experienceList?currentPage=${lastPage+1}&searchTitle=${searchTitle}"
								class="btn btn-outline-light text-dark">끝으로</a>
						</c:if>
					</div>
					<br>
					<form method="get" id="/experienceList">
						<input name="searchTitle" value="${searchTitle}">
						<button>검색</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>