<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<form method="post" action="${pageContext.request.contextPath}/ceo/insertHotel" enctype="multipart/form-data" class="forms-sample" id="addForm">
	<br>
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title">호텔 등록</h2>
					<p class="card-description">등록하실 호텔의 정보를 입력해주세요.</p>
					<div class="form-group">
						<label for="exampleInputName1">호텔 이름</label> <input type="text"
							class="form-control" name="hotelName" id="hotelName" placeholder="호텔이름">
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
						<label>이미지 등록</label> <!-- <input type="file" name="img[]"
							class="file-upload-default"> -->
						<div class="input-group col-xs-12">
						<!--  	<input type="text" class="form-control file-upload-info" disabled
								placeholder="Upload Image"> <span
								class="input-group-append">
								<button class="file-upload-browse btn btn-primary" type="button">Upload</button>
							</span> -->
							<input multiple="multiple" type="file" name="hotelImage" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="exampleTextarea1">호텔 소개</label>
						<textarea class="form-control" name="hotelContent" id="hotelContent" rows="10"></textarea>
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
					inputHashtag += '<input type="hidden" style="opacity:0; padding: 10px;" name="keyword" value="'+value+'">';
					inputHashtag += '</label>';
					$('#hashtag').append(inputHashtag);
					$('input[name=addHashtag]').val("");
				}
			});
			
			// 해시태그 버튼 클릭 시 삭제...
			$(document).on("click", "label[name='label']", function () {
				console.log($(this).val());
			   	$(this).remove();
			});
			
			
		});
		//  Submit 버튼 클리 시 addForm Submit
		$(function(){
			$('#addBtn').click(function(){
				// 이미지,키워드 제외한 내용이 1개라도 빠질 시 submit안되고 경고창출력
				if($('#hotelName').val() == '' || $('#hotelContent').val() == '' || $('#theme').val() == ''){
					alert('내용이 비어있습니다');
					return;
				}
				$('#addForm').submit();
			});
		});
	
	</script>
</body>
</html>