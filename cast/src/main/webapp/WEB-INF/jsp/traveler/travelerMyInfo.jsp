<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[여행작가]프로필</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style> 
	body {
	 min-height: 100vh; 
	 background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c));
	 background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	 background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	 background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	 background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
	 } 
	.input-form { 
	 max-width: 680px;
	 margin-top: 80px; 
	 padding: 32px; 
	 background: #fff; 
	 -webkit-border-radius: 10px; 
	 -moz-border-radius: 10px; 
	 border-radius: 10px; 
	 -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15); 
	 -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15); 
	 box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
	 }
</style>
</head>
<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">${loginTravelerId}님의 프로필!</h4>
				<div class="mb-3">
					<label for="name">이름</label>
					<input type="text" class="form-control" name="travelerName" value="${traveler.travelerName}" readonly="readonly" required>
				</div>
				<div class="mb-3">
					<label for="phonenumber">전화번호</label>
					<input type="text" class="form-control" name="travelerPhoneNum" value="${traveler.travelerPhoneNum}" readonly="readonly" required>
				</div>
				<div class="mb-3">
					<label for="email">이메일</label>
					<input type="text" class="form-control" name="travelerEmail" value="${traveler.travelerEmail}" readonly="readonly"required>
				</div>
				<div class="mb-3">
					<label for="license">라이센스</label>
					<input type="text" class="form-control" name=travelerLicense value="${traveler.travelerLicense}" readonly="readonly" required>
				</div>
				<div class="mb-3">
					<label for="career">경력</label>
					<input type="text" class="form-control" name="travelerCareer" value="${traveler.travelerCareer}" readonly="readonly" required>
				</div>
				<input type="button" class="btn btn-primary" value="이전" onclick="history.back(-1)">
				<a class="btn btn-warning" href="/modifyTravelerMyInfo?travelerId=${loginTravelerId}">회원정보 수정</a>
			</div>
		</div>
		<footer class="my-3 text-center text-small">
			<p class="mb-1">&copy; 2021 CAST</p>
		</footer>
		
	</div>
</body>
</html>