<%@ page import="service.DrinkService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    DrinkService service = new DrinkService();
    pageContext.setAttribute("drinkList", service.getList());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table border="1">
        <tr>
            <th>이미지</th><th>음료명</th><th>가격</th>
        </tr>
        <c:forEach var="i" items="${drinkList}">
            <tr>
                <td><img width="150px" height="150px" src="${i.img}"/></td><td>${i.name}</td><td>${i.price}</td>
                <td><input type="text" name="code" value="${i.code}" hidden>
                    <input type="text" name="customerNum" value="" hidden>
                    <br><input type="submit" value="담기" formaction="customerDrinkAdd.jsp?code=${i.code}"></td>
            </tr>
        </c:forEach>
    </table>
</form>
<jsp:include page="basket.jsp"/>
</body>
</html>
