<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<%@ include file="ceoBase.jsp"%>
	<br>
	<form method="post" action="/updateCeo">
		<h5>내정보 수정</h5>
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="ceoId" value="${ceoId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="ceoEmail" value="${ceoEmail}"></td>
			</tr>
			<tr>
				<td>License</td>
				<td><input type="text" name="ceoLicense" value="${ceoLicense}"></td>
			</tr>
			<tr>
				<td>PhoneNum</td>
				<td><input type="text" name="ceoPhonenum" value="${ceoPhonenum}"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>