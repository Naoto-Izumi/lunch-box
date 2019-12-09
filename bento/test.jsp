<%@page pageEncoding="Windows-31J" contentType="text/html; charset=Windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Test</title>
</head>
<body>
    <table>
        <c:forEach var="pro" items="${tableBefore}">
            <tr>
                <td>${pro.count}</td>
                <td>${pro.name}</td>
                <td>${pro.type}</td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <table>
        <c:forEach var="pro" items="${tableAfter}">
            <tr>
                <td>${pro.count}</td>
                <td>${pro.name}</td>
                <td>${pro.type}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>