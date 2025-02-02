<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="${pageContext.request.contextPath}/resources/admin_template/img/logo/logo.png" rel="icon">
  <title>RuangAdmin - Dashboard</title>
  <link href="${pageContext.request.contextPath}/resources/admin_template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/admin_template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/admin_template/css/ruang-admin.min.css" rel="stylesheet">
</head>

<body id="page-top">
  <div id="wrapper">
  	
  	<!-- adminSidebar include -->
    <%@ include file="adminSidebar.jsp"%>
  	
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
		
		<!-- adminTopbar include -->
		<%@ include file="adminTopbar.jsp"%>
        
        <!-- Container Fluid-->
        <div class="container-fluid" id="container-wrapper" style="width: 1700px">
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page" style="margin-right: 450px">Dashboard</li>
            </ol>
          </div>

          <div class="row mb-3">
            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card h-100">
                <div class="card-body">
                  <div class="row align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-uppercase mb-1">연간 수익</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800"><fmt:formatNumber value="${yearTotalPay}" pattern="#,###"/>원</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-calendar fa-2x text-primary"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- Earnings (Annual) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card h-100">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-uppercase mb-1">총 예약수</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${orderCount}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-shopping-cart fa-2x text-success"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            
             <!-- Pending Requests Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card h-100">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-uppercase mb-1">미답변 Qna</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${newNotQnaComment}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-comments fa-2x text-warning"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
		</div>
		      
		<div class="row mb-3">
            <!-- New User Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card h-100">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-uppercase mb-1">신규 사업자</div>
                      <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${newCeo}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-users fa-2x text-info"></i>
                    </div>
                  </div>
                   <div class="mt-0 mb-0 text-muted text-xs">
                        <i>총</i><span class="mx-2 text-body">${TotalCeo}</span>
                        <span>명의 사업자</span>
                  </div>
                </div>
              </div>
            </div>
            
			<!-- New User Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card h-100">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-uppercase mb-1">신규 여행작가</div>
                      <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${newTraveler}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-users fa-2x text-info"></i>
                    </div>
                  </div>
                  <div class="mt-0 mb-0 text-muted text-xs">
                        <i>총</i><span class="mx-2 text-body">${TotalTraveler}</span>
                        <span>명의 여행작가</span>
                  </div>
                </div>
              </div>
            </div>
            
            <!-- New User Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card h-100">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-uppercase mb-1">신규 회원</div>
                      <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${newCustomer}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-users fa-2x text-info"></i>
                    </div>
                  </div>
                  <div class="mt-0 mb-0 text-muted text-xs">
                        <i>총</i><span class="mx-2 text-body">${TotalCustomer}</span>
                        <span>명의 회원</span>
                  </div>
                </div>
              </div>
            </div>
            
            <!-- Area Chart -->
            <div class="col-xl-9 col-lg-7">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <dvi id="add">
                  </dvi>
                  <!-- 차트 메뉴 시작 -->
                  <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown"
                      aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                      aria-labelledby="dropdownMenuLink">
                      <div class="dropdown-header">Dropdown Header:</div>
                      <ul>
                      	<c:forEach items="${yearList}" var="year">
                      		<li class="nowYear" style="cursor: pointer; list-style:none;" value="${year}">${year}</li>
                      	</c:forEach>
                      </ul>
                      <!-- 
                      <a class="dropdown-item" id="nowYear">2022</a>
                      <a class="dropdown-item" id="preYear">2021</a>
                    	 -->
                    </div>
                  </div>
                  <!-- 차트 메뉴 끝 -->
                </div>
                <div class="card-body">
                  <div class="chart-area">
                    <canvas id="myAreaChart"></canvas>
                  </div>
                </div>
              </div>
			</div>
		</div>             
		</div>
		<!-- Container Fluid-->
		<div class="container-fluid" id="container-wrapper" style="width: 1395px">
		  <div class="row mb-3">
            <!-- Invoice Example -->
            <div class="col-xl-11 col-lg-7 mb-4">
              <div class="card ">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Qna 미답변</h6>
                  <a class="m-0 float-right btn btn-danger btn-sm" href="${pageContext.request.contextPath}/admin/qnaList">Qna More <i
                      class="fas fa-chevron-right"></i></a>
                </div>
                <div class="table-responsive">
                  <table class="table align-items-center table-flush">
                    <thead class="thead-light">
                      <tr style="text-align: center;">
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성 날짜</th>
                        <th>비밀글</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                      	 <c:forEach items="${notQnaCommentList}" var="nqcl">
		                     <tr style="text-align:center">
		                        <td style="text-align: center;"><a href ="${pageContext.request.contextPath}/mainQnaListOne?qnaId=${nqcl.qnaId}">${nqcl.qnaTitle}</a></td>
		                        <td style="text-align: center;">${nqcl.customerId}</td>
		                        <td style="text-align: center;">${fn:substring(nqcl.createDate,0,10)}</td>
		                        <td style="text-align: center;">${nqcl.qnaSecret}</td>
		                     </tr>
                  		</c:forEach>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div class="card-footer"></div>
              </div>
            </div>
           </div>
            <!-- 여행작가 가입 요청 -->
           <div class="row mb-3">
            <div class="col-xl-5 col-lg-5 ">
              <div class="card">
                <div class="card-header py-4 bg-primary d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-light">여행작가 가입 요청</h6>
                </div>
                <div>
                <!-- 여행작가 리스트 시작-->
	               <c:forEach items="${joinTravelerList}" var="joinTraveler">
						<div class="customer-message align-items-center">
							<a class="font-weight-bold" href="${pageContext.request.contextPath}/admin/travelerSelectOne?joinTravelerId=${joinTraveler.joinTravelerId}">
								<div class="text-truncate message-title">${joinTraveler.travelerId}님께서 여행작가 가입 요청했습니다.</div>
								<div class="small text-gray-500 message-time font-weight-bold">${fn:substring(traveler.createDate,0,19)}</div>
							</a>
						</div>
					</c:forEach>	
                  <!-- 여행작가 리스트 끝 -->
                  <div class="card-footer text-center">
                    <a class="m-0 small text-primary card-link" href="${pageContext.request.contextPath}/admin/travelerJoinRequestList?state=요청">View More <i
                        class="fas fa-chevron-right"></i></a>
                  </div>
                </div>
              </div>
            </div>
           <!-- 사업자 가입 요청-->
            <div class="col-xl-5 col-lg-5 " style="margin-left: 110px">
              <div class="card">
                <div class="card-header py-4 bg-primary d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-light">사업자 가입 요청</h6>
                </div>
                <div>
                <!-- 사업자 리스트 시작 -->
                  <c:forEach items="${joinCeoList}" var="joinCeo">
						<div class="customer-message align-items-center">
							<a class="font-weight-bold" href="${pageContext.request.contextPath}/admin/ceoSelectOne?joinCeoId=${joinCeo.joinCeoId}">
								<div class="text-truncate message-title">${joinCeo.ceoId}님께서 사업자 가입 요청했습니다.</div>
								<div class="small text-gray-500 message-time font-weight-bold">${fn:substring(joinCeo.createDate,0,19)}</div>
							</a>
						</div>
					</c:forEach>
					 <!-- 사업자 리스트 끝 -->
                  <div class="card-footer text-center">
                    <a class="m-0 small text-primary card-link" href="${pageContext.request.contextPath}/admin/ceoJoinRequestList?state=요청">View More <i
                        class="fas fa-chevron-right"></i></a>
                  </div>
                </div>
              </div>
            </div>
            </div>
           </div>
          </div>

			<!-- Modal Logout include 로그아웃 클릭 시 나타나는 메시지 창-->
			<%@ include file="adminModalLogout.jsp"%>
        
        </div>
        <!---Container Fluid-->
      </div>
      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>copyright &copy; <script> document.write(new Date().getFullYear()); </script> - developed by
              <b><a href="https://indrijunanda.gitlab.io/" target="_blank">indrijunanda</a></b>
            </span>
          </div>
        </div>

        <div class="container my-auto py-2">
          <div class="copyright text-center my-auto">
            <span>copyright &copy; <script> document.write(new Date().getFullYear()); </script> - distributed by
              <b><a href="https://themewagon.com/" target="_blank">themewagon</a></b>
            </span>
          </div>
        </div>
      </footer>
      <!-- Footer -->
    </div>
  </div>

  <!-- Scroll to top -->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/js/ruang-admin.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/chart.js/Chart.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/js/demo/chart-area-demo.js"></script>  

