<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>주소 입력 페이지</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>RoyalUI CEO</title>
<!-- plugins:css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ceo_template/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ceo_template/vendors/base/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ceo_template/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/ceo_template/images/favicon.png" />
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<form method="post" action="/ceo/insertExpAddress" class="form-sample">
	<br>
		<div class="col-12 grid-margin bg-white">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">주소입력</h4>
					<p class="card-description">Address</p>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">우편번호</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="postcode" name="postcode" readonly />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group row">
								<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="btn btn-inverse-secondary"><br>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">도로명주소</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="roadAddress" name="roadAddress" readonly />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">지번주소</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="jibunAddress" name="jibunAddress" readonly />
								</div>
							</div>
						</div>
					</div>
					<span id="guide" style="color: #999; display: none"></span>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">상세주소</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="detailAddress" name="detailAddress" required/>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">참고항목</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="extraAddress" name="extraAddress" readonly />
								</div>
							</div>
						</div>
					</div>
					<div align="center">
						<div>
							<div id="map" style="width: 500px; height: 400px;"></div>
						</div>
						<br>
						<button type="submit" class="btn btn-inverse-primary">등록</button>
					</div>
					<div id="latLng"></div>
				</div>
			</div>
		</div>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=736d8d95b9c9321d5c6e6055f1874da1&libraries=services"></script>
		<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.4780757, 126.8785684), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

	    //지도를 미리 생성
	    var map = new daum.maps.Map(mapContainer, mapOption);
	 	// 마우스 휠과 모바일 터치를 이용한 지도 확대, 축소를 막는다
		map.setZoomable(false); 
	    //주소-좌표 변환 객체를 생성
	    var geocoder = new daum.maps.services.Geocoder();
	    //마커를 미리 생성
	    var marker = new daum.maps.Marker({
	        position: new daum.maps.LatLng(37.4780757, 126.8785684),
	        map: map
	    });
	    
			function execDaumPostcode() {
				new daum.Postcode({
							oncomplete : function(data) {
								// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

								// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
								// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
								var roadAddr = data.roadAddress; // 도로명 주소 변수
								var extraRoadAddr = ''; // 참고 항목 변수

								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraRoadAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== '' && data.apartment === 'Y') {
									extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName: data.buildingName);
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraRoadAddr !== '') {
									extraRoadAddr = ' (' + extraRoadAddr + ')';
								}

								// 우편번호와 주소 정보를 해당 필드에 넣는다.
								document.getElementById('postcode').value = data.zonecode;
								document.getElementById("roadAddress").value = roadAddr;
								document.getElementById("jibunAddress").value = data.jibunAddress;

								// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
								if (roadAddr !== '') {
									document.getElementById("extraAddress").value = extraRoadAddr;
								} else {
									document.getElementById("extraAddress").value = '';
								}

								var guideTextBox = document.getElementById("guide");
								// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
								if (data.autoRoadAddress) {
									var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
									guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
									guideTextBox.style.display = 'block';

								} else if (data.autoJibunAddress) {
									var expJibunAddr = data.autoJibunAddress;
									guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
									guideTextBox.style.display = 'block';
								} else {
									guideTextBox.innerHTML = '';
									guideTextBox.style.display = 'none';
								}
					            
								geocoder.addressSearch(data.address, function(results, status) {
								
				                    // 정상적으로 검색이 완료됐으면
				                    if (status === daum.maps.services.Status.OK) {
	
				                        var result = results[0]; //첫번째 결과의 값을 활용
	
				                        // 해당 주소에 대한 좌표를 받아서
				                        var coords = new daum.maps.LatLng(result.y, result.x);
				                        
				                        var message = '<input type="hidden" value="'+ result.y +'" name="lat">';
				                        message += '<input type="hidden" value="'+ result.x +'" name="lng">';
				                        
				                        var resultDiv = document.getElementById('latLng');
				                        resultDiv.innerHTML = message;
				                        
				                        // 지도를 보여준다.
				                        mapContainer.style.display = "block";
				                        map.relayout();
				                        // 지도 중심을 변경한다.
				                        map.setCenter(coords);
				                        // 마커를 결과값으로 받은 위치로 옮긴다.
				                        marker.setPosition(coords)
				                    }
								});
							}
						}).open();
			}
		</script>
	</form>
</body>
</html>