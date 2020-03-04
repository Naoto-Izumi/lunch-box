<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>確認</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/Browser/js/lightbox.js"></script>
    <script src="${pageContext.request.contextPath}/Browser/js/Confirmation.js"></script>    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu.css">
    
</head>
    <body>
        <header class="grovalNavigation">
            <div class="logo" title="春戸弁当">
                <a href="TopServlet" class="fade_btn"><img src="${pageContext.request.contextPath}/Browser/img/harutoya.png" title="" height="90px" width="375px"></a>
            </div>
        
            <ul id="navi" class="icon_nav">
                <li>
                    <a href="TopServlet" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_01.png" alt="メニュー" title="">
                        <span>メニュー</span>
                    </a>
                </li>
                <li>
                    <a href="TopCusServlet" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_06.png" alt="カスタムメニュー" title="">
                            <span>カスタムメニュー</span>
                    </a>
                </li>
        
                <li>
                    <a href="StoreServlet" target="_blank" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_02.png" alt="店舗検索" title="">
                        <span>店舗検索</span>
                    </a>
                </li>
        
                <li>
                    <a href="norder" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_04.png" alt="お知らせ" title="">
                        <span>ネット注文</span>
                    </a>
                </li>
                
                <li>
                    <a href="custom" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_08.png" alt="カート" title="">
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
                         <a href="ruser" >新規会員登録</a>
                    </li>
                    <li>
                        <a href="infomation" >ログイン</a>
                    </li>
                </ul>
            </div>
        
        
         </header>
            <p>名前${sessionScope.p.name}</p>
            <p>電話番号${sessionScope.p.tel}</p>
            <p>メールアドレス${sessionScope.p.mail}</p>
            <p>住所${sessionScope.p.address}</p>
            <div  class="${sessionScope.spuData.store}" id="target"><P>店舗${sessionScope.spuData.st_name}</P></div>
            <p>日付${sessionScope.p.date}</p>
            <p>時間${sessionScope.p.time}</p>
            <div class="${sessionScope.p.type}" id="pay"><p>支払い方法=${sessionScope.p.type}</p></div>
            <p>合計金額${sessionScope.totalPrice + sessionScope.ccb.custom_total_money}</p>
            <a href="CompleteServlet">完了ページ</a>
    </body>
</html>