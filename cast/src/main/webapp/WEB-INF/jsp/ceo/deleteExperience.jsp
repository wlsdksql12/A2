<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체험 삭제 페이지</title>
</head>
<body>
	<%@ include file="ceoBase.jsp"%>
	<br>
	<form method="post" action="${pageContext.request.contextPath}/ceo/deleteExperience">
		<div class="col-lg-6 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h3 class="card-title">${experience.experienceId}번째글삭제하기</h3>
					<hr>

					<h4>삭제하시려면 아이디를 입력해주세요!</h4>
					<br>
					<div>
						<input type="hidden" name="experienceId"
							value="${experience.experienceId}">
					</div>
					<div>
						아이디 <br>
						<br> <input type="text" class="form-control " name="ceoId">
					</div>
					<p></p>
					<div align="right">
						<input type="button" value="뒤로가기" onclick="history.back(-1)"
							class="btn btn-inverse-secondary">
						<button type="submit" class="btn btn-inverse-danger">삭제</button>
						<button type="reset" class="btn btn-inverse-info">초기화</button>

					</div>
				</div>
			</div>
		</div>
		<div></div>
	</form>
</body>
</html>