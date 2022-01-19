<%@ page import="service.DrinkService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DrinkService service = new DrinkService();
    pageContext.setAttribute("drink", service.getDrink(request.getParameter("code")));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="text" name="code" value="${drink.code}" hidden>
    <table border="1">
        <tr>
            <th colspan="2">음료 주문</th>
            <th rowspan="5"><input type="submit" value="담기" formaction="basketInsert.do"></th>
        </tr>
        <tr>
            <td>음료명</td><td><input type="text" name="name" value="${drink.name}"></td>
        </tr>
        <tr>
            <td>가격</td><td><input type="text" name="price" value="${drink.price}"></td>
        </tr>
        <tr>
            <td>수량</td><td><input type="number" name="quantity" value="1" min="1"></td>
        </tr>
        <tr>
            <td rowspan="2">이미지</td><td><img width="300px" height="300px" src="${drink.img}" alt="${drink.img}">
        </tr>
    </table>
</form>

</body>
</html>
