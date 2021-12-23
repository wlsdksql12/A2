<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<form method="post" action="/ceo/insertRoomBedroom" class="forms-sample">
		<br>
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title">객실 옵션 등록</h2>
					<p class="card-description">등록하실 객실의 정보를 입력해주세요.</p>
					<div class="form-group">
						<label for="exampleInputName1">침대 개수</label> 
						<input type="number" class="form-control" name="bedCount">
					</div>
					<div class="form-group">
						<label for="exampleInputName1">침실 개수</label> 
						<input type="number" class="form-control" name="bedroomCount">
					</div>
					<div class="form-group">
						<label for="exampleInputName1">욕실 개수</label> 
						<input type="number" class="form-control" name="bathroomCount">
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" value="${roomId}" name="roomId">
					</div>
					<div align="right">
					<button type="submit" class="btn btn-primary mr-2">Submit</button>
					<button class="btn btn-light">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>