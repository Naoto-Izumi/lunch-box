<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <meta charset="utf-8">
    <title>ぶるまてすと</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/bulma.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link rel ="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu2.css">
    <script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>
  </head>




<!--レスポンシブデザイン諦めました-->
  <body>
    <header class="nav">
  <div class="nav-left">
      <span class="nav-item">
  
      </span>
  </div>
  <!--has textは追加しますた-->
  <div class="nav-right has-text-right">
    <span class="nav-item">
      
    </span>
    <!--------------------------------------------保留---------------------------------------------->
    <span class="nav-item">
      <h1 id ="userid">${menutoken}</h1>
      <a class="regist" id="newregist" href="ruser">新規会員登録</a>
      <a class="login" id="login" href="infomation">ログイン</a>
      <a id="logout" href="vmenu" style="display:none;">ログアウト</a>
    </span>
  </div>
 
  <div class="hero is-bold">
   <div class="hero-body">
       <div class="container">
          <img src="${pageContext.request.contextPath}/Browser/img/logo3.jpg"> </a>
           <nav>
            <ul>
              <li class=”current”><a href="TopServlet">メニュー</a></li>
              <li><a href="StoreServlet">店舗検索</a></li>
              <li><a href="custom">カート</a></li>
              <li><a href="page">マイページ</a></li>
 
            </ul>
          </nav>
       </div>
   </div>
</div>
<section class="level">
   <!--<div class="level-left"></div>
   <div class="level-right">
     <div class="level-item tabs"-->

    <!--</div>
   </div>-->
   <div class="level-right">
 
   </div>
</section>
</header>
<!----------------なぜかここにもスタイルタグ-------------------->
<style>
  main {
    background-color: #eeeeee;
    padding-bottom: 40px;
  }
</style>

    <!-- 記述場所１-->
<main class="columns">
  <div class="submenu column is-3">
    
    <aside class="box">
      とても芸術的なサイトです

    </aside>

    <aside class="box menu">
    <ul class="menu-list">
        <li><a href="TopServlet" class="fas fa-book-open">　メニュー</a></li>
        <li><a href="StoreServlet" class="fas fa-home">　店舗</a></li>
        <li><a href="norder" class="fas fa-mobile-alt">　ネット注文</a></li>
    <ul class="gnav">
    <li>
        <a href="#" class="fas fa-ellipsis-h">　その他</a>
        <ul>
          <li><a href="member">メンバー紹介</a></li>
        </ul>
    </li>
    </ul>
    
   </aside>
  </div>
  <div class="slide">
         <img src="${pageContext.request.contextPath}/Browser/img/ben2.jpg">
         <img src="${pageContext.request.contextPath}/Browser/img/ben4.jpg">
         <img src="${pageContext.request.contextPath}/Browser/img/ben5.jpg">
         <img src="${pageContext.request.contextPath}/Browser/img/ben3.jpg">
         <img src="${pageContext.request.contextPath}/Browser/img/ben.jpg">
  </div>
</main>


<!--フッター-->
   <footer class="footer">
   <div class="containerfoot">
     <div class="columns">
        <div class="column asi"><a href="http://ur2.link/rwHD" class="fab fa-facebook fa-lg"></a></div>
        <div class="column asi"><a href="https://twitter.com/Harutoya315" class="fab fa-twitter fa-lg"></a></div>
        <div class="column asi"><a href="https://www.instagram.com/harutoyabento/?hl=ja" class="fab fa-instagram fa-lg"></a></div>
      </div>
     <div class="content has-text-centered">    
       2020 ©harutoya Co., Ltd. All Rights Reserved.
     </div>
   </div>
</footer>
  </body>
</html>

<!--https://www.facebook.com/%E6%98%A5%E6%88%B8%E5%B1%8B-109751540592903/?modal=admin_todo_tour-->



