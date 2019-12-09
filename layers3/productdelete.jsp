<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>商品削除</title></head>
<body>
	<h1>商品の削除</h1>
	<table border="1">
		<tr><th>商品番号</th><th>商品名</th><th>価格</th><th>在庫</th><th>カロリー</th><th>発売日</th><th>種類</th>
			<th>画像</th><th>たんぱく質</th><th>糖質</th><th>脂質</th><th>ビタミン</th><th>無機質</th><th>小麦</th><th>卵</th><th>乳</th><th>落花生</th><th>そば</th><th>えび</th><th>かに</th></tr>
		<c:forEach var="p" items="${product}">
			<tr><td>${p.id}</td><td>${p.name}</td><td>${p.price}</td><td>${p.stock}</td>
			<td>${p.calorie}</td><td>${p.date}</td><td>${p.type}</td>
			<td><img src="${p.image}"></td></td><td>${p.pro}</td><td>${p.carbo}</td>
			<td>${p.lip}</td><td>${p.vita}</td><td>${p.ino}</td>
			<td>${p.wheat}</td><td>${p.egg}</td><td>${p.milk}</td>
			<td>${p.peanut}</td><td>${p.buck}</td><td>${p.shrimp}</td>
			<td>${p.kani}</td></tr>
			<td><form method='post' action='pde'><input type="hidden" name ="id" value="${p.id}"><input type="submit" value="削除"></form></td>
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