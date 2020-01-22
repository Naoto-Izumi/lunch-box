<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
<head>
<title>管理者情報</title>
<script src="${pageContext.request.contextPath}/Browser/js/Store.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Browser/css/KanrisyaSabu.css">
</head>
<body>
	<div id="wraper">
		<div id="header">
			<ul id="link">
				<li><a href="pqs">商品登録</a></li>
				<li><a href="sqs">店舗登録</a></li>
				<li><a href="pss">管理者</a></li>
			</ul>
		</div>
		<div id="header2">
			<ul id="a">
				<li><a><input type="radio" name="target" value="delete" onchange="showDelete();" checked>店舗の削除</a></li>
				<li><a><input type="radio" name="target" value="add" onchange="showAdd();" checked>店舗の登録</a></li>
			</ul>
		</div>
		<div id="main">
			<div id="delete" class="off">
				<h1>店舗の削除</h1>
				<table border="1">
					<tr><th>店舗番号</th><th>店舗名</th><th>住所</th><th>電話番号</th><th>営業時間</th></tr>
					<c:forEach var="s" items="${store}">
						<tr><td>${s.id}</td><td>${s.name}</td><td>${s.address}</td><td>${s.phone}<td>${s.hours}</td>
						<td><form method='post' action='sde'><input type="hidden" name ="id" value="${s.id}"><input type="submit" value="削除"></form></td></tr>
					</c:forEach>
				</table>
				<a href="kanrisyamain.jsp">トップに戻る</a>

			</div>
	
			<div id="add" class="on">
				<h1>店舗の登録</h1>

				<form name="form1" method='post' action='srs'>

				店舗名<input type='text' name='sname'><br>
				住所<input type='text' name='saddress'><br>
				電話番号<input type='number' name='snumber'><br>
				営業時間<input type='number' name='openhours'>~<input type='number' name='closehours'><br>
	
				<input type='button' value='登録' onclick="store();">
				<br><a href="kanrisyamain.jsp">トップに戻る</a>
			</div>
			<br>
		</div>
		<div id="footer">
			<address>
			<center>Copyright 2020 HelshinBento,All rights reserved.</center>
			</address>
		</div>
	</div>
</body>
</html>