<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
<head>
<title>管理者情報</title>
</head>
<body>
	<h1>売り上げ情報</h1>
	<form method='get' action='uriage'>
		<input type='text' name='nen' placeholder='2019'>年<input type='text' name = 'tuki'>月
		<input type='submit' value='絞り込み'>
	</form>
	
	<table border="1">
		<tr><th>商品名</th><th>売り上げ</th></tr>
		<c:forEach var="UriageBox" items="${result}">
			<tr><td>${UriageBox.name}</td><td>${UriageBox.count}</td></tr>
		</c:forEach>
	</table>
</body>
</html>