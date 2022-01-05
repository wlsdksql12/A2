<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/addHotelReview">
		<div>작성자</div>
		<input type="text" name="customerId" value="${customerId}" readonly="readonly">
		<div>내용</div>
		<input type="text" name="roomPaymentReviewContent">
		<div>
		<input type="text" name="roomPaymentId" value="${roomPaymentId}" readonly="readonly">
		</div>
		<div>
		<input type="text" name="hotelId" value="${hotelId}"readonly="readonly">
		</div>
		<div>
		<input type="file" multiple="multiple" name="roompaymentReviewImageUpload">
		</div>
		<input type="text" name="hotelName" value="${hotelName}" readonly="readonly">
		
		
	
	<button type="submit">추가</button>
	<a href="mainHotelOne?hotelId=${hotelId}&currentPage=1">이전</a>
	</form>
</body>
</html>