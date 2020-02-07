<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
<head>
<title>管理者情報</title>
<script src="${pageContext.request.contextPath}/Browser/js/Kanrisya.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Browser/css/KanrisyaSabu.css">
</head>
<body>
	<div id="wraper">
		<div id="header">
			<ul id="link">
				<li><a href="pqs">商品登録</a></li>
				<li><a href="sqs">店舗登録</a></li>
				<li><a href="ks">ユーザー情報</a></li>
			</ul>
		</div>
		<div id="header2">
			<ul id="a">
				<li><a><input type="radio" name="target" value="sale" onchange="showSale();">売り上げ</a></li>
				<li><a><input type="radio" name="target" value="add" onchange="showAdd();" checked>ユーザー管理</a></li>
			</ul>
		</div>
		<div id="main">
			<div id="sale" class="off">
				<h1>売り上げ情報</h1>
				<form method="get" action="us">
					<input type="text" name="nen">年<input type="text" name="tuki">月
					<input type="submit" value="絞り込み">
				</form>
	
				<table border="1">
					<tr><th>商品名</th><th>売り上げ</th></tr>
					<c:forEach var="UriageBox" items="${uriage}">
						<tr><td>${UriageBox.name}</td><td>${UriageBox.count}</td></tr>
					</c:forEach>
				</table>
			<a href="main">トップに戻る</a>
			</div>
	
			<div id="add" class="on">
				<h1>ユーザー管理</h1>
				<form method='get' action='ls'>
					ユーザー名<input type='text' name = 'lastname'><br>
					<input type='submit' value='登録'>
				</form>
		
			
				<table border="1">
					<tr><th>ユーザー名</th><th>id</th><th>メアド</th><th>電話番号</th><th>ロック</th></tr>
					<c:forEach var="product" items="${result}">
						<tr><td>${product.lname}</td><td>${product.id}</td>
						<td>${product.mail}</td><td>${product.telphone}</td>
						<td><form method='get' action='lsadd'>
						<input type='checkbox' name='lock' value='true' ${product.locks}>
						<input type='hidden' name='id' value='${product.id}' >
					
					</td><td><input type='submit'></form></td></tr>
					</c:forEach>
				</table>
				<a href="main">トップに戻る</a>
			</div>
		</div>
		<div id="footer">
			<address>
			<center>Copyright 2020 HelshinBento,All rights reserved.</center>
			</address>
		</div>
	</div>
</body>
</html>