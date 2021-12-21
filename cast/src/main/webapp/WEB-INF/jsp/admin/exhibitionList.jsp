<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="${pageContext.request.contextPath}/resources/admin_template/img/logo/logo.png" rel="icon">
  <title>RuangAdmin - Dashboard</title>
  <link href="${pageContext.request.contextPath}/resources/admin_template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/admin_template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/admin_template/css/ruang-admin.min.css" rel="stylesheet">
</head>

<body id="page-top">
  <div id="wrapper">
   
	<!-- adminSidebar include -->
    <%@ include file="/WEB-INF/jsp/admin/adminSidebar.jsp"%>
   
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        
        <!-- adminTopbar include -->
		<%@ include file="/WEB-INF/jsp/admin/adminTopbar.jsp"%>

        <!-- Container Fluid-->
        <div class="container-fluid" id="container-wrapper">
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">전시소개</h1>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="/admin/adminIndex">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">전시소개</li>
            </ol>
          </div>
		<div class="container" style="text-align:center">	
	<div class="card">
      <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
        <h6 class="m-0 font-weight-bold text-primary">전시소개</h6>
        <c:if test="${loginAdminId != null}">
				<a href="/admin/addExhibition" id="insertBtn" class="btn btn-outline-primary" style="margin-right: 60px">작성</a>
			</c:if>
      </div>
      
      <div class="table-responsive">
		<table class="table align-items-center table-flush">
		  <thead class="thead-light">
			<tr style="text-align:center" class="table-primary">
				<th width="10%">번호</th>
				<th width="60%">제목</th>
				<th width="10%">작성자</th>
				<th width="20%">작성날짜</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${exhibitionList}" var="exhibition">
					<tr style="text-align:center">
						<td>${exhibition.exhibitionNo}</td>
						<td><a href="/admin/exhibitionOne?exhibitionNo=${exhibition.exhibitionNo}">${exhibition.exhibitionTitle}</a></td>
						<td>${exhibition.admin.adminName}</td>
						<td>${exhibition.createDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<c:if test="${startPage > 1}">
				<a href="/admin/exhibitionList?currentPage=${startPage-1}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">◁</a>
			</c:if>
			<c:forEach begin="${startPage}" end="${lastPage}" var="i">
				<c:choose>
					<c:when test="${i == currentPage}">
						<a href="/admin/exhibitionList?currentPage=${i}&searchTitle=${searchTitle}" class="btn btn-secondary">${i}</a>
					</c:when>
					<c:otherwise>
						<a href="/admin/exhibitionList?currentPage=${i}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${lastPage != totalPage}">
				<a href="/admin/exhibitionList?currentPage=${lastPage+1}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">▷</a>
			</c:if>
		</div>
		<br>
		<form method="get" id="/admin/exhibitionList">
			<input name="searchTitle" value="${searchTitle}">
			<button>검색</button>
		</form>	
		</div>
		<br>
	</div>
</div>


          <!-- Modal Logout include 로그아웃 클릭 시 나타나는 메시지 창-->
          <%@ include file="/WEB-INF/jsp/admin/adminModalLogout.jsp"%>

        </div>
        <!---Container Fluid-->
      </div>
      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>copyright &copy; <script> document.write(new Date().getFullYear()); </script> - developed by
              <b><a href="https://indrijunanda.gitlab.io/" target="_blank">indrijunanda</a></b>
            </span>
          </div>
        </div>

        <div class="container my-auto py-2">
          <div class="copyright text-center my-auto">
            <span>copyright &copy; <script> document.write(new Date().getFullYear()); </script> - distributed by
              <b><a href="https://themewagon.com/" target="_blank">themewagon</a></b>
            </span>
          </div>
        </div>
      </footer>
      <!-- Footer -->
    </div>
  </div>

  <!-- Scroll to top -->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/js/ruang-admin.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/chart.js/Chart.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/js/demo/chart-area-demo.js"></script>  
</body>

</html>