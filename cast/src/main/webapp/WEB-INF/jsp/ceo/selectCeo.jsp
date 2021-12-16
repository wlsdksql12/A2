<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ceo_template/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ceo_template/vendors/base/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ceo_template/css/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/ceo_template/images/favicon.png" />
</head>
<body>
	<%@ include file="ceoBase.jsp"%>
	<br>
	<form method="post" action="/ceo/selectCeo">
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">나의 개인정보</h4>
					<div class="table-responsive pt-3">
						<table class="table table-bordered">
							<tr>
								<td>ID</td>
								<td>${ceoId}</td>
							</tr>
							<tr>
								<td>PW</td>
								<td><a href="/ceo/updateCeoPw">비밀번호 수정</a></td>
							</tr>
							<tr>
								<td>Name</td>
								<td>${ceoName}</td>
							</tr>
							<tr>
								<td>Email</td>
								<td>${ceoEmail}</td>
							</tr>
							<tr>
								<td>License</td>
								<td>${ceoLicense}</td>
							</tr>
							<tr>
								<td>PhoneNum</td>
								<td>${ceoPhonenum}</td>
							</tr>
							<tr>
								<td>생성일</td>
								<td>${createDate}</td>
							</tr>
						</table>
						<br>
						<div style="text-align:right">
							<a class="btn btn-outline-primary btn-icon-text" href="/ceo/updateCeo?ceoId=${ceoId}&ceoEmail=${ceoEmail}&ceoLicense=${ceoLicense}&ceoPhonenum=${ceoPhonenum}">
							 <i class="ti-file btn-icon-prepend"></i>
							내 정보수정
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>