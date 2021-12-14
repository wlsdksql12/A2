<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[여행작가]내정보 보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
				<h4 class="mb-3">내정보</h4>
					<form id="travelerForm" method='post' action="/addTraveler" class="validation-form" novalidate>
						<div class="mb-3">
							<label for="name">아이디</label>
							<input type="text" class="form-control" name="travelerId" placeholder="" value="" required>
						</div>
						<div class="mb-3">
							<label for="password">비밀번호</label>
							<input type="password" class="form-control" name="travelerPw" placeholder="" value="" required>
						</div>
						<div class="mb-3">
							<label for="name">이름</label>
							<input type="text" class="form-control" name="travelerName" placeholder="" required>
						</div>
						<div class="mb-3">
							<label for="jumin">주민번호</label>
							<input type="text" class="form-control" name="travelerJumin" placeholder="******-*******" required>
						</div>
						<div class="mb-3">
							<label for="phonenumber">전화번호</label>
							<input type="text" class="form-control" name="travelerPhoneNum" placeholder="010-****-****" required>
						</div>
						<div class="mb-3">
							<label for="email">이메일</label>
							<input type="text" class="form-control" name="travelerEmail" placeholder="you@example.com" required>
						</div>
						<div class="mb-3">
							<label for="license">라이센스</label>
							<input type="text" class="form-control" name=travelerLicense placeholder="000-00-0000" required>
						</div>
						<div class="mb-3">
							<label for="career">경력</label>
							<input type="text" class="form-control" name="travelerCareer" placeholder="" required>
						</div>
					</form>
				</div>
			</div>
			<footer class="my-3 text-center text-small">
				<p class="mb-1">&copy; 2021 CAST</p>
			</footer>
		</div>
</body>
</html>