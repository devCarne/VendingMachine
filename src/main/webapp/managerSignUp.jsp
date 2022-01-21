<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous">
    </script>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <th colspan="2">관리자 등록</th><th rowspan="4"><input type="submit" value="등록" onclick="return inputCheck()" formaction="managerSignUp.do"></th>
        </tr>
        <tr>
            <td>아이디</td><td><input type="text" id="id" name="id"></td><td><input type="submit" id="checkBtn" value="중복확인"><div id="message"></div></td>
        </tr>
        <tr>
            <td>비밀번호</td><td><input type="password" id="pw" name="pw"></td>
        </tr>
        <tr>
            <td>이름</td><td><input type="text" id="name" name="name"></td>
        </tr>
    </table>
</form>
<script>
    $('#checkBtn').on("click", (e) => {
        const id = $('#id').val();
        e.preventDefault()
        console.log('btn clock')
        if(id.length === 0) return alert("아이디를 입력하세요")

        $.ajax({
            type:'post',
            async:false,
            url:'IdCheck.do',
            dataType:'text',
            data:{id:id},
            success:function (data, textStatus) {
                if (data === 'yes') {
                    $('#message').text('사용 가능한 아이디입니다.')
                } else {
                    $('#message').text('이미 사용 중인 아이디입니다.')
                }
            },
            error:function (data, textStatus) {
                console.log('error');
            }
        })
    })

    function inputCheck() {
        if (document.getElementById("id").value.length === 0) {
            alert("아이디를 입력하세요");
            document.getElementById("id").focus();
            return false;
        } else if (document.getElementById("pw").value.length === 0) {
            alert("비밀번호를 입력하세요");
            document.getElementById("pw").focus();
            return false;
        } else if (document.getElementById("name").value.length === 0) {
            alert("이름을 입력하세요");
            document.getElementById("name").focus();
            return false;
        }
    }
</script>
</body>
</html>
