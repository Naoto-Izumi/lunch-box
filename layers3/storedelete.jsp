<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>店舗削除</title></head>
<body>
	<h1>店舗の削除</h1>
	<table border="1">
		<tr><th>店舗番号</th><th>店舗名</th><th>住所</th><th>電話番号</th><th>営業時間</th></tr>
		<c:forEach var="s" items="${store}">
			<tr><td>${s.id}</td><td>${s.name}</td><td>${s.address}</td><td>${s.phone}<td>${s.hours}</td></tr>
		
		</c:forEach>
	</table>

</body>
</html>