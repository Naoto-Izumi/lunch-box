<%@page pageEncoding="Windows-31J" contentType="text/html; charset=Windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
</head>
    <body>
            <p>name=${sessionScope.ub.name}</p>
            <p>tel=${sessionScope.ub.tel}</p>
            <p>mail=${sessionScope.ub.mail}</p>
            <p>address=${sessionScope.ub.address}</p>
            <p>time=${sessionScope.ub.time}</p>
            <p>price=${sessionScope.ub.price}</p>
            <p>total=${sessionScope.realTotal}</p>
            <a href="CompleteServlet">完了ページ</a>
    </body>
</html>