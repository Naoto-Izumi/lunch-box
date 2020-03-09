<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/Browser/js/lightbox.js"></script>  
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu.css"> -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico">
    <script src="${pageContext.request.contextPath}/Browser/js/Detail.js"></script>
    <script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>

    <style>
        .active{
            display: inline;
        }
        .passive{
            display: none;
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

        .cho{
            padding:100px 0 0 0;
        }
        table{
            border-collapse:collapse;
            margin:0 auto;
            table-layout: fixed;
        }
        td,th{
            padding:10px;
            border-bottom:1px solid #ccc;
            text-align: center;
        }
        table tr th:nth-child(odd),
        table tr td:nth-child(odd){
            background:#e6f2ff;
        }

        ul {
        list-style: none;
        }
        .menuimg{
            float:left;
        }
        #alle{
            clear:both;
        }
        .ref-btn {
        display       : inline-block;
        border-radius : 5%;          /* 角丸       */
        font-size     : 10pt;        /* 文字サイズ */
        text-align    : center;      /* 文字位置   */
        cursor        : pointer;     /* カーソル   */
        padding       : 6px 6px;   /* 余白       */
        background    : #e8ecef;     /* 背景色     */
        color         : #09186e;     /* 文字色     */
        line-height   : 1em;         /* 1行の高さ  */
        transition    : .3s;         /* なめらか変化 */
        box-shadow    : 1px 1px 1px #666666;  /* 影の設定 */
        border        : 2px solid #e8ecef;    /* 枠の指定 */
        }
        .ref-btn:hover {
        box-shadow    : none;        /* カーソル時の影消去 */
        color         : #3d4da7;     /* 背景色     */
        background    : #ffffff;     /* 文字色     */
        }
        a {
        text-decoration: none;
        }
        .btn-pop {
        position: relative;
        display: inline-block;
        padding: 0.25em 0.5em;
        text-decoration: none;
        color: #FFF;
        background: #fd9535;/*背景色*/
        border-bottom: solid 2px #d27d00;/*少し濃い目の色に*/
        border-radius: 4px;/*角の丸み*/
        box-shadow: inset 0 2px 0 rgba(255,255,255,0.2), 0 2px 2px rgba(0, 0, 0, 0.19);
        font-weight: bold;
        }

        .btn-pop:active {
        border-bottom: solid 2px #fd9535;
        box-shadow: 0 0 2px rgba(0, 0, 0, 0.30);
        }
        .btn-top{
            margin:0 auto;
            position: fixed;
            bottom: 10px;
            right: 10px;

        }
        .rebtn{
            text-align: center;
        }
        .plmi{
            border-color: #ba2636;
            border-style: solid;
            background-color:#eaf4fc;
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
            <div class="kensaku">
                <form action="SearchServlet" method="post" name="search">
                    <input type="text" name="sname" id="s1" placeholder="商品検索">
                    <input type="submit" id="sea" value="検索" class="ref-btn">
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
                        <h1 id ="userid" style="display:none;">${menutoken}</h1>
                        <a id="login"  href="page" >ログイン</a>
                        <a id="logout" href="vmenu" style="display:none;">ログアウト</a>
                    </li>
                </ul>
            </div>
        
        
         </header>
        <div class="zuras">
            <div class="cho">

                <c:forEach var="prof" items="${product}"> 
                    <h1>${prof.pro_name}</h1>   
                        <img src="${prof.pro_image}"  height="300px" width="300px" class="menuimg">
                        <br>
                        
                        ${prof.pro_price}円
                        
                        ${prof.pro_calorie}㎉
                        <br>
                        ${prof.pro_description}
                        <br><br><br>
                        <p>この商品をカートに追加</p>
                    <form action="MenuServlet" method="post" name="frml" >
                        <input type="text" name="${prof.pro_id}" id="${prof.pro_id}" value=0 size=6 MIN="O" MAX="99"><br>
                        <input type="button" value="＋" onClick="javascript:this.form.${prof.pro_id}.value++;"> 
                        <input type="button" value="－" onClick="javascript:this.form.${prof.pro_id}.value--;">
                        <input type="submit" value="カート" class="dialog ref-btn" onclick="test('${prof.pro_id}')">
                    </form>

                        
                    <div id="nav">
                                <ul id="alle">
                                    <p>アレルギー物質表示</p>
                                <li class="active" name="${prof.pro_wheat}"><img src="${pageContext.request.contextPath}/Browser/img/a1.png" width="50px" height="50px">小麦</li>
                                <li class="active" name="${prof.pro_egg}"><img src="${pageContext.request.contextPath}/Browser/img/a2.png" width="50px" height="50px">卵</li>
                                <li class="active" name="${prof.pro_milk}"><img src="${pageContext.request.contextPath}/Browser/img/a3.png" width="50px" height="50px">乳</li>
                                <li class="active" name="${prof.pro_peanuts}"><img src="${pageContext.request.contextPath}/Browser/img/a4.png" width="50px" height="50px">落花生</li>
                                <li class="active" name="${prof.pro_buckwheat}"><img src="${pageContext.request.contextPath}/Browser/img/a5.png" width="50px" height="50px">そば</li>
                                <li class="active" name="${prof.pro_shrimp}"><img src="${pageContext.request.contextPath}/Browser/img/a6.png" width="50px" height="50px">えび</li>
                                <li class="active" name="${prof.pro_crab}"><img src="${pageContext.request.contextPath}/Browser/img/a7.png" width="50px" height="50px">かに</li>
                                
                                </ul>  
                            </div> 

                            <table border=1 width="80%">
                                <tr>
                                    <th>タンパク質</th>
                                    <th>糖質</th>
                                    <th>脂質</th>
                                    <th>ビタミン</th>
                                    <th>無機質</th>
                                </tr>
                                <tr>
                                    <td>${prof.pro_protein}(g)</td>
                                <td>${prof.pro_carbohydrate}(g)</td>
                                <td>${prof.pro_lipid}(g)</td>
                                <td>${prof.pro_vitamin}(g)</td>
                                <td>${prof.pro_inorganic}(g)</td>
                                </tr>
                            </table>

                            <!-- <form action="MenuServlet" method="post" name="frml" >
                                <input type="text" name="${prof.pro_id}" id="${prof.pro_id}" value=0 size=6 MIN="O" MAX="99"><br>
                                <input type="button" value="＋" onClick="javascript:this.form.${prof.pro_id}.value++;"> 
                                <input type="button" value="－" onClick="javascript:this.form.${prof.pro_id}.value--;">
                                <input type="submit" value="カート" class="dialog" onclick="test('${prof.pro_id}')">${prof.pro_id}
                            </form>
                                         -->
                        </c:forEach>
                        <div class="rebtn">
                            <br>
                            <a href="TopServlet" class="btn-pop btn-top">Topへ戻る</a>
                        </div>

                        
            
            </div>
        </div>

        <!--ダイアログの内容-->
        <div id="mydialog2" title="個数を入力して下さい">
            最低注文個数に達していません。（最低注文個数：1個）<br />
        </div>
    </body>
</html>