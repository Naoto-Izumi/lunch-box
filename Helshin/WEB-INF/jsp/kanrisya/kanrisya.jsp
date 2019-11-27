<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
<head>
<title>管理者情報</title>
</head>
<body>
	<h1>管理者 ユーザー管理</h1>
	<form method='get' action='add'>
		商品名<input type='text' name = 'lastname'><br>
		<input type='submit' value='登録'>
	</form>
	
	<table border="1">
		<tr><th>ユーザー名</th><th>id</th><th>メアド</th><th>電話番号</th><th>ロック</th></tr>
		<c:forEach var="product" items="${result}">
			<tr><td>${product.lname}</td><td>${product.id}</td><td>${product.mail}</td><td>${product.telphone}</td><td>null</td></tr>
		</c:forEach>
	</table>
</body>
</html>