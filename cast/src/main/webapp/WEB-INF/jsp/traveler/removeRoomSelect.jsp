<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[여행작가]삭제 페이지</title>
</head>
<body>
	<div style="text-align:center">
		<h1>페이지 삭제</h1>
		<form method="post" action="/removeRoomSelect">
			<h3>여행작가 아이디를 입력해주세요!</h3>
			<div>
				<input type="hidden" name="roomSelectId" value="${roomSelect.roomSelectId}">
			</div>
			<div>
				아이디 : 
				<input type="text" name="travelerId">
			</div>
			<p></p>
			<button type="submit">삭제</button>
			<button type="reset">초기화</button>
		</form>
	</div>
</body>
</html>