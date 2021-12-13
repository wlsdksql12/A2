<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>RoyalUI Admin</title>
	<!-- plugins:css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ceo_template/vendors/ti-icons/css/themify-icons.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ceo_template/vendors/base/vendor.bundle.base.css">
	<!-- endinject -->
	<!-- plugin css for this page -->
	<!-- End plugin css for this page -->
	<!-- inject:css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ceo_template/css/style.css">
	<!-- endinject -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/ceo_template/images/favicon.png" />
</head>
<body>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<div class="jumbotron bg-white">
	<div class="card">
		<div class="card-body">
			<p class="text-muted font-weight-light">
				<a href="/insertExpAddress?ceoId=${loginCeoId}" class="btn btn-success" style="height: 200px;">체험 등록</a>
				<a href="/insertHotel" class="btn btn-warning" style="height: 200px;">숙소 등록</a>
			</p>
		</div>
	</div>
</div>
</body>
</html>