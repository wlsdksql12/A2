<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<br>
	<div>
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">${experience.experienceId}번째글 상세보기</h4>
					
					<h3>${experience.experienceName}</h3>
					<br><hr><br>
					
					<p class="card-description">주소</p>
					<h4>(${experience.address.postcode}) ${experience.address.roadAddress} ${experience.address.extraAddress} ${experience.address.detailAddress}</h4>
					<h5> &emsp; &emsp; &emsp;${experience.address.jibunAddress}</h5>
					<br><hr><br>
					
					<p class="card-description">예약 가능 날짜</p>
					<h4>${experience.experienceStartdate} ~ ${experience.experienceEnddate}</h4>
					<br> 
					<p class="card-description">최대 인원수</p>
					<h4>${experience.experiencePerson} 명</h4>
					<br> 
					<p class="card-description">가격</p>
					<h4>${experience.experiencePrice}&nbsp;&#8361;</h4>
					<br><hr><br>
					<p class="card-description">이미지(미구현)</p>
					<h4></h4>
					<br><hr><br>
					 
					<p class="card-description">프로그램</p>
					<h4>${experience.experienceContent}</h4>
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
				        center: new kakao.maps.LatLng(${experience.address.lat}, ${experience.address.lng}), // 지도의 중심좌표
				        level: 2, // 지도의 확대 레벨
				        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
				    }; 

					// 지도를 생성한다 
					var map = new kakao.maps.Map(mapContainer, mapOption);
					
					// 지도에 마커를 생성하고 표시한다
					var marker = new kakao.maps.Marker({
					    position: new kakao.maps.LatLng(${experience.address.lat}, ${experience.address.lng}), // 마커의 좌표
					    map: map // 마커를 표시할 지도 객체
					});
				    </script>
				</div>
				<div align="right">
				<input type="button" value="뒤로가기" onclick="history.back(-1)" class="btn btn-inverse-secondary">
				<a href="#" class="btn btn-inverse-warning">수정</a>
				<a href="#" class="btn btn-inverse-danger">삭제</a>&emsp;
				</div>
				<br>
			</div>
		</div>
	</div>
</body>
</html>