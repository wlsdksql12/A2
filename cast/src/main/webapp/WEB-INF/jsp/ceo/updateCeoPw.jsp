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
	<form method="post" action="/updateCeoPw">
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">비밀번호 변경</h4>
					<div class="form-group row">
						<label for="exampleInputUsername2" class="col-sm-2 col-form-label">기존
							비밀번호 입력</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" name="ceoPw">
						</div>
					</div>
					<div class="form-group row">
						<label for="exampleInputUsername2" class="col-sm-2 col-form-label">변경할
							비밀번호 입력</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" name="newCeoPw">
						</div>
					</div>

					<div style="text-align: right">
						<button type="submit" class="btn btn-primary mr-2">Submit</button>
						<input class="btn btn-light" type="button" value="뒤로가기"
							onclick="history.back(-1)">
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>