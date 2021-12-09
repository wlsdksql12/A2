<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
	<h1>공지사항</h1>
	<form method="post" action="/addNotice">
		<table border="1">
			<tr>
				<td>noticeTitle<td>
				<td><input type="text" name="noticeTitle"></td>
			<tr>
			<tr>
				<td>noticeContent</td>
				<td><textarea name="noticeContent" rows="5" cols="50"></textarea></td>
			</tr>
		</table>
		<button type="submit">추가하기</button>
	</form>
</body>
</html>