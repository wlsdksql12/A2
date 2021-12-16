<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	            <div class="col-xl-6 col-md-12">
                <div class="card table-card">
                    <div class="card-header">
                        <h5>QNA</h5>
                        <div class="card-header-right">
                            <div class="btn-group card-option">
                                <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="feather icon-more-horizontal"></i>
                                </button>
                                <ul class="list-unstyled card-option dropdown-menu dropdown-menu-right">
                                    <li class="dropdown-item full-card"><a href="#!"><span><i class="feather icon-maximize"></i> maximize</span><span style="display:none"><i class="feather icon-minimize"></i> Restore</span></a></li>
                                    <li class="dropdown-item minimize-card"><a href="#!"><span><i class="feather icon-minus"></i> collapse</span><span style="display:none"><i class="feather icon-plus"></i> expand</span></a></li>
                                    <li class="dropdown-item reload-card"><a href="#!"><i class="feather icon-refresh-cw"></i> reload</a></li>
                                    <li class="dropdown-item close-card"><a href="#!"><i class="feather icon-trash"></i> remove</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="card-body p-0">
                        <div class="table-responsive">
                            <table class="table table-hover mb-0">
                                <thead>
                                    <tr>
                                        <th>
                                            <div class="chk-option">
                                                <label class="check-task custom-control custom-checkbox d-flex justify-content-center done-task">
                                                    <input type="checkbox" class="custom-control-input">
                                                    <span class="custom-control-label"></span>
                                                </label>
                                            </div>
                                            제목
                                        </th>
                                        <th>작성자</th>
                                        <th>작성 날짜</th>
                                        <th class="text-right">비밀글</th>
                                    </tr>
                                </thead>
                                <tbody>
                                 <c:forEach items="${qnaList}"  var="qna">
                                	
                                    <tr>
                                        <td>
                                            <div class="chk-option">
                                                <label class="check-task custom-control custom-checkbox d-flex justify-content-center done-task">
                                                    <input type="checkbox" class="custom-control-input">
                                                    <span class="custom-control-label"></span>
                                                </label>
                                            </div>
                                            <div class="d-inline-block align-middle">
                                                <img src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/images/user/avatar-4.jpg" alt="user image" class="img-radius wid-40 align-top m-r-15">
                                                <div class="d-inline-block">
                                                    <h6><a href ="/qnaListOne?qnaId=${qna.qnaId}&customerId=${loginCustomerId}">${qna.qnaTitle}</a></h6>
                                                </div>
                                            </div>
                                        </td>
                                        <td>${qna.customerId}</td>
                                        <td>${qna.createDate}</td>
                                        <td class="text-right"><label class="badge badge-light-danger">${qna.qnaSecret}</label></td>
                                    </tr>
                                   
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="table container mt-3">
							<c:if test="${currentPage > 1}">
								<a href="/qnaList?customerId=${loginCustomerId}&currentPage=${currentPage-1}">이전</a>
							</c:if>
							<c:if test="${currentPage < lastPage}">
								<a href="/qnaList?customerId=${loginCustomerId}&currentPage=${currentPage+1}">다음</a>
							</c:if>
							</div>
                        </div>
                    </div>
                </div>
                   <!-- Required Js -->
    <script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/vendor-all.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/plugins/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/ripple.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/pcoded.min.js"></script>

<!-- Apex Chart -->
<script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/plugins/apexcharts.min.js"></script>


<!-- custom-chart js -->
<script src="${pageContext.request.contextPath}/resources/assets/customer/dist/assets/js/pages/dashboard-main.js"></script>
                
</body>
</html>