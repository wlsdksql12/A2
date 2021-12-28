<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 아이콘 -->
<script src="https://kit.fontawesome.com/def66b134a.js" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
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
					
					
					<p class="card-description">이미지(미구현)</p>
					<h4></h4>
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
					<a href="/ceo/updateRoom?roomId=${room.roomId}" class="btn btn-inverse-warning">수정</a> &emsp;
					</div>
					<br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>