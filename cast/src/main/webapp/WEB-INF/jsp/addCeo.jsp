<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <meta charset="utf-8">
        <title>사업자 회원가입</title>
    </head>
    <body>
        <form method="post" action="/addCeo">
            <div class="jumbotron bg-white" align="center">
                <h3>Join the CAST</h3>
                <hr>
                <table style="text-align: center;">
                    <tr>
                        <td style="font-weight: bold;">이름</td>
                        <td>
                            <input type="text" class="form-control" placeholder="Name" name="ceoName">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">주민등록번호</td>
                        <td>
                            <input type="password" class="form-control" name="ceoJumin">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">아이디</td>
                        <td>
                            <input type="text" class="form-control" placeholder="ID" name="ceoId">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">비밀번호</td>
                        <td>
                            <input type="password" class="form-control" placeholder="Password" name="ceoPw">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">이메일</td>
                        <td>
                            <input type="text" class="form-control" placeholder="email@example.com" name="ceoEmail">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">전화번호</td>
                        <td>
                            <input type="text" class="form-control" placeholder="010-0000-0000" name="ceoPhonenum">
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">사업자등록번호&nbsp; &nbsp;</td>
                        <td>
                            <input type="text" class="form-control" name="ceoLicense">
                        </td>
                    </tr>
                </table>
                <hr>
                <button type="submit" class="btn btn-outline-success">회원가입</button>
                &nbsp;
                <button type="reset" class="btn btn-outline-danger">초기화</button>
                &nbsp;
                <a href="#" onclick="history.go(-1)" class="btn btn-outline-warning">이전</a>
            </div>
        </form>
    </body>
</html>