<script type="text/javascript">
	
	let today = new Date();
	let year = today.getFullYear(); //2022
	let preyear = year-1;
	// Area Chart Example
	var ctx = document.getElementById("myAreaChart");
	var myLineChart = new Chart(ctx, {
	  type: 'bar',
	  data: {	
	    labels: ["1분기", "2분기", "3분기", "4분기"],
	    datasets: [{
	      label: "",
	      barPercentage: 0.5,
	      barTension: 0.3,
	      backgroundColor: ["rgba(255, 192, 203, 0.5)","rgba(185, 206, 172, 0.5)","rgba(150, 75, 0, 0.5)","rgba(78, 155, 223, 0.5)"],
	      borderColor: "rgba(78, 115, 223, 1)",
	      pointRadius: 3,
	      pointBackgroundColor: "rgba(78, 115, 223, 1)",
	      pointBorderColor: "rgba(78, 115, 223, 1)",
	      pointHoverRadius: 3,
	      pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
	      pointHoverBorderColor: "rgba(78, 115, 223, 1)",
	      pointHitRadius: 10,
	      pointBorderWidth: 2,
	      // data: myData,
	    }],
	  },
	  options: {
	    maintainAspectRatio: false,
	    layout: {
	      padding: {
	        left: 10,
	        right: 25,
	        top: 25,
	        bottom: 0
	      }
	    },
	    scales: {
	      xAxes: [{
	        time: {
	          unit: 'date'
	        },
	        gridLines: {
	          display: false,
	          drawBorder: false
	        },
	        ticks: {
	          maxTicksLimit: 12
	        }
	      }],
	      yAxes: [{
	        ticks: {
	          beginAtZero: true,
	          userCallback: function(value, index, values){
	        	  value = value.toString();
	        	  value = value.split(/(?=(?:...)*$)/);
	        	  value = value.join(',');
	        	  return value+"원";
	          },
	        },
	        gridLines: {
	          color: "rgb(234, 236, 244)",
	          zeroLineColor: "rgb(234, 236, 244)",
	          drawBorder: false,
	          borderDash: [2],
	          zeroLineBorderDash: [2]
	        }
	      }],
	    },
	    legend: {
	      display: false
	    },
	    tooltips: {
	      backgroundColor: "rgb(255,255,255)",
	      bodyFontColor: "#858796",
	      titleMarginBottom: 10,
	      titleFontColor: '#6e707e',
	      titleFontSize: 14,
	      borderColor: '#dddfeb',
	      borderWidth: 1,
	      xPadding: 10,	
	      yPadding: 15,
	      displayColors: false,
	      intersect: false,
	      mode: 'index',
	      caretPadding: 10,
	      callbacks: {
	        label: function(tooltipItem, chart) {
	          var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
	          return datasetLabel  + number_format(tooltipItem.yLabel) + '원';
	        }
	      }
	    }
	  }
	});
	
	function chart() {
		let add = '<h6 id="delete" class="m-0 font-weight-bold text-primary">'+year+'년도 분기별 매출표</h6>';
		$('#delete').remove();
		$('#add').prepend(add);
		$.ajax({
	         type:'get',
	         url:'${pageContext.request.contextPath}/admin/getQuarterChart?year='+year,
	         success:function(json){
	            console.log(json)
	            // json변수값 -> labels와 data로 가공
	            let myData = [];
	            myData.push(json.firstQuarter);
	            myData.push(json.secondQuarter);
	            myData.push(json.thirdQuarter);
	            myData.push(json.fourthQuarter);

	            myLineChart.data.datasets[0].data = myData;
	            myLineChart.update();
	         }
	      });
	} 
	
	$(document).ready(function(){
		  chart();
	   });
	
	$('li[class=nowYear]').click(function(){
		year = $(this).val();
		console.log($('#nowYear').val());
		console.log($(this).val());
		
		// year= today.getFullYear(); // 2022
	    chart();
	   });

</script>
</body>
</html>