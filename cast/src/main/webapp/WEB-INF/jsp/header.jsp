<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!-- 최상단 목록 선택 웬만하면 통일 -->
    <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <a class="navbar-brand text-success logo h1 align-self-center" href="index">
                Cast
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="index">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="mainNotice">고객센터</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="mainRoomSelect">여행작가 추천!</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="shop">Shop</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contact">Contact</a>
                        </li>
                    </ul>
               </div>
               <div class="navbar align-self-center d-flex">
                   <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                       <div class="input-group">
                           <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                           <div class="input-group-text">
                               <i class="fa fa-fw fa-search"></i>
                           </div>
                       </div>
                   </div>
                   <a class="nav-icon d-none d-lg-inline" href="#" data-bs-toggle="modal" data-bs-target="#templatemo_search">
                        <i class="fa fa-fw fa-search text-dark mr-2"></i>
                   </a>
                   <a class="nav-icon position-relative text-decoration-none" href="#">
                        <i class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">7</span>
                   </a>
                   <c:choose>
                   <c:when test="${loginCustomerId != null}">
                   <a class="nav-icon position-relative text-decoration-none" href="${pageContext.request.contextPath}/customer/customerIndex?customerId=${loginCustomerId}&currentPage=1">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
                    </a>
             		 </c:when>
               
                  <c:when test="${loginCeoId != null}">
                    <a class="nav-icon position-relative text-decoration-none" href="${pageContext.request.contextPath}/ceo/ceoIndex?ceoId=${loginCeoId}">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
                    </a>
               </c:when>
               
                   <c:when test="${loginTravelerId != null}">
                    <a class="nav-icon position-relative text-decoration-none" href="${pageContext.request.contextPath}/travelerIndex?travelerId=${loginTravelerId}&currentPage=1">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
                    </a>
               </c:when>
            
                      <c:when test="${loginAdminId != null}">
                    <a class="nav-icon position-relative text-decoration-none" href="${pageContext.request.contextPath}/admin/adminIndex">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
                    </a>
               </c:when>
               
               <c:otherwise>
                <a class="nav-icon position-relative text-decoration-none" href="${pageContext.request.contextPath}/loginSelect">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
                    </a>
               </c:otherwise>
               </c:choose>
                </div>
            </div>
        </div>
    </nav>
    <!-- Close Header -->
</body>
</html>
