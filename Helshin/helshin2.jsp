<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
	
<html>
<head>新規登録画面</head>
<title>入力内容不適合</title>
</head>
<body>
	<h1>入力結果</h1>
	<p>姓${Bean.lastname}</p>
	<p>名${Bean.firstname}</p>
	<p>姓(カタカナ)${Bean.lastname_hira}</p>
	<p>名(カタカナ)${Bean.firstname_hira}</p>
	<p>電話番号${Bean.phone}</p>
	<p>メールアドレス${Bean.mail}</p>
	<p>パスワード${Bean.password}</p>
	<p>住所${Bean.address}</p>
	<p>性別${Bean.sex}</p>
	<p>生年月日${Bean.birthyear}</p>
	</form>
</body>
</html>