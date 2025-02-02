<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Cast Shop MainPage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/resources/assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/assets/img/favicon.ico">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/templatemo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/custom.css">

    <!-- 레이아웃 렌더링한 후 폰트 스타일 로드 -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/fontawesome.min.css">
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	
	<style> 
		body { font-family: 'twayair' } 
		p { font-family: 'twayair' } 
		
		@font-face {
    	font-family: 'twayair';
    	src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_tway@1.0/twayair.woff') format('woff');
    	font-weight: normal;
    	font-style: normal;
		}
	</style>
</head>

<body>
    <!-- 최상단 네비게이션 -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
        <div class="container text-light">
            <div class="w-100 d-flex justify-content-between">
                <div>
                    <i class="fa fa-envelope mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">goodee@naver.com</a>
                    <i class="fa fa-phone mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">02-999-8888</a>
                </div>
                <div>
                    <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i class="fab fa-linkedin fa-sm fa-fw"></i></a>
                </div>
            </div>
        </div>
    </nav>
    <!-- 최상단 네비게이션 끝 -->


    <!-- 최상단 목록 선택 웬만하면 통일 -->
    <!-- header include -->
   <%@ include file="/WEB-INF/jsp/header.jsp"%>
    <!-- Close Header -->

    <!-- Modal -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>



    <!-- Start Banner Hero -->
    <!-- style="height"로 높이 조절 -->
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel" style="height: 650px;">
        <!-- 아래 언더바  -->
        <ol class="carousel-indicators">
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="3"></li>
            <li  data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="4"></li>
        </ol>
        <div class="carousel-inner" style="background-image:url('${pageContext.request.contextPath}/resources/assets/img/home.jpg'); background-size:auto;">
            <div class="carousel-item active">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/resources/assets/img/white.png" style="width:550px; height:550px; border-radius:5%; alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left align-self-center">
                                <h1 style="color:#FFFFFF; font-family: 'twayair'">Comfortable And Safe Travel</h1>
                                <h4 style="color:#FFFFFF; font-family: 'twayair'">편안하고 안전한 여행</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 테스트 중 -->
            <c:forEach items="${exhibition}" var="exhibition">
	            <div class="carousel-item">
	                <div class="container">
	                    <div class="row p-5" OnClick="location.href ='${pageContext.request.contextPath}/mainExhibitionOne?exhibitionNo=${exhibition.exhibitionNo}'" style="cursor:pointer;">
	                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
	                       		<c:forEach items="${exhibition.exhibitionImage}" var="exhibitionImage" begin="0" end="0">
	                       			<img class="img-fluid" src="${pageContext.request.contextPath}/upload/${exhibitionImage.imageName}.${exhibitionImage.imageExt}" style="width:550px; height:550px; border-radius:5%;" alt="">
	                       		</c:forEach>
	                            	
	                        </div>
	                        <div class="col-lg-6 mb-0 d-flex align-items-center">
	                            <div class="text-align-left">
	                                <h3 class="h3" style="color:#FFFFFF; font-family:'twayair'">${exhibition.exhibitionTitle}</h3>
	                                <p class="h4">
	                                	${exhibition.exhibitionIntro}   
	                                </p>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
        </div>
        <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="prev">
            <i class="fas fa-chevron-left"></i>
        </a>
        <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="next">
            <i class="fas fa-chevron-right"></i>
        </a>
    </div>
    <!-- End Banner Hero -->


    <!-- Start Categories of The Month -->
    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
            	<h1><img style="width: 400px; height: 200px;" src="${pageContext.request.contextPath}/upload/new2.JPG"></h1>
                <p>
                    최근에 등록된 호텔와 체험를 볼 수 있습니다.
                </p>
            </div>
        </div>
        <div class="table-responsive">
	        <div style="width: 45%; display: inline-block; float: left;" class="float-right">
				<h2 style="font-family: 'twayair'; font-size:30pt;">호텔</h2>
		        <table class="text-center">
		        <tr>
		        <c:forEach items="${hotelList}" var="hotelList">
                	
		        		<td class="col-6 col-md-2 p-3 mt-1">
		        			<div>
				                <a href="${pageContext.request.contextPath}/mainHotelOne?hotelId=${hotelList.hotelId}">
				                	<img src="${pageContext.request.contextPath}/upload/${hotelList.imageName}.${hotelList.imageExt}" style="width: 400px; height: 400px; border-radius:5%;">
				                </a>
				                <h5 class="text-center mt-3 mb-3" style="font-family: 'twayair'; font-size:20pt;">${hotelList.hotelName}</h5>
				                <!-- <p class="text-center"><a href="${pageContext.request.contextPath}/mainHotelOne?hotelId=${hotelList.hotelId}" class="btn btn-success">Go Shop</a></p> -->
				            </div>
		        		</td>
					
				</c:forEach>
				</tr>
		        </table>
        	</div>
        </div>
        <div class="table-responsive">
			<div style="width: 45%; display: inline-block; float: left;" class="float-left">
				<h2 style="font-family: 'twayair'; font-size:30pt">체험</h2>
		        <table class="text-center">
		        <tr>
		        <c:forEach items="${experienceList}" var="expList">
                	
		        		<td class="col-6 col-md-2 p-3 mt-1">
		        			<div>
				                <a href="${pageContext.request.contextPath}/mainExperienceOne?experienceId=${expList.experienceId}&experienceName=${expList.experienceName}">
				                	<img src="${pageContext.request.contextPath}/upload/${expList.imageName}.${expList.imageExt}" style="width: 400px; height: 400px; border-radius:5%;">
				                </a>
				                <h5 class="text-center mt-3 mb-3" style="font-family: 'twayair'; font-size:20pt;">${expList.experienceName}</h5>
				                <!-- <p class="text-center"><a href="${pageContext.request.contextPath}/mainExperienceOne?experienceId=${expList.experienceId}&experienceName=${expList.experienceName}" class="btn btn-success">Go Shop</a></p> -->
				            </div>
		        		</td>
				</c:forEach>
				</tr>
		        </table>
        	</div>
        </div>
    </section>
    <!-- End Categories of The Month -->


    <!-- Start Featured Product -->
    <section class="bg-light">
        <div class="container py-5">
            <div class="row text-center py-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">
                    	<img src="${pageContext.request.contextPath}/upload/best.png" width="300px">
                    </h1>
                    <p>
                    	여러 여행작가에게 추천을 많이 받은 상품입니다.
                    </p>
                </div>
            </div>
            <div class="row">
				<table>
			        <tr>
			        	<c:forEach items="${experienceBestChoice}" var="expBestChoice">
		        		<td style="width: 500px;">
			        		<div style="width: 500px; height: 600px; margin-left: auto; margin-right: auto;" class="col-12 col-md-4 mb-4">
						        <div class="card-body">
						        	<p style="text-align:center;" class="text-muted">추천 수 : ${expBestChoice.cnt} 회!</p>
			                        <a href="${pageContext.request.contextPath}/mainExperienceOne?experienceId=${expBestChoice.experienceId}&experienceName=${expBestChoice.experienceName}">
			                            <img src="${pageContext.request.contextPath}/upload/${expBestChoice.imageName}.${expBestChoice.imageExt}" class="card-img-top" style="width:500px; height:400px; border-radius:5%;">
			                        </a>
			                        <div class="card-body">
			                            <p style="text-align:center;">
			                            	<a href="${pageContext.request.contextPath}/mainExperienceOne?experienceId=${expBestChoice.experienceId}&experienceName=${expBestChoice.experienceName}" class="h2 text-decoration-none text-dark" style="font-family: 'twayair'; font-size:15pt;">${expBestChoice.experienceName}</a>
			                            </p>
			                            <!-- <p class="text-muted text-center">${expBestChoice.experiencePrice}원</p> -->
			                        </div>
			                    </div>
				            </div>
		        		</td>
		        		</c:forEach>
		        		<!-- 임시로 넣어둠 -->
		        		<c:forEach items="${hotelBestChoice}" var="hotelBestChoice">
		        		<td style="width: 500px;">
			        		<div style="width: 500px; height: 600px; margin-left: auto; margin-right: auto;" class="col-12 col-md-4 mb-4">
						        <div class="card-body">
						        	<p style="text-align:center;" class="text-muted">추천 수 : ${hotelBestChoice.cnt} 회!</p>
			                        <a href="${pageContext.request.contextPath}/mainHotelOne?hotelId=${hotelBestChoice.hotelId}">
			                            <img src="${pageContext.request.contextPath}/upload/${hotelBestChoice.imageName}.${hotelBestChoice.imageExt}" class="card-img-top" style="width:500px; height:400px; border-radius:5%;">
			                        </a>
			                        <div class="card-body">
			                            <p style="text-align:center;">
			                            	<a href="${pageContext.request.contextPath}/mainHotelOne?hotelId=${hotelBestChoice.hotelId}" class="h2 text-decoration-none text-dark" style="font-family: 'twayair'; font-size:15pt;">${hotelBestChoice.hotelName}</a>
			                            </p>  
			                        </div>
			                    </div>
				            </div>
		        		</td>
		        		</c:forEach>
					</tr>
		        </table>
            </div>
            
        </div>
        
    </section>
    <!-- End Featured Product -->


    <!-- Start Footer -->
    <footer class="bg-dark" id="tempaltemo_footer">
        <div class="container">
            <div class="row">

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-success border-bottom pb-3 border-light logo">Cast Shop</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li>
                            <i class="fas fa-map-marker-alt fa-fw"></i>
                            123 Consectetur at ligula 10660
                        </li>
                        <li>
                            <i class="fa fa-phone fa-fw"></i>
                            <a class="text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                        </li>
                        <li>
                            <i class="fa fa-envelope fa-fw"></i>
                            <a class="text-decoration-none" href="mailto:info@company.com">info@company.com</a>
                        </li>
                    </ul>
                </div>

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Products</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">Luxury</a></li>
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">Sport Wear</a></li>
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">Men's Shoes</a></li>
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">Women's Shoes</a></li>
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">Popular Dress</a></li>
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">Gym Accessories</a></li>
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">Sport Shoes</a></li>
                    </ul>
                </div>

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Further Info</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">Home</a></li>
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">About Us</a></li>
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">Shop Locations</a></li>
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">FAQs</a></li>
                        <li><a class="text-decoration-none" href="${pageContext.request.contextPath}/#">Contact</a></li>
                    </ul>
                </div>

            </div>

            <div class="row text-light mb-4">
                <div class="col-12 mb-3">
                    <div class="w-100 my-3 border-top border-light"></div>
                </div>
                <div class="col-auto me-auto">
                    <ul class="list-inline text-left footer-icons">
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="col-auto">
                    <label class="sr-only" for="subscribeEmail">Email address</label>
                    <div class="input-group mb-2">
                        <input type="text" class="form-control bg-dark border-light" id="subscribeEmail" placeholder="Email address">
                        <div class="input-group-text btn-success text-light">Subscribe</div>
                    </div>
                </div>
            </div>
        </div>

        <div class="w-100 bg-black py-3">
            <div class="container">
                <div class="row pt-2">
                    <div class="col-12">
                        <p class="text-left text-light">
                           &copy; 2021 Cast
                        </p>
                    </div>
                </div>
            </div>
        </div>

    </footer>
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/templatemo.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/custom.js"></script>
    <!-- End Script -->
</body>

</html>
