<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
import="java.util.ArrayList"
import="Menu.Beans.CustomCartBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

    <script src="${pageContext.request.contextPath}/Browser/js/lightbox.js"></script>  
    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu.css"> -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico">
    <script src="${pageContext.request.contextPath}/Browser/js/Order.js"></script>
    <script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>

    <style>
        .active{
            display: inline;
        }
        .passive{
            display: none;
        }

        body{
            padding: 0;
            margin: 0;
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


        .active{
            display:block;
        }
        .inactive{
            display:none;
        }
        .nocart{
            margin: -200px 0 0 -300px;  /*縦横半分をネガティブマージンでずらす*/
            position: absolute;     /*body要素に対して絶対配置*/
            top: 50%;       /*上端を中央に*/
            left: 50%;      /*左端を中央に*/
            width: 600px;   /*横幅*/
            height: 400px;  /*縦幅*/
            background-color:#fff;

        }
        .nocart p{
            margin-top:10%;
            margin-left: 10%;
            position: absolute;
            font-size: 30px;
            color:#353834;
            
        }
        .nocart a{
            margin-top:30%;
            margin-left: 20%;
            position: absolute;
            
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
            text-align: center;
            font-size: 32px;
            text-decoration: none;
        }

        .btn-flat-border:hover {
        background: #67c5ff;
        color: white;
        }
        .tablecus table{
        border-collapse:collapse;
        margin:0 auto;
        table-layout: fixed;
        }
        .tablecus td,th{
        padding:10px;
        border-bottom:1px solid #ccc;
        text-align: center;
        }
        .tablecus table tr th:nth-child(odd),
        .tablecus table tr td:nth-child(odd){
        background:#e6f2ff;
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
        ul {
        list-style: none;
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



















     <div class="zuras">


            <h1>カート</h1>
            <c:forEach var="prof" items="${cart}" varStatus="st">
                <c:set var="data" value="${prof.pro_id}" />

                <div class="custable">
                    <table>
                        <tr>
                        <td>${prof.pro_name}</td>
                        <td>${prof.pro_price}円</td>
                        <td>${prof.pro_calorie}㎉</td>
                        <td><img src="${prof.pro_image}" width="50px" height="50px"></td>
                        </tr>
                        <tr>
                        <td>タンパク質：${prof.pro_protein}g</td>
                        <td>糖質：${prof.pro_carbohydrate}g</td>
                        <td>脂質：${prof.pro_lipid}g</td>
                        <td>ビタミン：${prof.pro_vitamin}g</td>
                        <td>無機質：${prof.pro_inorganic}g</td>
                        <c:if test="${prof.pro_wheat} != 0}">
                    
                        <td><img src="${pageContext.request.contextPath}/Browser/img/a1.png" name="are" height="25px" width="25px" ></td>
                    </c:if>
                    <c:if test="${element.ab.pro_wheat != 0}">
                        <td><img src="${pageContext.request.contextPath}/Browser/img/a1.png" name="are" height="25px" width="25px" ></td>
                    </c:if>

                    <c:if test="${element.ab.pro_wheat != 0}">
                            <td><img src="${pageContext.request.contextPath}/Browser/img/a1.png" name="are" height="25px" width="25px" ></td>
                        </c:if>
                    
                    <c:if test="${prof.pro_egg} == 1}">
                    <td><img src="${pageContext.request.contextPath}/Browser/img/a2.png" name="are" height="25px" width="25px" ></td>
                </c:if>
                
                <c:if test="${prof.pro_milk} == 1}">
                    <td><img src="${pageContext.request.contextPath}/Browser/img/a3.png" name="are" height="25px" width="25px" ></td>
                </c:if>
                
                <c:if test="${prof.pro_peanuts} == 1}">
                    <td><img src="${pageContext.request.contextPath}/Browser/img/a4.png" name="are" height="25px" width="25px" ></td>
                </c:if>
                
                <c:if test="${prof.pro_buckwheat} == 1}">
                    <td><img src="${pageContext.request.contextPath}/Browser/img/a5.png" name="are" height="25px" width="25px" ></td>
                </c:if>
                
                <c:if test="${prof.pro_shrimp} == 1}">
                    <td><img src="${pageContext.request.contextPath}/Browser/img/a6.png" name="are" height="25px" width="25px" ></td>
                </c:if>
                
                <c:if test="${prof.pro_crab} == 1}">
                    <td><img src="${pageContext.request.contextPath}/Browser/img/a7.png" name="are" height="25px" width="25px" ></td>
                </c:if>
                    
                <td>${sessionScope.list[data]}個</td>
                <td>${prof.total}円</td>
                </tr>
            </table>
        </div>
                <form action="MenuServlet" method="post" name="frml">
                    <input type="number" name="${prof.pro_id}" id="${prof.pro_id}" value='${sessionScope.list[data]}' size=6 MIN="O" MAX="99"><br>
                    <input type="button" value="＋" onClick="javascript:this.form.${prof.pro_id}.value++;"> 
                    <input type="button" value="－" onClick="javascript:this.form.${prof.pro_id}.value--;">
                    <input type="submit" value="カート" id="${st.count}" class="dialog ref-btn"  onclick="test('${prof.pro_id}', '${sessionScope.list[data]}')">
                </form>
                <form action="RemoveServlet" method="post" name="remove">
                    <input type="hidden" value="${prof.pro_id}" name="id">
                    <input type="hidden" value="0" name="judge">
                    <input type="hidden" value="${st.count}" name="remove">
                    <input type="submit" value="削除" id="" class="ref-btn">
                </form>
            
            
            </c:forEach>
            <table>
                <c:forEach var="elements" items="${sessionScope.ccb.customList}" varStatus="el">
                <tr>
                    <table>
                        <tr>
                        <th>商品名</th>
                        <th>金額</th>
                        <th>熱量</th>
                        <th>タンパク質</th>
                        <th>糖質</th>
                        <th>脂質</th>
                        <th>ビタミン</th>
                        <th>無機質</th>
                    </tr>
                <c:forEach var="element" items="${elements.elementList}">                   
                    <tr>
                        
                        <td><img src="${element.image}" width="50px" height="50px"></td>
                        <td>${element.name}</td>
                        <td>${element.money}</td>
                        <td>${element.calory}</td>
                        <td>${element.nb.pro_protein}</td>
                        <td>${element.nb.pro_carbohydrate}</td>
                        <td>${element.nb.pro_lipid}</td>
                        <td>${element.nb.pro_vitamin}</td>
                        <td>${element.nb.pro_inorganic}</td>
                        <c:if test="${element.ab.pro_wheat != 0}">
                            <td><img src="${pageContext.request.contextPath}/Browser/img/a1.png" name="are" height="25px" width="25px" id="a1"></td>
                        </c:if>
                        <!-- <td>${element.ab.pro_wheat}</td> -->
                        <c:if test="${element.ab.pro_egg == 1}">
                            <td><img src="${pageContext.request.contextPath}/Browser/img/a2.png" name="are" height="25px" width="25px" id="a2"></td>
                        </c:if>
                        <!-- <td>${element.ab.pro_egg}</td> -->
                        <c:if test="${element.ab.pro_milk == 1}">
                            <td><img src="${pageContext.request.contextPath}/Browser/img/a3.png" name="are" height="25px" width="25px" id="a3"></td>
                        </c:if>
                        <!-- <td>${element.ab.pro_milk}</td> -->
                        <c:if test="${element.ab.pro_peanuts == 1}">
                            <td><img src="${pageContext.request.contextPath}/Browser/img/a4.png" name="are" height="25px" width="25px" id="a4"></td>
                        </c:if>
                        <!-- <td>${element.ab.pro_peanuts}</td> -->
                        <c:if test="${element.ab.pro_buckwheat == 1}">
                            <td><img src="${pageContext.request.contextPath}/Browser/img/a5.png" name="are" height="25px" width="25px" id="a5"></td>
                        </c:if>
                        <!-- <td>${element.ab.pro_buckwheat}</td> -->
                        <c:if test="${element.ab.pro_shrimp == 1}">
                            <td><img src="${pageContext.request.contextPath}/Browser/img/a6.png" name="are" height="25px" width="25px" id="a6"></td>
                        </c:if>
                        <!-- <td>${element.ab.pro_shrimp}</td> -->
                        <c:if test="${element.ab.pro_crab == 1}">
                            <td><img src="${pageContext.request.contextPath}/Browser/img/a7.png" name="are" height="25px" width="25px" id="a7"></td>
                        </c:if>
                        <!-- <td>${element.ab.pro_crab}</td> -->
                        </tr>
                    </c:forEach>
                    <td>カロリー合計：${elements.elementList[0].calory+elements.elementList[1].calory+elements.elementList[2].calory+elements.elementList[3].calory}</td>
                    <td>タンパク質：${elements.elementList[0].nb.pro_protein+elements.elementList[1].nb.pro_protein+elements.elementList[2].nb.pro_protein+elements.elementList[3].nb.pro_protein}</td>
                    <td>糖質：${elements.elementList[0].nb.pro_carbohydrate+elements.elementList[1].nb.pro_carbohydrate+elements.elementList[2].nb.pro_carbohydrate+elements.elementList[3].nb.pro_carbohydrate}</td>
                    <td>脂質：${elements.elementList[0].nb.pro_lipid+elements.elementList[1].nb.pro_lipid+elements.elementList[2].nb.pro_lipid+elements.elementList[3].nb.pro_lipid}</td>
                    <td>ビタミン：${elements.elementList[0].nb.pro_vitamin+elements.elementList[1].nb.pro_vitamin+elements.elementList[2].nb.pro_vitamin+elements.elementList[3].nb.pro_vitamin}</td>
                    <td>無機質：${elements.elementList[0].nb.pro_inorganic+elements.elementList[1].nb.pro_inorganic+elements.elementList[2].nb.pro_inorganic+elements.elementList[3].nb.pro_inorganic}</td>
                    <td>${elements.total_money}円</td>
                    <td><form action="RemoveServlet" method="post" name="remove">
                        <input type="hidden" value="${prof.pro_id}" name="id">
                        <input type="hidden" value="1" name="judge">
                        <input type="hidden" value="${el.count}" name="remove">
                        <input type="submit" value="削除" id="" class="ref-btn">
                    </form></td>
                </table></tr>
                </c:forEach>
                <!-- <p>${sessionScope.ccb.custom_total_money}</P> -->
            </table>
            <%! ArrayList list = null;
                CustomCartBean customCart = null;
             %>
            <%
                list = (ArrayList)session.getAttribute("cart");
                customCart = (CustomCartBean)session.getAttribute("ccb");
                if(!(list==null && customCart==null)){
            %>
            <p>合計：${sessionScope.totalPrice + sessionScope.ccb.custom_total_money}円</p>
            <form action="RemoveServlet" method="post" name="remove">
                <input type="hidden" value="2" name="judge">
                <input type="submit" value="カートの中身をすべて削除" id="" class="ref-btn">
            </form>
            <a href="TopServlet" class="btn-pop">もう一度頼む</a>
    <a href="infomation" class="btn-pop">ご注文内容の指定へ進む</a>
            
        
            <%
                }
                if(list==null && customCart==null){
            %>
            <div class="nocart">
                <p>カートに商品が入っておりません。</p>
                <a href="TopServlet" class="btn-flat-border">TOPページへ</a>
            </div>
            <%
                }
            %>
    </div>


    
    


    
<!--ダイアログの内容-->
<div id="mydialog2" title="個数を入力して下さい">
    最低注文個数に達していません。（最低注文個数：1個）<br />
</div>


    </body>
</html>