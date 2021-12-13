<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table align-items-center table-flush">
			<tr>
				<td width="20%">번호</td>
				<td width="60%">제목</td>
				<td width="20%">글작성 시간</td>
			</tr>
			<tbody>
				<tr>
				<td>${exhibition.exhibitionNo}</td>
				<td>${exhibition.exhibitionTitle}</td>
				<td>${exhibition.createDate}</td>
			</tr>
			</tbody>
			<tr>
				<td colspan="3"><textarea class="content" rows="10" cols="100" readonly="readonly">${exhibition.exhibitionContent}</textarea></td>
			</tr>
		</table>
</body>
</html>