<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입선택</title>
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
                <p>
                	<h1>Sign Up</h1>
                </p>
            </div>
        </div>
        <div class="row" style="margin: 50px auto;">
            <div class="col-md-6 col-lg-3 pb-5" style="margin: 50px auto;">
            	<a style="text-decoration-line : none; color:blue;" href="${pageContext.request.contextPath}/addCustomer">
	                <div class="h-100 py-5 services-icon-wap shadow">
	                    <div class="h1 text-primary text-center"><i class="fas fa-exchange-alt"></i></div>
	                    <h2 class="h5 mt-4 text-center">Customer</h2>
	                </div>
                </a>
            </div>

            <div class="col-md-6 col-lg-3 pb-5" style="margin: 50px auto;">
           		<a style="text-decoration-line : none; color:blue;" href="${pageContext.request.contextPath}/addCeo">
	                <div class="h-100 py-5 services-icon-wap shadow">
	                    <div class="h1 text-primary text-center"><i class="fa fa-percent"></i></div>
	                    <h2 class="h5 mt-4 text-center">CEO</h2>
	                </div>
                </a>
            </div>

            <div class="col-md-6 col-lg-3 pb-5" style="margin: 50px auto;">
           		<a style="text-decoration-line : none; color:blue;" href="${pageContext.request.contextPath}/addTraveler">
	                <div class="h-100 py-5 services-icon-wap shadow">
	                    <div class="h1 text-primary text-center"><i class="fa fa-user"></i></div>
	                    <h2 class="h5 mt-4 text-center">Traveler</h2>
	                </div>
                </a>
            </div>
        </div>
    </section>
    <!-- End Section -->
    <footer class="my-3 text-center text-small">
		<p class="mb-1">&copy; 2021 CAST</p>
	</footer>
</body>
</html>