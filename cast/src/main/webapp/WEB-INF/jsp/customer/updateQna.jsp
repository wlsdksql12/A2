<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/updateQna">
	<input type="hidden" name="currentPage" value="${currentPage}">
	<input type="text" name="qnaId" value="${qnaId}" readonly="readonly">
	<input type="text" name="customerId" value="${customerId}" readonly="readonly">
	<div>qnaTitle</div>
	<input type="text" name="qnaTitle">
	<div>qnaCategory</div>
	<select name="qnaCategory" size="1">
		<option value="">선택하세요.</option>
		<option value="자유">자유</option>
		<option value="기타">기타</option>
	</select>
	<div>qnaContent</div>
	<input type="text" name="qnaContent">
	<button type="submit">수정</button>
	</form>
	<a href="/qnaListOne?qnaId=${qnaId}&customerId=${customerId}">이전</a>
</body>
</html>
