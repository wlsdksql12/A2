<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/updateInfo">
		<h1>내정보 수정</h1>
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="customerId" value="${customerId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="customerName"></td>
			</tr>
			<tr>
				<td>Jumin</td>
				<td><input type="text" name="customerJumin"></td>
			</tr>
			<tr>
				<td>customerEmail</td>
				<td><input type="text" name="customerEmail"></td>
			</tr>
			<tr>
				<td>PhoneNum</td>
				<td><input type="text" name="customerPhoneNum"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>