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
	<form  method="post" action="${pageContext.request.contextPath}/ceo/updateExperience">
	<div>
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">${experience.experienceId}번째글 수정하기</h4>
					
					<input type="hidden" class="form-control" name="experienceId"
								value="${experience.experienceId}" >
								
					<p class="card-description">체험이름</p>
					<input type="text" class="form-control" name="experienceName"
								value="${experience.experienceName}">
					<br><hr><br>
					
					<p class="card-description">주소</p>
					<h4>(${experience.address.postcode}) ${experience.address.roadAddress} ${experience.address.extraAddress} ${experience.address.detailAddress}</h4>
					<h5> &emsp; &emsp; &emsp;${experience.address.jibunAddress}</h5>
					<br><hr><br>
					
					<p class="card-description">예약 가능 날짜</p>
					<div class="form-group input-group">
					<input type="date" class="form-control" name="experienceStartdate"
								value="${experience.experienceStartdate}">
					<div class="input-group-text">~</div>
					<input type="date" class="form-control" name="experienceEnddate"
								value="${experience.experienceEnddate}">
					</div>
					<br> 
					<p class="card-description">최대 인원수</p>
					<div class="input-group-append">
					<input type="number" class="form-control" name="experiencePerson"
								value="${experience.experiencePerson}"> 
					<span style="color: black" class="input-group-text">명</span>
							</div>
					
					<br> 
					<p class="card-description">가격</p>
					<div class="input-group">
					<input type="number" class="form-control" name="experiencePrice"
								value="${experience.experiencePrice}">
					<div class="input-group-append">
								<span style="color: black" class="input-group-text">&#8361;</span>
					</div></div>
					<br><hr><br>
					<p class="card-description">이미지(미구현)</p>
					<h4></h4>
					<br><hr><br>
					 
					<p class="card-description">프로그램</p>
					<textarea class="form-control" name="experienceContent" rows="10">${experience.experienceContent}</textarea>
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
				<button type="submit" class="btn btn-inverse-warning">수정하기</button>&emsp;
				</div>
				<br>
			</div>
		</div>
	</div>
	</form>
</body>
</html>