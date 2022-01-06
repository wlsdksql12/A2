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
<!-- 아이콘 -->
<script src="https://kit.fontawesome.com/def66b134a.js" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
    
	<br>
	<div>
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">${room.roomId}번째 객실 상세보기</h4>
					<input type="hidden" class="form-control" name="hotelId" value="${room.hotelId}" >
							
					<h3>${room.roomName}</h3>
					<br><hr><br>
		
					<p class="card-description">예약 가능 날짜</p>
					<h4>${room.roomStartdate} ~ ${room.roomEnddate}</h4>
					<br>
					<p class="card-description">객실 개수</p>
					<h4>${room.roomCount}</h4>
					<br>
					<p class="card-description">가격</p>
					<h4>${room.roomPrice}&nbsp;&#8361;</h4>
					<br><hr><br>
					
					
					<p class="card-description">이미지</p>
					<c:forEach items="${roomImageList}" var="roomImage">
						<img src="${pageContext.request.contextPath}/upload/${roomImage.imageName}.${roomImage.imageExt}" style="height: 500px; width: 400px;">	
					</c:forEach>
					<br><hr><br>
					 
					<p class="card-description">객실 소개</p>
					<h4>${room.roomContent}</h4>
					<br><hr><br>
					
					<p class="card-description">객실 정보</p>
					<h4><i class="fas fa-door-open fa-2x"></i>&emsp;침실 수 : ${room.roomBedroom.bedroomCount}</h4>
					<h4><i class="fas fa-bed fa-2x"></i>&emsp;침대 수 : ${room.roomBedroom.bedCount}</h4>
					<h4><i class="fas fa-bath fa-2x"></i>&emsp;욕실 수 : ${room.roomBedroom.bathroomCount}</h4>

					<br><hr><br>
					
					<p class="card-description">접근성</p>
						<c:if test="${room.roomConvenience.stairsThreshold eq 'Y'}">
							<h4><span class="material-icons">stairs</span>&emsp;계단</h4>
						</c:if>
						<c:if test="${room.roomConvenience.toiletHandle eq 'Y'}">
							<h4><i class="fas fa-toilet"></i><span class='material-icons'>drag_handle</span>&emsp;변기 옆 고정 손잡이</h4>
						</c:if>
						<c:if test="${room.roomConvenience.showerStallHandle eq 'Y'}">
							<h4><span class='material-icons'>shower</span><span class='material-icons'>drag_handle</span>&emsp;샤워실 고정 손잡이</h4>
						</c:if>
					<br><hr><br>
					
					<p class="card-description">객실 편의시설</p>
						<c:if test="${room.roomFilter.internet eq 'Y'}">
							<h4><i class="fas fa-wifi"></i>&emsp;인터넷</h4>
						</c:if>
						<c:if test="${room.roomFilter.kitchen eq 'Y'}">
							<h4><i class="fas fa-utensils"></i>&emsp;주방</h4>
						</c:if>
						<c:if test="${room.roomFilter.boiler eq 'Y'}">
							<h4><i class="fas fa-temperature-high"></i>&emsp;난방</h4>
						</c:if>
						<c:if test="${room.roomFilter.aircon eq 'Y'}">
							<h4><i class="fas fa-snowflake"></i>&emsp;에어컨</h4>
						</c:if>
						<c:if test="${room.roomFilter.washingMachine eq 'Y'}">
							<h4><i class="fab fa-algolia"></i>&emsp;세탁기</h4>
						</c:if>
						<c:if test="${room.roomFilter.breakfast eq 'Y'}">
							<h4><span class='material-icons'>free_breakfast</span>&emsp;조식</h4>
						</c:if>
						<c:if test="${room.roomFilter.tv eq 'Y'}">
							<h4><i class="fas fa-tv"></i>&emsp;TV</h4>
						</c:if>
						<c:if test="${room.roomFilter.hairdryer eq 'Y'}">
							<h4><i class="fas fa-wind"></i>&emsp;헤어드라이어</h4>
						</c:if>
						<c:if test="${room.roomFilter.bidet eq 'Y'}">
							<h4><i class="fas fa-toilet"></i>&emsp;비데</h4>
						</c:if>
					<div align="right">
					<input type="button" value="뒤로가기" onclick="history.back(-1)" class="btn btn-inverse-secondary">
					</div>
					<br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>