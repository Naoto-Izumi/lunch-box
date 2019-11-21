<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
<head>
<title>商品一覧</title>
</head>
<body>
	<h1>商品一覧</h1>
	<form method='post' action='add'>
		商品名<input type='text' name = 'lastname'><br>
		<input type='submit' value='登録'>
	</form>
	
	<table border="1">
		<tr><th>商品名</th><th>id</th><th>メアド</th><th>電話番号</th><th>ロック</th></tr>
		<c:forEach var="product" items="${result}">
			<tr><td>${product.lastname}</td><td>${product.id}</td><td>${product.mail}</td><td>${product.telphone}</td><td>null</td></tr>
		</c:forEach>
	</table>
</body>
</html>