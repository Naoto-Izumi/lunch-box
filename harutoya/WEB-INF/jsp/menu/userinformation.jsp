<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
    <script src="${pageContext.request.contextPath}/Browser/js/UserInfomation.js"></script>
    <script src="${pageContext.request.contextPath}/Browser/js/Menu.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Browser/css/Menu2.css">
  
    
    
</head>
<body>
    <header class="grovalNavigation">
        <div class="logo" title="春戸弁当">
            <a href="st" class="fade_btn"><img src="${pageContext.request.contextPath}/Browser/img/harutoya.png" title="" height="90px" width="375px"></a>
        </div>
    
        <ul id="navi" class="icon_nav">
            <li>
                <a href="top" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_01.png" alt="メニュー" title="">
                    <span>メニュー</span>
                </a>
            </li>
    
            <li>
                <a href="store" target="_blank" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_02.png" alt="店舗検索" title="">
                    <span>店舗検索</span>
                </a>
            </li>
    
            <li>
                <a href="norder" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_03.png" alt="お知らせ" title="">
                    <span>ネット注文</span>
                </a>
            </li>
            <li>
                <a href="page" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_05.png" alt="スタッフ募集" title="">
                        <span>マイページ</span>
                </a>
            </li>
            <li>
                <a href="custom" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_05.png" alt="カート" title="">
                        <span>カート</span>
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
                <li>
                     <a href="" >新規会員登録</a>
                </li>
                <li>
                    <a href="infomation" >ログイン</a>
                </li>
            </ul>
        </div>
    
    
     </header>
     <div class="allergy">
        <form method="POST" action="uinfo" name="info">
            名前<input type="text" name="name" required><br>
            電話<input type="tel" name="tel" oninput="check(this)" required><br>
            メール<input type="email" name="mail" required><br>
            住所<input type="text" name="address" required><br>
            日付<input type="text" name="date" id="datepicker" required><br>
            時間<input type="time" name="time"  required><br>
            支払い方法
            <input type="radio" name="type" value="0" onchange="showCash();" checked>現金
            <input type="radio" name="type" value="1" onchange="showCard();" >カード<br>

            <ul id="card" class="passive">
                <li>カード名義人(半角ローマ字)<input type="text" name="cardname" ></li>
                <li>カード番号<input type="password" name="cardnumber" ></li>
                <li>有効期限<input type="password" name="carddate" ></li>
            </ul>
            <input type="submit" value="確認" id="awawa" >
        </form>

        <div id="mydialog2" title="入力欄が空白です">
            カード情報を入力してください<br />
        </div>
    </div>
    </body>
</html>