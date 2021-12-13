<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[여행작가]숙소 추천 수정 페이지</title>
</head>
<body>
	<form method="post" action="/modifyRoomSelect">
		<input type="hidden" name="qnaId" value="${roomSelectId}" readonly="readonly">
		<input type="hidden" name="travelerId" value="${travelerId}" readonly="readonly">
		<div>
			제목 : 
			<input style="text-align:center" type="text" name="roomSelectTitle" value="${roomSelect.roomSelectTitle}">
		</div>
		<div> 
			내용 : 
			<textarea style="text-align:center" name="roomSelectContent" rows="7" cols="100">${roomSelect.roomSelectContent}</textarea>
		</div>
		<p></p>
		<button type="submit">수정</button>
		<button type="reset">초기화</button>
	</form>
</body>
</html>