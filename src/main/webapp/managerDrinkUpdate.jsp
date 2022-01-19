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
<form method="post" enctype="multipart/form-data">
    <table border="1">
        <tr>
            <th colspan="2">음료 정보 변경</th>
            <th rowspan="8"><input type="submit" value="변경" onclick="return inputCheck()" formaction="drinkUpdate.do">
                <br><input type="submit" value="삭제" formaction="drinkDelete.do?code=${drink.code}"></th>
        </tr>
        <tr>
            <td>음료코드</td><td><input type="text" id="dCode" name="code" value="${drink.code}" readonly></td>
        </tr>
        <tr>
            <td>음료명</td><td><input type="text" id="dName" name="name" value="${drink.name}"></td>
        </tr>
        <tr>
            <td>가격</td><td><input type="text" id="dPrice" name="price" value="${drink.price}"></td>
        </tr>
        <tr>
            <td>수량</td><td><input type="text" id="dStock" name="stock" value="${drink.stock}"></td>
        </tr>
        <tr>
            <td rowspan="2">기존 이미지</td><td><img width="300px" height="300px" src="${drink.img}" alt="${drink.img}">
        </tr>
        <tr>
           <td>파일 경로 : <input type="text" name="originImg" value="${drink.img}" readonly></td>
        </tr>
        <tr>
            <td>변경할 이미지</td><td><input type="file" name="newImg"></td>
        </tr>
    </table>
</form>
</body>
<script>
    function inputCheck() {
        if (document.getElementById("dName").value.length === 0) {
            alert("음료명을 입력하세요");
            document.getElementById("dName").focus();
            return false;
        } else if (document.getElementById("dPrice").value.length === 0) {
            alert("가격을 입력하세요");
            document.getElementById("dPrice").focus();
            return false;
        } else if (document.getElementById("dStock").value.length === 0) {
            alert("수량을 입력하세요");
            document.getElementById("dStock").focus();
            return false;
        }
    }
</script>
</html>
