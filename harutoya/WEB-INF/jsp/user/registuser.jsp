<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>ユーザーのやつ</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/User.css">
    <script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>
    <style>
        .active{
            display: inline;
        }
        .passive{
            display: none;
        }
    </style>
</head>
<body>
    <header class="grovalNavigation">
        <div class="logo" title="春戸弁当">
            <a href="start" class="fade_btn"><img src="${pageContext.request.contextPath}/Browser/img/harutoya.png" title="" height="90px" width="375px"></a>
        </div>
    
        <ul id="navi" class="icon_nav">
            <li>
                <a href="TopServlet" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/5.png" alt="メニュー" title="">
                    <span>メニュー</span>
                </a>
            </li>
            <li>
                <a href="TopCusServlet" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/4.png" alt="カスタムメニュー" title="">
                        <span>カスタムメニュー</span>
                </a>
            </li>
    
            <li>
                <a href="StoreServlet"  class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/1.png" alt="店舗検索" title="">
                    <span>店舗検索</span>
                </a>
            </li>
    
            <li>
                <a href="norder" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/2.png" alt="お知らせ" title="">
                    <span>ネット注文</span>
                </a>
            </li>
            
            <li>
                <a href="look" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/3.png" alt="カート" title="">
                        <span>カート</span>
                </a>
            </li>
            <li>
                <a href="page" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/6.png" alt="カート" title="">
                        <span>マイページ</span>
                </a>
            </li>
        </ul>
        <div class="kensaku">
            <form action="SearchServlet" method="post" name="search">
                <input type="text" name="sname" id="s1" placeholder="商品検索">
                <input type="submit" id="sea" value="検索" >
            </form>
        </div>
        <div>
            <ul class="headinfo">
                <div id="newregist">
                <li>
                     <a href="ruser" >新規会員登録</a>
                </li>
                </div>
                <li>
                    <h1 id ="userid" style="display:none;">${menutoken}</h1>
                    <a id="login"  href="page" >ログイン</a>
                    <a id="logout" href="vmenu" style="display:none;">ログアウト</a>
                </li>
            </ul>
        </div>
    </header>
    <div class="mypage">

	<h1>個人情報の変更</h1>
	<form action="uuc" method="post">
        名前(姓):<input type="text" name="lastname"><br>
        名前(名):<input type="text" name="firstname"><br>
        名前(せい):<input type="text" name="lastname_hira"><br>
        名前(めい):<input type="text" name="firstname_hira"><br>
        電話番号:<input type="text" name="phone"><br>
        メールアドレス:<input type="text" name="mail"><br>
        パスワード:<input type="password" name="password"><br>
        住所:<input type="text" name="address"><br>
        性別:<input type="text" name="sex"><br>
        <datalist id='sex'>
            <option value="男"></option>
            <option value="女"></option>
            <option value="その他"></option>
        </datalist>
        誕生日:<input type="date" name="birthyear"><br><br>
        <input type="submit" value="登録">
    </form>
</div>
<br>	
</body>
</html>