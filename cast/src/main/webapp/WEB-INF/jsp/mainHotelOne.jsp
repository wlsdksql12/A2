<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cast Shop - Product Listing Page</title>
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
			                		<li><a href="${pageContext.request.contextPath}/shop?themeSmallName=${SmallList.themeSmallName}">${SmallList.themeSmallName}</a></li>
			                		</c:if>
			                		</c:forEach>
			                	</ul>
			                </li>
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
			        </li>
			        <li class="menu">
			            <a>메뉴2<i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i></a>
			            <ul class="hide">
			                <li class="menu">
			                	<a>메뉴2-1<i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i></a>
			                	<ul class="hide">
			                		<li>메뉴2-1-1</li>
			                		<li>메뉴2-1-2</li>
			                		<li><a href="${pageContext.request.contextPath}/addHotelOrder">숙소 주문</a></li>
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
			</div>

<div class="col-lg-9">
    <div class="row">
                    
		<div>
			<div>
				<div class="col-lg-12 grid-margin stretch-card">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title">${hotel.hotelId}번째글 상세보기</h4>
							
							<input type="hidden" class="form-control" name="hotelId" value="${hotel.hotelId}" >
										
							<h3>${hotel.hotelName}</h3>
							<br><hr><br>
							
							<p class="card-description">주소</p>
							<table>
							<tr>
								<td style="font-size:14px">도로명 &nbsp;</td>
								<td>(${hotel.address.postcode})</td>
								<td>${hotel.address.roadAddress} ${hotel.address.extraAddress} ${hotel.address.detailAddress}</td>
							</tr>
							<tr>
								<td colspan="2" style="font-size:14px">지번 &nbsp;</td>
								<td>${hotel.address.jibunAddress}</td>
							</tr>
							</table>
							<br><hr><br>
			
							<p class="card-description">이미지(미구현)</p>
							<h4></h4>
							<br><hr><br>
							 
							<p class="card-description">호텔 소개</p>
							<h4>${hotel.hotelContent}</h4>
							<br><hr><br>
							
							<p class="card-description">숙박 장소 
							</p>
							
							<!-- 방 리스트 -->	
							<table class="table table-bordered">
							<thead>
								<tr>
									<th>객실 이름</th>
									<th>객실 개수</th>
									<th>시작날짜</th>
									<th>종료날짜</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${roomList}" var="list">
							
							<tr>
								<td><a href="${pageContext.request.contextPath}/mainRoomOne?roomId=${list.roomId}">${list.roomName}</a></td>
								<td>${list.roomCount}</td>
								<td>${list.roomStartdate}</td>
								<td>${list.roomEnddate}</td>
							</tr>
							</c:forEach>
							</tbody>
							</table>
							<hr><br>
							
							<!-- 지도자리 -->
							<br> 
							<p class="card-description">방문장소</p>
							<h4></h4>
							<div id="map" style="width:100%;height:500px;"></div>
							
							<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
							<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=736d8d95b9c9321d5c6e6055f1874da1&libraries=services"></script>
							<script>
							var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
						    mapOption = {
						        center: new kakao.maps.LatLng(${hotel.address.lat}, ${hotel.address.lng}), // 지도의 중심좌표
						        level: 2, // 지도의 확대 레벨
						        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
						    }; 
		
							// 지도를 생성한다 
							var map = new kakao.maps.Map(mapContainer, mapOption);
							
							// 지도에 마커를 생성하고 표시한다
							var marker = new kakao.maps.Marker({
							    position: new kakao.maps.LatLng(${hotel.address.lat}, ${hotel.address.lng}), // 마커의 좌표
							    map: map // 마커를 표시할 지도 객체
							});
						    </script>
						    <br>
							<p class="card-description">여행작가 추천</p>
							<hr>
								<a href="${pageContext.request.contextPath}/mainRoomSelect" style="text-align:right;" class="btn btn-outline-success">리스트로 이동</a>
								<a href="${pageContext.request.contextPath}/addHotelOrder" style="text-align:right;" class="btn btn-outline-success">호텔 예약</a>
							<p></p><p></p>
							<div>
								<c:if test="${loginTravelerId != null && state eq '승인'}">
										<a href="${pageContext.request.contextPath}/addRoomSelect?hotelId=${hotel.hotelId}&travelerId=${loginTravelerId}" id="insertBtn" style="text-align:right;" class="btn btn-outline-success">추가</a>
								</c:if>
							</div>
						</div>
						
						
						
					<h4>review</h4>
					
					<div style="text-align: right;">
					<c:if test="${loginCustomerId != null}">
						<a href="${pageContext.request.contextPath}/addHotelReview?hotelId=${hotel.hotelId}&hotelName=${hotel.hotelName}"class="btn btn-outline-success">추가</a>
					</c:if>
					</div>
				<table style="width: 750px; margin-right: auto; margin-left: auto;">
					<c:forEach items="${RoomPaymentReview}"  var="RoomPaymentReview">
						<tr>
							<td>
								${RoomPaymentReview.roomOrder.customerId} · ${RoomPaymentReview.createDate.substring(0,10)}
								<hr>
							</td>
							
							<td rowspan="2" style="text-align: center;">
							<div>
							<c:choose>
							<c:when test="${loginCustomerId == RoomPaymentReview.roomOrder.customerId}">
								<a href="${pageContext.request.contextPath}/">수정</a>
								<!-- <a href="${pageContext.request.contextPath}/deleteExperienceReview?experiencePaymentReviewId=${ExperiencePaymentReview.experiencePaymentReviewId}&experienceId=${experience.experienceId}&experienceName=${experience.experienceName}">삭제</a> -->
							
							</c:when>
								<c:otherwise>
									<div>-</div>
									<div>-</div>
								</c:otherwise>
							</c:choose>
						<c:forEach items="${RoomPaymentReview.roomPaymentReviewImage}" var="roomPaymentReviewImage">
                        <img src="${pageContext.request.contextPath}/upload/${roomPaymentReviewImage.imageName}.${roomPaymentReviewImage.imageExt}" style="width: 100px; height: 100px"/>
                     	</c:forEach>
	
							</td>
						</tr>
						<tr>
							
							<td>${RoomPaymentReview.roomPaymentReviewContent}</td>
							<!-- 고쳐야 됨. -->
					</c:forEach>		
						</tr>
					
				</table>
					<div style="text-align: center;">
				<c:if test="${startPage > 1}">
					<a href="${pageContext.request.contextPath}/mainHotelOne?hotelId=${hotel.hotelId}&currentPage=${startPage-1}" class="btn btn-outline-light text-dark">◁</a>
				</c:if>
				
				<c:forEach begin="${startPage}" end="${lastPage}" var="i">
					<c:choose>
						<c:when test="${i == currentPage}">
							<a href="${pageContext.request.contextPath}/mainHotelOne?hotelId=${hotel.hotelId}&currentPage=${i}" class="btn btn-secondary">${i}</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/mainHotelOne?hotelId=${hotel.hotelId}&currentPage=${i}" class="btn btn-outline-light text-dark">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
					<c:if test="${lastPage != totalPage}">
					<a href="${pageContext.request.contextPath}/mainHotelOne?hotelId=${hotel.hotelId}&currentPage=${lastPage+1}" class="btn btn-outline-light text-dark">▷</a>
					</c:if>
					</div>
						
						
						
						
						
						
						
						<div align="right">
						<input type="button" value="뒤로가기" onclick="history.back(-1)" class="btn btn-inverse-secondary">
						</div>
						<br>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
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
});
</script>
</body>
</html>