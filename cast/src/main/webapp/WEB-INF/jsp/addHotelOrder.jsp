<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 예약 </h1>
	<form method="post" action="${pageContext.request.contextPath}/addHotelOrder">
	<div>예약인</div>
	<input type="text" name="customerId" value="${customerId}" readonly="readonly">
	<div> 호텔 이름 </div>
	<input type="text" name="hotelName" value="${hotelName}" readonly="readonly">
	<div> 방 이름</div>
	<input type="text" name="roomName" value="${roomName}" readonly="readonly">
	<!-- roomId -->
	<input type="hidden" name="roomId" value="${roomId}">
	<div>예약 인원 수</div>
	<input type="text" name="roomOrderPeople">
	<div> 예약 시작 일자</div>
	<input type="date" name="roomOrderStartDate">
	<div> 예약 종료 일자</div>
	<input type="date" name="roomOrderEndDate">
	<div> 옵션 </div>
	<textarea style="resize:none;" rows="15" cols="30" name="note" readonly="readonly">${note}</textarea>
	<button type="submit">예약</button>
	</form>
</body>
</html>