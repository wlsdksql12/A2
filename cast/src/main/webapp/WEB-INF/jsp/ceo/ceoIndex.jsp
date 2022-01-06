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
                     <p class="card-title text-md-center text-xl-left">체험 좋아요 개수</p>
                     <div class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
                       <h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">${expWishList}</h3>
                       <i class="ti-heart icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
                     </div>  
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
                     <p class="card-title text-md-center text-xl-left">호텔 좋아요 개수</p>
                     <div class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
                       <h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">34040</h3>
                       <i class="ti-heart icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
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
                                 <th>작성날짜</th>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach items="${hotelList}" var="hotel">
                                 <tr>
                                    <td>${hotel.hotelName}</td>
                                    <td>${hotel.createDate}</td>
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
                  <h4 class="card-title">체험 수익</h4>
                  <div style="display:none">
                     <button id="btnOut">월별 체험결제</button>
                  </div>
      
                  <!--  월별 체험 결제 차트 -->   
                  <div class="col-sm-12">
                      <div class="card">
                          <canvas id="myChart"></canvas>
                        </div>
                     </div>
                </div>
              </div>
            </div>
            <div class="col-lg-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">수익</h4>
                  <div style="display:none">
                     <button id="btnOut2">월별 호텔결제</button>
                  </div>
                     <div class="col-sm-12">
                      <div class="card">
                          <canvas id="myChart2"></canvas>
                        </div>
            </div>
              </div>
            </div>
         </div>
      </div>
   </div>
</body>
<!-- Plugin js for this page-->
<script src="${pageContext.request.contextPath}/resources/ceo_template/pages/charts/chart.js/Chart.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js"></script>
    <script>
   let today = new Date();
   let year = today.getFullYear(); 
   console.log(year);
   
   
   let ctx = document.getElementById('myChart').getContext('2d');
   let myChart = new Chart(ctx, {
       type: 'bar',
       data: {
           labels: [],
           datasets: [{
               label: '',
               data: [],
               backgroundColor: [],
               borderColor: [],
               borderWidth: 1
           }]
       },
       options: {
           scales: {
               y: {
                   beginAtZero: true
               }
           }
       }
   });
   $(document).ready(function(){
      $('#btnOut').trigger('click');
      $('#btnOut2').trigger('click');
     
   });
   $('#btnOut').click(function(){
         
         
         $.ajax({
            type:'get',
            url:'${pageContext.request.contextPath}/ceo/ExperienceMonth?year='+year,
            success:function(json){
               console.log(json)
               // json변수값 -> labels와 data로 가공
               let myLabels = ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'];
               let myData = [];
               myData.push(json.january);
               myData.push(json.february);
               myData.push(json.march);
               myData.push(json.april);
               myData.push(json.may);
               myData.push(json.june);
               myData.push(json.july);
               myData.push(json.august);
               myData.push(json.september);
               myData.push(json.october);
               myData.push(json.november);
               myData.push(json.december);
               
               myChart.data.labels = myLabels;
               myChart.data.datasets[0].label = '체험 결제금액('+year+')';
               myChart.data.datasets[0].data = myData;
               myChart.data.datasets[0].backgroundColor = [
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)',
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'
                  ];
               myChart.data.datasets[0].boarderColor = [
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)',
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)'
                  ];
               
               myChart.update();
            }
         });
      });
   
   
   
   
   let ctx2 = document.getElementById('myChart2').getContext('2d');
   let myChart2 = new Chart(ctx2, {
       type: 'bar',
       data: {
           labels: [],
           datasets: [{
               label: '',
               data: [],
               backgroundColor: [],
               borderColor: [],
               borderWidth: 1
           }]
       },
       options: {
           scales: {
               y: {
                   beginAtZero: true
               }
           }
       }
   });
   $('#btnOut2').click(function(){
         
         
         $.ajax({
            type:'get',
            url:'${pageContext.request.contextPath}/getHotelTotalInOfMonthByYear?year='+year+'&customerId=${customerId}',
            success:function(json){
               console.log(json)
               // json변수값 -> labels와 data로 가공
               let myLabels = ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'];
               let myData2 = [];
               myData2.push(json.january);
               myData2.push(json.february);
               myData2.push(json.march);
               myData2.push(json.april);
               myData2.push(json.may);
               myData2.push(json.june);
               myData2.push(json.july);
               myData2.push(json.august);
               myData2.push(json.september);
               myData2.push(json.october);
               myData2.push(json.november);
               myData2.push(json.december);
               
               myChart2.data.labels = myLabels;
               myChart2.data.datasets[0].label = '호텔 결제금액('+year+')';
               myChart2.data.datasets[0].data = myData2;
               myChart2.data.datasets[0].backgroundColor = [
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)',
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'
                  ];
               myChart2.data.datasets[0].boarderColor = [
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)',
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)'
                  ];
               
               myChart2.update();
            }
         });
      });
   </script>
</html>