<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qnaList</title>
</head>
<body>
	<h1>qnaList</h1>
	
	<table border="1">
		<tr>
			<td>제목</td>
			<td>작성자</td>
			<td>작성 날짜</td>
			<td>비밀글</td>
		</tr>
		<tr>
			<c:forEach items="${qnaList}" var="qna">
				<td>
					<h6><a href ="/qnaListOne?qnaId=${qna.qnaId}&customerId=${loginCustomerId}">${qna.qnaTitle}</a></h6>
				</td>
				<td>${qna.customerId}</td>
				<td>${qna.createDate}</td>
				<td>${qna.qnaSecret}</td>
			</c:forEach>			
		</tr>
	</table>
	<c:if test="${currentPage > 1}">
		<a href="/admin/qnaList?&currentPage=${currentPage-1}">이전</a>
	</c:if>
	<c:if test="${currentPage < lastPage}">
		<a href="/admin/qnaList?&currentPage=${currentPage+1}">다음</a>
	</c:if>
</body>
</html>