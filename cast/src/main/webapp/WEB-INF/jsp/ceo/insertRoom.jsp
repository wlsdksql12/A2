<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<form method="post" action="/insertHotel" class="forms-sample">
	<br>
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title">호텔 등록</h2>
					<p class="card-description">등록하실 호텔의 정보를 입력해주세요.</p>
					<div class="form-group">
						<label for="exampleInputName1"></label> <input type="text"
							class="form-control" name="hotelName" placeholder="체험제목">
					</div>
					<div class="form-group">
						<label for="exampleInputName1"></label> <input type="text"
							class="form-control" value="${loginCeoId}" name="ceoId" readonly>
					</div>
					<div class="form-group">
						<label for="exampleInputName1"></label> <input type="number"
							class="form-control" name="countRoom" placeholder="방의 수">
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" value="${hotelId}"
							name="hotelId">
					</div>
					<div class="form-group">
						<label>이미지 등록[미구현]</label> <input type="file" name="img[]"
							class="file-upload-default">
						<div class="input-group col-xs-12">
							<input type="text" class="form-control file-upload-info" disabled
								placeholder="Upload Image"> <span
								class="input-group-append">
								<button class="file-upload-browse btn btn-primary" type="button">Upload</button>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleTextarea1">호텔 소개</label>
						<textarea class="form-control" name="hotelContent" rows="10"></textarea>
					</div>
					<button type="submit" class="btn btn-primary mr-2">Submit</button>
					<button class="btn btn-light">Cancel</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>