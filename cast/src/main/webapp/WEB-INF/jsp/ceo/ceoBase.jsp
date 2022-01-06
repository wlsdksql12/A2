<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="${pageContext.request.contextPath}/resources/ceo_template/vendors/base/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <script src="${pageContext.request.contextPath}/resources/ceo_template/vendors/chart.js/Chart.min.js"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="${pageContext.request.contextPath}/resources/ceo_template/js/off-canvas.js"></script>
  <script src="${pageContext.request.contextPath}/resources/ceo_template/js/hoverable-collapse.js"></script>
  <script src="${pageContext.request.contextPath}/resources/ceo_template/js/template.js"></script>
  <script src="${pageContext.request.contextPath}/resources/ceo_template/js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="${pageContext.request.contextPath}/resources/ceo_template/js/dashboard.js"></script>
  <!-- End custom js for this page-->
</head>
<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
        <a class="navbar-brand brand-logo mr-5" href="${pageContext.request.contextPath}/ceo/ceoIndex?ceoId=${loginCeoId}">MYPAGE</a>
        <a class="navbar-brand brand-logo-mini" href="${pageContext.request.contextPath}/ceo/ceoIndex"><img src="${pageContext.request.contextPath}/resources/ceo_template/images/logo-mini.svg" alt="logo"/></a>
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
        <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
          <span class="ti-view-list"></span>
        </button>
        <ul class="navbar-nav mr-lg-2">
          <li class="nav-item nav-search d-none d-lg-block">
          </li>
        </ul>
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item dropdown mr-1">
          <div>
	            <a href="${pageContext.request.contextPath}/index" style="font-weight:bold;" class="nav-link count-indicator">
	              <i class="ti-home"></i>
	            </a>
            </div>
            &emsp;
            <a class="nav-link count-indicator dropdown-toggle d-flex justify-content-center align-items-center" id="expHotelDropdown" href="#" data-toggle="dropdown">
              <i class="ti-clipboard"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="expHotelDropdown">
            	<p class="mb-0 font-weight-normal float-left dropdown-header">Select</p>
            	<a id="stateBtn" href="${pageContext.request.contextPath}/ceo/insertExpAddress?ceoId=${loginCeoId}" class="dropdown-item">
            		<div class="item-content flex-grow">
	                  <h6 class="ellipsis font-weight-normal">Experience</h6>
	                  <p class="font-weight-light small-text text-muted mb-0">
	                  	체험 등록
	                  </p>
                	</div>
            	</a>
            	<a id="stateBtn" href="${pageContext.request.contextPath}/ceo/insertHotelAddress?ceoId=${loginCeoId}" class="dropdown-item">
            		<div class="item-content flex-grow">
	                  <h6 class="ellipsis font-weight-normal">Hotel</h6>
	                  <p class="font-weight-light small-text text-muted mb-0">
	                    호텔 등록
	                  </p>
                	</div>
            	</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
              <i class="ti-bell mx-0"></i>
              <span class="count"></span>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="notificationDropdown">
              <p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
              <a class="dropdown-item">
                <div class="item-thumbnail">
                  <div class="item-icon bg-success">
                    <i class="ti-info-alt mx-0"></i>
                  </div>
                </div>
                <div class="item-content">
                  <h6 class="font-weight-normal">Application Error</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    Just now
                  </p>
                </div>
              </a>
              <a class="dropdown-item">
                <div class="item-thumbnail">
                  <div class="item-icon bg-warning">
                    <i class="ti-settings mx-0"></i>
                  </div>
                </div>
                <div class="item-content">
                  <h6 class="font-weight-normal">Settings</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    Private message
                  </p>
                </div>
              </a>
              <a class="dropdown-item">
                <div class="item-thumbnail">
                  <div class="item-icon bg-info">
                    <i class="ti-user mx-0"></i>
                  </div>
                </div>
                <div class="item-content">
                  <h6 class="font-weight-normal">New user registration</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    2 days ago
                  </p>
                </div>
              </a>
            </div>
          </li>
          <li class="nav-item nav-profile dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
              <img src="${pageContext.request.contextPath}/resources/ceo_template/images/faces/face28.jpg" alt="profile"/>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
              <a class="dropdown-item">
                <i class="ti-settings text-primary"></i>
                 내 정보
              </a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/ceoLogout">
                <i class="ti-power-off text-primary"></i>
                로그아웃
              </a>
            </div>
          </li>
        </ul>
        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="ti-view-list"></span>
        </button>
      </div>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/ceo/ceoIndex?ceoId=${loginCeoId}">
              <i class="ti-shield menu-icon"></i>
              <span class="menu-title" style="font-weight:bold;">사업자 페이지</span>
            </a>
          </li>
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/ceo/selectCeo" class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/charts/chartjs.html">
              <i class="ti-user menu-icon"></i>
              <span class="menu-title" style="font-weight:bold;">내정보</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#selectExpHotel" aria-expanded="false" aria-controls="ui-basic">
              <i class=" menu-icon ti-plus"></i>
              <span class="menu-title" style="font-weight:bold;">사업체 등록</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="selectExpHotel">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item">
                <a id="stateBtn" href="${pageContext.request.contextPath}/ceo/insertExpAddress?ceoId=${loginCeoId}" class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/ui-features/buttons.html" style="font-weight:bold;">체험</a></li>
                <li class="nav-item">
                <a id="stateBtn" href="${pageContext.request.contextPath}/ceo/insertHotelAddress?ceoId=${loginCeoId}" class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/ui-features/typography.html" style="font-weight:bold;">호텔</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic1" aria-expanded="false" aria-controls="ui-basic">
              <i class=" menu-icon ti-clipboard"></i>
              <span class="menu-title" style="font-weight:bold;">사업체 목록</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic1">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item">
                <a id="stateBtn" href="experienceList" class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/ui-features/buttons.html" style="font-weight:bold;">체험</a></li>
                <li class="nav-item">
                <a id="stateBtn" href="hotelList" class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/ui-features/typography.html" style="font-weight:bold;">호텔</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/CeoExperienceChart" class="nav-link">
              <i class="ti-bar-chart-alt menu-icon"></i>
              <span class="menu-title" style="font-weight:bold;">체험 수익</span>
            </a>
          </li>
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/CeoRoomChart" class="nav-link">
              <i class="ti-bar-chart-alt menu-icon"></i>
              <span class="menu-title" style="font-weight:bold;">숙소 수익</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="ti-palette menu-icon"></i>
              <span class="menu-title">UI Elements</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/ui-features/buttons.html">Buttons</a></li>
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/ui-features/typography.html">Typography</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/forms/basic_elements.html">
              <i class="ti-layout-list-post menu-icon"></i>
              <span class="menu-title">Form elements</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/charts/chartjs.html">
              <i class="ti-pie-chart menu-icon"></i>
              <span class="menu-title">Charts</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/tables/basic-table.html">
              <i class="ti-view-list-alt menu-icon"></i>
              <span class="menu-title">Tables</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/icons/themify.html">
              <i class="ti-star menu-icon"></i>
              <span class="menu-title">Icons</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#auth" aria-expanded="false" aria-controls="auth">
              <i class="ti-user menu-icon"></i>
              <span class="menu-title">User Pages</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="auth">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/samples/login.html"> Login </a></li>
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/samples/login-2.html"> Login 2 </a></li>
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/samples/register.html"> Register </a></li>
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/samples/register-2.html"> Register 2 </a></li>
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/resources/ceo_template/pages/samples/lock-screen.html"> Lockscreen </a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
          	<a class="nav-link" href="${pageContext.request.contextPath}/ceoLogout">
          		<i class="ti-power-off menu-icon"></i>
          		<span class="menu-title">Logout</span>
          	</a>
          </li>
        </ul>
      </nav>
      <!-- partial -->
      <div class="main-panel">
</body>
<script>
	// 체험등록, 호텔등록 클릭 시 함수를 발생시켜 가입 요청값에 맞는 이벤트
	$("[id='stateBtn']").click(function(){
		if('${state}' == '요청'){
			swal("요청 중입니다.", "", "warning");
			return false;
		} else if('${state}' == '거절'){
			swal("요청이 거절되었습니다.", "가입을 재요청하십시오.", "error");
			return false;
		}
	});
</script>
</html>

