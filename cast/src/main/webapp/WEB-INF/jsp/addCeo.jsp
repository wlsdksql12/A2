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
	 * {
	  box-sizing: border-box;
	}
	
	/* Create three columns of equal width */
	.columns {
	  float: left;
	  width: 50%;
	  padding: 8px;
	}
	
	/* Style the list */
	.price {
	  list-style-type: none;
	  border: 1px solid #eee;
	  margin: 0;
	  padding: 0;
	  -webkit-transition: 0.3s;
	  transition: 0.3s;
	}
	
	/* Add shadows on hover */
	.price:hover {
	  box-shadow: 0 8px 12px 0 rgba(0,0,0,0.2)
	}
	
	/* Pricing header */
	.price .header {
	  background-color: #111;
	  color: white;
	  font-size: 25px;
	}
	
	/* List items */
	.price li {
	  border-bottom: 1px solid #eee;
	  padding: 20px;
	  text-align: center;
	}
	
	/* Grey list item */
	.price .grey {
	  background-color: #eee;
	  font-size: 20px;
	}
	
	/* The "Sign Up" button */
	.button {
	  background-color: #5f5f5f;
	  border: none;
	  border-radius: 7px;
	  color: white;
	  padding: 10px 25px;
	  text-align: center;
	  text-decoration: none;
	  font-size: 18px;
	}
	
	/* Change the width of the three columns to 100%
	(to stack horizontally on small screens) */
	@media only screen and (max-width: 600px) {
	  .columns {
	    width: 100%;
	  }
	}
</style>
</head>
<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
					<form id="ceoForm" method='post' action="${pageContext.request.contextPath}/addCeo" class="validation-form" novalidate>
						<div class="mb-3">
							<label for="name">아이디</label>
							<input type="text" class="form-control" name="ceoId" id="ceoId" placeholder="" value="" required>
							<div class="invalid-feedback"> 아이디를 입력해주세요.
							</div>
						</div>
						<div class="mb-3">
							<label for="nickname">비밀번호</label>
							<input type="password" class="form-control" name="ceoPw" id="ceoPw" placeholder="" value="" required>
							<div class="invalid-feedback"> 비밀번호를 입력해주세요.
							</div>
						</div>
						<div class="mb-3">
							<label for="email">이름</label>
							<input type="text" class="form-control" name="ceoName" id="ceoName" placeholder="" required>
							<div class="invalid-feedback"> 이름을 입력해주세요.
							</div>
						</div>
						<div class="mb-3">
							<label for="address">주민번호</label>
							<input type="text" class="form-control" name="ceoJumin" id="ceoJumin" placeholder="******-*******" required>
							<div class="invalid-feedback"> 주민번호를 입력해주세요. 
							</div>
						</div>
						<div class="mb-3">
							<label for="address">이메일</label>
							<input type="text" class="form-control" name="ceoEmail" id="ceoEmail" placeholder="you@example.com" required>
							<div class="invalid-feedback"> 이메일을 입력해주세요. 
							</div>
						</div>
						<div class="mb-3">
							<label for="address">전화번호</label>
							<input type="text" class="form-control" name="ceoPhonenum" id="ceoPhonenum" placeholder="010-****-****" required>
							<div class="invalid-feedback"> 전화번호를 입력해주세요. 
							</div>
						</div>
						<div class="mb-3">
							<label for="address">사업자 등록번호</label>
							<input type="text" class="form-control" name="ceoLicense" id="ceoLicense" placeholder="000-00-0000" required>
							<div class="invalid-feedback"> 사업자 등록번호를 입력해주세요. 
							</div>
						</div>
						<div class="mb-3">
							<div class="card">
								<div class="card-body">
									<h2 class="card-title">구독을 선택해주세요</h2>
									<p class="card-description">구독 가능한 상품의 리스트입니다.</p>
									<div class="columns">
									  <ul class="price">
									    <li class="header" style="background-color:#04AA6D">Pro</li>
									    <li class="grey">&#8361; 5,000 / year</li>
									    <li>체험 5개 등록 가능</li>
									    <li>호텔 5개 등록 가능</li>
									    <li>방 50개 등록 가능</li>
									    <li class="grey"><input type="checkbox" href="#" class="button">선택</li>
									  </ul>
									</div>
									
									<div class="columns">
									  <ul class="price">
									    <li class="header">Premium</li>
									    <li class="grey">&#8361; 10,000 / year</li>
									    <li>체험 무제한 등록 가능</li>
									    <li>호텔 무제한 등록 가능</li>
									    <li>방 무제한 등록 가능</li>
									    <li class="grey"><input type="checkbox" href="#" class="button">선택</li>
									  </ul>
									  
									</div>
								</div>
							</div>
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