<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   <%@ include file="ceoBase.jsp"%>
   <br>
   <div class="bg-white">
      <div class="content-wrapper bg-white">
         <div class="row">
            <div class="col-md-3 grid-margin stretch-card">
                 <div class="card">
                   <div class="card-body">
                     <p class="card-title text-md-center text-xl-left">Sales</p>
                     <div class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
                       <h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">34040</h3>
                       <i class="ti-calendar icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
                     </div>  
                     <p class="mb-0 mt-2 text-danger">0.12% <span class="text-black ml-1"><small>(30 days)</small></span></p>
                   </div>
                 </div>
               </div>
               <div class="col-md-3 grid-margin stretch-card">
                 <div class="card">
                   <div class="card-body">
                     <p class="card-title text-md-center text-xl-left">Sales</p>
                     <div class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
                       <h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">34040</h3>
                       <i class="ti-calendar icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
                     </div>  
                     <p class="mb-0 mt-2 text-danger">0.12% <span class="text-black ml-1"><small>(30 days)</small></span></p>
                   </div>
                 </div>
               </div>
               <div class="col-md-3 grid-margin stretch-card">
                 <div class="card">
                   <div class="card-body">
                     <p class="card-title text-md-center text-xl-left">Sales</p>
                     <div class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
                       <h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">34040</h3>
                       <i class="ti-calendar icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
                     </div>  
                     <p class="mb-0 mt-2 text-danger">0.12% <span class="text-black ml-1"><small>(30 days)</small></span></p>
                   </div>
                 </div>
               </div>
               <div class="col-md-3 grid-margin stretch-card">
                 <div class="card">
                   <div class="card-body">
                     <p class="card-title text-md-center text-xl-left">Sales</p>
                     <div class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
                       <h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">34040</h3>
                       <i class="ti-calendar icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
                     </div>  
                     <p class="mb-0 mt-2 text-danger">0.12% <span class="text-black ml-1"><small>(30 days)</small></span></p>
                   </div>
                 </div>
               </div>
            <div class="col-lg-6 grid-margin stretch-card">
               <div class="card">
                  <div class="card-body">
                     <h4 class="card-title">내 체험 목록</h4>
                     <div class="table-responsive">
                        <table class="table">
                           <thead>
                              <tr>
                                 <th>체험이름</th>
                                 <th>가격</th>
                                 <th>작성날짜</th>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach items="${experienceList}" var="experience">
                                 <tr>
                                    <td>${experience.experienceName}</td>
                                    <td>${experience.experiencePrice}</td>
                                    <td>${experience.createDate}</td>
                                 </tr>
                              </c:forEach>
                           </tbody>
                        </table>
                     </div>
                  </div>
               </div>
            </div>
            <div class="col-lg-6 grid-margin stretch-card">
               <div class="card">
                  <div class="card-body">
                     <h4 class="card-title">내 호텔 목록</h4>
                     <div class="table-responsive">
                        <table class="table">
                           <thead>
                              <tr>
                                 <th>호텔 이름</th>
                                 <th>가격</th>
                                 <th>작성날짜</th>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach items="${experienceList}" var="experience">
                                 <tr>
                                    <td>${experience.experienceName}</td>
                                    <td>${experience.ceoId}</td>
                                    <td>${experience.createDate}</td>
                                 </tr>
                              </c:forEach>
                           </tbody>
                        </table>
                     </div>
                  </div>
               </div>
            </div>
            <div class="col-lg-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">수익</h4>
                  <canvas id="areaChart"></canvas>
                </div>
              </div>
            </div>
         </div>
      </div>
   </div>
</body>
<!-- Plugin js for this page-->
  <script src="${pageContext.request.contextPath}/resources/ceo_template/pages/charts/chart.js/Chart.min.js"></script>
</html>
