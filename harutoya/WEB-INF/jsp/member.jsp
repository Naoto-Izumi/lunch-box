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
  border-bottom: 3px solid #e49e61;
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
  background-color: #e49e61;
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
    background-color:#ffffff;
    color: #000000;
    position: fixed;
}
#navi {
  list-style: none;
  overflow: hidden;
}
 
#navi li {
  width: 10%;
  text-align: center;
  float: left;
  height: 80px;
  line-height: 70px;
  margin-right: 2px;
  display: inline-block;

}
 
/*#navi li a {
  text-decoration: none;
  color: rgb(174, 211, 180);
  font-weight: bold;
  padding: 20px;
}*/
#navi li img{
    width: 80px;
    height:80px;
}
#navi li span{
    /* position: absolute;
    right: 60px;
    top: 20px;
    font-size: 13px;
    text-align: center; */
    position: absolute;
    bottom: 0;
    top: 50%;
    margin-top: -0.5em;
    
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

.allergy{
    padding:100px 0 0 0;
}
.menuset{
    display: inline-block;      /* インラインブロック要素にする */
    background-color:  #fff;    /* 背景色指定 */
    padding:  29px;             /* 余白指定 */
    height: 370px;              /* 高さ指定 */
}

/* .are_btn{
    position:absolute;
    margin-left: 710px;
    top: 230px;
} */
.ref-btn {
  display       : inline-block;
  border-radius : 5%;          /* 角丸       */
  font-size     : 10pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 6px 6px;   /* 余白       */
  background    : #e8ecef;     /* 背景色     */
  color         : #09186e;       /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  transition    : .3s;         /* なめらか変化 */
  box-shadow    : 1px 1px 1px #666666;  /* 影の設定 */
  border        : 2px solid #e8ecef;    /* 枠の指定 */
}
.ref-btn:hover {
  box-shadow    : none;        /* カーソル時の影消去 */
  color         : #3d4da7;     /* 背景色     */
  background    : #ffffff;      /* 文字色     */
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
.btn-square-pop {
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

.btn-square-pop:active {
  border-bottom: solid 2px #fd9535;
  box-shadow: 0 0 2px rgba(0, 0, 0, 0.30);
}
ul {
  list-style: none;
}
.plmi{
    border-color: #887f7a;
  border-style: solid;
  background-color:#eaf4fc;
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



