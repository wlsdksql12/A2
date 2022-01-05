<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="${pageContext.request.contextPath}/resources/admin_template/img/logo/logo.png" rel="icon">
  <title>RuangAdmin - 사업자 가입 요청</title>
  <link href="${pageContext.request.contextPath}/resources/admin_template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/admin_template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/admin_template/css/ruang-admin.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/admin_template/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>
<style>
	input{
		text-align: center;
	}
</style>
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
            <h1 class="h3 mb-0 text-gray-800">사업자 상세보기</h1>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/adminIndex">Home</a></li>
              <li class="breadcrumb-item">가입승인요청리스트</li>
              <li class="breadcrumb-item active" aria-current="page">사업자상세보기</li>
            </ol>
          </div>
          <!-- Row -->
          <div class="row" style="text-align:center">
            <!-- DataTable with Hover -->
            <div class="col-lg-12">
            	<div class="card mb-4">
            		<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                 		 <h6 class="m-0 font-weight-bold text-primary">사업자 상세보기</h6>
            		</div>
            		<div class="table-responsive p-3">
					<div class="input-form-backgroud row">
					<div class="input-form col-md-12 mx-auto">
					<div class="mb-3">
						<label for="name">ID</label>
						<input type="text" class="form-control" name="travelerName" value="${joinCeo.ceoId}" readonly="readonly" required>
					</div>
					<div class="mb-3">
						<label for="name">이름</label>
						<input type="text" class="form-control" name="travelerName" value="${joinCeo.ceoName}" readonly="readonly" required>
					</div>
					<div class="mb-3">
						<label for="phonenumber">전화번호</label>
						<input type="text" class="form-control" name="travelerPhoneNum" value="${joinCeo.ceoPhonenum}" readonly="readonly" required>
					</div>
					<div class="mb-3">
						<label for="email">이메일</label>
						<input type="text" class="form-control" name="travelerEmail" value="${joinCeo.ceoEmail}" readonly="readonly"required>
					</div>
					<div class="mb-3">
						<label for="license">라이센스</label>
						<input type="text" class="form-control" name="travelerLicense" value="${joinCeo.ceoLicense}" readonly="readonly" required>
					</div>
					<div class="mb-3">
						<label for="subscriptionNo">구독</label>
						<input type="text" class="form-control" name="subscriptionNo" value="${joinCeo.subscription.subscriptionName}" readonly="readonly" required>
					</div>
					<c:if test="${joinCeo.active eq '요청' }">
						<a class="btn btn-outline-success" href="${pageContext.request.contextPath}/admin/updateCeoJoinRequest?joinCeoId=${joinCeo.joinCeoId}&adminId=${loginAdminId}&state=승인&ceoId=${joinCeo.ceoId}&subscriptionNo=${joinCeo.subscriptionNo}">승인</a>
						<a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/admin/updateCeoJoinRequest?joinCeoId=${joinCeo.joinCeoId}&adminId=${loginAdminId}&state=거절">거절</a>
					</c:if>
					<c:if test="${joinCeo.active eq '승인' }">
						<hr>
						<p>승인되었습니다</p>
					</c:if>
					<c:if test="${joinCeo.active eq '거절' }">
						<hr>
						<p>거절되었습니다</p>
					</c:if>
				</div>
			</div>
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
              <b><a href="${pageContext.request.contextPath}https://indrijunanda.gitlab.io/" target="_blank">indrijunanda</a></b>
            </span>
          </div>
        </div>
      </footer>
      <!-- Footer -->
    </div>
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