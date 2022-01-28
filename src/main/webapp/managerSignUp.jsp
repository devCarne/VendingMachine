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
            <th colspan="2">관리자 등록</th>
            <th rowspan="4"><input type="submit" value="등록" onclick="return inputCheck()" formaction="managerSignUp.do"></th>
        </tr>
        <tr>
            <td>아이디</td><td><input type="text" id="id" name="id"></td>
            <td><input type="button" onclick="idCheck()" value="중복체크"><div id="message"></div></td>
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
    function idCheck() {
        let xhr = new XMLHttpRequest();

        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 200) {
                document.getElementById("message").innerText = xhr.responseText;
            }
        };
        let id = document.getElementById("id").value;
        xhr.open("GET", "IdCheck.do?id=" + id);
        xhr.send();
    }
    // Jquery AJAX
    // $('#checkBtn').on("click", (e) => {
    //     const id = $('#id').val();
    //     e.preventDefault()
    //     console.log('btn clock')
    //     if(id.length === 0) return alert("아이디를 입력하세요")
    //
    //     $.ajax({
    //         type:'post',
    //         async:false,
    //         url:'IdCheck.do',
    //         dataType:'text',
    //         data:{id:id},
    //         success:function (data, textStatus) {
    //             if (data === 'yes') {
    //                 $('#message').text('사용 가능한 아이디입니다.')
    //             } else {
    //                 $('#message').text('이미 사용 중인 아이디입니다.')
    //             }
    //         },
    //         error:function (data, textStatus) {
    //             console.log('error');
    //         }
    //     })
    // })

    function inputCheck() {
        if (document.getElementById("message").textContent === "yes") {
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
        } else {
            alert("중복검사를 해주세요");
            return false;
        }
    }

    $(function() {
        $('#checkJson').on('click', () => {
            const jsonStr = '{' +
                '"member":[' +
                '{"name":"김공","age":26,"nick":"kimball"},' +
                '{"name":"이불","age":21,"nick":"FireLee"}' +
                ']' +
                '}'
            console.log(jsonStr)
            const jsonInfo = JSON.parse(jsonStr)

            let output = '회원 정보<hr>'

            for(const i in jsonInfo.member) {
                output += '이름 : ' + jsonInfo.member[i].name + '<br>'
                output += '나이 : ' + jsonInfo.member[i].age + '<br>'
                output += '별명 : ' + jsonInfo.member[i].nick + '<hr>'
            }

            $('#output').html(output)
        })
    })
</script>
</body>
</html>
