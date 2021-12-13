<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnaListOne</title>
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
      <h1>qna상세보기</h1>
      <a href="/updateQna?qnaId=${qnaId}&customerId=${customerId}" id="insertBtn" class="btn btn-outline-success">수정</a>
      <a href="/deleteQna?qnaId=${qnaId}&customerId=${customerId}" id="insertBtn" class="btn btn-outline-success">삭제</a>
      <table border="1">
         <tr style="text-align:center" class="table-primary">
            <th width="40">번호</th>
            <th width="110">카테고리</th>
            <th width="380">제목</th>
            <th width="380">내용</th>
            <th width="110">작성자</th>
            <th width="90">작성날짜</th>
            <th width="90">수정날짜</th>
         </tr>
            <tr style="text-align:center" height="70px">
               <td>${qnaId}</td>
               <td>${qnaCategory}</td>
               <td>${qnaTitle}</td>
               <td>${qnaContent}</td>
               <td>${customerId}</td>
               <td>${createDate}</td>
               <td>${updateDate}</td>
            </tr>
      </table>
      <a href="/customerIndex?customerId=${customerId}&currentPage=1">이전</a>

   </div>
</body>
</html>