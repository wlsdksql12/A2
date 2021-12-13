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
  <!-- Login Content -->
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
					<form method="post" action="/customerLogin" id="loginCusForm">
	                    <div class="form-group">
	                      <input type="text" class="form-control" id="customerId" name="customerId"  placeholder="아이디를 입력해주세요">
	                    </div>
	                    <div class="form-group">
	                      <input type="password" class="form-control" id="customerPw" name="customerPw" placeholder="비밀번호를 입력해주세요">
	                    </div>
	                    <div class="form-group">
	                      <button type="button" class="btn btn-primary btn-block" id="loginBtn">Login</button>
	                    </div>
					</form>
                    <hr>
					<div class="text-center">
                    	<a href="${pageContext.request.contextPath}/addCustomer" class="font-weight-bold small">회원가입</a>
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
<script type="text/javascript">
	$(function(){
		$('#loginBtn').click(function(){
			if($('#customerId').val() == ""){
				alert("아이디를 입력하세요.");
				$('#customerId').focus();
				return false;
			}
			else if($('#customerPw').val() == ""){
				alert("비밀번호를 입력하세요.");
				$('#customerPw').focus();
				return false;
			}
			else {
				$('#loginCusForm').submit();
			}
		});
	});
</script>
</body>
</html>