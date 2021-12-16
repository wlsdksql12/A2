<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Q&A상세보기</title>
    <!-- HTML5 Shim and Respond.js IE11 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 11]>
    	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="description" content="" />
    <meta name="keywords" content="">
    <meta name="author" content="Phoenixcoded" />
    <!-- Favicon icon -->
    <link rel="icon" href="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/favicon.ico" type="image/x-icon">
    <!-- vendor css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/css/style.css">
    
</head>
<body class="">
	<!-- [ Pre-loader ] start -->
	<div class="loader-bg">
		<div class="loader-track">
			<div class="loader-fill"></div>
		</div>
	</div>
	<!-- [ Pre-loader ] End -->
	<!-- [ navigation menu ] start -->
	<nav class="pcoded-navbar menu-light ">
		<div class="navbar-wrapper  ">
			<div class="navbar-content scroll-div " >
				
				<div class="">
					<div class="main-menu-header">
						<img class="img-radius" src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/user/avatar-2.jpg" alt="User-Profile-Image">
						<div class="user-details">
							<div id="more-details">${loginCustomerId}<i class="fa fa-caret-down"></i></div>
						</div>
					</div>
					<div class="collapse" id="nav-user-link">
						<ul class="list-unstyled">
							<li class="list-group-item"><a href="/myinfo?customerId=${loginCustomerId}"><i class="feather icon-user m-r-5"></i>내 정보</a></li>
							<li class="list-group-item"><a href="/setting?customerId=${loginCustomerId}"><i class="feather icon-settings m-r-5"></i>Settings</a></li>
							<li class="list-group-item"><a href="/logOut"><i class="feather icon-log-out m-r-5"></i>Logout</a></li>
						</ul>
					</div>
				</div>
				
				<ul class="nav pcoded-inner-navbar ">
					<li class="nav-item pcoded-menu-caption">
					    <label>Navigation</label>
					</li>
					<li class="nav-item">
					    <a href="/customerIndex?customerId=${loginCustomerId}&currentPage=1" class="nav-link "><span class="pcoded-micon"><i class="feather icon-home"></i></span><span class="pcoded-mtext">Dashboard</span></a>
					</li>
					<li class="nav-item pcoded-hasmenu">
					    <a href="#!" class="nav-link "><span class="pcoded-micon"><i class="feather icon-layout"></i></span><span class="pcoded-mtext">관심상품</span></a>
					    <ul class="pcoded-submenu">
					        <li><a href="layout-vertical.html" target="_blank">체험 관심상품</a></li>
					        <li><a href="layout-horizontal.html" target="_blank">숙소 관심상품</a></li>
					    </ul>
					</li>
					<li class="nav-item pcoded-menu-caption">
					    <label>UI Element</label>
					</li>
					<li class="nav-item pcoded-hasmenu">
					    <a href="#!" class="nav-link "><span class="pcoded-micon"><i class="feather icon-box"></i></span><span class="pcoded-mtext">Basic</span></a>
					    <ul class="pcoded-submenu">
					        <li><a href="bc_alert.html">Alert</a></li>
					        <li><a href="bc_button.html">Button</a></li>
					        <li><a href="bc_badges.html">Badges</a></li>
					        <li><a href="bc_breadcrumb-pagination.html">Breadcrumb & paggination</a></li>
					        <li><a href="bc_card.html">Cards</a></li>
					        <li><a href="bc_collapse.html">Collapse</a></li>
					        <li><a href="bc_carousel.html">Carousel</a></li>
					        <li><a href="bc_grid.html">Grid system</a></li>
					        <li><a href="bc_progress.html">Progress</a></li>
					        <li><a href="bc_modal.html">Modal</a></li>
					        <li><a href="bc_spinner.html">Spinner</a></li>
					        <li><a href="bc_tabs.html">Tabs & pills</a></li>
					        <li><a href="bc_typography.html">Typography</a></li>
					        <li><a href="bc_tooltip-popover.html">Tooltip & popovers</a></li>
					        <li><a href="bc_toasts.html">Toasts</a></li>
					        <li><a href="bc_extra.html">Other</a></li>
					    </ul>
					</li>
					<li class="nav-item pcoded-menu-caption">
					    <label>QNA</label>
					</li>
					<li class="nav-item">
					    <a href="/qnaList?customerId=${loginCustomerId}&currentPage=1" class="nav-link "><span class="pcoded-micon"><i class="feather icon-file-text"></i></span><span class="pcoded-mtext">Qna</span></a>
					</li>
					<li class="nav-item pcoded-menu-caption">
					    <label>Chart & Maps</label>
					</li>
					<li class="nav-item">
					    <a href="chart-apex.html" class="nav-link "><span class="pcoded-micon"><i class="feather icon-pie-chart"></i></span><span class="pcoded-mtext">Chart</span></a>
					</li>
					<li class="nav-item">
					    <a href="map-google.html" class="nav-link "><span class="pcoded-micon"><i class="feather icon-map"></i></span><span class="pcoded-mtext">Maps</span></a>
					</li>
					<li class="nav-item pcoded-menu-caption">
					    <label>Pages</label>
					</li>
					<li class="nav-item pcoded-hasmenu">
					    <a href="#!" class="nav-link "><span class="pcoded-micon"><i class="feather icon-lock"></i></span><span class="pcoded-mtext">Authentication</span></a>
					    <ul class="pcoded-submenu">
					        <li><a href="auth-signup.html" target="_blank">Sign up</a></li>
					        <li><a href="auth-signin.html" target="_blank">Sign in</a></li>
					    </ul>
					</li>
					<li class="nav-item"><a href="sample-page.html" class="nav-link "><span class="pcoded-micon"><i class="feather icon-sidebar"></i></span><span class="pcoded-mtext">Sample page</span></a></li>

				</ul>
				
				<div class="card text-center">
					<div class="card-block">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						<i class="feather icon-sunset f-40"></i>
						<h6 class="mt-3">Download Pro</h6>
						<p>Getting more features with pro version</p>
						<a href="https://1.envato.market/qG0m5" target="_blank" class="btn btn-primary btn-sm text-white m-0">Upgrade Now</a>
					</div>
				</div>
				
			</div>
		</div>
	</nav>
	<!-- [ navigation menu ] end -->
	<!-- [ Header ] start -->
	<header class="navbar pcoded-header navbar-expand-lg navbar-light header-blue">
		
			
				<div class="m-header">
					<a class="mobile-menu" id="mobile-collapse" href="#!"><span></span></a>
					<a href="#!" class="b-brand">
						<!-- ========   change your logo hear   ============ -->
						<img src="${pageContext.request.contextPath}/resources/assets/dist/assets/images/logo.png" alt="" class="logo">
						<img src="${pageContext.request.contextPath}/resources/assets/dist/assets/images/logo-icon.png" alt="" class="logo-thumb">
					</a>
					<a href="#!" class="mob-toggler">
						<i class="feather icon-more-vertical"></i>
					</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item">
							<a href="#!" class="pop-search"><i class="feather icon-search"></i></a>
							<div class="search-bar">
								<input type="text" class="form-control border-0 shadow-none" placeholder="Search hear">
								<button type="button" class="close" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
						</li>
					</ul>
					<ul class="navbar-nav ml-auto">
						<li>
							<div class="dropdown">
								<a class="dropdown-toggle" href="#" data-toggle="dropdown"><i class="icon feather icon-bell"></i></a>
								<div class="dropdown-menu dropdown-menu-right notification">
									<div class="noti-head">
										<h6 class="d-inline-block m-b-0">알람</h6>
										<div class="float-right">
											
											<a href="#!">clear all</a>
										</div>
									</div>
											<p class="m-b-0">NEW</p>
										<br>
										<c:forEach items="${list}"  var="qna">
											<a href="/qnaListOne?customerId=${loginCustomerId}&qnaId=${qna.qnaId}">
											${qna.qnaId}번,
											${qna.qnaTitle}
											제목에 헤당하는 QNA 게시글에 답글이 달렸습니다.
											</a>
											
											<br>
										</c:forEach>
									<div class="noti-footer">
										<a href="#!">show all</a>
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="dropdown drp-user">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<i class="feather icon-user"></i>
								</a>
								<div class="dropdown-menu dropdown-menu-right profile-notification">
									<div class="pro-head">
										<img src="${pageContext.request.contextPath}/resources/assets/dist/assets/images/user/avatar-1.jpg" class="img-radius" alt="User-Profile-Image">
										<span>John Doe</span>
										<a href="auth-signin.html" class="dud-logout" title="Logout">
											<i class="feather icon-log-out"></i>
										</a>
									</div>
									<ul class="pro-body">
										<li><a href="user-profile.html" class="dropdown-item"><i class="feather icon-user"></i> Profile</a></li>
										<li><a href="email_inbox.html" class="dropdown-item"><i class="feather icon-mail"></i> My Messages</a></li>
										<li><a href="auth-signin.html" class="dropdown-item"><i class="feather icon-lock"></i> Lock Screen</a></li>
									</ul>
								</div>
							</div>
						</li>
					</ul>
				</div>
	</header>
	<!-- [ Header ] end -->



	<!-- 주 내용 -->
