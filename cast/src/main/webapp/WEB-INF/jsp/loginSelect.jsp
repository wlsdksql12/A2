<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 로그인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/admin_template/img/logo/logo.png" rel="icon">
<title>RuangAdmin - Login</title>
<link href="${pageContext.request.contextPath}/resources/admin_template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/admin_template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/admin_template/css/ruang-admin.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-login">
<!-- 로그인 -->
  <div class="container-login">
    <div class="row justify-content-center">
      <div class="col-xl-6 col-lg-12 col-md-9">
        <div class="card shadow-sm my-5">
          <div class="card-body p-0">
            <div class="row">
              <div class="col-lg-12">
                <div class="login-form">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Login</h1>
                  </div>
					<form method="post" action="${pageContext.request.contextPath}/index" id="loginForm">
						<div>
						<select id="loginSelect" name="login">
				 			<option value="">로그인 방식을 선택해주세요..</option>
				 			<option value="adminLogin" selected>관리자</option>
				 			<option value="travelerLogin">여행작가</option>
				 			<option value="customerLogin">일반회원</option>
				 			<option value="ceoLogin">사업자</option>
			 			</select>
			 			<hr>
						</div>

	                    <div class="form-group">
	                      <input type="text" class="form-control" id="Id" name="Id" value="admin" placeholder="아이디를 입력해주세요">
	                    </div>
	                    <div class="form-group">
	                      <input type="password" class="form-control" id="Pw" name="Pw" value="1234" placeholder="비밀번호를 입력해주세요">
	                    </div>
	                    <div class="form-group">
	                      <button type="button" class="btn btn-primary btn-block" id="loginBtn">Login</button>
	                    </div>
					</form>
                    <hr>
                    <div class="text-center">
                    	<a class="font-weight-bold small" href="${pageContext.request.contextPath}/customersingup">회원가입</a>
                    </div>
                </div>
                <footer class="my-3 text-center text-small">
				<p class="mb-1">&copy; 2021 CAST</p>
				</footer>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</div>
<!-- jquery -->
<script type="text/javascript">
	$(function(){
		// 로그인 유효성 검사
		$('#loginBtn').click(function(){
			if($('#loginSelect').val() == ""){
				alert("로그인 방식을 선택해주세요....");
				$('#loginSelect').focus();
				return false;
			}
			
			else if($('#Pw').val() == ""){
				alert("비밀번호를 입력하세요.");
				$('#Pw').focus();
				return false;
			}
			else if($('#Id').val() == ""){
				alert("아이디를 입력하세요.");
				$('#Id').focus();
				return false;
			}
			else {
				$('#loginForm').submit();
			}
		});
		// 로그인 엔터키 이벤트
		$('#loginForm').keypress(function(event){
			if(event.which == 13) {
				$('#loginBtn').click();
				return false;
			}
		});
	});
</script>
</body>
</html>