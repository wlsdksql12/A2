<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="utf-8">
<title>체험 등록</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>RoyalUI Admin</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ceo_template/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ceo_template/vendors/base/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ceo_template/css/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/ceo_template/images/favicon.png" />
</head>
<body>
	<form method="post" action="/insertHotel" class="forms-sample">
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title">호텔 등록</h2>
					<p class="card-description">등록하실 호텔의 정보를 입력해주세요.</p>
					<div class="form-group">
						<label for="exampleInputName1">호텔 이름</label> <input type="text"
							class="form-control" name="hotelName" placeholder="체험제목">
					</div>
					<div class="form-group">
						<label for="exampleInputName1">작성자</label> <input type="text"
							class="form-control" value="${loginCeoId}" name="ceoId" readonly>
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" value="${addressId}"
							name="addressId">
					</div>
					<label for="exampleSelectGender" style="font-size: 15px">체험일자</label>
					<div class="form-group input-group">
						<input type="date" class="form-control" style="width: 250px" name="experienceStartdate" >
						<div class="input-group-text">~</div>
						<input type="date" class="form-control" style="width: 250px" name="experienceEnddate">
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