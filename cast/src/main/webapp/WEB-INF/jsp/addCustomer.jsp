<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method='post' action="/addCustomer">
	<div>ID</div>
	<input type="text" name="customerId">
	<div>Pw</div>
	<input type="text" name="customerPw">
	<div>Name</div>
	<input type="text" name="customerName">
	<div>Jumin</div>
	<input type="text" name="customerJumin">
	<div>E-mail</div>
	<input type="text" name="customerEmail">
	<div>Phone-Number(-도 함게 써주세요)</div>
	<input type="text" name="customerPhoneNum">
	<input type="hidden" name="active" value="1">
	<button type="submit">회원가입</button>
	</form>
	
</body>
</html>