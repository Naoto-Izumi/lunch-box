<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>マイページ</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/User.css">
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

       <div class="mypage"> <h1>マイページ</h1>
        <a href="uqc">個人情報</a>
        <a href="huser">購入履歴</a>
        <br><br>
        <a href="start">TOPに戻る</a>
    </div>
    </body>
</html>