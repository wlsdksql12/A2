<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 결제 </h1>
	<form method="post" action="/addHotelPayment">
	<div>호텔 이름</div>
	<input type="text" name ="hotelName" value="${hotelName}" readonly="readonly">
	<div>방 이름</div>
	<input type="text" name="roomName" value="${roomName}" readonly="readonly">
	<div>결제자</div>
	<input type="text" name="customerId" value="${customerId}" readonly="readonly">
	<input type="hidden" name="roomOrderEndDate" value="${roomOrderEndDate}">
	<input type="hidden" name="roomOrderStartDate" value="${roomOrderStartDate}">
	<input type="hidden" name="roomOrderPeople" value="${roomOrderPeople}">
	<input type="hidden" name="note" value="${note}">
	<div>카드 은행</div>
	<select name="roomPaymentMethod">
		<option value="NH">NH</option>
		<option value="KB">KB</option>
	</select>
	<div>카드 번호</div>
	<input type="text" name="roomPaymentMethodNumber">
	<div>가격</div>
	<input type="text" name="roomPaymentMoney" value="${roomPrice}">
	<button type="submit">결제</button>
	</form>
</body>
</html>