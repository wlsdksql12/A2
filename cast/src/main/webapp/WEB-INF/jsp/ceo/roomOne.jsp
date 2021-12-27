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
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<br>
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
					
					<p class="card-description">객실 편의시설</p>

				
				<div align="right">
				<input type="button" value="뒤로가기" onclick="history.back(-1)" class="btn btn-inverse-secondary">
				<a href="#" class="btn btn-inverse-warning">수정</a> &emsp;
				</div>
				<br>
			</div>
		</div>
	</div>
</body>
</html>