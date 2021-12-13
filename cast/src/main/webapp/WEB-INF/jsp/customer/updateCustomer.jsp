<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/updatePw">
	<!--  회원 아이디 히든으로... -->
	<input type="hidden" name="customerId" value= "${loginCustomerId}">
	<div>현재 비밀번호</div>
	<input type="password" name="customerPw">
	<div>새 비밀번호</div>
	<input type="password" name="newCustomerPw">
	<button type="submit">수정</button>
	</form>
</body>
</html>