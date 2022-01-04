<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
	<%@ include file="ceoBase.jsp" %>
	<br>
	
	<form method="post" action="${pageContext.request.contextPath}/ceo/insertExp" enctype="multipart/form-data" class="forms-sample" id="addForm">
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title">체험 등록</h2>
					<p class="card-description">등록하실 체험의 정보를 입력해주세요.</p>
					<div class="form-group">
						<label for="exampleInputName1">체험 이름</label> <input type="text"
							class="form-control" name="experienceName" id="experienceName" placeholder="체험제목">
					</div>
					<div class="form-group">
						<label for="exampleInputName1">작성자</label> <input type="text"
							class="form-control" value="${loginCeoId}" name="ceoId" readonly>
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" value="${addressId}"
							name="addressId">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail3">가격</label>
						<div class="input-group">
							<input type="text" class="form-control" name="experiencePrice" id="experiencePrice"
								placeholder="가격">
							<div class="input-group-append">
								<span style="color: black" class="input-group-text">&#8361;</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword4">최대 수용 인원</label>
						<div class="input-group">
							<input type="number" class="form-control" name="experiencePerson" id="experiencePerson"
								placeholder="최대 수용 인원">
							<div class="input-group-append">
								<span style="color: black" class="input-group-text">명</span>
							</div>
						</div>
					</div>
					<label for="exampleSelectGender" style="font-size: 15px">체험일자</label>
					<div class="form-group input-group">
						<input type="date" class="form-control" style="width: 250px" name="experienceStartdate" id="experienceStartdate" >
						<div class="input-group-text">~</div>
						<input type="date" class="form-control" style="width: 250px" name="experienceEnddate" id="experienceEnddate">
					</div>
					<div class="form-group">
						<label>이미지 등록</label> <!--  <input type="file" name="img[]"
							class="file-upload-default"> -->
						<div class="input-group col-xs-12">
							<!--  <input type="text" class="form-control file-upload-info" disabled
								placeholder="Upload Image"> <span
								class="input-group-append">
								<button class="file-upload-browse btn btn-primary" type="button">Upload</button>
							</span> -->
							<input multiple="multiple" type="file" name="experienceImage" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="exampleTextarea1">내용</label>
						<textarea class="form-control" name="experienceContent" id="experienceContent" rows="10"></textarea>
					</div>
					<hr>
					<!-- 테마 추가 -->
					<div class="form-group">
					<label for="exampleTextarea1">테마 선택</label>
						<div>
	               			<select name="theme" id="theme">
	               				<option value="">테마 선택</option>
	               				<c:forEach items="${selectThemeSmallList}" var="themeSmall">
	               					<option value="${themeSmall.themeSmallName}">${themeSmall.themeSmallName}</option>
	               				</c:forEach>
	               			</select>
	               		</div>
	               	</div>
					<!-- 해시태그 추가 -->
					<div class="form-group">
					<label for="exampleTextarea1">태그 입력</label>
						<div>
							<input name="addHashtag" id="addHashtag" type="text" style="width:300px;height:30px" placeholder="태그를 입력해주세요 (최대 10개)">
							<button type="button" name="addHashtag" class="btn btn-outline-info btn-sm">추가</button>
						</div>
						<div class="tag_input_box inactive" id="hashtag">
              			</div>
            		</div>
              	 	<!-- 해시태그 추가 끝 -->
              	 	<div align="right">
					<button class="btn btn-light">Cancel</button>
					<button type="button" id="addBtn" class="btn btn-primary mr-2">Submit</button>
					</div>
				</div>
			</div>
		</div>
		<div id ="test">
		</div>
	</form>
	<script type="text/javascript">
		$(document).ready(function () {
			$('input[type="text"]').keydown(function() {
			    if (event.keyCode === 13) {
			        event.preventDefault();
			    }
			});
			$('input[type="number"]').keydown(function() {
			    if (event.keyCode === 13) {
			        event.preventDefault();
			    }
			});
			// 해시태그 추가 버튼 클릭 시
			$('button[name=addHashtag]').click(function () {
				var value = $('input[name=addHashtag]').val();
				/*
				console.log("버튼1을 누르셨습니다.");
				
				console.log(value);
				console.log($('#hashtag0').val());
				console.log($('input[name=addHashtag]').val());
				*/
				if($('input[name=addHashtag]').val() == ""){
					alert("태그입력후 추가를 눌러주세요");
					$('#addHashtag').focus();
					return false;
				} else{
					// 버튼 타입 시 form으로 값이 안넘어옴 > 문제 수정
					let inputHashtag = '<label name ="label" class="btn btn-light" style="visibility: visible; background-color: rgba(255, 255, 255);border-radius: 50px;margin-bottom: 3px;margin-top: 3px;">#'+value+''; 
					inputHashtag += '<input type="hidden" style="opacity:0; padding: 10px;" name="keyword" value="#'+value+'">';
					inputHashtag += '</label>';
					$('#hashtag').append(inputHashtag);
					$('input[name=addHashtag]').val("");
				}
			});
			
			$('#tset').append('<div id ="insertDiv"></div>');
			
			
			// 해시태그 버튼 클릭 시 삭제...
			$(document).on("click", "label[name='label']", function () {
				console.log($(this).val());
			   	$(this).remove();
			});
			
			
		});
		//  Submit 버튼 클릭 시 addForm Submit
		$(function(){
			$('#addBtn').click(function(){
				// 내용이 1개라도 빠질 시 submit안되고 경고창출력
				if($('#experienceName').val() == '' || $('#experiencePrice').val() == '' || $('#experiencePerson').val() == '' || $('#experienceStartdate').val() == '' || $('#experienceEnddate').val() == '' || $('#experienceContent').val() == '' || $('#theme').val() == ''){
					alert('내용이 비어있습니다');
					return;
				}
				$('#addForm').submit();
			});
		});
	
	</script>
</body>
</html>