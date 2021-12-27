<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<br>
	<form  method="post" action="/ceo/updateHotel">
	<div>
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">${hotel.hotelId}번째글 수정하기</h4>
					
					<input type="hidden" class="form-control" name="hotelId" value="${hotel.hotelId}" >
					
					<p class="card-description">호텔이름</p>
					<input type="text" class="form-control" name="hotelName"
								value="${hotel.hotelName}">
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
					<textarea class="form-control" name="hotelContent" rows="10">${hotel.hotelContent}</textarea>
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
						<td><a href="/ceo/roomOne?roomId=${list.roomId}">${list.roomName}</a></td>
						<td>${list.roomCount}</td>
						<td>${list.roomStartdate}</td>
						<td>${list.roomEnddate}</td>
					</tr>
					</c:forEach>
					</tbody>
					</table>
					<br>
					<br><hr><br>
					
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
				</div>
				<div align="right">
				<input type="button" value="뒤로가기" onclick="history.back(-1)" class="btn btn-inverse-secondary">
				<button type="submit" class="btn btn-inverse-warning">수정하기</button>&emsp;
				</div>
				<br>
			</div>
		</div>
	</div>
</body>
</html>