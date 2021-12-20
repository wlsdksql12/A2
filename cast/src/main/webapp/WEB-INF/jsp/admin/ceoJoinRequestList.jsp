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
            <h1 class="h3 mb-0 text-gray-800">사업자 가입 요청</h1>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="/admin/adminIndex">Home</a></li>
              <li class="breadcrumb-item">가입승인요청리스트</li>
              <li class="breadcrumb-item active" aria-current="page">사업자가입요청</li>
            </ol>
          </div>
          <!-- Row -->
          <div class="row" style="text-align:center">
            <!-- DataTable with Hover -->
            <div class="col-lg-12">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">사업자 가입 요청</h6>

					<select class="form-control-sm" name="state" id="state" onchange="chageState()">
						<option hidden="" selected="selected">전체</option>
						<option value="" >전체</option>
                        <option value="요청">요청</option>
                        <option value="거절">거절</option>
                        <option value="승인">승인</option>
					</select>

                </div>
                <div class="table-responsive p-3">
                  <table class="table align-items-center table-flush table-hover" id="dataTableHover">
                    <thead class="thead-light">
					<tr style="text-align:center" class="table-primary">
						<th width="10%">요청 번호</th>
						<th width="10%">아이디</th>
						<th width="10%">이름</th>
						<th width="15%">E-mail</th>
						<th width="20%">전화번호</th>
						<th width="10%">현재상태</th>
						<th width="10%">요청날짜</th>					
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${joinCeoList}" var="joinCeo">
							<c:choose>
								<c:when test="${joinCeo.active eq '요청'}">
									<tr style="text-align:center" style = "cursor:pointer;" onClick = " location.href='/admin/ceoSelectOne?joinCeoId=${joinCeo.joinCeoId}'">
								</c:when>
								<c:otherwise>
									<tr style="text-align:center">
								</c:otherwise>
							</c:choose>
							
								<td>${joinCeo.joinCeoId}</td>
								<td>${joinCeo.ceo.ceoId}</td>
								<td>${joinCeo.ceo.ceoName}</td>
								<td>${joinCeo.ceo.ceoEmail}</td>
								<td>${joinCeo.ceo.ceoPhonenum}</td>
								<td>${joinCeo.active}</td>
								<td>${fn:substring(joinCeo.createDate,0,10)}</td>
							</tr>
						</c:forEach>
					</tbody>
                  </table>
                </div>
                <div>
					<c:if test="${startPage > 1}">
						<a href="/admin/ceoJoinRequestList?currentPage=${startPage-1}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">◁</a>
					</c:if>
					<c:forEach begin="${startPage}" end="${lastPage}" var="i">
						<c:choose>
							<c:when test="${i == currentPage}">
								<a href="/admin/ceoJoinRequestList?currentPage=${i}&searchTitle=${searchTitle}" class="btn btn-secondary">${i}</a>
							</c:when>
							<c:when test="${i != 0}">
								<a href="/admin/ceoJoinRequestList?currentPage=${i}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">${i}</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${lastPage != totalPage}">
						<a href="/admin/ceoJoinRequestList?currentPage=${lastPage+1}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">▷</a>
					</c:if>
				</div>
				<br>
				<form method="get" action="/admin/ceoJoinRequestList" id="search">
					<input name="searchTitle" value="${searchTitle}">
					<input type="hidden" name="state" value="${state}">
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
<script type="text/javascript">
// 넘어오는 state값으로 select의 option선택되게 보여주기
$(document).ready(function(){
	$('#state').val("<c:out value='${state}'/>").prop("selected",true);
});

	
	function chageState() {
		
		var selectState = document.getElementById("state");
		var selectValue = selectState.options[selectState.selectedIndex].value;
		console.log(selectValue);
		$('input[name=state]').attr('value',selectValue);
		$('input[name=searchTitle]').attr('value','');
		/*
		var search = document.getElementById("search");
		var newP = document.createElement('p');
		newP.innerHTML = "<input type='hidden'name='state' value='"+selectValue+"'>";
		search.appendChild(newP);
		*/
		$('#search').submit();
	}

</script>
</html>