<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <!-- jQuery UI -->
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

        <script src="js/lightbox.js"></script> 
    <script>
        
    </script>
    <style>
       

        .wrapper {
        display: block;
        position: absolute;
        top: 70%;
        left: 50%;
        transform: translate(-50%, -50%);
        }
        



                
        .button-7{
        width:330px;
        height:200px;
        border:10px solid #09186e;
        float:left;
        text-align:center;
        cursor:pointer;
        position:relative;
        box-sizing:border-box;
        overflow:hidden;
        margin:0 0 40px 50px;

        }
        .button-7 a{
        font-family:arial;
        font-size: 230%;
        color:#09186e;
        text-decoration:none;
        line-height:50px;
        transition:all .5s ease;
        z-index:2;
        position:relative;
        line-height: 200px;
        
        }
        .eff-7{
        width:330px;
        height:200px;
        border:0px solid #09186e;
        position:absolute;
        transition:all .5s ease;
        z-index:1;
        box-sizing:border-box;
        }
        .button-7:hover .eff-7{
        border:100px solid #09186e;
        }
        .button-7:hover a{
        color:#fff;
        }

        /* ------------------------------------------------------------------------------------- */
        /*タブ切り替え全体のスタイル*/
        .tabs {
        margin-top: 50px;
        padding-bottom: 40px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        width: 80%;
        margin: 0 auto;}

        /*タブのスタイル*/
        .tab_item {
        width: calc(100%/3);
        height: 50px;
        border-bottom: 3px solid #5ab4bd;
        background-color: #d9d9d9;
        line-height: 50px;
        font-size: 16px;
        text-align: center;
        color: #565656;
        display: block;
        float: left;
        text-align: center;
        font-weight: bold;
        transition: all 0.2s ease;
        }
        .tab_item:hover {
        opacity: 0.75;
        }

        /*ラジオボタンを全て消す*/
        input[name="tab_item"] {
        display: none;
        }

        /*タブ切り替えの中身のスタイル*/
        .tab_content {
        display: none;
        padding: 40px 40px 0;
        clear: both;
        overflow: hidden;
        }


        /*選択されているタブのコンテンツのみを表示*/
        #all:checked ~ #all_content,
        #programming:checked ~ #programming_content,
        #design:checked ~ #design_content {
        display: block;
        }

        /*選択されているタブのスタイルを変える*/
        .tabs input:checked + .tab_item {
        background-color: #5ab4bd;
        color: #fff;
        }

        .customtext1{
            background-color:#f0f8ff;
            font-size:50px;
            border-color:#6495ed;
            border-width:5px;
            position: relative;
            height: 300px;
            width: 400px;
        }
        .customtext2{
            background-color:#f0f8ff;
            font-size:50px;
            border-color:#6495ed;
            border-width:5px;
            position: relative;
            height: 150px;
            width: 400px;
            top:75px;
            right:7px;

        }
        .customtext3{
            background-color:#f0f8ff;
            font-size:50px;
            border-color:#6495ed;
            border-width:5px;
            position: relative;
            height: 150px;
            width: 200px;
            right:412px;
            bottom: 75px;
        }
        .customtext4{
            background-color:#f0f8ff;
            font-size:50px;
            border-color:#6495ed;
            border-width:5px;
            position: relative;
            height: 150px;
            width: 200px;
            right:418px;
            bottom: 75px;

        }

        body{
            margin:0;
            padding:0;
        }


        .grovalNavigation{
            z-index: 9999;
            width: 100%;
            height: 100px;
            text-align: center;
            background-color: #d1d1d1;
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
            width: 50px;
            height:50px;
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

        .cho{
            padding:100px 0 0 0;
        }

    </style>
    <title>ネット注文</title>
</head>
    <body>
        <header class="grovalNavigation">
            <div class="logo" title="春戸弁当">
                <a href="top.jsp" class="fade_btn"><img src="${pageContext.request.contextPath}/Browser/img/harutoya.png" title="" height="90px" width="375px"></a>
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
                    <a href="NetOrder.jsp" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_04.png" alt="お知らせ" title="">
                        <span>ネット注文</span>
                    </a>
                </li>
                
                <li>
                    <a href="order.jsp" class="fade_btn">
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
                         <a href="" >新規会員登録</a>
                    </li>
                    <li>
                        <a href="" >ログイン</a>
                    </li>
                </ul>
            </div>
        
        
         </header>







        <div class="cho">
            <p><img src="${pageContext.request.contextPath}/Browser/img/logo-pc4.png" width="300x" height="170px"></p>
            <div class="wrapper">
                <!-- <a href="StorePickUpServlet" class="button">店舗受け取り</a>
                <a href="TopServlet" class="button">配達</a>     
            </div>       -->
            
            <div class="button-7">
                <div class="eff-7"></div>
                <a href="StorePickUpServlet" class="button">店舗受け取り</a>
            </div>
            <div class="button-7">
                <div class="eff-7"></div>
                <a href="TopServlet" class="button">配達</a>
            </div>
            </div> 
        </div>
    </body>
</html>