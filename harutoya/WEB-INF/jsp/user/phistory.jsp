<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>購入履歴</title>
    </head>
    <body>
        <h1>購入履歴</h1>

            <c:forEach var="a" items="${result}">
                <form method="post" action="uuc">
                <table>
                    <tr><td>${sessionScope.a.odate}</td><td>${sessionScope.a.sproid}</td><td>${sessionScope.a.scount}</td><td>${sessionScope.a.pid}</td></tr>
                </table>
            </form>
            </c:forEach>
    </body>
</html>