<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<form method="post" action="/ceo/updateRoom">
		<input type="text" value="${room.roomId}" name="roomId">
		<input type="text" value="${room.roomName}" name="roomName">
		<input type="text" value="${room.roomContent}" name="roomContent">
		<input type="number" value="${room.roomCount}" name="roomCount">
		<input type="text" value="${room.roomStartdate}" name="roomStartdate">
		<input type="text" value="${room.roomEnddate}" name="roomEnddate">
		<input type="number" value="${room.roomPrice}" name="roomPrice">
		<input type="number" value="${room.roomBedroom.bedCount}" name="roomBedroom.bedCount">
		<input type="number" value="${room.roomBedroom.bedroomCount}" name="roomBedroom.bedroomCount">
		<input type="number" value="${room.roomBedroom.bathroomCount}" name="roomBedroom.bathroomCount">
		<input type="text" value="${room.roomConvenience.stairsThreshold}" name="roomConvenience.stairsThreshold">
		<input type="text" value="${room.roomConvenience.toiletHandle}" name="roomConvenience.toiletHandle">
		<input type="text" value="${room.roomConvenience.showerStallHandle}" name="roomConvenience.showerStallHandle">
		<input type="text" value="${room.roomFilter.internet}" name="roomFilter.internet">
		<input type="text" value="${room.roomFilter.kitchen}" name="roomFilter.kitchen">
		<input type="text" value="${room.roomFilter.boiler}" name="roomFilter.boiler">
		<input type="text" value="${room.roomFilter.aircon}" name="roomFilter.aircon">
		<input type="text" value="${room.roomFilter.washingMachine}" name="roomFilter.washingMachine">
		<input type="text" value="${room.roomFilter.breakfast}" name="roomFilter.breakfast">
		<input type="text" value="${room.roomFilter.tv}" name="roomFilter.tv">
		<input type="text" value="${room.roomFilter.hairdryer}" name="roomFilter.hairdryer">
		<input type="text" value="${room.roomFilter.bidet}" name="roomFilter.bidet">
		<button type="submit">수정 완료</button>
	</form>
</body>
</html>