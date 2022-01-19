<%@ page import="dto.BasketDTO" %>
<%@ page import="service.DrinkService" %>
<%@ page import="dto.DrinkDTO" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");

    BasketDTO basket = (BasketDTO) session.getAttribute("basket");
    pageContext.setAttribute("time", basket.getDate());
    pageContext.setAttribute("selection", basket.getSelection());

    DrinkService service = new DrinkService();
    pageContext.setAttribute("list", service.getList());

    pageContext.setAttribute("sum", 0);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>장바구니</h2>
<form method="post">
<table border="1">
    <tr>
        <th>이미지</th><th>음료명</th><th>가격</th><th>수량</th><th>금액</th><th>비고</th>
    </tr>
    <c:forEach var="l" items="${list}">
        <c:if test="${selection.containsKey(l.code)}">
            <tr>
                <td><img width="150px" height="150px" src="${l.img}"></td>
                <td>${l.name}</td><td>${l.price}</td><td>${selection.get(l.code)}</td><td>${l.price * selection.get(l.code)}</td>
                <td><input type="submit" value="제거" formaction="basketDelete.do?code=${l.code}"></td>
                <td hidden>${sum = sum + l.price * selection.get(l.code)}</td>
            </tr>
        </c:if>
    </c:forEach>
    <tr>
        <td>총액</td><td colspan="4">${sum}</td><td><input type="submit" value="주문하기" formaction="basketOrder.do"></td>
    </tr>
</table>
</form>
</body>
</html>
