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
	<form method="post" action="/updateCeoPw">
	<table border="1">
		<tr>
			<td>기존 비밀번호 입력</td>
			<td><input type="password" name="ceoPw"></td>
		</tr>
		<tr>
			<td>변경할 비밀번호 입력</td>
			<td><input type="password" name="newCeoPw"></td>
		</tr>
	</table>
	<button type="submit">입력완료</button>
	</form>
</body>
</html>