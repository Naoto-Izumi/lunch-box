<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>商品削除</title></head>
<body>
	<h1>商品の削除</h1>
	<table border="1">
		<tr><th>商品番号</th><th>商品名</th><th>価格</th></tr>
		<c:forEach var="p" items="${product}">
			<tr><td>${p.id}</td><td>${p.name}</td><td>${p.price}</td><td>${p.stock}</td>
			<td>${p.calorie}</td><td>${p.date}</td><td>${p.type}</td>
			<td><img src="${p.image}"></td></td><td>${p.pro}</td><td>${p.carbo}</td>
			<td>${p.lip}</td><td>${p.vita}</td><td>${p.ino}</td>
			<td>${p.wheat}</td><td>${p.egg}</td><td>${p.milk}</td>
			<td>${p.peanut}</td><td>${p.buck}</td><td>${p.shrimp}</td>
			<td>${p.kani}</td></tr>
		</c:forEach>
	</table>

</body>
</html>