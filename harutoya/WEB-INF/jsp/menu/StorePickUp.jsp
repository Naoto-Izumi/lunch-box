<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu.css"> -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico">
    <script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>

    <title>メニュー</title>
    <style>
        .active{
            display: inline;
        }
        .passive{
            display: none;
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

.zuras{
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
        <div id="zuras">
            <table>
                
                <form method="POST" action="SPUNextServlet">
                    <c:forEach var="prof" items="${product}">
                        <tr>                        
                            <td>
                                ${prof.st_name}
                            </td>
                            <td>
                                ${prof.st_address}
                            </td>
                            <td>
                                ${prof.st_phone}
                            </td>
                            <td>
                                ${prof.st_hours}
                            </td>
                            <!-- <td>
                                <input type="date" name="date" value="">
                                <input type="time" name="time" value="">
                            </td> -->
                            <td>
                                <input type="hidden" name="st_name" value="${prof.st_name}">
                                <input type="hidden" name="store" value="${prof.st_id}">
                                <input type="submit" value="次へ">
                            </td>
                        </tr>                                        
                    </c:forEach>
                </form>
            </table>
        </div>
    </body>
</html>