<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/addExperiencePayment">
	<div>체험 이름</div>
	<input type="text" name="experienceName" value="${experienceSelectName}" readonly="readonly">
	<div>카드 선택</div>
	<select name="experiencePaymentMethod">
		<option value="NH">NH</option>
		<option value="KB">KB></option>
	</select>
	<div>카드 번호</div>
	<input type="text" name="experiencePaymentMethodNumber">
	<div>인원 수</div>
	<input type="text" name="experienceOrderPeople" value="${experienceOrderPeople}" readonly="readonly">
	<div>결제 금액</div>
	<input type="text" name="experiencePaymentMoney" value="${experiencePrice}" readonly="readonly">
	<input type="hidden" name="customerId" value="${customerId}">
	<input type="hidden" name="experienceOrderEndDate" value="${ExperienceOrderEndDate}">
	<input type="hidden" name="experienceOrderStartDate" value="${ExperienceOrderStartDate}">
	
	
	
	
	
	<button type="submit">결제</button>
	</form>
</body>
</html>