<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeList</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
	table {
				width: 700px;
				margin-left:auto; 
    			margin-right:auto;
			}
	#boardCategoryDiv{
		margin-right:555px; 
	}
	#insertBtn{
		margin-left:640px; 
	}
</style>
</head>
<body>
	<div class="container" style="text-align:center">
		<h1>공지사항</h1>
		<a href="/addNotice" id="insertBtn" class="btn btn-outline-success">작성</a>
		<table border="1">
			<tr style="text-align:center" class="table-primary">
				<th width="40">번호</th>
				<th width="380">제목</th>
				<th width="110">작성자</th>
				<th width="90">작성날짜</th>
			</tr>
			<c:forEach items="${noticeList}" var="notice">
				<tr style="text-align:center" height="70px">
					<td>${notice.noticeNo}</td>
					<td><a href="/noticeOne?noticeNo=${notice.noticeNo}">${notice.noticeTitle}</a></td>
					<td>관리자</td>
					<td>${notice.createDate}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<c:if test="${startPage > 1}">
				<a href="/noticeList?currentPage=${startPage-1}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">◁</a>
			</c:if>
			<c:forEach begin="${startPage}" end="${lastPage}" var="i">
				<c:choose>
					<c:when test="${i == currentPage}">
						<a href="/noticeList?currentPage=${i}&searchTitle=${searchTitle}" class="btn btn-secondary">${i}</a>
					</c:when>
					<c:otherwise>
						<a href="/noticeList?currentPage=${i}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${lastPage != totalPage}">
				<a href="/noticeList?currentPage=${lastPage+1}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">▷</a>
			</c:if>
		</div>
		<form method="get" id="/noticeList">
			<input name="searchTitle">
			<button>검색</button>
		</form>	
	</div>
</body>
</html>