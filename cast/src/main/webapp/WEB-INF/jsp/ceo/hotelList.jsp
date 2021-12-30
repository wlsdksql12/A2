<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체험 리스트</title>

</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<br>
	<div>
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">호텔 목록</h4>
					<p class="card-description">등록한 호텔 목록입니다</p>
					<div class="table-responsive pt-3" id="form1">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>제목</th>
									<th>작성날짜</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${hotList}" var="hotel">
									<tr>
										<td>${hotel.hotelId}</td>
										<td>
											<a href="${pageContext.request.contextPath}/ceo/hotelOne?hotelId=${hotel.hotelId}">${hotel.hotelName}</a>
										</td>
										<td>${hotel.createDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<br>
						<div>
							<c:if test="${startPage > 1}">
								<a href="${pageContext.request.contextPath}/ceo/hotelList?currentPage=${startPage-1}" class="btn btn-outline-light text-dark">처음으로</a>
							</c:if>
							<div class="btn-group">
							<c:forEach begin="${startPage}" end="${lastPage}" var="i">
								<c:choose>
									<c:when test="${i == currentPage}">
										<a href="${pageContext.request.contextPath}/ceo/hotelList?currentPage=${i}" class="btn btn-group btn-secondary">${i}</a>
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath}/ceo/hotelList?currentPage=${i}" class="btn btn-group btn-outline-secondary">${i}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</div>
							<c:if test="${lastPage != totalPage}">
								<a href="${pageContext.request.contextPath}/ceo/hotelList?currentPage=${lastPage+1}" class="btn btn-outline-light text-dark">끝으로</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>