<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>예약 번호</td>
			<td>체험 이름</td>
			<td>예약인</td>
			<td>예약 인원 수</td>
			<td>예약 시작 일</td>
			<td>예약 종류 일</td>
			<td>createDate</td>
			<td>updateDate</td>
		</tr>
		<c:forEach items="${experienceOrderList}"  var="list">
		<tr>
			<td>${list.experienceOrderId}</td>
			<td>${list.experienceName}</td>
			<td>${list.customerId}</td>
			<td>${list.experienceOrderPeople}</td>
			<td>${list.experienceOrderStartDate}</td>
			<td>${list.experienceOrderEndDate}</td>
			<td>${list.createDate}</td>
			<td>${list.updateDate}</td>
		</tr>
		</c:forEach>
	</table>
									<div class="text-center table container mt-3">
									<c:if test="${currentPage > 1}">
										<a href="/CustomerOrderList?customerId=${loginCustomerId}&currentPage=${currentPage-1}">이전</a>
									</c:if>
									<c:if test="${currentPage < lastPage}">
										<a href="/CustomerOrderList?customerId=${loginCustomerId}&currentPage=${currentPage+1}">다음</a>
									</c:if>
								</div>
</body>
</html>