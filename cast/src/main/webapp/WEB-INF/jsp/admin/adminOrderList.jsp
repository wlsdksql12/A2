<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="${pageContext.request.contextPath}/resources/admin_template/img/logo/logo.png" rel="icon">
  <title>RuangAdmin - DataTables</title>
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
            <h1 class="h3 mb-0 text-gray-800">예약 결제 리스트</h1>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/adminIndex">Home</a></li>
              <li class="breadcrumb-item">예약결제리스트</li>
              <li class="breadcrumb-item active" aria-current="page">예약 리스트</li>
            </ol>
          </div>

          <!-- Row -->
          <div class="row">
            <!-- DataTable with Hover -->
            <div class="col-lg-12">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">체험 예약 리스트</h6>
                </div>
                <div class="table-responsive p-3">
                  <table class="table align-items-center table-flush table-hover" id="dataTableHover" style="text-align: center;">
                    <thead class="thead-light">
                      <tr>
                        <th width="100px;">예약 번호</th>
                        <th>고객ID</th>
                        <th>체험 이름</th>
                        <th>예약 날짜</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${experienceOrderList}" var="expOrderList">
                      	<tr style="text-align:center" style = "cursor:pointer;" onClick = " location.href='${pageContext.request.contextPath}/admin/experiencePaymentOne?experienceOrderId=${expOrderList.experienceOrderId}'">
                      		<td>${expOrderList.experienceOrderId}</td>
                      		<td>${expOrderList.customerId}</td>
                      		<td>${expOrderList.experienceName}</td>
                      		<td>${expOrderList.createDate}</td>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <!-- 절취선 -->
            <!-- DataTable with Hover -->
            <div class="col-lg-12">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">숙소 예약 리스트</h6>
                </div>
                <div class="table-responsive p-3">
                  <table class="table align-items-center table-flush table-hover" id="dataTableHover1" style="text-align: center;">
                    <thead class="thead-light">
                      <tr>
                        <th width="100px;">예약 번호</th>
                        <th>고객ID</th>
                        <th>호텔 이름</th>
                        <th>예약 날짜</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${roomOrderList}" var="roomOrderList">
                      	<tr style="text-align:center" style = "cursor:pointer;" onClick = " location.href='${pageContext.request.contextPath}/admin/roomPaymentOne?roomOrderId=${roomOrderList.roomOrderId}'">
                      		<td>${roomOrderList.roomOrderId}</td>
                      		<td>${roomOrderList.customerId}</td>
                      		<td>${roomOrderList.hotelName}</td>
                      		<td>${roomOrderList.createDate}</td>
                      	</tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <!--Row-->

          <!-- Documentation Link -->
          <div class="row">
            <div class="col-lg-12">
              <p>DataTables is a third party plugin that is used to generate the demo table below. For more information
                about DataTables, please visit the official <a href="https://datatables.net/" target="_blank">DataTables
                  documentation.</a></p>
            </div>
          </div>

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
  <!-- Page level plugins -->
  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/datatables/jquery.dataTables.js"></script>
  <script src="${pageContext.request.contextPath}/resources/admin_template/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script>
    $(document).ready(function () {
      $('#dataTableHover').DataTable(); // ID From dataTable with Hover
      $('#dataTableHover1').DataTable(); // ID From dataTable with Hover
    });
  </script>

</body>

</html>