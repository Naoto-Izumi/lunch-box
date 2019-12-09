<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head><title>商品登録</title></head>
<body>
	<h1>商品登録</h1>

	<form method='post' action='prs'>
		商品名<input type='text' name='pname'><br>
		値段<input type='number' name='price'><br>
		カロリー<input type='number' name='cal'><br>
		商品の種類<input type='text' name='cate'>※必須ではない<br>
		商品画像<input type='text' name='image'><br>

		<h3>5大栄養素</h3>
		タンパク質<input type='number' name='pro'><br>
		糖質<input type='number' name='carbo'><br>
		脂質<input type='number' name='lip'><br>
		ビタミン<input type='number' name='vita'><br>
		無機質<input type='number' name='ino'><br>
		
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
	<input type='submit' value='登録'>


</body>
</html>
