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
	<h1>체험</h1>
	<table border="1">
		<tr>
			<td>예약 번호</td>
			<td>체험 이름</td>
			<td>예약인</td>
			<td>예약 인원 수</td>
			<td>예약 시작 일</td>
			<td>예약 종료 일</td>
			<td>createDate</td>
			<td>updateDate</td>
			<td>사업체 정보</td>
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
			<td><a href="/">정보 보기</a></td>
		</tr>
		</c:forEach>
	</table>
					<div class="text-center table container mt-3">
					<c:if test="${currentPage > 1}">
						<a href="/CustomerOrderList?customerId=${loginCustomerId}&currentPage=${currentPage-1}&currentPage2=${currentPage2}">이전</a>
					</c:if>
					<c:if test="${currentPage < lastPage}">
						<a href="/CustomerOrderList?customerId=${loginCustomerId}&currentPage=${currentPage+1}&currentPage2=${currentPage2}">다음</a>
					</c:if>
				</div>
				
		
		
		<h1>숙소</h1>
		<table border="1">
		<tr>
			<td>예약 번호</td>
			<td>숙소 이름</td>
			<td>방 이름</td>
			<td>예약인</td>
			<td>예약 인원 수</td>
			<td>예약 시작 일</td>
			<td>예약 종료 일</td>
			<td>createDate</td>
			<td>updateDate</td>
			<td>사업체 정보</td>
		</tr>
		<c:forEach items="${roomOrderList}"  var="list">
		<tr>
			<td>${list.roomOrderId}</td>
			<td>${list.hotelName}</td>
			<td>${list.roomName}</td>
			<td>${list.customerId}</td>
			<td>${list.roomOrderPeople}</td>
			<td>${list.roomOrderStartDate}</td>
			<td>${list.roomOrderEndDate}</td>
			<td>${list.createDate}</td>
			<td>${list.updateDate}</td>
			<td><a href="/">정보 보기</a></td>
		</tr>
		</c:forEach>
	</table>
				<div class="text-center table container mt-3">
				<c:if test="${currentPage2 > 1}">
					<a href="/CustomerOrderList?customerId=${loginCustomerId}&currentPage2=${currentPage2-1}&currentPage=${currentPage}">이전</a>
				</c:if>
				<c:if test="${currentPage2 < lastPage2}">
					<a href="/CustomerOrderList?customerId=${loginCustomerId}&currentPage2=${currentPage2+1}&currentPage=${currentPage}">다음</a>
				</c:if>
			</div>
								
								
	<div><a href="/customer/customerIndex" type="button">메인페이지로</a></div>				
								
</body>
</html>