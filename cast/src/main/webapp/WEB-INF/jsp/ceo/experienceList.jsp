<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체험 리스트</title>
<!-- plugins:css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ceo_template/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ceo_template/vendors/base/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ceo_template/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/ceo_template/images/favicon.png" />
<!-- JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="ceoBase.jsp" %>
	<br>
	<div>
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">사업체 목록</h4>
					<p class="card-description">등록한 사업체 목록입니다</p>
					<div align="right">
						<select id="select" class="form-control" style="width:100px; height:30px">
							<option id="1">체험</option>
							<option id="2">호텔</option>
						</select>
					</div>
					<div class="table-responsive pt-3" id="form1">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>제목</th>
									<th>가격</th>
									<th>작성날짜</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${experienceList}" var="experience">
									<tr>
										<td>${experience.experienceId}</td>
										<td>
											<a href="/ceo/experienceOne?experienceId=${experience.experienceId}">${experience.experienceName}</a>
										</td>
										<td>${experience.experiencePrice}&#8361;</td>
										<td>${experience.createDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<br>
						<div>
							<c:if test="${startPage > 1}">
								<a href="/ceo/experienceList?currentPage=${startPage-1}" class="btn btn-outline-light text-dark">처음으로</a>
							</c:if>
							<div class="btn-group">
							<c:forEach begin="${startPage}" end="${lastPage}" var="i">
								<c:choose>
									<c:when test="${i == currentPage}">
										<a href="/ceo/experienceList?currentPage=${i}" class="btn btn-group btn-secondary">${i}</a>
									</c:when>
									<c:otherwise>
										<a href="/ceo/experienceList?currentPage=${i}" class="btn btn-group btn-outline-secondary">${i}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</div>
							<c:if test="${lastPage != totalPage}">
								<a href="/ceo/hotelList?currentPage=${lastPage+1}" class="btn btn-outline-light text-dark">끝으로</a>
							</c:if>
						</div>
					</div>
					<div class="table-responsive pt-3" id="form2">
						<!-- 호텔 리스트 -->
						
						<!-- 페이징 -->
						<div>
							<c:if test="${startPage > 1}">
								<a href="/ceo/hotelList?currentPage=${startPage-1}" class="btn btn-outline-light text-dark">처음으로</a>
							</c:if>
							<div class="btn-group">
							<c:forEach begin="${startPage}" end="${lastPage}" var="i">
								<c:choose>
									<c:when test="${i == currentPage}">
										<a href="/ceo/hotelList?currentPage=${i}" class="btn btn-group btn-secondary">${i}</a>
									</c:when>
									<c:otherwise>
										<a href="/ceo/hotelList?currentPage=${i}" class="btn btn-group btn-outline-secondary">${i}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</div>
							<c:if test="${lastPage != totalPage}">
								<a href="/ceo/hotelList?currentPage=${lastPage+1}" class="btn btn-outline-light text-dark">끝으로</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
        $("#form2, #form3").hide();
        $("#select").change(function(){
            $("#form1, #form2, #form3").hide();
            $('#form'+$(this).find('option:selected').attr('id')).show();
        });
    </script>
</body>
</html>