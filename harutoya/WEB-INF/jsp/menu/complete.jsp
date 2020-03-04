<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>完了ページ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu2.css">
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
                    <a href="TopCusServlet" class="fade_btn">
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
         <div>
            <p>注文完了しました!! </p>
            <a href="TopServlet">menuページ</a>
        </div>
    </body>
</html>