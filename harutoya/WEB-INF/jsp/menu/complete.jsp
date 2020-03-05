<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>完了ページ</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico">
    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu.css">-->
    <script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>
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
    
    
            .btn-flat-border {
            display: inline-block;
            padding: 0.3em 1em;
            text-decoration: none;
            color: #67c5ff;
            border: solid 2px #67c5ff;
            border-radius: 3px;
            transition: .4s;
            width:250px;
                height:50px;
            }
    
            .btn-flat-border:hover {
            background: #67c5ff;
            color: white;
            }
            .zuras{
                margin: -200px 0 0 -300px;  /*縦横半分をネガティブマージンでずらす*/
                position: absolute;     /*body要素に対して絶対配置*/
                top: 50%;       /*上端を中央に*/
                left: 50%;      /*左端を中央に*/
                width: 600px;   /*横幅*/
                height: 400px;  /*縦幅*/
                background-color:#fff;
    
            }
            .zuras p{
                margin-top:10%;
                margin-left: 22%;
                position: absolute;
                font-size: 30px;
                color:#353834;
                
            }
            .zuras a{
                margin-top:30%;
                margin-left: 20%;
                position: absolute;
                
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
         <div class="zuras">
            <p>注文完了しました!! </p>
            <a href="TopServlet"  class="btn-flat-border">TOPに戻る</a>
        </div>
    </body>
</html>