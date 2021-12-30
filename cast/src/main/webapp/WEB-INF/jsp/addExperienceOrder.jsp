<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/addExperienceOrder">
	<div>체험 번호</div>
	<input type="text" name="experienceId" value="${experienceId}" readonly="readonly">
	<input type="hidden" name="customerId" value="${customerId}">
	<div>예약 인원 수</div> 
	<input type="text" name="experienceOrderPeople">
	<div>예약 시작 일자</div>
	<input type="date" name="experienceOrderStartDate">
	<div>예약 종료 일자</div>
	<input type="date" name="experienceOrderEndDate">
	<button type="submit">입력</button>
	</form>
</body>
</html>