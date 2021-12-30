<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 회원가입</title>
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
				<h4 class="mb-3">회원가입</h4>
					<form id="cusForm" method='post' action="${pageContext.request.contextPath}/addCustomer" class="validation-form" novalidate>
						<div class="mb-3">
							<label for="id">아이디</label>
							<input type="text" class="form-control" name="customerId" id="customerId" placeholder="" value="" required>
							<div class="invalid-feedback"> 아이디를 입력해주세요.
							</div>
						</div>
						<div class="mb-3">
							<label for="password">비밀번호</label>
							<input type="password" class="form-control" name="customerPw" id="customerPw" placeholder="" value="" required>
							<div class="invalid-feedback"> 비밀번호를 입력해주세요.
							</div>
						</div>
						<div class="mb-3">
							<label for="name">이름</label>
							<input type="text" class="form-control" name="customerName" id="customerName" placeholder="" required>
							<div class="invalid-feedback"> 이름을 입력해주세요.
							</div>
						</div>
						<div class="mb-3">
							<label for="jumin">주민번호</label>
							<input type="text" class="form-control" name="customerJumin" id="customerJumin" placeholder="******-*******" required>
							<div class="invalid-feedback"> 주민번호를 입력해주세요. 
							</div>
						</div>
						<div class="mb-3">
							<label for="email">이메일</label>
							<input type="text" class="form-control" name="customerEmail" id="customerEmail" placeholder="you@example.com" required>
							<div class="invalid-feedback"> 이메일을 입력해주세요. 
							</div>
						</div>
						<div class="mb-3">
							<label for="phoneNumber">전화번호</label>
							<input type="text" class="form-control" name="customerPhoneNum" id="customerPhoneNum" placeholder="01*-****-****" required>
							<div class="invalid-feedback"> 전화번호를 입력해주세요. 
							</div>
							<input type="hidden" name="active" value="1">
						</div>
						<button class="btn btn-primary btn-lg btn-block" type="submit" id="registerBtn">가입 완료</button>
					</form>
				</div>
			</div>
			<footer class="my-3 text-center text-small">
				<p class="mb-1">&copy; 2021 CAST</p>
			</footer>
		</div>
	<script>
		window.addEventListener('load', () => {
			const forms = document.getElementsByClassName('validation-form');
			Array.prototype.filter.call(forms, (form) => {
				form.addEventListener('submit', function (event) {
					if (form.checkValidity() === false) { event.preventDefault();
					event.stopPropagation();
					}
					form.classList.add('was-validated'); 
					}, false);
				});
			}, false);
	</script>
</body>
</html>