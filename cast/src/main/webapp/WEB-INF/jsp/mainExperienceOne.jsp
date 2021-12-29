<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
	    <!-- 최상단 네비게이션 -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
        <div class="container text-light">
            <div class="w-100 d-flex justify-content-between">
                <div>
                    <i class="fa fa-envelope mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">info@company.com</a>
                    <i class="fa fa-phone mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                </div>
                <div>
                    <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i class="fab fa-linkedin fa-sm fa-fw"></i></a>
                </div>
            </div>
        </div>
    </nav>
    <!-- 최상단 네비게이션 끝 -->


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
					<h4 class="card-title">${experience.experienceId}번째글 상세보기</h4>
					
					<input type="hidden" class="form-control" name="experienceId"
								value="${experience.experienceId}" >
								
					<h3>${experience.experienceName}</h3>
					<br><hr><br>
					
					<p class="card-description">주소</p>
					<table>
					<tr>
						<td style="font-size:14px">도로명 &nbsp;</td>
						<td>(${experience.address.postcode})</td>
						<td>${experience.address.roadAddress} ${experience.address.extraAddress} ${hotel.address.detailAddress}</td>
					</tr>
					<tr>
						<td colspan="2" style="font-size:14px">지번 &nbsp;</td>
						<td>${experience.address.jibunAddress}</td>
					</tr>
					</table>
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

					<!-- 방 리스트 -->
					
					
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
				    <br>
					<p class="card-description">여행작가 추천</p>
					<hr>
						<a href="/mainExperienceSelect" style="text-align:right;" class="btn btn-outline-success">리스트로 이동</a>
						<a href="/addExperienceOrder?experienceId=${experience.experienceId}" style="text-align:right;" class="btn btn-outline-success">체험 예약</a>
					<p></p><p></p>
					<div>
						<c:if test="${loginTravelerId != null}">
								<a href="/addExperienceSelect?experienceId=${experience.experienceId}&travelerId=${loginTravelerId}" id="insertBtn" style="text-align:right;" class="btn btn-outline-success">추가</a>
						</c:if>
					</div>
				</div>
				<div align="right">
				<input type="button" value="뒤로가기" onclick="history.back(-1)" class="btn btn-inverse-secondary">
				</div>
				<br>
			</div>
		</div>
	</div>
</body>
</html>