<%@ page import="service.OrderService" %>
<%@ page import="service.DrinkService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    OrderService service = new OrderService();
    pageContext.setAttribute("list", service.getList());

    DrinkService DrinkService = new DrinkService();
    pageContext.setAttribute("DrinkList", DrinkService.getList());

    pageContext.setAttribute("sum", 0);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" id="forRowspan">
    <tr>
        <th>코드</th><th>수량</th><th>주문자</th>
    </tr>
    <c:forEach var="i" items="${list}">
        <tr>
            <td>${i.code}</td><td>${i.quantity}</td><td>${i.order_time}</td>
        </tr>
    </c:forEach>
</table>
</body>
<script>
$(function(){
        $('#forRowspan').each(function() {
            var table = this;
            $.each([2,3,4] /* 합칠 칸 번호 */, function(c, v) {
                var tds = $('>tbody>tr>td:nth-child(' + v + ')', table).toArray();
                var i = 0, j = 0;
                for(j = 1; j < tds.length; j ++) {
                    if(tds[i].innerHTML != tds[j].innerHTML) {
                        $(tds[i]).attr('rowspan', j - i);
                        i = j;
                        continue;
                    }
                    $(tds[j]).hide();
                }
                j --;
                if(tds[i].innerHTML == tds[j].innerHTML) {
                    $(tds[i]).attr('rowspan', j - i + 1);
                }
            });
        });
    });
</script>
</html>
