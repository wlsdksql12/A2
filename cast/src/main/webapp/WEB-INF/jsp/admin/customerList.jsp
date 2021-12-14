<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="${pageContext.request.contextPath}/resources/admin_template/img/logo/logo.png" rel="icon">
  <title>RuangAdmin - 고객 리스트</title>
  <link href="${pageContext.request.contextPath}/resources/admin_template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/admin_template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/admin_template/css/ruang-admin.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/admin_template/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>

<body id="page-top">
  <div id="wrapper">
    <!-- adminSidebar include -->
    <%@ include file="adminSidebar.jsp"%>
    
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        
        <!-- adminTopbar include -->
		<%@ include file="adminTopbar.jsp"%>
		
        <!-- Container Fluid-->
        <div class="container-fluid" id="container-wrapper">
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">고객 리스트</h1>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="./">Home</a></li>
              <li class="breadcrumb-item">가입자리스트</li>
              <li class="breadcrumb-item active" aria-current="page">고객리스트</li>
            </ol>
          </div>
          <!-- Row -->
          <div class="row" style="text-align:center">
            <!-- DataTable with Hover -->
            <div class="col-lg-12">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">고객 리스트</h6>
                </div>
                <div class="table-responsive p-3">
                  <table class="table align-items-center table-flush table-hover" id="dataTableHover">
                    <thead class="thead-light">
					<tr style="text-align:center" class="table-primary">
						<th width="15%">아이디</th>
						<th width="10%">이름</th>
						<th width="15%">E-mail</th>
						<th width="15%">전화번호</th>
						<th width="10%">활성상태</th>
						<th width="15%"></th>
						<th width="15%">생성날짜</th>					
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${customerList}" var="customer">
							<tr style="text-align:center">
								<td>${customer.customerId}</td>
								<td>${customer.customerName}</td>
								<td>${customer.customerEmail}</td>
								<td>${customer.customerPhoneNum}</td>
								<td>${customer.active}</td>
								<td>
									<!-- 활성화상태라면(active=1) 비활성화 버튼이 보이도록 -->
									<c:if test="${customer.active eq '1' }">
										<a href="/admin/customerDisable?customerId=${customer.customerId}" class="btn btn-secondary">비활성화</a>
									</c:if>
									<!-- 비활성화상태라면(active=0) 활성화 버튼이 보이도록 -->
									<c:if test="${customer.active eq '0' }">
										<a href="/admin/customerActive?customerId=${customer.customerId}" class="btn btn-outline-light text-dark" style="width: 90px">활성화</a>
									</c:if>
								</td>
								<td>${fn:substring(customer.createDate,0,10)}</td>
							</tr>
						</c:forEach>
					</tbody>
                  </table>
                </div>
                <div>
					<c:if test="${startPage > 1}">
						<a href="/admin/customerList?currentPage=${startPage-1}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">◁</a>
					</c:if>
					<c:forEach begin="${startPage}" end="${lastPage}" var="i">
						<c:choose>
							<c:when test="${i == currentPage}">
								<a href="/admin/customerList?currentPage=${i}&searchTitle=${searchTitle}" class="btn btn-secondary">${i}</a>
							</c:when>
							<c:otherwise>
								<a href="/admin/customerList?currentPage=${i}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${lastPage != totalPage}">
						<a href="/admin/customerList?currentPage=${lastPage+1}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">▷</a>
					</c:if>
				</div>
				<br>
				<form method="get" id="/admin/customerList">
					<input name="searchTitle" value="${searchTitle}">
					<button>검색</button>
				</form>
				<br>
              </div>
            </div>
          </div>
          <!--Row-->
          
          <!-- Modal Logout include 로그아웃 클릭 시 나타나는 메시지 창-->
          <%@ include file="adminModalLogout.jsp"%>

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
  <!-- Page level plugins 삭제해도 문제 없을듯?-->
  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/datatables/dataTables.bootstrap4.min.js"></script>

</body>

</html>