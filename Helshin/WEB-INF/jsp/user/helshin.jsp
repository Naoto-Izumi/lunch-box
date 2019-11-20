<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	
<html>
<head>
<title>新規登録</title>
</head>
<body>
	<h1>ユーザー登録</h1>
	<form method='get' action='login'>
	<table>
	<tr><td>姓</td><td><input type='text' name='lastname'></td></tr>
	<tr><td>名</td><td><input type='text' name='firstname'></td></tr>
	<tr><td>姓(カタカナ)</td><td><input type='text' name='lastname_hira'></td></tr>
	<tr><td>名(カタカナ)</td><td><input type='text' name='firstname_hira'></td></tr>
	<tr><td>電話番号</td><td><input type='tel' name='phone'></td></tr>
	<tr><td>メールアドレス</td><td><input type='email' name='mail'></td></tr>
	<tr><td>パスワード</td><td><input type='password' name='password'></td></tr>
	<tr><td>パスワード(確認用)</td><td><input type='password' name='password'></td></tr>
	<tr><td>住所</td><td><input type='text' name='address'></td></tr>
	<tr><td>性別</td><td>男<input type='radio' name='sex'> 女<input type='radio' name='sex'></td></tr>
	<tr><td>生年月日</td><td><input type='datetime' name='birthyear'></td></tr>
	</table>
	<br><br>
	<input type='submit' value='送信'>
	</form>
</body>
</html>