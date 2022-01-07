<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Cast Shop - Product Listing Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/resources/assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/assets/img/favicon.ico">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/templatemo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/custom.css">

    <!-- 레이아웃 렌더링한 후 폰트 스타일 로드 -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/fontawesome.min.css">
    <style>
    ul{
  		 list-style:none;
  	}
		.menu a{cursor:pointer;}
		.menu .hide{display:none;}
		.hashtagBtn{
			background-color: rgba(255, 255, 255);
			border-radius: 50px;
			margin-bottom: 3px;
			margin-top: 3px;
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
                    <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">info@company.com</a>
                    <i class="fa fa-phone mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
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

    <!-- Start Content -->
    <div class="container py-5">
        <div class="row">
			<div class="col-lg-3">
			<h1 class="h2 pb-4">Categories</h1>
			    <ul class="hide">
				<c:forEach items="${selectThemeList}" var="ThemeList">
			        <li class="menu">
			            <a>${ThemeList.themeBig.themeBigName}<i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i></a>
			            <ul>
			                <li class="menu">
			                	<a>${ThemeList.themeMiddleName}<i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i></a>
			                	<ul class="hide">
			                	<c:forEach items="${selectThemeSmallList}" var="SmallList">
			                	<c:if test="${ThemeList.themeMiddleId == SmallList.themeMiddleId}">
			                		<li>
			                			<a href="${pageContext.request.contextPath}/shop?themeSmallName=${SmallList.themeSmallName}">${SmallList.themeSmallName}</a>
			                		</li>
			                		</c:if>
			                		</c:forEach>
			                	</ul>
			            </ul>
			        </li>
			        </c:forEach>
			                <li class="menu">
								<a>메뉴1-2<i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i></a>
								<ul class="hide">
			                		<li>메뉴1-2-1</li>
			                		<li>메뉴1-2-2</li>
			                	</ul>
			                </li>
			            </ul>
			        <ul>
			        <li class="menu">
			            <a>메뉴2<i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i></a>
			            <ul class="hide">
			                <li class="menu">
			                	<a>메뉴2-1<i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i></a>
			                	<ul class="hide">
			                		<li>메뉴2-1-1</li>
			                		<li>메뉴2-1-2</li>
			                		
			                	</ul>
			                </li>
			                <li class="menu">
								<a>메뉴2-2<i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i></a>
								<ul class="hide">
			                		<li>메뉴2-2-1</li>
			                		<li>메뉴2-2-2</li>
			                	</ul>
			                </li>
			            </ul>
			        </li>
			    </ul>
			    <br>
			    <h1 class="h2 pb-4">HashTag</h1>
				<c:forEach items="${keywordList}" var="keyword">
					<button type="button" class="hashtagBtn" data-wow-delay="0.3s"
					style="visibility: visible; animation-delay: 0.3s; animation-name: fadeInDown;" name="searchKeyword" value="${keyword.keywordName}">
               		#${keyword.keywordName}
           			</button>
           		</c:forEach>
			    <form method="get" action="${pageContext.request.contextPath}/shop" style="height: 25px" id="searchKeywordForm">
					<input class="hashtagBtn" name="searchKeyword" id="searchKeyword" placeholder="해시태그를 입력하세요" style="height: 25px">
					<button class="hashtagBtn" style="height: 30px;">검색</button>
				</form>
			</div>
			
            <div class="col-lg-9">
                <div class="row">
                    <div class="col-md-6">
                        <ul class="list-inline shop-top-menu pb-3 pt-1">
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none mr-3" href="#">All</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none mr-3" href="#">Men's</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none" href="#">Women's</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-6 pb-4">
                    	<form action="${pageContext.request.contextPath}/shop" id ="shopCategoryForm">
                        <div class="d-flex">
                        <c:if test=""></c:if>
                       <input type="hidden" name="themeSmallName" value="${themeSmallName}">
                       <div id = "searchKeywordBtn"></div>
                            <select class="form-control" name="shopCategory" id="shopCategory"  onchange="shopCategory()">
                                <option value="전체보기">전체보기</option>
                                <option value="체험">체험</option>
                                <option value="호텔">호텔</option>
                            </select>
                       </form>
                        </div>
                    </div>
                </div>
                <c:choose>
				<c:when test="${shopCategory eq '전체보기'}">
	                <div class="row">
	                <h5>체험</h5>
	                 <c:forEach items="${selectThemeShopExperienceList}" var="ShopExperienceList">
	                 <c:set var="test" value="${value}" />
	                    <div class="col-md-4">
	                        <div class="card mb-4 product-wap rounded-0">
	                            <div class="card rounded-0">
	                                <img class="card-img rounded-0 img-fluid" src="${pageContext.request.contextPath}/resources/assets/img/shop_01.jpg">
	                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
	                                    <ul class="list-unstyled">
	                                        <li><a class="btn btn-success text-white" href="shop-single.html"><i class="far fa-heart"></i></a></li>
	                                        <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i class="far fa-eye"></i></a></li>
	                                 
	                                
	                                  <c:if test="${not empty wishList}">
	                                   <c:forEach items="${wishList}" var = "wishList">
	                                   
	            							<!-- 등록이 되어있다면 -->
	            							<c:choose>
	            								<c:when test="${(wishList.experienceId == ShopExperienceList.experience.experienceId)}">
	            								<c:set var="test" value="true" />
	            								<li><a name="duplWishListBtn" class="btn btn-success text-white mt-2"><i class="fas fa-cart-plus"></i></a></li>
	            								</c:when>
	            							</c:choose>

	                                    </c:forEach>
	                                    		
	                             				 <c:if test="${test eq false}">
	            								<li><a name="ExpAddWishListBtn" class="btn btn-success text-white mt-2" href="${pageContext.request.contextPath}/experienceWishList?experienceId=${ShopExperienceList.experience.experienceId}"><i class="fas fa-cart-plus"></i></a></li>
	            								</c:if>
	            								
	                                    </c:if>
	                                  
	                                    <!-- 관심상품 테이블이 비어있다면 -->
	                                    <c:if test="${(empty wishList)}">
	                                    <li><a name="ExpEmpWishListBtn" class="btn btn-success text-white mt-2" href="${pageContext.request.contextPath}/experienceWishList?experienceId=${ShopExperienceList.experience.experienceId}"><i class="fas fa-cart-plus"></i></a></li>
	                                    </c:if>
	                                    
	                                    </ul>
	                                </div>
	                            </div>
	                            <div class="card-body">
	                                <a href="${pageContext.request.contextPath}/mainExperienceOne?experienceId=${ShopExperienceList.experience.experienceId}&experienceName=${ShopExperienceList.experience.experienceName}" class="h3 text-decoration-none">${ShopExperienceList.experience.experienceName}</a>
	                                <div>
	                                </div>
	                                <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
	                                    <li class="pt-2">
	                                        <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
	                                    </li>
	                                </ul>
	                                <ul class="list-unstyled d-flex justify-content-center mb-1">
	                                    <li>
	                                        <i class="text-warning fa fa-star"></i>
	                                        <i class="text-warning fa fa-star"></i>
	                                        <i class="text-warning fa fa-star"></i>
	                                        <i class="text-muted fa fa-star"></i>
	                                        <i class="text-muted fa fa-star"></i>
	                                    </li>
	                                </ul>
	                                <p class="text-center mb-0">${ShopExperienceList.experience.experiencePrice}원</p>
	                            </div>
	                        </div>
	                    </div>
	                   </c:forEach>
	                </div>
	                <div class="row">
	                <h5>호텔</h5>
	                 <c:forEach items="${selectThemeShopHotelList}" var="ShopHotelList">
	                 <c:set var="test" value="${value}" />
	                    <div class="col-md-4">
	                        <div class="card mb-4 product-wap rounded-0">
	                            <div class="card rounded-0">
	                                <img class="card-img rounded-0 img-fluid" src="${pageContext.request.contextPath}/resources/assets/img/shop_01.jpg">
	                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
	                                    <ul class="list-unstyled">
	                                        <li><a class="btn btn-success text-white" href="shop-single.html"><i class="far fa-heart"></i></a></li>
	                                        <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i class="far fa-eye"></i></a></li>
	                                        <c:if test="${not empty roomWishList}">
	                                   <c:forEach items="${roomWishList}" var = "roomWishList">
	            
											<c:if test="${(roomWishList.hotelId == ShopHotelList.hotel.hotelId)}">
											<c:set var="test" value="true" />
	                                     		<li><a name="duplWishListBtn" class="btn btn-success text-white mt-2"><i class="fas fa-cart-plus"></i></a></li>
	                                     	</c:if>   
	                                    </c:forEach>
	                                    
	                                     	<c:if test="${test eq false}">
											<li><a name="RoomAddWishListBtn" class="btn btn-success text-white mt-2" href="${pageContext.request.contextPath}/roomWishList?hotelId=${ShopHotelList.hotel.hotelId}"><i class="fas fa-cart-plus"></i></a></li>
											</c:if>
	                                    </c:if>
	                                    <c:if test="${empty roomWishList}">
	                                    <li><a name="RoomEmpWishListBtn" class="btn btn-success text-white mt-2" href="${pageContext.request.contextPath}/roomWishList?hotelId=${ShopHotelList.hotel.hotelId}"><i class="fas fa-cart-plus"></i></a></li>
	                                    </c:if>
	                                    </ul>
	                                </div>
	                            </div>
	                            <div class="card-body">
	                                <a href="${pageContext.request.contextPath}/mainHotelOne?hotelId=${ShopHotelList.hotel.hotelId}&hotelName=${ShopHotelList.hotel.hotelName}" class="h3 text-decoration-none">${ShopHotelList.hotel.hotelName}</a>
	                                <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
	                                    <li class="pt-2">
	                                        <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
	                                    </li>
	                                </ul>
	                                <ul class="list-unstyled d-flex justify-content-center mb-1">
	                                    <li>
	                                        <i class="text-warning fa fa-star"></i>
	                                        <i class="text-warning fa fa-star"></i>
	                                        <i class="text-warning fa fa-star"></i>
	                                        <i class="text-muted fa fa-star"></i>
	                                        <i class="text-muted fa fa-star"></i>
	                                    </li>
	                                </ul>
	                            </div>
	                        </div>
	                    </div>
	                   </c:forEach>
	                </div>
                </c:when>
                <c:when test="${shopCategory eq '체험'}">
	                 <div class="row">
	                 <h5>체험</h5>
	                 <c:forEach items="${selectThemeShopExperienceList}" var="ShopExperienceList">
	                    <div class="col-md-4">
	                        <div class="card mb-4 product-wap rounded-0">
	                            <div class="card rounded-0">
	                                <img class="card-img rounded-0 img-fluid" src="${pageContext.request.contextPath}/resources/assets/img/shop_01.jpg">
	                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
	                                    <ul class="list-unstyled">
	                                        <li><a class="btn btn-success text-white" href="shop-single.html"><i class="far fa-heart"></i></a></li>
	                                        <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i class="far fa-eye"></i></a></li>
	                                        <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i class="fas fa-cart-plus"></i></a></li>
	                                    </ul>
	                                </div>
	                            </div>
	                            <div class="card-body">
	                                <a href="${pageContext.request.contextPath}/mainExperienceOne?experienceId=${ShopExperienceList.experience.experienceId}" class="h3 text-decoration-none">${ShopExperienceList.experience.experienceName}</a>
	                                <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
	                                    <li class="pt-2">
	                                        <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
	                                        <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
	                                    </li>
	                                </ul>
	                                <ul class="list-unstyled d-flex justify-content-center mb-1">
	                                    <li>
	                                        <i class="text-warning fa fa-star"></i>
	                                        <i class="text-warning fa fa-star"></i>
	                                        <i class="text-warning fa fa-star"></i>
	                                        <i class="text-muted fa fa-star"></i>
	                                        <i class="text-muted fa fa-star"></i>
	                                    </li>
	                                </ul>
	                                <p class="text-center mb-0">${ShopExperienceList.experience.experiencePrice}원</p>
	                            </div>
	                        </div>
	                    </div>
	                   </c:forEach>
	                </div>
                </c:when>
                <c:when test="${shopCategory eq '호텔'}">
               <div class="row">
               <h5>호텔</h5>
                 <c:forEach items="${selectThemeShopHotelList}" var="ShopHotelList">
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="${pageContext.request.contextPath}/resources/assets/img/shop_01.jpg">
                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                    <ul class="list-unstyled">
                                        <li><a class="btn btn-success text-white" href="shop-single.html"><i class="far fa-heart"></i></a></li>
                                        <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i class="far fa-eye"></i></a></li>
                                        <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i class="fas fa-cart-plus"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="card-body">
                                <a href="${pageContext.request.contextPath}/mainHotelOne?hotelId=${ShopHotelList.hotel.hotelId}" class="h3 text-decoration-none">${ShopHotelList.hotel.hotelName}</a>
                                <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                    <li class="pt-2">
                                        <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                    </li>
                                </ul>
                                <ul class="list-unstyled d-flex justify-content-center mb-1">
                                    <li>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                   </c:forEach>
                </div>
                </c:when>
                </c:choose>
                <c:choose>
                	<c:when test="${searchKeyword != null && not empty searchKeyword}">
                	<div div="row">
                    <ul class="pagination pagination-lg justify-content-end">
                        <c:if test="${startPage > 1}" >
                            <a class="page-link active rounded-0 mr-3 shadow-sm border-top-0 border-left-0" href="${pageContext.request.contextPath}/shop?currentPage=${startPage-1}&searchKeyword=${searchKeyword}&shopCategory=${shopCategory}" tabindex="-1">◁</a>
                        </c:if>
                        
                        <c:forEach begin="${startPage}" end="${lastPage}" var="i">
							<c:choose>
								<c:when test="${i == currentPage}">
									<a href="${pageContext.request.contextPath}/shop?currentPage=${i}&searchKeyword=${searchKeyword}&shopCategory=${shopCategory}" class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark">${i}</a>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath}/shop?currentPage=${i}&searchKeyword=${searchKeyword}&shopCategory=${shopCategory}" class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark">${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
                        	<c:if test="${lastPage != totalPage}">
                            	<a class="page-link rounded-0 shadow-sm border-top-0 border-left-0 text-dark" href="${pageContext.request.contextPath}/shop?currentPage=${lastPage+1}&searchKeyword=${searchKeyword}&shopCategory=${shopCategory}">▷</a>
                        	</c:if>
                    </ul>
                </div>
                </c:when>
                <c:when test="${searchKeyword != null || empty searchKeyword}">
                <div div="row">
                    <ul class="pagination pagination-lg justify-content-end">
                        <c:if test="${startPage > 1}" >
                            <a class="page-link active rounded-0 mr-3 shadow-sm border-top-0 border-left-0" href="${pageContext.request.contextPath}/shop?currentPage=${startPage-1}&themeSmallName=${themeSmallName}" tabindex="-1">◁</a>
                        </c:if>
                        
                        <c:forEach begin="${startPage}" end="${lastPage}" var="i">
							<c:choose>
								<c:when test="${i == currentPage}">
									<a href="${pageContext.request.contextPath}/shop?currentPage=${i}&themeSmallName=${themeSmallName}&shopCategory=${shopCategory}" class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark">${i}</a>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath}/shop?currentPage=${i}&themeSmallName=${themeSmallName}&shopCategory=${shopCategory}" class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark">${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
                        	<c:if test="${lastPage != totalPage}">
                            	<a class="page-link rounded-0 shadow-sm border-top-0 border-left-0 text-dark" href="${pageContext.request.contextPath}//shop?currentPage=${lastPage+1}&themeSmallName=${themeSmallName}&shopCategory=${shopCategory}">▷</a>
                        	</c:if>
                    </ul>
                </div>
                </c:when>
                </c:choose>
            </div>

        </div>
    <!-- End Content -->

    <!-- Start Brands -->
    <section class="bg-light py-5">
        <div class="container my-4">
            <div class="row text-center py-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">Our Brands</h1>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        Lorem ipsum dolor sit amet.
                    </p>
                </div>
                <div class="col-lg-9 m-auto tempaltemo-carousel">
                    <div class="row d-flex flex-row">
                        <!--Controls-->
                        <div class="col-1 align-self-center">
                            <a class="h1" href="#multi-item-example" role="button" data-bs-slide="prev">
                                <i class="text-light fas fa-chevron-left"></i>
                            </a>
                        </div>
                        <!--End Controls-->

                        <!--Carousel Wrapper-->
                        <div class="col">
                            <div class="carousel slide carousel-multi-item pt-2 pt-md-0" id="multi-item-example" data-bs-ride="carousel">
                                <!--Slides-->
                                <div class="carousel-inner product-links-wap" role="listbox">

                                    <!--First slide-->
                                    <div class="carousel-item active">
                                        <div class="row">
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--End First slide-->

                                    <!--Second slide-->
                                    <div class="carousel-item">
                                        <div class="row">
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--End Second slide-->

                                    <!--Third slide-->
                                    <div class="carousel-item">
                                        <div class="row">
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                            </div>
                                            <div class="col-3 p-md-5">
                                                <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--End Third slide-->

                                </div>
                                <!--End Slides-->
                            </div>
                        </div>
                        <!--End Carousel Wrapper-->

                        <!--Controls-->
                        <div class="col-1 align-self-center">
                            <a class="h1" href="#multi-item-example" role="button" data-bs-slide="next">
                                <i class="text-light fas fa-chevron-right"></i>
                            </a>
                        </div>
                        <!--End Controls-->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--End Brands-->


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
                        <li><a class="text-decoration-none" href="#">Luxury</a></li>
                        <li><a class="text-decoration-none" href="#">Sport Wear</a></li>
                        <li><a class="text-decoration-none" href="#">Men's Shoes</a></li>
                        <li><a class="text-decoration-none" href="#">Women's Shoes</a></li>
                        <li><a class="text-decoration-none" href="#">Popular Dress</a></li>
                        <li><a class="text-decoration-none" href="#">Gym Accessories</a></li>
                        <li><a class="text-decoration-none" href="#">Sport Shoes</a></li>
                    </ul>
                </div>

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Further Info</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="#">Home</a></li>
                        <li><a class="text-decoration-none" href="#">About Us</a></li>
                        <li><a class="text-decoration-none" href="#">Shop Locations</a></li>
                        <li><a class="text-decoration-none" href="#">FAQs</a></li>
                        <li><a class="text-decoration-none" href="#">Contact</a></li>
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
                           &copy; 2021 CAST
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
    <script>
    // html dom 이 다 로딩된 후 실행된다.
    $(document).ready(function(){
        // menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
        $(".menu>a").click(function(){
            var submenu = $(this).next("ul");
 
            // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
            if( submenu.is(":visible") ){
                submenu.slideUp();
            }else{
                submenu.slideDown();
            }
        });
      if("${searchKeyword}" !="") {
    	  console.log('${searchKeyword}');
    	  $("#searchKeywordBtn").append('<input type="hidden" name="searchKeyword" value="${searchKeyword}">');
      }
    });
</script>
 <script>
 $(document).ready(function(){
		$('#shopCategory').val("<c:out value='${shopCategory}'/>").prop("selected",true);
	});
 
 $(function() {

	    $("#shopCategory").change(function() {

	        var v = $("#shopCategory").val();
	       
	       $('#shopCategoryForm').submit();
	    });

	});
 
// 해시태그 클릭시 검색에 적용
$(document).on("click", "button[name='searchKeyword']", function () {
	console.log($(this).val());
	$('#searchKeyword').val($(this).val());
	console.log($('#searchKeyword').val());
	$('#searchKeywordForm').submit();
});

//해시태그 클릭시 검색에 적용
$(document).on("click", "button[name='searchKeyword']", function () {
	// console.log($(this).val());
	$('#searchKeyword').val($(this).val());
	// console.log($('#searchKeyword').val());
	$('#searchKeywordForm').submit();
});

//중복된 관심상품 등록시
$(document).ready(function(){
	
	$('[name="duplWishListBtn"]').click(function(){
		alert('이미 등록한 관심상품입니다.');
		location.href = "${pageContext.request.contextPath}/shop";
	});
});
// 체험
	// 등록되지 않은 관심상품 등록시
	$(document).ready(function(){
		
		$('[name="ExpAddWishListBtn"]').click(function(){
			alert('해당 체험을 관심상품으로 등록했습니다.');
			location.href = "${pageContext.request.contextPath}/shop";
		});
	});
	// 관심상품 테이블이 비워있거나
	// 로그인을 하지 않은 상태로 관심상품 등록시
	$(document).ready(function(){
		
		$('[name="ExpEmpWishListBtn"]').click(function(){
			if(${loginCustomerId == null}) {
				alert('로그인 후 이용해주시기 바랍니다.');
			} else {
				alert('해당 체험을 관심상품으로 등록했습니다.');
				location.href = "${pageContext.request.contextPath}/shop";
			}
		});
	});
// 숙소
	// 등록되지 않은 관심상품 등록시
	$(document).ready(function(){
		
		$('[name="RoomAddWishListBtn"]').click(function(){
			alert('해당 숙소를 관심상품으로 등록했습니다.');
			location.href = "${pageContext.request.contextPath}/shop";
		});
	});
	// 관심상품 테이블이 비워있거나
	// 로그인을 하지 않은 상태로 관심상품 등록시
	$(document).ready(function(){
		
		$('[name="RoomEmpWishListBtn"]').click(function(){
			if(${loginCustomerId == null}) {
				alert('로그인 후 이용해주시기 바랍니다.');
			} else {
				alert('해당 숙소를 관심상품으로 등록했습니다.');
			}
		});
	});
</script>
</body>

</html>
