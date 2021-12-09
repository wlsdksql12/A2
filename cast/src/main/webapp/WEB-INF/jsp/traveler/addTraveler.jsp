<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[여행작가]회원가입!</title>
</head>
<body>
	<h1>여행작가 회원가입</h1>
	<form method="post" action="/addTraveler">
		<div>
			아이디 : 
			<input type="text" name="travelerId">
		</div>
		<div>
			비밀번호 : 
			<input type="password" name="travelerPw">
		</div>
		<div>
			이름 : 
			<input type="text" name="travelerName">
		</div>
		<div>
			주민번호 : 
			<input type="text" name="travelerJumin">
		</div>
		<div>
			전화번호 : 
			<input type="text" name="travelerPhoneNum">
		</div>
		<div>
			이메일 : 
			<input type="text" name="travelerEmail">
		</div>
		<div>
			라이센스 : 
			<input type="text" name="travelerLicense">
		</div>
		<div>
			경력 : 
			<input type="text" name="travelerCareer">
		</div>
		<div>
			<button type="submit">회원가입</button>
			<button type="reset">초기화</button>
		</div>
	</form>
</body>
</html>