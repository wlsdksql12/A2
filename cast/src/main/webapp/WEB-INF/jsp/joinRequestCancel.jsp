<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 요청 거절</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/resources/assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/assets/img/favicon.ico">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/templatemo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/fontawesome.min.css">

</head>
<body>
    <!-- Start Section -->
    <section class="container py-5" style="margin: 50px auto;">
        <div class="row text-center pt-5 pb-3">
            <div class="col-lg-6 m-auto">
                <h1>가입 요청이 거절되었습니다</h1>
            	<h3>회원가입을 다시 진행해주세요.</h3>
            </div>
        </div>
        <c:choose>
        	<c:when test="${travelerId != null}">
        		<div style="text-align: center; margin: 50px auto;">
        			<a class="btn btn-outline-warning" href="/deleteTraveler?travelerId=${travelerId}">확인</a>
				</div>
        	</c:when>
        	<c:when test="${ceoId != null}">
        		<div style="text-align: center; margin: 50px auto;">
        			<a class="btn btn-outline-warning" href="/deleteCeo?ceoId=${ceoId}">확인</a>
				</div>
        	</c:when>
        </c:choose>
        
    </section>
    <!-- End Section -->
    <footer class="my-3 text-center text-small">
		<p class="mb-1">&copy; 2021 CAST</p>
	</footer>
</body>
</html>