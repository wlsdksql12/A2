<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#registerBtn').click(function(){
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
			else if($('#customerName').val() == ""){
				alert("이름을 입력하세요.");
				$('#customerName').focus();
				return false;
			}
			else if($('#customerJumin').val() == ""){
				alert("주민번호를 입력하세요.");
				$('#customerJumin').focus();
				return false;
			}
			else if($('#customerEmail').val() == ""){
				alert("이메일을 입력하세요.");
				$('#customerEmail').focus();
				return false;
			}
			else if($('#customerPhoneNum').val() == ""){
				alert("핸드폰 번호를 입력하세요.");
				$('#customerPhoneNum').focus();
				return false;
			}
			else {
				$('#cusForm').submit();
			}
		});
	});
</script>
</head>
<body>
	<form id="cusForm" method='post' action="/addCustomer">
	<div>ID</div>
	<input type="text" name="customerId" id="customerId">
	<div>Pw</div>
	<input type="text" name="customerPw" id="customerPw">
	<div>Name</div>
	<input type="text" name="customerName" id="customerName">
	<div>Jumin</div>
	<input type="text" name="customerJumin" id="customerJumin">
	<div>E-mail</div>
	<input type="text" name="customerEmail" id="customerEmail">
	<div>Phone-Number(-도 함게 써주세요)</div>
	<input type="text" name="customerPhoneNum" id="customerPhoneNum">
	<input type="hidden" name="active" value="1">
	<button type="button" id="registerBtn">회원가입</button>
	</form>
</body>
</html>