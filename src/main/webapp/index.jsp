<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <th colspan="2">매니저 로그인</th><th rowspan="3"><input type="submit" value="로그인" formaction="managerLogin.do"></th>
        </tr>
        <tr>
            <td>아이디</td><td><input type="text" name="ID"></td>
        </tr>
        <tr>
            <td>비밀번호</td><td><input type="password" name="PW"></td>
        </tr>
    </table>
</form>
<a href="createBasket.do">주문하기</a>
</body>
</html>
