<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>店舗削除</title></head>
<body>
	<h1>店舗の削除</h1>
	<table border="1">
		<tr><th>店舗番号</th><th>店舗名</th><th>住所</th><th>電話番号</th><th>営業時間</th></tr>
		<c:forEach var="s" items="${store}">
			<tr><td>${s.id}</td><td>${s.name}</td><td>${s.address}</td><td>${s.phone}<td>${s.hours}</td>
			<td><form method='post' action='sde'><input type="hidden" name ="id" value="${s.id}"><input type="submit" value="削除"></form></td></tr>
		</c:forEach>
	</table>
<br>
<a href="addproduct.jsp">商品登録</a><br>
<a href="pss">在庫変更</a><br>
<a href="pqs">商品削除</a><br>
<a href="addstore.jsp">店舗登録</a><br>
<a href="sqs">店舗削除</a><br>
</body>
</html>