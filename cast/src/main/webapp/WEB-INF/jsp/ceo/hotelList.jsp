<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체험 리스트</title>

</head>
<body>

					<div class="table-responsive pt-3" id="form2">
						<!-- 호텔 리스트 -->
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
								<c:forEach items="${hotelList}" var="hotel">
									<tr>
										<td>${hotel.hotelId}</td>
										<td>
											<a href="#">${hotel.hotelName}</a>
										</td>
										<td>${hotel.hotelPrice}&#8361;</td>
										<td>${hotel.createDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						
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