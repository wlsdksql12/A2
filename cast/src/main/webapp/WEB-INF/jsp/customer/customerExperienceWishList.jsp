<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Q&A목록</title>
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
			<div class="navbar-content scroll-div ">

				<div class="">
					<div class="main-menu-header">
						<img class="img-radius"
							src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/user/avatar-2.jpg"
							alt="User-Profile-Image">
						<div class="user-details">
							<div id="more-details">${loginCustomerId}<i
									class="fa fa-caret-down"></i>
							</div>
						</div>
					</div>
					<div class="collapse" id="nav-user-link">
						<ul class="list-unstyled">
							<li class="list-group-item"><a
								href="/myinfo?customerId=${loginCustomerId}"><i
									class="feather icon-user m-r-5"></i>내 정보</a></li>
							<li class="list-group-item"><a
								href="/setting?customerId=${loginCustomerId}"><i
									class="feather icon-settings m-r-5"></i>Settings</a></li>
							<li class="list-group-item"><a href="/logOut"><i
									class="feather icon-log-out m-r-5"></i>Logout</a></li>
						</ul>
					</div>
				</div>

				<ul class="nav pcoded-inner-navbar ">
					<li class="nav-item pcoded-menu-caption"><label>Navigation</label>
					</li>
					<li class="nav-item"><a
						href="/customer/customerIndex?customerId=${loginCustomerId}&currentPage=1"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-home"></i></span><span class="pcoded-mtext">고객페이지</span></a>
					</li>
					<li class="nav-item pcoded-menu-caption"><label>관심상품 목록</label>
					</li>
					<li class="nav-item pcoded-hasmenu"><a href="#!"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-layout"></i></span><span class="pcoded-mtext">관심상품</span></a>
						<ul class="pcoded-submenu">
							<li><a href="layout-vertical.html">체험
									관심상품</a></li>
							<li><a href="layout-horizontal.html">숙소
									관심상품</a></li>
						</ul></li>
					<li class="nav-item pcoded-menu-caption"><label>결제목록</label></li>
					<li class="nav-item pcoded-hasmenu"><a href="#!"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-monitor"></i></span><span class="pcoded-mtext">결제</span></a>
						<ul class="pcoded-submenu">
							<li><a href="/CustomerOrderList">상품예약
									</a></li>
							<li><a href="/CustomerPaymentList">결제내역
									</a></li>
							<li><a href="layout-horizontal.html">상품후기
									</a></li>
						</ul>
					</li>
					<li class="nav-item pcoded-menu-caption"><label>Q&A</label></li>
					<li class="nav-item"><a
						href="/qnaList?customerId=${loginCustomerId}&currentPage=1"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-file-text"></i></span><span class="pcoded-mtext">Q&A목록</span></a>
					</li>
					<li class="nav-item pcoded-menu-caption"><label>추천댓글</label></li>
					<li class="nav-item"><a href="/customerExperienceSelectCommentList"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-clock"></i></span><span class="pcoded-mtext">체험추천댓글</span></a>
					</li>
					<li class="nav-item"><a href="/customerRoomSelectCommentList"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-clock"></i></span><span class="pcoded-mtext">숙소추천댓글</span></a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- [ navigation menu ] end -->
	<!-- [ Header ] start -->
	<header
		class="navbar pcoded-header navbar-expand-lg navbar-light header-blue">


		<div class="m-header">
			<a class="mobile-menu" id="mobile-collapse" href="#!"><span></span></a>
			<a href="#!" class="b-brand"> <!-- ========   change your logo hear   ============ -->
				<img
				src="${pageContext.request.contextPath}/resources/assets/dist/assets/images/logo.png"
				alt="" class="logo"> <img
				src="${pageContext.request.contextPath}/resources/assets/dist/assets/images/logo-icon.png"
				alt="" class="logo-thumb">
			</a> <a href="#!" class="mob-toggler"> <i
				class="feather icon-more-vertical"></i>
			</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a href="#!" class="pop-search"><i
						class="feather icon-search"></i></a>
					<div class="search-bar">
						<input type="text" class="form-control border-0 shadow-none"
							placeholder="Search hear">
						<button type="button" class="close" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li>
					<div class="dropdown">
						<a class="dropdown-toggle" href="#" data-toggle="dropdown"><i
							class="icon feather icon-bell"></i></a>
						<div class="dropdown-menu dropdown-menu-right notification">
							<div class="noti-head">
								<h6 class="d-inline-block m-b-0">알람</h6>
								<div class="float-right">

									<a href="#!">clear all</a>
								</div>
							</div>
							<br>
							<h6 class="m-b-0">최신 Q&A 답변</h6>
							<br>
							<c:forEach items="${list}" var="qna">
							<div class="row-fluid" style="width: 350px; height: 50px; margin-left: 3px;">
								<i class="feather icon-bell"></i>&nbsp;
								<a href="/customer/qnaListOne?customerId=${loginCustomerId}&qnaId=${qna.qnaId}">
									${qna.qnaTitle} 제목에 해당되는 Q&A에 답글이 달렸습니다. </a>
									
								<hr>
							</div>
							</c:forEach>

							<div class="noti-footer">
								<a href="#!">show all</a>
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="dropdown drp-user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i
							class="feather icon-user"></i>
						</a>
						<div
							class="dropdown-menu dropdown-menu-right profile-notification">
							<div class="pro-head">
								<span>${loginCustomerId }</span> <a href="/logOut" class="dud-logout"
									title="Logout"> <i class="feather icon-log-out"></i>
								</a>
							</div>
							<ul class="pro-body">
								<li><a href="/myinfo?customerId=${loginCustomerId}" class="dropdown-item"><i
										class="feather icon-user"></i> 내정보</a></li>
								<li><a href="/qnaList?customerId=${loginCustomerId}&currentPage=1" class="dropdown-item"><i
										class="feather icon-file-text"></i> Q&A</a></li>
								<li><a href="/CustomerOrderList" class="dropdown-item"><i
										class="feather icon-monitor"></i> 예약정보</a></li>
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
								<h3 style="color: white;" class="m-b-10">추천댓글</h3>
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
									<h2 class="m-0">체험 관심 상품</h2>
									<span class="text-c-blue"></span>
									<p class="mb-3 mt-3"></p>
								</div>
								<div class="card-body p-0">
									<div class="table-responsive">
										<table style="text-align: center;" class="table table-bordered">
											<thead>
												<tr>
													<th>
														<div class="chk-option">
													</div> 체험 이름
													</th>
													<th>체험 내용</th>
													<th>체험 가격</th>
													<th>체험 시작일</th>
													<th>체험 종료일</th>
													<th>체험 최대 인원 수 </th>
													<th>createDate</th>
													<th>updateDate</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${wishList}" var="wishList">
													<tr>
														<td>
														${wishList.experience.experienceName}
														</td>
														<td>${wishList.experience.experienceContent}</td>
														<td>${wishList.experience.experiencePrice}</td>
														<td>${wishList.experience.experienceStartdate}</td>
														<td>${wishList.experience.experienceEnddate}</td>
														<td>${wishList.experience.experiencePerson}</td>
														<td>${wishList.createDate}</td>
														<td>${wishList.updateDate}</td>
														
														</tr>
												</c:forEach>
											</tbody>
										</table>
										<div style="text-align: center;" class="table container mt-3">
											<c:if test="${currentPage > 1}">
												<a
													href="/customerExperienceWishList?customerId=${loginCustomerId}&currentPage=${currentPage-1}">이전</a>
											</c:if>
											<c:if test="${currentPage < lastPage}">
												<a
													href="/customerExperienceWishList?customerId=${loginCustomerId}&currentPage=${currentPage+1}">다음</a>
											</c:if>
										</div>
									</div>
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