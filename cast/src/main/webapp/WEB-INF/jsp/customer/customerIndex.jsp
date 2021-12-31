<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
					<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js"></script>
<title>고객페이지</title>
<!-- HTML5 Shim and Respond.js IE11 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 11]>
    	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
<!-- Meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="" />
<meta name="keywords" content="">
<meta name="author" content="Phoenixcoded" />
<!-- Favicon icon -->
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/favicon.ico"
	type="image/x-icon">
<!-- vendor css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/css/style.css">

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
								href="${pageContext.request.contextPath}/myinfo?customerId=${loginCustomerId}"><i
									class="feather icon-user m-r-5"></i>내 정보</a></li>
							<li class="list-group-item"><a
								href="${pageContext.request.contextPath}/setting?customerId=${loginCustomerId}"><i
									class="feather icon-settings m-r-5"></i>Settings</a></li>
							<li class="list-group-item"><a href="${pageContext.request.contextPath}/logOut"><i
									class="feather icon-log-out m-r-5"></i>Logout</a></li>
						</ul>
					</div>
				</div>

				<ul class="nav pcoded-inner-navbar ">
					<li class="nav-item pcoded-menu-caption"><label>Navigation</label>
					</li>
					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/customer/customerIndex?customerId=${loginCustomerId}&currentPage=1"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-home"></i></span><span class="pcoded-mtext">고객페이지</span></a>
					</li>
					<li class="nav-item pcoded-menu-caption"><label>관심상품 목록</label>
					</li>
					<li class="nav-item pcoded-hasmenu"><a href="#!"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-layout"></i></span><span class="pcoded-mtext">관심상품</span></a>
						<ul class="pcoded-submenu">
							<li><a href="${pageContext.request.contextPath}/customerExperienceWishList">체험
									관심상품</a></li>
							<li><a href="${pageContext.request.contextPath}/customerRoomWishList">숙소
									관심상품</a></li>
						</ul></li>
					<li class="nav-item pcoded-menu-caption"><label>결제목록</label></li>
					<li class="nav-item pcoded-hasmenu"><a href="#!"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-monitor"></i></span><span class="pcoded-mtext">결제</span></a>
						<ul class="pcoded-submenu">
							<li><a href="${pageContext.request.contextPath}/CustomerOrderList">상품예약
									</a></li>
							<li><a href="${pageContext.request.contextPath}/CustomerPaymentList">결제내역
									</a></li>
							<li><a href="layout-horizontal.html">상품후기
									</a></li>
						</ul>
					</li>
					<li class="nav-item pcoded-menu-caption"><label>Q&A</label></li>
					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/qnaList?customerId=${loginCustomerId}&currentPage=1"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-file-text"></i></span><span class="pcoded-mtext">Q&A목록</span></a>
					</li>
					<li class="nav-item pcoded-menu-caption"><label>추천댓글</label></li>
					<li class="nav-item"><a href="${pageContext.request.contextPath}/customerExperienceSelectCommentList"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-clock"></i></span><span class="pcoded-mtext">체험추천댓글</span></a>
					</li>
					<li class="nav-item"><a href="${pageContext.request.contextPath}/customerRoomSelectCommentList"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-clock"></i></span><span class="pcoded-mtext">숙소추천댓글</span></a>
					</li>
					
					
						</li>
					<li class="nav-item pcoded-menu-caption"><label>Q&A</label></li>
					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/test?customerId=${loginCustomerId}&currentPage=1"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-file-text"></i></span><span class="pcoded-mtext">test</span></a>
					</li>
					<li class="nav-item pcoded-menu-caption"><label>추천댓글</label></li>
					<li class="nav-item"><a href="${pageContext.request.contextPath}/customerExperienceSelectCommentList"
						class="nav-link "><span class="pcoded-micon"><i
								class="feather icon-clock"></i></span><span class="pcoded-mtext">체험추천댓글</span></a>
					</li>
					<li class="nav-item"><a href="${pageContext.request.contextPath}/customerRoomSelectCommentList"
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
								<a href="${pageContext.request.contextPath}/customer/qnaListOne?customerId=${loginCustomerId}&qnaId=${qna.qnaId}">
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
								<span>${loginCustomerId }</span> <a href="${pageContext.request.contextPath}/logOut" class="dud-logout"
									title="Logout"> <i class="feather icon-log-out"></i>
								</a>
							</div>
							<ul class="pro-body">
								<li><a href="${pageContext.request.contextPath}/myinfo?customerId=${loginCustomerId}" class="dropdown-item"><i
										class="feather icon-user"></i> 내정보</a></li>
								<li><a href="${pageContext.request.contextPath}/qnaList?customerId=${loginCustomerId}&currentPage=1" class="dropdown-item"><i
										class="feather icon-file-text"></i> Q&A</a></li>
								<li><a href="${pageContext.request.contextPath}/CustomerOrderList" class="dropdown-item"><i
										class="feather icon-monitor"></i> 예약정보</a></li>
							</ul>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</header>
	<!-- [ Header ] end -->



	<!-- [ Main Content ] start -->
	<div class="pcoded-main-container">
		<div class="pcoded-content">
			<!-- [ breadcrumb ] start -->
			<div class="page-header">
				<div class="page-block">
					<div class="row align-items-center">
						<div class="col-md-12">
							<div class="page-header-title">
								<h5 class="m-b-10">Dashboard Analytics</h5>
							</div>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index"><i
										class="feather icon-home"></i></a></li>
								<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">go to
										MainMenu</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- [ breadcrumb ] end -->
			<!-- [ Main Content ] start -->
			<div class="row">
				<div class="col-lg-7 col-md-12">
					<!-- support-section start -->
					<div class="row">
	
	
	
						<div style="display:none">
					      <button id="btnOut">월별 체험결제</button>
					   </div>
					   <div style="display:none">
					      <button id="btnOut2">월별 호텔결제</button>
					   </div>
   	
						<!--  월별 체험 결제 차트 -->	
						<div class="col-sm-6">
							 <div>
     							<canvas id="myChart"></canvas>
   							</div>
						

							 <div>
     							<canvas id="myChart2"></canvas>
   							</div>
						</div>

						
					</div>
					<!-- support-section end -->
				</div>
				<div class="col-lg-5 col-md-12">
					<!-- page statustic card start -->
					<div class="row">
						<div class="col-sm-6">
							<div class="card">
								<div class="card-body">
									<div class="row align-items-center">
										<div class="col-8">
											<h4 class="text-c-yellow">${selectPaymentCount}원</h4>
											
											<h6 class="text-muted m-b-0">총 결제금액</h6>
										</div>
										<div class="col-4 text-right">
											<i class="feather icon-credit-card f-28"></i>
										</div>
									</div>
								</div>
								<div class="card-footer bg-c-yellow">
									<div class="row align-items-center">
										<div class="col-9">
											<p class="text-white m-b-0">% change</p>
										</div>
										<div class="col-3 text-right">
											<i class="feather icon-trending-up text-white f-16"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="card">
								<div class="card-body">
									<div class="row align-items-center">
										<div class="col-8">
											<h4 class="text-c-green">${selectOrderCount}</h4>
											<h6 class="text-muted m-b-0">총 예약 수</h6>
										</div>
										<div class="col-4 text-right">
											<i class="feather icon-monitor f-28"></i>
										</div>
									</div>
								</div>
								<div class="card-footer bg-c-green">
									<div class="row align-items-center">
										<div class="col-9">
											<p class="text-white m-b-0">% change</p>
										</div>
										<div class="col-3 text-right">
											<i class="feather icon-trending-up text-white f-16"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="card">
								<div class="card-body">
									<div class="row align-items-center">
										<div class="col-8">
											<h4 class="text-c-red">${selectCount}</h4>
											<h6 class="text-muted m-b-0">추천 댓글 수</h6>
										</div>
										<div class="col-4 text-right">
											<i class="feather icon-clock f-28"></i>
										</div>
									</div>
								</div>
								<div class="card-footer bg-c-red">
									<div class="row align-items-center">
										<div class="col-9">
											<p class="text-white m-b-0">% change</p>
										</div>
										<div class="col-3 text-right">
											<i class="feather icon-trending-down text-white f-16"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="card">
								<div class="card-body">
									<div class="row align-items-center">
										<div class="col-8">
											<h4 class="text-c-blue">500</h4>
											<h6 class="text-muted m-b-0">상품 후기 수</h6>
										</div>
										<div class="col-4 text-right">
											<i class="feather icon-thumbs-up f-28"></i>
										</div>
									</div>
								</div>
								<div class="card-footer bg-c-blue">
									<div class="row align-items-center">
										<div class="col-9">
											<p class="text-white m-b-0">% change</p>
										</div>
										<div class="col-3 text-right">
											<i class="feather icon-trending-down text-white f-16"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- page statustic card end -->
				</div>
				<!-- prject ,team member start -->
			<div class="col-xl-8 col-md-12">
				<div class="card table-card review-card">
						<div class="card-body">
							<div class="card latest-update-card">
								<div class="card-header">
									<h5>업데이트된 상품</h5>
									<div class="card-header-right">
										<div class="btn-group card-option">
											<button type="button" class="btn dropdown-toggle"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<i class="feather icon-more-horizontal"></i>
											</button>
											<ul
												class="list-unstyled card-option dropdown-menu dropdown-menu-right">
												<li class="dropdown-item full-card"><a href="#!"><span><i
															class="feather icon-maximize"></i> maximize</span><span
														style="display: none"><i
															class="feather icon-minimize"></i> Restore</span></a></li>
												<li class="dropdown-item minimize-card"><a href="#!"><span><i
															class="feather icon-minus"></i> collapse</span><span
														style="display: none"><i class="feather icon-plus"></i>
															expand</span></a></li>
												<li class="dropdown-item reload-card"><a href="#!"><i
														class="feather icon-refresh-cw"></i> reload</a></li>
												<li class="dropdown-item close-card"><a href="#!"><i
														class="feather icon-trash"></i> remove</a></li>
											</ul>
										</div>
									</div>
								</div>

								<div class="card-body">
									<div style="width: 45%; display: inline-block;" class="float-left">
									
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>체험 번호</th>
													<th>체험 이름</th>
													<th>체험 등록일</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach items="${experienceList}"  var="list">
												<tr>
													<td>${list.experienceId}</td>
													<td><a href= "${pageContext.request.contextPath}/customerIndex?customerId=${loginCustomerId}&currentPage=1">${list.experienceName}</a></td>
													<td>${list.createDate}</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
										
									</div>
									<div style="width: 45%; display: inline-block;" class="float-right">
										<table class="table table-bordered">
											<thead>
											
												<tr>
													<th>호텔 번호</th>
													<th>호텔 이름</th>
													<th>호텔 등록일</th>
												</tr>
												
											</thead>
											<c:forEach items="${hotelList}"  var="list">
											<tbody>
												<tr>
													<td>${list.hotelId}</td>
													<td> <a href= "${pageContext.request.contextPath}/customerIndex?customerId=${loginCustomerId}&currentPage=1">${list.hotelName}</a></td>
													<td>${list.createDate}</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-4 col-md-12">
					<div class="card chat-card">
						<div class="card-header">
							<h5>Chat</h5>
							<div class="card-header-right">
								<div class="btn-group card-option">
									<button type="button" class="btn dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<i class="feather icon-more-horizontal"></i>
									</button>
									<ul
										class="list-unstyled card-option dropdown-menu dropdown-menu-right">
										<li class="dropdown-item full-card"><a href="#!"><span><i
													class="feather icon-maximize"></i> maximize</span><span
												style="display: none"><i
													class="feather icon-minimize"></i> Restore</span></a></li>
										<li class="dropdown-item minimize-card"><a href="#!"><span><i
													class="feather icon-minus"></i> collapse</span><span
												style="display: none"><i class="feather icon-plus"></i>
													expand</span></a></li>
										<li class="dropdown-item reload-card"><a href="#!"><i
												class="feather icon-refresh-cw"></i> reload</a></li>
										<li class="dropdown-item close-card"><a href="#!"><i
												class="feather icon-trash"></i> remove</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="card-body">
							<div class="row m-b-20 received-chat">
								<div class="col-auto p-r-0">
									<img
										src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/user/avatar-2.jpg"
										alt="user image" class="img-radius wid-40">
								</div>
								<div class="col">
									<div class="msg">
										<p class="m-b-0">Nice to meet you!</p>
									</div>
									<p class="text-muted m-b-0">
										<i class="fa fa-clock-o m-r-10"></i>10:20am
									</p>
								</div>
							</div>
							<div class="row m-b-20 send-chat">
								<div class="col">
									<div class="msg">
										<p class="m-b-0">Nice to meet you!</p>
									</div>
									<p class="text-muted m-b-0">
										<i class="fa fa-clock-o m-r-10"></i>10:20am
									</p>
								</div>
								<div class="col-auto p-l-0">
									<img
										src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/user/avatar-3.jpg"
										alt="user image" class="img-radius wid-40">
								</div>
							</div>
							<div class="row m-b-20 received-chat">
								<div class="col-auto p-r-0">
									<img
										src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/user/avatar-2.jpg"
										alt="user image" class="img-radius wid-40">
								</div>
								<div class="col">
									<div class="msg">
										<p class="m-b-0">Nice to meet you!</p>
										<img
											src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/widget/dashborad-1.jpg"
											alt=""> <img
											src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/widget/dashborad-3.jpg"
											alt="">
									</div>
									<p class="text-muted m-b-0">
										<i class="fa fa-clock-o m-r-10"></i>10:20am
									</p>
								</div>
							</div>
							<div class="form-group m-t-15">
								<label class="floating-label" for="Project">Send message</label>
								<input type="text" name="task-insert" class="form-control"
									id="Project">
								<div class="form-icon">
									<button class="btn btn-primary btn-icon">
										<i class="feather icon-message-circle"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>

					<!-- prject ,team member start -->

					<!-- Latest Customers start -->
	</div>
			<div class="col-lg-12 col-md-12">
					<div class="card table-card">
						<div class="card-header">
							<h5>QNA</h5>
							<div class="card-header-right">
								<div class="btn-group card-option">
									<button type="button" class="btn dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<i class="feather icon-more-horizontal"></i>
									</button>
									<ul
										class="list-unstyled card-option dropdown-menu dropdown-menu-right">
										<li class="dropdown-item full-card"><a href="#!"><span><i
													class="feather icon-maximize"></i> maximize</span><span
												style="display: none"><i
													class="feather icon-minimize"></i> Restore</span></a></li>
										<li class="dropdown-item minimize-card"><a href="#!"><span><i
													class="feather icon-minus"></i> collapse</span><span
												style="display: none"><i class="feather icon-plus"></i>
													expand</span></a></li>
										<li class="dropdown-item reload-card"><a href="#!"><i
												class="feather icon-refresh-cw"></i> reload</a></li>
										<li class="dropdown-item close-card"><a href="#!"><i
												class="feather icon-trash"></i> remove</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="card-body p-0">
							<div class="table-responsive">
								<table class="table table-hover mb-0">
									<thead>
										<tr>
											<th>
												<div class="chk-option">
													<label
														class="check-task custom-control custom-checkbox d-flex justify-content-center done-task">
														<input type="checkbox" class="custom-control-input">
														<span class="custom-control-label"></span>
													</label>
												</div> 제목
											</th>
											<th>작성자</th>
											<th>작성 날짜</th>
											<th class="text-right">비밀글</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${qnaList}" var="qna">

											<tr>
												<td>
													<div class="chk-option">
														<label
															class="check-task custom-control custom-checkbox d-flex justify-content-center done-task">
															<input type="checkbox" class="custom-control-input">
															<span class="custom-control-label"></span>
														</label>
													</div>
													<div class="d-inline-block align-middle">
														<img
															src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/user/avatar-4.jpg"
															alt="user image"
															class="img-radius wid-40 align-top m-r-15">
														<div class="d-inline-block">
															<h6>
																<a
																	href="${pageContext.request.contextPath}/customer/qnaListOne?qnaId=${qna.qnaId}&customerId=${loginCustomerId}&currentPage=${currentPage}">${qna.qnaTitle}</a>
															</h6>
														</div>
													</div>
												</td>
												<td>${qna.customerId}</td>
												<td>${qna.createDate}</td>
												<td class="text-right"><label
													class="badge badge-light-danger">${qna.qnaSecret}</label></td>
											</tr>

										</c:forEach>
									</tbody>
								</table>
								<div class="text-center table container mt-3">
									<c:if test="${currentPage > 1}">
										<a href="${pageContext.request.contextPath}/customer/customerIndex?customerId=${loginCustomerId}&currentPage=${currentPage-1}">이전</a>
									</c:if>
									<c:if test="${currentPage < lastPage}">
										<a href="${pageContext.request.contextPath}/customer/customerIndex?customerId=${loginCustomerId}&currentPage=${currentPage+1}">다음</a>
									</c:if>
								</div>
							</div>
						</div>
					</div>
					
					
					
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
	         url:'${pageContext.request.contextPath}/getTotalInOfMonthByYear?year='+year+'&customerId=${customerId}',
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
					<!-- [ Main Content ] end -->
				</div>
				<!-- [ Main Content ] end -->
				<!-- Warning Section start -->
				<!-- Older IE warning message -->
				<!--[if lt IE 11]>
        <div class="ie-warning">
            <h1>Warning!!</h1>
            <p>You are using an outdated version of Internet Explorer, please upgrade
               <br/>to any of the following web browsers to access this website.
            </p>
            <div class="iew-container">
                <ul class="iew-download">
                    <li>
                        <a href="http://www.google.com/chrome/">
                            <img src="${pageContext.request.contextPath}/resources/assets/dist/assets/images/browser/chrome.png" alt="Chrome">
                            <div>Chrome</div>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.mozilla.org/en-US/firefox/new/">
                            <img src="${pageContext.request.contextPath}/resources/assets/dist/assets/images/browser/firefox.png" alt="Firefox">
                            <div>Firefox</div>
                        </a>
                    </li>
                    <li>
                        <a href="http://www.opera.com">
                            <img src="${pageContext.request.contextPath}/resources/assets/dist/assets/images/browser/opera.png" alt="Opera">
                            <div>Opera</div>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.apple.com/safari/">
                            <img src="${pageContext.request.contextPath}/resources/assets/dist/assets/images/browser/safari.png" alt="Safari">
                            <div>Safari</div>
                        </a>
                    </li>
                    <li>
                        <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">
                            <img src="${pageContext.request.contextPath}/resources/assets/dist/assets/images/browser/ie.png" alt="">
                            <div>IE (11 & above)</div>
                        </a>
                    </li>
                </ul>
            </div>
            <p>Sorry for the inconvenience!</p>
        </div>
    <![endif]-->
				<!-- Warning Section Ends -->

				<!-- Required Js -->
				<script
					src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/vendor-all.min.js"></script>
				<script
					src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/plugins/bootstrap.min.js"></script>
				<script
					src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/ripple.js"></script>
				<script
					src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/pcoded.min.js"></script>

				<!-- Apex Chart -->
				<script
					src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/plugins/apexcharts.min.js"></script>


				<!-- custom-chart js -->
				<script
					src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/pages/dashboard-main.js"></script>
					
</body>

</html>
