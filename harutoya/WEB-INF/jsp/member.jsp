<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>ぶるまてすと</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico">
    <link rel="stylesheet" href="css/bulma.css">
    <link rel="stylesheet" href="css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu.css">
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




<!--レスポンシブデザイン諦めました-->
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
            <a href="StoreServlet" class="fade_btn">
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
      
      <div>
        <ul class="headinfo">
            <div id="newregist">
            
                 <a href="ruser" >新規会員登録</a>
            
            </div>
            
                <h1 id ="userid" style="display:none;">${menutoken}</h1>
                <a id="login"  href="page" >ログイン</a>
                <a id="logout" href="vmenu" style="display:none; text-decoration:none;">ログアウト</a>
            
        </ul>
      </div>
  </header>
  <div class="allergy">
      <h1>メンバー紹介</h1>
        <h2>高橋春斗</h2>
        <p>春戸屋店長<br>
            デザインと管理者画面とユーザー画面を担当しました。</p>
        <hr>
        <h2>泉 奈央人</h2>
        <p>普通の人。<br>管理者画面とユーザー画面を担当しました。</p>
        <hr>
        <h2>川口剛司</h2>
        <p>春戸屋を提案した一人。<br>商品画面・店舗画面を担当しました。</p>
        <hr>
        <h2>本城早友里</h2>
        <p>チーム唯一の華。<br>商品画面・店舗画面を担当しました。</p>
        <hr>
        <h2>山崎智史</h2>
        <p>チームのリーダー的存在。<br>管理者画面とユーザー画面を担当しました。</p>
        <hr>
  </div>
  </body>
</html>

<!--https://www.facebook.com/%E6%98%A5%E6%88%B8%E5%B1%8B-109751540592903/?modal=admin_todo_tour-->



