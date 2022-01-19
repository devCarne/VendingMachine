<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <th colspan="2">관리자 등록</th><th rowspan="4"><input type="submit" value="등록" onclick="return inputCheck()" formaction="managerSignUp.do"></th>
        </tr>
        <tr>
            <td>아이디</td><td><input type="text" id="mID" name="ID"></td>
        </tr>
        <tr>
            <td>비밀번호</td><td><input type="password" id="mPW" name="PW"></td>
        </tr>
        <tr>
            <td>이름</td><td><input type="text" id="mName" name="name"></td>
        </tr>
    </table>
</form>
</body>
<script>
    function inputCheck() {
        if (document.getElementById("mID").value.length === 0) {
            alert("아이디를 입력하세요");
            document.getElementById("mID").focus();
            return false;
        } else if (document.getElementById("mPW").value.length === 0) {
            alert("비밀번호를 입력하세요");
            document.getElementById("mPW").focus();
            return false;
        } else if (document.getElementById("mName").value.length === 0) {
            alert("이름을 입력하세요");
            document.getElementById("mName").focus();
            return false;
        }
    }
</script>
</html>
