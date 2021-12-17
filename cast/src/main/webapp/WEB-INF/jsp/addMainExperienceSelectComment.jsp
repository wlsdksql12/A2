<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method ="post" action="/addMainExperienceSelectComment">
	<div>작성자</div>
	<input type="text" name="customerId" value="${customerId}" readonly="readonly">
	<div>내용</div>
	<input type="text" name="experienceSelectContent">
	<input type="hidden" name ="experienceSelectId" value="${experienceSelectId}">
	<button type="submit">입력</button>
	</form>
	
</body>
</html>