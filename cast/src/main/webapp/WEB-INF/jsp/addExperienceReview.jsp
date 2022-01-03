<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/addExperienceReview">
		<div>작성자</div>
		<input type="text" name="customerId" value="${customerId}" readonly="readonly">
		<div>내용</div>
		<input type="text" name="experiencePaymentReviewContent">
		
		<div>
		<input multiple="multiple" type="file" name="experienceSelectImage" required="required">
		</div>
	
	<button type="submit">추가</button>
	<a href="mainExperienceOne?experienceId=${experienceId}&currentPage=1">이전</a>
	</form>
</body>
</html>