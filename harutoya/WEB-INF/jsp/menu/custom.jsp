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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Custom.css">  

<title>カスタムメニュー</title>



</head>
<body>

    <header class="grovalNavigation">
        <div class="logo" title="春戸弁当">
            <a href="TopServlet" class="fade_btn"><img src="${pageContext.request.contextPath}/Browser/img/harutoya.png" title="" height="90px" width="375px"></a>
        </div>
    
        <ul id="navi" class="icon_nav">
            <li>
                <a href="TopServlet" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_01.png" alt="メニュー" title="">
                    <span>メニュー</span>
                </a>
            </li>
            <li>
                <a href="TopServlet" class="fade_btn">
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
                <a href="norder" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_04.png" alt="お知らせ" title="">
                    <span>ネット注文</span>
                </a>
            </li>
            
            <li>
                <a href="TopCusServlet" class="fade_btn">
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
                     <a href="ruser" >新規会員登録</a>
                </li>
                <li>
                    <a href="infomation" >ログイン</a>
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
    <div class="allergy">
        <p>アレルギーの絞り込み</p>
    </div>

    <form action="RefineCusServlet" method="post" name="refine">
        
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a1.png" name="are" height="40px" width="40px" id="a1">
            <input type="checkbox" name="check" id="p1" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a1.png')">小麦</label>
            <input type="hidden" name="check1" id="p1" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a2.png" name="are" height="40px" width="40px" id="a2">
            <input type="checkbox" name="check" id="p2" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a2.png')">卵</label>
            <input type="hidden" name="check1" id="p2" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a3.png" name="are" height="40px" width="40px" id="a3">
            <input type="checkbox" name="check" id="p3" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a3.png')">乳</label>
            <input type="hidden" name="check1" id="p3" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a4.png" name="are" height="40px" width="40px" id="a4">
            <input type="checkbox" name="check" id="p4" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a4.png')">落花生</label>
            <input type="hidden" name="check1" id="p4" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a5.png" name="are" height="40px" width="40px" id="a5">
            <input type="checkbox" name="check" id="p5" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a5.png')">そば</label>
            <input type="hidden" name="check1" id="p5" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a6.png" name="are" height="40px" width="40px" id="a6">
            <input type="checkbox" name="check" id="p6" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a6.png')">えび</label>
            <input type="hidden" name="check1" id="p6" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a7.png" name="are" height="40px" width="40px" id="a7">
            <input type="checkbox" name="check" id="p7" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a7.png')">かに</label>
            <input type="hidden" name="check1" id="p7" value="1">
        <div >
            <input type="submit" id="ref" value="を表示しない" class="ref-btn" onclick="onButtonClick()">
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
        



<div>
        <form action="CustomMenuServlet" method="POST" name="custom">
            <div >
            <span id="one"></span><input type="text" id="syusyoku" name="syusyoku" value="" oninput="gazou()" class="customtext1" placeholder="主食" required>
            <input type="hidden" id="syusyoku2" name="syusyoku" >
            <span id="two"></span><input type="text" id="syusai" name="syusai" value="" oninput="gazou()" class="customtext2"　placeholder="主菜">
            <input type="hidden" id="syusai2" name="syusai" >
            <span id="three"></span><input type="text" id="huku1" name="huku1" value="" oninput="gazou()" class="customtext3"　placeholder="副菜">
            <input type="hidden" id="huku12" name="huku1" >
            <span id="four"></span><input type="text" id="huku2" name="huku2" oninput="gazou()" class="customtext4"　placeholder="副菜">
            <input type="hidden" id="huku22" name="huku2" >
            </div>
            <!-- このコードは使わない<input type="button" onclick="check();" value="カート"> -->
             <input type="submit" id="cart" value="カート">
             
        </form>
        <button id="reset" >reset</button>
      
            
</div> 


<a href="norder">カートを見る</a>

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
                    <form method="post" name="${prof.id}" action="DetailServlet">
                        <a href="javascript:${prof.id}.submit()">
                            <img src="${prof.image}" name="bento" height="170px" width="170px">
                            <input type="hidden" name="id" value="${prof.id}"><br>
                            <p>${prof.name}</p>
                            <p>${prof.pro_price}円</p>
                            <p>${prof.pro_calorie}㎉</p>
                        </a>
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
                        <a href="javascript:${prof.id}.submit()">
                            <img src="${prof.image}" name="bento" height="170px" width="170px">
                            <input type="hidden" name="id" value="${prof.id}"><br>
                            <p>${prof.name}</p>
                            <p>${prof.pro_price}円</p>
                            <p>${prof.pro_calorie}㎉</p>
                        </a>
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
                        <form method="post" name="${prof.id}" action="DetailServlet">
                            <a href="javascript:${prof.id}.submit()">
                                <img src="${prof.image}" name="bento" height="170px" width="170px">
                                <input type="hidden" name="id" value="${prof.id}"><br>
                                <p>${prof.name}</p>
                                <p>${prof.pro_price}円</p>
                                <p>${prof.pro_calorie}㎉</p>
                            </a>
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