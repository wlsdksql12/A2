<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<form method="post" action="/ceo/insertRoomFilter" class="forms-sample">
		<br>
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title">편의 시설 등록</h2>
					<p class="card-description">등록하실 편의 시설의 정보를 입력해주세요.</p>
					<div class="form-group">
						<label for="exampleInputName1">인터넷 유무</label> 
						<br>
						<input type="radio" name="internet" value="Y">있음
						<input type="radio" name="internet" value="N">없음
					</div>
					<div class="form-group">
						<label for="exampleInputName1">부엌 유무</label> 
						<br>
						<input type="radio" name="kitchen" value="Y">있음
						<input type="radio" name="kitchen" value="N">없음
					</div>
					<div class="form-group">
						<label for="exampleInputName1">보일러 유무</label> 
						<br>
						<input type="radio" name="boiler" value="Y">있음
						<input type="radio" name="boiler" value="N">없음
					</div>
					<div class="form-group">
						<label for="exampleInputName1">에어컨 유무</label> 
						<br>
						<input type="radio" name="aircon" value="Y">있음
						<input type="radio" name="aircon" value="N">없음
					</div>
					<div class="form-group">
						<label for="exampleInputName1">세탁기 유무</label> 
						<br>
						<input type="radio" name="washingMachine" value="Y">있음
						<input type="radio" name="washingMachine" value="N">없음
					</div>
					<div class="form-group">
						<label for="exampleInputName1">조식 제공</label> 
						<br>
						<input type="radio" name="breakfast" value="Y">있음
						<input type="radio" name="breakfast" value="N">없음
					</div>
					<div class="form-group">
						<label for="exampleInputName1">TV 유무</label> 
						<br>
						<input type="radio" name="tv" value="Y">있음
						<input type="radio" name="tv" value="N">없음
					</div>
					<div class="form-group">
						<label for="exampleInputName1">헤어 드라이기 유무</label> 
						<br>
						<input type="radio" name="hairdryer" value="Y">있음
						<input type="radio" name="hairdryer" value="N">없음
					</div>
					<div class="form-group">
						<label for="exampleInputName1">비데 유무</label> 
						<br>
						<input type="radio" name="bidet" value="Y">있음
						<input type="radio" name="bidet" value="N">없음
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