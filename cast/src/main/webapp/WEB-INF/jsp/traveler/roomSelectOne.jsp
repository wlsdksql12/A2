<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>[여행작가] 숙소추천 상세보기 페이지</title>
</head>
<body>
	<div style="text-align:center">
		<table border="1" class="table table-striped">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>제목</th>
				<th>내용</th>
				<th>생성날짜</th>
				<th>수정날짜</th>
			</tr>
			<tr>
				<td>${roomSelect.roomSelectId}</td>
				<td>${roomSelect.travelerId}</td>
				<td>${roomSelect.roomSelectTitle}</td>
				<td>${roomSelect.roomSelectContent}</td>
				<td>${roomSelect.createDate}</td>
				<td>${roomSelect.updateDate}</td>
			</tr>
		</table>
		<p></p>
		<div>
			<a class="btn btn-warning" href="/modifyRoomSelect?roomSelectId=${roomSelect.roomSelectId}">수정</a>
			<a class="btn btn-danger" href="/removeRoomSelect?roomSelectId=${roomSelect.roomSelectId}">삭제</a>
		</div>
	</div>
</body>
</html>