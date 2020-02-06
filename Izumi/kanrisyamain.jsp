<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理者情報</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Browser/css/KanrisyaMain.css">
</head>
<body>
	<div id="wraper">
		<div id="header">
    		<center><h1>管理者情報</h1>
    		<img src="${pageContext.request.contextPath}/Browser/img/pc3.jpg">
    		<p>このページは管理者専用のページです。
			一般の方は立ち入ることは出来ません。</p>
			</center>
			<center>
				<table>
    				<tr><td><a href="ks">管理者</a></td>
    				<td><a href="sqs">店舗</a></td>
    				<td><a href="pqs">商品</a></td></tr>
				</table>
			</center>
		</div>
		<div id="footer">
			<address>
			<center>Copyright 2020 HelshinBento,All rights reserved.</center>
			</address>
		</div>
	</div>
</body>
</html>