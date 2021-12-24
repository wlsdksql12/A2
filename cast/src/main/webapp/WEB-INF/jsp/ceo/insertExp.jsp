<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form method="post" action="/ceo/insertExp" class="forms-sample" id="addForm">
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title">체험 등록</h2>
					<p class="card-description">등록하실 체험의 정보를 입력해주세요.</p>
					<div class="form-group">
						<label for="exampleInputName1">체험 이름</label> <input type="text"
							class="form-control" name="experienceName" placeholder="체험제목">
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
							<input type="text" class="form-control" name="experiencePrice"
								placeholder="가격">
							<div class="input-group-append">
								<span style="color: black" class="input-group-text">&#8361;</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword4">최대 수용 인원</label>
						<div class="input-group">
							<input type="number" class="form-control" name="experiencePerson"
								placeholder="최대 수용 인원">
							<div class="input-group-append">
								<span style="color: black" class="input-group-text">명</span>
							</div>
						</div>
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
						<label for="exampleTextarea1">내용</label>
						<textarea class="form-control" name="experienceContent" rows="10"></textarea>
					</div>
					<!-- 해시태그 추가 -->
					<hr>
					<div class="form-group">태그 입력
						<div>
							<input name="addHashtag" id="addHashtag" type="text" placeholder="태그를 입력해주세요 (최대 10개)">
							<button type="button" name="addHashtag">추가</button>
						</div>
						<div class="tag_input_box inactive" id="hashtag">
              			</div>
            		</div>
               	
               	<!-- 해시태그 추가 끝 -->
					<button type="button" id="addBtn" class="btn btn-primary mr-2">Submit</button>
					<button class="btn btn-light">Cancel</button>
				</div>
			</div>
		</div>
	</form>
	<!-- Start Script -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/templatemo.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/custom.js"></script>
    <!-- End Script -->
	<script type="text/javascript">
		num = 0;
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
				console.log("버튼1을 누르셨습니다.");
				var value = $('input[name=addHashtag]').val();
				console.log(value);
				console.log($('#hashtag0').val());
				console.log($('input[name=addHashtag]').val());
				if($('input[name=addHashtag]').val() == ""){
					alert("태그입력후 추가를 눌러주세요");
					$('#addHashtag').focus();
					return false;
				} else{
					num = num + 1;
					console.log(num);
					var numHashtag = numHashtag + 1;
					// 버튼 타입 시 form으로 값이 안넘어옴
					let inputHashtag = '<label name ="label" class="btn btn-light" style="visibility: visible; background-color: rgba(255, 255, 255);border-radius: 50px;margin-bottom: 3px;margin-top: 3px;">#'+value+''; 
					inputHashtag += '<input type="hidden" style="opacity:0; padding: 10px;" name="keyword" value="#'+value+'">';
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
		$(function(){
			$('#addBtn').click(function(){
				$('#addForm').submit();
			});
		});
		/*	
	document.addEventListener('keydown', function(event) {
		  if (event.keyCode === 13) {
			  event.preventDefault();
			  var numHashtag = 1;
			  if($('#hashtag[0]').val() == ""){
					alert("해시태그를 입력해주세요");
					$('#loginSelect').focus();
					return false;
				} else if(($('#hashtag[0]').val() != "")){
					let inputHashtag = '<input  name="hashtag['+numHashtag+']" id="hashtag['+numHashtag+']" name="hashtag['+numHashtag+']"  type="text" placeholder="태그를 입력해주세요 (최대 10개)" class="tag_input">';
					$('#hashtag').append(inputHashtag);
				}
			  $('#hashtag[1]').focus();
		    event.preventDefault();
		  };
		}, true);
	*/
	</script>
</body>
</html>