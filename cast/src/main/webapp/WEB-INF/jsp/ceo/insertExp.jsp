<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>체험 등록</title>
</head>
<body>
	<h3>체험 등록</h3>
	<form method="post" action="#">
	<input type="hidden" value="${loginCeoId}">
	<br> address id
	<br> 체험 이름
	<br>
	<input type="text" name="experienceName">
	<br> 내용
	<br>
	<textarea cols="50" rows="5" name="experienceContent"></textarea>
	<br> 가격
	<input type="text" name="experiencePrice"> \
	<br> 체험 일자
	<input type="date" name="experienceStartdate"> ~
	<input type="date" name="experienceEnddate">
	<br> 최대 인원
	<input type="number"> 명
	<br> 상세 주소
	<input type="number">
	<button type="submit">체험 등록</button>
	</form>
</body>
</html>