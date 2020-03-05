<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico">
    <link rel="stylesheet" type="text/css" href="style.css">
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <script src="${pageContext.request.contextPath}/Browser/js/UserInfomation.js"></script>
    <script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>
    <script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu.css">
        
        
   -->
    <style>
        .grovalNavigation{
    z-index: 9999;
    width: 100%;
    height: 100px;
    text-align: center;
    background-color: #ffffff;
    color: #000000;
    position: fixed;
}
#navi {
  list-style: none;
  overflow: hidden;
}
 
#navi li {
  background-color:;
  width: 10%;
  text-align: center;
  float: left;
  height: 80px;
  line-height: 70px;
  margin-right: 2px;
  display: inline-block;
}
 
#navi li a {
  text-decoration: none;
  color: #fff;
  font-weight: bold;
  padding: 20px;
}
#navi li img{
    width: 80px;
    height:80px;
}
#navi li span{
    position:relative;
    right: 60px;
    top: 20px;
    font-size: 13px;
    text-align: center;
}
.logo{
    float:left;
    margin-top:5px;
}

.kensaku{
    float:right;
    position: relative;
    right: 20px;
    bottom: 50px;

}

.headinfo{
    float:right;
    position:absolute;
    right: 80px;
    bottom:26px;
}

.zuras{
    padding:100px 0 0 0;
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
                <a href="TopCusServlet" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/3.png" alt="カート" title="">
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
     <div class="zuras"></div>
     <h1>ご注文内容の指定</h1>
        <form method="POST" action="UserInformationServlet" name="info">
            名前<input type="text" name="name" required><br>
            電話<input type="tel" name="tel" oninput="check(this)"  required><br>
            メール<input type="email" name="mail" required><br>
            住所<input type="text" name="address" required><br>
            日付<input type="text" name="date" id="datepicker" required><br>
            時間<input type="time" name="time"  required><br>
            支払い方法
            <input type="radio" name="type" value="0" onchange="showCash();" checked>現金
            <input type="radio" name="type" value="1" onchange="showCard();" >カード<br>

            <ul id="card" class="passive">
                <li>カード名義人(半角ローマ字)<input type="text" name="cardname" class="cardinfo"　maxlength="50" pattern="/d*"></li>
                <li>カード番号<input type="password" name="cardnumber" class="cardinfo" pattern="/d*"></li>
                <li>有効期限<input type="password" name="carddate" class="cardinfo" pattern="/d*"></li>
            </ul>
            <input type="submit" value="確認" id="awawa" >
        </form>
    </div>

        <!--ダイアログの内容-->
        <div id="mydialog2" title="入力欄が空白です">
            カード情報を入力してください<br />
        </div>

    </body>
</html>