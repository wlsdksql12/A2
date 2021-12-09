<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
</head>
<body>
	<h1>공지사항 상세보기</h1>
	<table border="1">
		<tr>
			<td>공지사항 번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>글작성 시간</td>
		</tr>
		<tr>
			<td>${noticeNo}</td>
			<td>${noticeTitle}</td>
			<td>${noticeContent}</td>
			<td>${createDate}</td>
		</tr>
	</table>
</body>
</html>