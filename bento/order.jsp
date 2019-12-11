<%@page pageEncoding="Windows-31J" contentType="text/html; charset=Windows-31J"
import="java.util.Map"
import="java.util.TreeMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
</head>
<body>
    <table>
    <c:forEach var="list" items="${sessionScope.cb.cartList}">
    <tr><td>${list.syusyoku}</td>
            <td>${list.syusai}</td>
            <td>${list.huku1}</td>
            <td>${list.huku2}</td></tr>
        </c:forEach>
    </table>    
    <table>
    <c:forEach var="list" items="${sessionScope.tpb.priceList}">
            <tr><td>${list.syusyoku}</td>
            <td>${list.syusai}</td>
            <td>${list.huku1}</td>
            <td>${list.huku2}</td>
            <td>${list.total}</td></tr>
        </c:forEach>
    </table>

    <%
        Map map = (TreeMap)request.getAttribute("plist");

        for (Object val : map.values()) {

    %>
    <p><%=val%></p>
    <%
        }
    %>
<!-- 
    <table>
            <c:forEach var="list" items="${sessionScope.plist}">
                <tr><td>${list.name}</td>
                <td>${list.count}</td></tr>
            </c:forEach>
     </table>

    <p>${plist.count1}</p>
    <p>${plist.count2}</p>
    <p>${plist.count3}</p>
    <p>${plist.count4}</p>
    <p>${plist.count5}</p>
    <p>${plist.count6}</p> -->

        <p>合計:${realTotal}</p>
        <a href="TopServlet">もう一度頼む</a>
        <a href="userinformation.jsp">個人情報入力</a>
    </body>
</html>