<div class="pcoded-main-container">
		<div class="pcoded-content">
			<!-- [ breadcrumb ] start -->
			<div class="page-header">
				<div class="page-block">
					<div class="row align-items-center">
						<div class="col-md-12">
							<div class="page-header-title">
								<h3 style="color: white;" class="m-b-10">Q&A</h3>
							</div>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="/index"><i
										class="feather icon-home"></i></a></li>
								<li class="breadcrumb-item"><a href="/index">go to
										MainMenu</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
	<!-- 윗화면내용 end -->
	<!-- 메인컨텐츠 start -->
			<div class="row">
				<div class="col-lg-12 col-md-24">
					<!-- support-section start -->
					<div class="row">
						<div class="col-sm-12">
							<div class="card support-bar overflow-hidden">
								<div class="card-body pb-0">
									<h2 class="m-0">Q&A상세보기</h2>
									<span class="text-c-blue"></span>
									<p class="mb-3 mt-3"></p>
								</div>
								<div class="container-fluid">
									
									<div style="margin-left: 1660px">
										<c:if test="${loginCustomerId == customerId}">
												<a href="/updateQna?qnaId=${qnaId}&customerId=${customerId}&currentPage=${currentPage}" id="insertBtn" class="btn btn-outline-success">수정</a>
												<a href="/maindeleteQna?qnaId=${qnaId}&customerId=${loginCustomerId}" id="insertBtn" class="btn btn-outline-success">삭제</a>
										</c:if>
									</div>
									
									<table class="table table-bordered">
										<tr style="text-align: center" class="table-primary">
											<th width="80">번호</th>
											<th width="120">카테고리</th>
											<th width="380">제목</th>
											<th width="380">내용</th>
											<th width="110">작성자</th>
											<th width="150">작성날짜</th>
											<th width="150">수정날짜</th>
										</tr>
										<tr style="text-align: center" height="70px">
											<td>${qnaId}</td>
											<td>${qnaCategory}</td>
											<td>${qnaTitle}</td>
											<td>${qnaContent}</td>
											<td>${customerId}</td>
											<td>${createDate.substring(0,10)}</td>
											<td>${updateDate.substring(0,10)}</td>
										</tr>
									</table>
									<div style="text-align: right;">
										<div>
											<c:if test="${loginAdminId != null}">
												<c:if test="${qnaCommentContent  == null}">
													<a href="/admin/qnaComment?qnaId=${qnaId}&customerId=${customerId}" id="insertBtn" class="btn btn-outline-success">Qna 답변달기</a>
												</c:if>
											</c:if>
										</div>
										<input class="btn btn-outline-success" type="button" value="이전페이지" onclick="history.back(-1)">
									</div>
									<h2>Comment</h2>
									<table class="table table-bordered">
										<tr>
											<td>${qnaCommentContent}</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

			<!-- 메인컨텐츠 end -->
			<footer class="my-3 text-center text-small">
				<p class="mb-1">&copy; 2021 CAST</p>
			</footer>
    <!-- Required Js -->
    <script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/vendor-all.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/plugins/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/ripple.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/pcoded.min.js"></script>

<!-- Apex Chart -->
<script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/plugins/apexcharts.min.js"></script>


<!-- custom-chart js -->
<script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/pages/dashboard-main.js"></script>
</body>

</html>