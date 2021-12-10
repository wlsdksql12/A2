<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$('#registerBtn').click(function(){
					if($('#ceoId').val() == ""){
						alert("아이디를 입력하세요.");
						$('#ceoId').focus();
						return false;
					}
					else if($('#ceoPw').val() == ""){
						alert("비밀번호를 입력하세요.");
						$('#ceoPw').focus();
						return false;
					}
					else if($('#ceoName').val() == ""){
						alert("이름을 입력하세요.");
						$('#ceoName').focus();
						return false;
					}
					else if($('#ceoJumin').val() == ""){
						alert("주민번호를 입력하세요.");
						$('#ceoJumin').focus();
						return false;
					}
					else if($('#ceoEmail').val() == ""){
						alert("이메일을 입력하세요.");
						$('#ceoEmail').focus();
						return false;
					}
					else if($('#ceoPhonenum').val() == ""){
						alert("핸드폰 번호를 입력하세요.");
						$('#ceoPhonenum').focus();
						return false;
					}
					else if($('#ceoLicense').val() == ""){
						alert("사업자등록번호를 입력하세요.");
						$('#ceoPhonenum').focus();
						return false;
					}
					else {
						$('#ceoForm').submit();
					}
				});
			});
		</script>
        <meta charset="utf-8">
        <title>사업자 회원가입</title>
    </head>
    <body>
        <form method="post" action="/addCeo" id="ceoForm">
            <div class="jumbotron bg-white" align="center">
                <h3>Join the CAST</h3>
                <hr>
                <table style="text-align: center;">
                    <tr>
                        <td style="font-weight: bold;">이름</td>
                        <td>
                            <input type="text" class="form-control" placeholder="Name" name="ceoName" id="ceoName">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">주민등록번호</td>
                        <td>
                            <input type="password" class="form-control" name="ceoJumin" id="ceoJumin">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">아이디</td>
                        <td>
                            <input type="text" class="form-control" placeholder="ID" name="ceoId" id="ceoId">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">비밀번호</td>
                        <td>
                            <input type="password" class="form-control" placeholder="Password" name="ceoPw" id="ceoPw">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">이메일</td>
                        <td>
                            <input type="text" class="form-control" placeholder="email@example.com" name="ceoEmail" id="ceoEmail">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">전화번호</td>
                        <td>
                            <input type="text" class="form-control" placeholder="010-0000-0000" name="ceoPhonenum" id="ceoPhonenum">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">사업자등록번호&nbsp; &nbsp;</td>
                        <td>
                            <input type="text" class="form-control" name="ceoLicense" id="ceoLicense">
                        </td>
                    </tr>
                </table>
                <hr>
                <button type="button" class="btn btn-outline-success" id="registerBtn">회원가입</button>
                &nbsp;
                <button type="reset" class="btn btn-outline-danger">초기화</button>
                &nbsp;
                <a href="#" onclick="history.go(-1)" class="btn btn-outline-warning">이전</a>
            </div>
        </form>
    </body>
</html>







