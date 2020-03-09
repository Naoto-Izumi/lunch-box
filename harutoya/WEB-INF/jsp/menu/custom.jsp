<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <!-- jQuery UI -->
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

        <script src="${pageContext.request.contextPath}/Browser/js/lightbox.js"></script>
        <script src="${pageContext.request.contextPath}/Browser/js/Custom.js"></script>
        <script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>
        <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu.css"> -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico"> 

<title>カスタムメニュー</title>

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
  border-bottom: 3px solid#e49e61;
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
  background-color:#e49e61;
  color: #fff;
}

.syusyokutext{
    background-color:#f0f8ff;
    font-size:50px;
    border-color:#6495ed;
    border-width:5px;
    position: relative;
    height: 300px;
    width: 400px;
}
.syusaitext{
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
.huku1text{
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
.huku2text{
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


.Asyusyokutext{
    background-color:#f0f8ff;
    font-size:5px;
    border-color:#6495ed;
    border-width:2px;
    position: fixed;
    height: 30px;
    width: 80px;
}
.Asyusaitext{
    background-color:#f0f8ff;
    font-size:5px;
    border-color:#6495ed;
    border-width:2px;
    position: fixed;
    height: 30px;
    width: 80px;

}

/* .kotei{
    position: fixed;
} */
.Ahuku1text{
    background-color:#f0f8ff;
    font-size:5px;
    border-color:#6495ed;
    border-width:2px;
    position: fixed;
    height: 30px;
    width: 80px;
}
.Ahuku2text{
    background-color:#f0f8ff;
    font-size:5px;
    border-color:#6495ed;
    border-width:2px;
    position: fixed;
    height: 30px;
    width: 80px;

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

.menuset{
    display: inline-block;      /* インラインブロック要素にする */
    background-color:  #fff;    /* 背景色指定 */
    padding:  29px;             /* 余白指定 */
    height: 300px;              /* 高さ指定 */
}

/* allergyボタン----------------------------------------------------- */
.are_btn{
    position:absolute;
    margin-left: 710px;
    top: 250px;
}
.btn-three {
    color: #09186e;
    transition: all 0.5s;
    position: relative;
}
.btn-three::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 9%;
    height: 100%;
    z-index: 1;
    background-color: rgba(236, 10, 134, 0.1);
    transition: all 0.3s;
}
.btn-three:hover::before {
    opacity: 0 ;
    transform: scale(0.5,0.5);
}
.btn-three::after {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 9%;
    height: 100%;
    z-index: 1;
    opacity: 0;
    transition: all 0.3s;
    border: 1px solid rgba(60, 223, 95, 0.5);
    transform: scale(1.2,1.2);
}
.btn-three:hover::after {
    opacity: 1;
    transform: scale(1,1);
}
/* ref-btn------------------------- */
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
ul {
  list-style: none;
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
<!-- 
<a href="top.jsp">topページ</a>
<p>商品の検索</p>
    <form action="SearchServlet" method="post" name="search">
        <input type="text" name="sname" id="s1">
        <input type="submit" id="sea" value="検索" >
    </form> -->
    <div class="zuras">
        <div>
            <form action="CustomMenuServlet" method="POST" name="custom">
                <div class="kotei">
                    主食
                    <span id="one"></span><input type="text" id="syusyoku" name="syusyoku" value="" oninput="gazou()"  required>
                    <input type="hidden" id="syusyoku2" name="syusyoku" >
                    主菜
                    <span id="two"></span><input type="text" id="syusai" name="syusai" value="" oninput="gazou()" " required>
                    <input type="hidden" id="syusai2" name="syusai" >
                    副菜
                    <span id="three"></span><input type="text" id="huku1" name="huku1" value="" oninput="gazou()" " required>
                    <input type="hidden" id="huku12" name="huku1" >
                    副菜
                    <span id="four"></span><input type="text" id="huku2" name="huku2" value="" oninput="gazou()" " required>
                    <input type="hidden" id="huku22" name="huku2" >
                
                <!-- このコードは使わない<input type="button" onclick="check();" value="カート"> -->
                    <input type="submit" id="cart" value="カート" class="ref-btn">
                        
                    </form>
                    <button id="reset" class="ref-btn">リセット</button>
                    <br>※画像をドラッグして入れてください
                </div>
                
        
                
        </div> 
        アレルギーの絞り込み
    </div>

    <form action="RefineCusServlet" method="post" name="refine">
        
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a1.png" name="are" height="40px" width="40px" id="a1">
            <input type="checkbox" name="check" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a1.png')">小麦</label>
            <input type="hidden" name="check1" id="p1" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a2.png" name="are" height="40px" width="40px" id="a2">
            <input type="checkbox" name="check"  onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a2.png')">卵</label>
            <input type="hidden" name="check2" id="p2" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a3.png" name="are" height="40px" width="40px" id="a3">
            <input type="checkbox" name="check"  onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a3.png')">乳</label>
            <input type="hidden" name="check3" id="p3" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a4.png" name="are" height="40px" width="40px" id="a4">
            <input type="checkbox" name="check"  onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a4.png')">落花生</label>
            <input type="hidden" name="check4" id="p4" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a5.png" name="are" height="40px" width="40px" id="a5">
            <input type="checkbox" name="check"  onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a5.png')">そば</label>
            <input type="hidden" name="check5" id="p5" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a6.png" name="are" height="40px" width="40px" id="a6">
            <input type="checkbox" name="check"  onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a6.png')">えび</label>
            <input type="hidden" name="check6" id="p6" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a7.png" name="are" height="40px" width="40px" id="a7">
            <input type="checkbox" name="check"  onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a7.png')">かに</label>
            <input type="hidden" name="check7" id="p7" value="1">
        <div >
            <input type="submit" id="ref" value="を表示しない" class="ref-btn">
        </div>
           <!-- Hover #3 -->
        <!-- <div class="box-3">
            <div class="btn btn-three">
                <input type="submit" id="ref" value="を表示しない" onclick="onButtonClick()">
            </div>
        </div> -->
    </form>
 


    <form action="SortServlet" method="post">
        <p>並び替え<br>
            <select size="1" name="sort">
                <option value="prHigh">値段高い</option>
                <option value="prLow">値段低い</option>
                <option value="caHigh">カロリー高い</option>
                <option value="caLow">カロリー低い</option>
            </select>
            <input type="submit" value="並び替え" class="ref-btn">
        </p>
    </form>

<div class="tabs">
    <input id="all" type="radio" name="tab_item" checked>
    <label class="tab_item" for="all">主食</label>
    <input id="programming" type="radio" name="tab_item">
    <label class="tab_item" for="programming">主菜</label>
    <input id="design" type="radio" name="tab_item">
    <label class="tab_item" for="design">副菜</label>
    <div class="tab_content" id="all_content">
        



        <div>
            <!-- <table>
                <tr>
                    <c:forEach var="prof" items="${syusyokuProduct}" varStatus="st">
                        <td>
                            <form method="post" name="${prof.id}" action="DetailServlet">
                                <img src="${prof.image}" name="bento" height="170px" width="170px">
                                <input type="hidden" name="id" value="${prof.id}"><br>
                                <a href="javascript:${prof.id}.submit()">${prof.name}</a>
                            </form>
                     
                        </td>
                    </c:forEach>
                </tr>
            </table> -->
            <c:forEach var="prof" items="${syusyokuProduct}" varStatus="st">
                <diV class="menuset">
                    <img src="${prof.image}" name="bento" height="170px" width="170px">

                    <form method="post" name="${prof.id}" action="DetailServlet">
                        <a href="javascript:document.forms.${prof.id}.submit()">  
                            <input type="hidden" name="id" value="${prof.id}"><br>
                            <p>${prof.name}</p>
                            
                        </a>
                        <p>${prof.pro_price}円</p>
                        <p>${prof.pro_calorie}㎉</p>
                    </form>
                </diV>
            </c:forEach>
        </div>
        


    </div>
    <div class="tab_content" id="programming_content">
        <div>
            <!-- <table>
                <tr>
                    <c:forEach var="prof" items="${syusaiProduct}" varStatus="st">
                        <td>
                            <form method="post" name="${prof.id}" action="DetailServlet">
                                <img src="${prof.image}" name="bento" height="70px" width="70px">
                                <input type="hidden" name="id" value="${prof.id}"><br>
                                <a href="javascript:${prof.id}.submit()">${prof.name}</a>
                            </form>
                         
                        </td>
                    </c:forEach>
                </tr>
            </table> -->
            <c:forEach var="prof" items="${syusaiProduct}" varStatus="st">
                <diV class="menuset">
                    <form method="post" name="${prof.id}" action="DetailServlet">
                        <img src="${prof.image}" name="bento" height="170px" width="170px">
                        <a href="javascript:${prof.id}.submit()">
                            <input type="hidden" name="id" value="${prof.id}"><br>
                            <p>${prof.name}</p>
                        </a>
                        <p>${prof.pro_price}円</p>
                        <p>${prof.pro_calorie}㎉</p>
                    </form>
                </diV>
            </c:forEach>
        </div>
    </div>
    <div class="tab_content" id="design_content">
        <div>
            <!-- <table>
                <tr>
                    <c:forEach var="prof" items="${hukuProduct}" varStatus="st">
                        <td>
                            <form method="post" name="${prof.id}" action="DetailServlet">
                                <img src="${prof.image}" name="bento" height="70px" width="70px">
                                <input type="hidden" name="id" value="${prof.id}"><br>
                                <a href="javascript:${prof.id}.submit()">${prof.name}</a>
                            </form>
                           
                        </td>
                    </c:forEach>
                </tr>
            </table> -->
                <c:forEach var="prof" items="${hukuProduct}" varStatus="st">
                    <diV class="menuset">
                        <img src="${prof.image}" name="bento" height="170px" width="170px">
                        <form method="post" name="${prof.id}" action="DetailServlet">
                            <a href="javascript:${prof.id}.submit()">
                                <input type="hidden" name="id" value="${prof.id}"><br>
                                <p>${prof.name}</p>
                            </a>
                            <p>${prof.pro_price}円</p>
                            <p>${prof.pro_calorie}㎉</p>
                        </form>
                    </div>
                </c:forEach>              
            
        </div>
    </div>



<!--ダイアログの内容-->
<div id="mydialog2" title="個数を入力して下さい">
    最低注文個数に達していません。（最低注文個数：1個）<br />
</div>


<p></p>



</body>
</html>