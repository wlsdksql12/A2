<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전시 소개</title>
</head>
<body>
	<form method="post" action="/admin/addExhibition">
			<table class="table align-items-center table-flush">
				<tr>
					<td width="10%" style="text-align: right">제목</td>
					<td width="80%"><input type="text" name="exhibitionTitle" style="width:685px; text-align: center"></td>
				</tr>
				<tbody>
					<tr>
						<td style="text-align: right">내용</td>
						<td><textarea name="exhibitionContent" rows="10" cols="80"></textarea></td>
					</tr>
				</tbody>
			</table>
			<button type="submit" class="btn btn-outline-success">저장</button>
		</form>
</body>
</html>