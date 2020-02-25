<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>ユーザーのやつ</title></head>
<body>
	<h1>個人情報の変更</h1>
	<form action="uuc" method="post">
        名前(姓):<input type="text" name="lastname"><br>
        名前(名):<input type="text" name="firstname"><br>
        名前(せい):<input type="text" name="lastname_hira"><br>
        名前(めい):<input type="text" name="firstname_hira"><br>
        電話番号:<input type="text" name="phone"><br>
        メールアドレス:<input type="text" name="mail"><br>
        パスワード:<input type="text" name="password"><br>
        住所:<input type="text" name="address"><br>
        性別:<input type="text" name="sex"><br>
        誕生日:<input type="text" name="birthyear"><br><br>
        <input type="submit" value="ログイン">
    </form>
<br>	
</body>
</html>