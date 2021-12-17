<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<h4>${experience.experiencePerson}</h4>
					<br> 
					<p class="card-description">가격</p>
					<h4>${experience.experiencePrice}&#8361;</h4>
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
				
				</div>
			</div>
		</div>
	</div>
</body>
</html>