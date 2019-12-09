<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head><title>商品登録</title></head>
<body>
	<h1>商品登録</h1>

	<form method='post' action='prs'>
		商品名<input type='text' name='pname'><br>
		値段<input type='text' name='price'><br>
		カロリー<input type='text' name='cal'><br>
		商品の種類<input type='text' name='cate'>※必須ではない<br>
		商品画像<input type='text' name='image'><br>

		<h3>5大栄養素</h3>
		タンパク質<input type='text' name='pro'><br>
		糖質<input type='text' name='carbo'><br>
		脂質<input type='text' name='lip'><br>
		ビタミン<input type='text' name='vita'><br>
		無機質<input type='text' name='ino'><br>
		
		<h3>アレルギー</h3>
		小麦<input type='text' name='wheat'><br>
		卵<input type='text' name='egg'><br>
		乳<input type='text' name='milk'><br>
		落花生<input type='text' name='peanut'><br>
		そば<input type='text' name='buck'><br>
		えび<input type='text' name='shrimp'><br>
		かに<input type='text' name='kani'><br>
	<input type='submit' value='登録'>
</body>
</html>



