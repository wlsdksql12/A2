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
	<form method="post" action="${pageContext.request.contextPath}/ceo/updateCeo">
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">나의 개인정보</h4>

					<p class="card-description">변경하실 정보를 입력해주세요</p>

					<div class="form-group row">
						<label for="exampleInputUsername2" class="col-sm-2 col-form-label">ID</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="ceoId"
								value="${ceoId}" readonly="readonly">
						</div>
					</div>
					<div class="form-group row">
						<label for="exampleInputEmail2" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="ceoEmail"
								value="${ceo.ceoEmail}" placeholder="변경할 Email을 입력하세요">
						</div>
					</div>
					<div class="form-group row">
						<label for="exampleInputMobile" class="col-sm-2 col-form-label">License</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="ceoLicense"
								value="${ceo.ceoLicense}" placeholder="변경할 License를 입력하세요">
						</div>
					</div>
					<div class="form-group row">
						<label for="exampleInputEmail2" class="col-sm-2 col-form-label">PhoneNum</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="ceoPhoneNum"
								value="${ceo.ceoPhonenum}" placeholder="변경할 PhoneNum을 입력하세요">
						</div>
					</div>
					<div style="text-align:right">
					<button type="submit" class="btn btn-primary mr-2">Submit</button>
					<input class="btn btn-light" type="button" value="뒤로가기" onclick="history.back(-1)">
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>