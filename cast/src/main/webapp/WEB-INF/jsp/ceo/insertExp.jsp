<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="utf-8">
<title>체험 등록</title>
</head>
<body>
	<h3>체험 등록</h3>
	<form method="post" action="/insertExp">
	<input type="text" value="${loginCeoId}" readonly>
	<input type="text" value="${addressId}" readonly>
	<br> 체험 이름
	<br>
	<input type="text" name="experienceName">
	<br> 내용
	<br>
	<textarea cols="50" rows="5" name="experienceContent"></textarea>
	<br> 가격
	<input type="text" name="experiencePrice"> &#8361;
	<br> 체험 일자
	<input type="date" name="experienceStartdate"> ~
	<input type="date" name="experienceEnddate">
	<br> 최대 인원
	<input type="number"> 명
	<br><br>
	<button type="submit">주소 입력 페이지</button>
	</form>
</body>
</html>