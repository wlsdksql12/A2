<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<form method="post" action="${pageContext.request.contextPath}/ceo/updateRoom">
	<br>
	<div>
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title">${room.roomId}번째글 수정하기</h2>
					<p class="card-description">객실 이름</p>
					<input type="hidden" value="${room.roomId}" name="roomId">
					<input type="text" value="${room.roomName}" name="roomName" class="form-control"><br>
					<p class="card-description">객실 소개</p>
					<textarea name="roomContent" class="form-control" rows="15">${room.roomContent}</textarea><br>
					<p class="card-description">객실 수</p>
					<input type="number" value="${room.roomCount}" name="roomCount" class="form-control"><br>
					<p class="card-description">예약 가능 일자</p>
					<div class="form-group input-group">
						<input type="date" value="${room.roomStartdate}" name="roomStartdate" class="form-control">
						<div class="input-group-text">~</div>
						<input type="date" value="${room.roomEnddate}" name="roomEnddate" class="form-control">
					</div>
					<p class="card-description">객실 가격</p>
					<div class="form-group input-group">
						<input type="number" value="${room.roomPrice}" name="roomPrice" class="form-control">
						<div class="input-group-text">&#8361;</div>
					</div>
					<br><hr><br>
					
					<p class="card-description">침대 수</p>
					<input type="number" value="${room.roomBedroom.bedCount}" name="roomBedroom.bedCount" class="form-control"><br>
					<p class="card-description">침실 수</p>
					<input type="number" value="${room.roomBedroom.bedroomCount}" name="roomBedroom.bedroomCount" class="form-control"><br>
					<p class="card-description">욕실 수</p>
					<input type="number" value="${room.roomBedroom.bathroomCount}" name="roomBedroom.bathroomCount" class="form-control"><br>
					<br><hr><br>
					
					<p class="card-description">계단과 문턱</p>
					<input type="radio" name="roomConvenience.stairsThreshold" id="stair1" value="Y" checked="checked" <c:if test="${room.roomConvenience.stairsThreshold eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomConvenience.stairsThreshold" id="stair2" value="N" <c:if test="${room.roomConvenience.stairsThreshold eq 'N'}">checked</c:if>/>없음<br><br>
					<p class="card-description">화장실 손잡이</p>
					<input type="radio" name="roomConvenience.toiletHandle" id="toiletHandle" value="Y" checked="checked" <c:if test="${room.roomConvenience.toiletHandle eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomConvenience.toiletHandle" id="toiletHandle" value="N" <c:if test="${room.roomConvenience.toiletHandle eq 'N'}">checked</c:if>/>없음<br><br>
					<p class="card-description">샤워실 손잡이</p>
					<input type="radio" name="roomConvenience.showerStallHandle" id="showerStallHandle1" value="Y" checked="checked" <c:if test="${room.roomConvenience.showerStallHandle eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomConvenience.showerStallHandle" id="showerStallHandle2" value="N" <c:if test="${room.roomConvenience.showerStallHandle eq 'N'}">checked</c:if>/>없음<br><br>
					<br><hr><br>
					
					<p class="card-description">인터넷</p>
					<input type="radio" name="roomFilter.internet" id="internet1" value="Y" checked="checked" <c:if test="${room.roomFilter.internet eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomFilter.internet" id="internet2" value="N" <c:if test="${room.roomFilter.internet eq 'N'}">checked</c:if>/>없음<br><br>
					<p class="card-description">부엌</p>
					<input type="radio" name="roomFilter.kitchen" id="kitchen1" value="Y" checked="checked" <c:if test="${room.roomFilter.kitchen eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomFilter.kitchen" id="kitchen2" value="N" <c:if test="${room.roomFilter.kitchen eq 'N'}">checked</c:if>/>없음<br><br>
					<p class="card-description">보일러</p>
					<input type="radio" name="roomFilter.boiler" id="boiler1" value="Y" checked="checked" <c:if test="${room.roomFilter.boiler eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomFilter.boiler" id="boiler2" value="N" <c:if test="${room.roomFilter.boiler eq 'N'}">checked</c:if>/>없음<br><br>
					<p class="card-description">에어컨</p>
					<input type="radio" name="roomFilter.aircon" id="aircon1" value="Y" checked="checked" <c:if test="${room.roomFilter.aircon eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomFilter.aircon" id="aircon2" value="N" <c:if test="${room.roomFilter.aircon eq 'N'}">checked</c:if>/>없음<br><br>
					<p class="card-description">세탁기</p>
					<input type="radio" name="roomFilter.washingMachine" id="washingMachine1" value="Y" checked="checked" <c:if test="${room.roomFilter.washingMachine eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomFilter.washingMachine" id="washingMachine2" value="N" <c:if test="${room.roomFilter.washingMachine eq 'N'}">checked</c:if>/>없음<br><br>
					<p class="card-description">조식 제공</p>
					<input type="radio" name="roomFilter.breakfast" id="breakfast1" value="Y" checked="checked" <c:if test="${room.roomFilter.breakfast eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomFilter.breakfast" id="breakfast2" value="N" <c:if test="${room.roomFilter.breakfast eq 'N'}">checked</c:if>/>없음<br><br>
					<p class="card-description">TV</p>
					<input type="radio" name="roomFilter.tv" id="tv1" value="Y" checked="checked" <c:if test="${room.roomFilter.tv eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomFilter.tv" id="tv2" value="N" <c:if test="${room.roomFilter.tv eq 'N'}">checked</c:if>/>없음<br><br>
					<p class="card-description">헤어드라이어</p>
					<input type="radio" name="roomFilter.hairdryer" id="hairdryer1" value="Y" checked="checked" <c:if test="${room.roomFilter.hairdryer eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomFilter.hairdryer" id="hairdryer2" value="N" <c:if test="${room.roomFilter.hairdryer eq 'N'}">checked</c:if>/>없음<br><br>
					<p class="card-description">비데</p>
					<input type="radio" name="roomFilter.bidet" id="bidet1" value="Y" checked="checked" <c:if test="${room.roomFilter.bidet eq 'Y'}">checked</c:if>/>있음&emsp;
					<input type="radio" name="roomFilter.bidet" id="bidet2" value="N" <c:if test="${room.roomFilter.bidet eq 'N'}">checked</c:if>/>없음<br><br>
					<div align="right">
						<input type="button" value="뒤로가기" onclick="history.back(-1)" class="btn btn-inverse-secondary">
						<button type="submit" class="btn btn-inverse-warning">수정 완료</button>&emsp;
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>
</html>