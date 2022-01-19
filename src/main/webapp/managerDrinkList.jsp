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
<table>
    <tr>
        <th>코드</th><th>음료명</th><th>가격</th><th>재고</th><th>이미지</th>
    </tr>
    <c:forEach var="i" items="${drinkList}">
        <tr>
            <td><a href="managerDrinkUpdate.jsp?code=${i.code}">${i.code}</a></td><td>${i.name}</td><td>${i.price}</td><td>${i.stock}</td><td><img width="150px" height="150px" src="${i.img}"/>${i.img}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
