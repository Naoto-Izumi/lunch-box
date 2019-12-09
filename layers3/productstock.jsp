<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>在庫管理</title></head>
<body>
	<h1>在庫の変更</h1>
	<table border="1">
		<tr><th>商品名</th><th>価格</th><th>在庫</th></tr>
		<c:forEach var="p" items="${product}">
		<form method='post' action='pscs'>
		<tr><td>${p.name}</td><td>${p.price}</td><td><input type="number" name="stock" value="${p.stock}"></td><td>
		<input type="hidden" name ="id" value="${p.id}"><input type="submit" value="変更"></td></tr>
		</form>
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