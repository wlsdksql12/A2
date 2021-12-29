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
<%@ include file="ceoBase.jsp" %>
<div>
	<div class="col-lg-6 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<p class="text-muted font-weight-light">				
					<a href="/ceo/insertExpAddress?ceoId=${loginCeoId}" class="btn btn-inverse-info col-lg-6 row-lg-6">
						<i class="ti-map-alt" style="font-size:100px;"><br><br>체험</i>
					</a>
					<a href="/ceo/insertHotelAddress?ceoId=${loginCeoId}" class="btn btn-inverse-info col-lg-6 row-lg-6">
						<i class="ti-home" style="font-size:100px"><br><br>호텔</i>
					</a>
				</p>
			</div>
		</div>
	</div>
</div>
</body>
</html>