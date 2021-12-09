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
				<th width="110">닉네임</th>
				<th width="90">작성날짜</th>
			</tr>
			<c:forEach items="${boardList}" var="board">
				<tr style="text-align:center" height="70px">
					<td>${board.boardNo}</td>
					<td>
						<a href="/boardList?currentPage=1&boardCategory=${board.boardCategory}">${board.boardCategory}</a>
					</td>
					<td>
						<a href="/boardOne?boardNo=${board.boardNo}">${board.boardTitle}</a>
					</td>
					<td>${board.boardUser}</td>
					<td>${board.boardDate}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<c:if test="${startPage > 1}">
				<a href="/boardList?currentPage=${startPage-1}&boardCategory=${boardCategory}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">◁</a>
			</c:if>
			<c:forEach begin="${startPage}" end="${lastPage}" var="i">
				<c:choose>
					<c:when test="${i == currentPage}">
						<a href="/boardList?currentPage=${i}&boardCategory=${boardCategory}&searchTitle=${searchTitle}" class="btn btn-secondary">${i}</a>
					</c:when>
					<c:otherwise>
						<a href="/boardList?currentPage=${i}&boardCategory=${boardCategory}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${lastPage != totalPage}">
				<a href="/boardList?currentPage=${lastPage+1}&boardCategory=${boardCategory}&searchTitle=${searchTitle}" class="btn btn-outline-light text-dark">▷</a>
			</c:if>
		</div>
		<form method="get" id="/boardList">
			<input name="searchTitle">
			<input hidden="hidden" name="boardCategory" value="${boardCategory}">
			<button>검색</button>
		</form>	
	</div>
</body>
</html>