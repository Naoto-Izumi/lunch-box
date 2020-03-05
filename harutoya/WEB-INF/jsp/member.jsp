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
                  <img src="${pageContext.request.contextPath}/Browser/img/nav_01.png" alt="メニュー" title="">
                  <span>メニュー</span>
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
            <div id="newregist">
            <li>
                 <a href="ruser" >新規会員登録</a>
            </li>
            </div>
            <li>
                <h1 id ="userid">${menutoken}</h1>
                <a id="login"  href="page" >ログイン</a>
                <a id="logout" href="vmenu" style="display:none;">ログアウト</a>
            </li>
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
        <p>管理者画面とユーザー画面を担当しました。</p>
        <hr>
        <h2>川口剛司</h2>
        <p>商品画面・店舗画面を担当しました。</p>
        <hr>
        <h2>本城早友里</h2>
        <p>チーム唯一の華。<br>商品画面・店舗画面を担当しました。</p>
        <hr>
        <h2>山崎智史</h2>
        <p>管理者画面とユーザー画面を担当しました。</p>
        <hr>
  </div>
  </body>
</html>

<!--https://www.facebook.com/%E6%98%A5%E6%88%B8%E5%B1%8B-109751540592903/?modal=admin_todo_tour-->



