<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <meta charset="UTF-8">
        <title>사업자 로그인</title>
    </head>
    <body>
        <form method="post" action="/ceoLogin">
            <table>
                <tr>
                    <td style="font-weight: bold;">아이디</td>
                    <td>
                        <input type="text" class="form-control" name="ceoId">
                    </td>
                </tr>
                <tr>
                    <td style="font-weight: bold;">비밀번호</td>
                    <td>
                        <input type="password" class="form-control" name="ceoPw">
                    </td>
                </tr>
            </table>
            <br>
            <button type="submit" class="btn btn-outline-success">로그인</button>
            <a href="#" onclick="history.go(-1)" class="btn btn-outline-warning">뒤로가기</a>
        </form>
    </body>
</html>