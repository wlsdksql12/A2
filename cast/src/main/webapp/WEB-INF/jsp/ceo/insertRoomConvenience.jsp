<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<form method="post" action="${pageContext.request.contextPath}/ceo/insertRoomConvenience" class="forms-sample">
		<br>
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
				<div class="progress" style="height:20px">
				<div class="progress-bar progress-bar-striped" style="width:75%">75%</div>
				</div>
				<br>
					<h2 class="card-title">편의 시설 등록</h2>
					<p class="card-description">등록하실 편의 시설의 정보를 입력해주세요.</p>
					<div class="form-group">
						<label for="exampleInputName1">계단과 문턱 유무</label> 
						<br>
						<input type="radio" name="stairsThreshold" value="Y">있음
						<input type="radio" name="stairsThreshold" value="N">없음
					</div>
					<div class="form-group">
						<label for="exampleInputName1">변기 옆 고정 손잡이 유무</label> 
						<br>
						<input type="radio" name="toiletHandle" value="Y">있음
						<input type="radio" name="toiletHandle" value="N">없음
					</div>
					<div class="form-group">
						<label for="exampleInputName1">샤워실 고정 손잡이</label> 
						<br>
						<input type="radio" name="showerStallHandle" value="Y">있음
						<input type="radio" name="showerStallHandle" value="N">없음
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" value="${roomId}" name="roomId">
					</div>
					<div align="right">
					<button type="submit" class="btn btn-primary mr-2">NEXT</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">

		window.history.forward();

		function noBack() {

			window.history.forward();

		}

         </script>
</body>
</html>