<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[여행작가]로그인</title>
</head>
<body>
	<h1>여행작가 로그인</h1>
	<form method="post" action="/travelerLogin">
		<div>
			아이디 : 
			<input type="text" name="travelerId">
		</div>
		<div>
			비밀번호 : 
			<input type="password" name="travelerPw">
		</div>
		<div>
			<button type="submit">로그인</button>
			<button type="reset">초기화</button>
		</div>
	</form>
</body>
</html>