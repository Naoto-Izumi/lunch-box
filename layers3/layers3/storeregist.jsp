<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head><title>店舗登録</title></head>
<body>
	<h1>店舗の登録</h1>

	<form method='post' action='srs'>

		店舗名<input type='text' name='sname'><br>
		住所<input type='text' name='saddress'><br>
		電話番号<input type='number' name='snumber'><br>
		営業時間<input type='number' name='openhours'>~<input type='number' name='closehours'><br>
	
	<input type='submit' value='登録'>


</body>
</html>