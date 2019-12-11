<%@page pageEncoding="Windows-31J" contentType="text/html; charset=Windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
</head>
    <body>
            <p>name=${sessionScope.p.name}</p>
            <p>tel=${sessionScope.p.tel}</p>
            <p>mail=${sessionScope.p.mail}</p>
            <p>address=${sessionScope.p.address}</p>
            <p>time=${sessionScope.p.time}</p>
            <p>type=${sessionScope.p.type}</p>
            <p>total=${sessionScope.realTotal}</p>
            <a href="CompleteServlet">完了ページ</a>
    </body>
</html>