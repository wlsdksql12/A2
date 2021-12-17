<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<br>
	<div>
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">상세 보기</h4>
					<p class="card-description">${experience.addressId}의 정보입니다.</p>
					${experience.address.postcode}
					${experience.address.roadAddress}
					<div class="table-responsive pt-3" id="form1">
						<table class="table table-bordered">
							<thead>
								
							</thead>
							<tbody>
							
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>