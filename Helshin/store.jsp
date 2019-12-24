<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
<head>
<title>管理者情報</title>
<script src="${pageContext.request.contextPath}/js/Store.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Store.css">
</head>
<body>
	<input type="radio" name="target" value="delete" onchange="showDelete();" checked>店舗の登録
	<input type="radio" name="target" value="add" onchange="showAdd();" checked>店舗の削除
	
	<div id="delete" class="on">
		<h1>店舗の削除</h1>
	<table border="1">
		<tr><th>店舗番号</th><th>店舗名</th><th>住所</th><th>電話番号</th><th>営業時間</th></tr>
		<c:forEach var="s" items="${store}">
			<tr><td>${s.id}</td><td>${s.name}</td><td>${s.address}</td><td>${s.phone}<td>${s.hours}</td>
			<td><form method='post' action='sde'><input type="hidden" name ="id" value="${s.id}"><input type="submit" value="削除"></form></td></tr>
		</c:forEach>
	</table>
<br>
<a href="product.jsp">商品登録</a><br>
<a href="store.jsp">店舗登録</a><br>
<a href="kanrisya.jsp">管理者</a><br>

	</div>
	
	<div id="add" class="off">
		<h1>店舗の登録</h1>

	<form method='post' action='srs'>

		店舗名<input type='text' name='sname'><br>
		住所<input type='text' name='saddress'><br>
		電話番号<input type='number' name='snumber'><br>
		営業時間<input type='number' name='openhours'>~<input type='number' name='closehours'><br>
	
	<input type='submit' value='登録'>

<br>
<a href="product.jsp">商品登録</a><br>
<a href="store.jsp">店舗登録</a><br>
<a href="kanrisya.jsp">管理者</a><br>
	</div>
	
	
</body>
</html>