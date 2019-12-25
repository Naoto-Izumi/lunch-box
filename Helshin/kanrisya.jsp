<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
<head>
<title>管理者情報</title>
<script src="${pageContext.request.contextPath}/js/Kanrisya.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Kanrisya.css">
</head>
<body>
	<div id="wraper">
		<div id="header">
			<ul id="link">
				<li><a href="product.jsp">商品登録</a></li>
				<li><a href="store.jsp">店舗登録</a></li>
				<li><a href="kanrisya.jsp">管理者</a></li>
			</ul>
		</div>
		<div id="header2">
			<ul id="a">
				<li><a><input type="radio" name="target" value="sale" onchange="showSale();" checked>売り上げ</a></li>
				<li><a><input type="radio" name="target" value="add" onchange="showAdd();" checked>ユーザー管理</a></li>
				<li><a><input type="radio" name="target" value="stock" onchange="showStock();" checked>在庫管理</a></li>
			</ul>
		</div>
		<div id="main">
			<div id="sale" class="off">
				<h1>売り上げ情報</h1>
				<form method="get" action="uriage">
					<input type="text" name="nen">年<input type="text" name="tuki">月
					<input type="submit" value="絞り込み">
				</form>
	
				<table border="1">
					<tr><th>商品名</th><th>売り上げ</th></tr>
					<c:forEach var="UriageBox" items="${uriage}">
						<tr><td>${UriageBox.name}</td><td>${UriageBox.count}</td></tr>
					</c:forEach>
				</table>
			<a href="kanrisyamain.jsp">トップに戻る</a>
			</div>
	
			<div id="add" class="off">
				<h1>管理者 ユーザー管理</h1>
				<form method='get' action='view'>
					商品名<input type='text' name = 'lastname'><br>
					<input type='submit' value='登録'>
				</form>
		
			
				<table border="1">
					<tr><th>ユーザー名</th><th>id</th><th>メアド</th><th>電話番号</th><th>ロック</th></tr>
					<c:forEach var="product" items="${result}">
						<tr><td>${product.lname}</td><td>${product.id}</td>
						<td>${product.mail}</td><td>${product.telphone}</td>
						<td><form method='get' action='add'>
						<input type='checkbox' name='id' value='${product.id}'></td><td><input type='submit'></form></td></tr>
					</c:forEach>
				</table>
				<a href="kanrisyamain.jsp">トップに戻る</a>
			</div>
	
			<div id="stock" class="on">	
	
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
				<a href="kanrisyamain.jsp">トップに戻る</a>
			</div>
			<br>
		</div>
	</div>
</body>
</html>