<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[여행작가]체험 추천 수정 페이지</title>
</head>
<body>
	<form method="post" action="/modifyExperienceSelect">
		<input type="hidden" name="experienceSelectId" value="${experienceSelect.experienceSelectId}" readonly="readonly">
		<input type="hidden" name="travelerId" value="${experienceSelect.travelerId}" readonly="readonly">
		<div>
			제목 : 
			<input style="text-align:center" type="text" name="experienceSelectTitle" value="${experienceSelect.experienceSelectTitle}">
		</div>
		<div> 
			내용 : 
			<textarea style="text-align:center" name="experienceSelectContent" rows="7" cols="100">${experienceSelect.experienceSelectContent}</textarea>
		</div>
		<p></p>
		<button type="submit">수정</button>
		<button type="reset">초기화</button>
	</form>
</body>
</html>