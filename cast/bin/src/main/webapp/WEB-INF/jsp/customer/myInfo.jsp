<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <a href="/updateInfo?customerId=${customerId}" id="updateBtn" class="btn btn-outline-success">수정</a>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>${customerId}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${customerName}</td>
		</tr>
		<tr>
			<td>Jumin</td>
			<td>${customerJumin}</td>
		</tr>
		<tr>
			<td>PhoneNum</td>
			<td>${customerPhoneNum}</td>
		</tr>
	</table>
	
</body>
</html>