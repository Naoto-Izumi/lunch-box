<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
<head>
<title>管理者情報</title>
<script src="${pageContext.request.contextPath}/Browser/js/Product.js"></script>
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
				<li><a><input type="radio" name="target" value="delete" onchange="showDelete();" checked>商品登録</a></li>
				<li><a><input type="radio" name="target" value="add" onchange="showAdd();" checked>商品削除</a></li>
				<li><a><input type="radio" name="target" value="stock" onchange="showStock();" checked>在庫管理</a></li>
			</ul>
		</div>
		<div id="main">
			<div id="add" class="off">
				<h1>商品の削除</h1>
				<table border="1">
					<tr><th>商品番号</th><th>商品名</th><th>価格</th><th>在庫</th><th>カロリー</th><th>発売日</th><th>種類</th>
						<th>画像</th><th>たんぱく質</th><th>糖質</th><th>脂質</th><th>ビタミン</th><th>無機質</th><th>小麦</th><th>卵</th><th>乳</th><th>落花生</th><th>そば</th><th>えび</th><th>かに</th></tr>
						<c:forEach var="p" items="${product}">
							<tr><td>${p.id}</td><td>${p.name}</td><td>${p.price}</td><td>${p.stock}</td>
							<td>${p.calorie}</td><td>${p.date}</td><td>${p.type}</td>
							<td><img src="${p.image}" width="90" height="60"></td></td><td>${p.pro}</td><td>${p.carbo}</td>
							<td>${p.lip}</td><td>${p.vita}</td><td>${p.ino}</td>
							<td>${p.wheat}</td><td>${p.egg}</td><td>${p.milk}</td>
							<td>${p.peanut}</td><td>${p.buck}</td><td>${p.shrimp}</td>
							<td>${p.kani}</td></tr>
							<td><form method='post' action='pde'><input type="hidden" name ="id" value="${p.id}"><input type="submit" value="削除"></form></td>
						</c:forEach>
				</table>
				<a href="main">トップに戻る</a>
			</div>
	
			<div id="delete" class="off">

				<h1>商品登録</h1>

				<form name='form1' method='post' action='prs'>
				商品名<input type='text' name='pname'><br>
				値段<input type='number' name='price'><br>
				カロリー<input type='number' name='cal' value='0' min='0'><br>
				<label>
					商品の種類<input list='cate' name='cate' ><br>
				</label>
				<datalist id='cate'>
					<option value="主食"></option>
					<option value="主菜"></option>
					<option value="副菜"></option>
					<option value="その他"></option>
				</datalist>
				商品画像<input type='text' name='image'><br>

				<h3>5大栄養素</h3>
				タンパク質<input type='number' name='pro' value='0' min='0' ><br>
				糖質<input type='number' name='carbo' value='0' min='0' ><br>
				脂質<input type='number' name='lip' value='0' min='0' ><br>
				ビタミン<input type='number' name='vita' value='0' min='0' ><br>
				無機質<input type='number' name='ino' value='0' min='0' ><br>
		
				<h3>アレルギー</h3>
				小麦<br>
				含む<input type='radio' name='wheat' value='1'>含まない<input type='radio' name='wheat' value='0' checked="checked" ><br>
				卵<br>
				含む<input type='radio' name='egg' value='1'>含まない<input type='radio' name='egg' value='0' checked="checked" ><br>
				乳<br>
				含む<input type='radio' name='milk' value='1'>含まない<input type='radio' name='milk' value='0' checked="checked" ><br>
				落花生<br>
				含む<input type='radio' name='peanut' value='1'>含まない<input type='radio' name='peanut' value='0' checked="checked" ><br>
				そば<br>
				含む<input type='radio' name='buck' value='1'>含まない<input type='radio' name='buck' value='0' checked="checked" ><br>
				えび<br>
				含む<input type='radio' name='shrimp' value='1'>含まない<input type='radio' name='shrimp' value='0' checked="checked" ><br>
				かに<br>
				含む<input type='radio' name='kani' value='1'>含まない<input type='radio' name='kani' value='0' checked="checked" ><br>
				<input type='button' value='登録' onclick="product();">
				</form>
			</div>
			<div id="stock" class="on">	
	
				<h1>在庫の変更</h1>
				<table border="1">
					<tr><th>商品名</th><th>価格</th><th>在庫</th></tr>
					<c:forEach var="p" items="${product}">
						<form method='post' action='pscs'>
							<tr><td>${p.name}</td><td>${p.price}</td><td><input type="number" name="stock" value="${p.stock}" min='0'></td><td>
							<input type="hidden" name ="id" value="${p.id}"><input type="submit" value="変更"></td></tr>
						</form>
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