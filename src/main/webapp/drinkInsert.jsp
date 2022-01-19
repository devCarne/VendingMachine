<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data">
    <table border="1">
        <tr>
            <th colspan="2">음료 등록</th>
            <th rowspan="5"><input type="submit" value="등록" onclick="return inputCheck()" formaction="drinkInsert.do"></th>
        </tr>
        <tr>
            <td>음료코드</td>
            <td><input type="text" id="dCode" name="code"></td>
        </tr>
        <tr>
            <td>음료명</td>
            <td><input type="text" id="dName" name="name"></td>
        </tr>
        <tr>
            <td>가격</td>
            <td><input type="text" id="dPrice" name="price"></td>
        </tr>
        <tr>
            <td>수량</td>
            <td><input type="text" id="dStock" name="stock"></td>
        </tr>
        <tr>
            <td>이미지</td>
            <td><input type="file" id="dImg" name="img"></td>
        </tr>
    </table>
</form>
</body>
<script>
    function inputCheck() {
        if (document.getElementById("dCode").value.length === 0) {
            alert("음료코드를 입력하세요");
            document.getElementById("dCode").focus();
            return false;
        } else if (document.getElementById("dName").value.length === 0) {
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
        } else if (document.getElementById("dImg").value.length === 0) {
            alert("이미지를 넣어주세요");
            document.getElementById("dImg").focus();
            return false;
        }
    }
</script>
</html>
