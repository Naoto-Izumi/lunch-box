<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/Browser/js/Menu.js"></script>
        
        <!-- jQuery UI -->
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

        <script src="${pageContext.request.contextPath}/Browser/js/lightbox.js"></script>  
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu2.css">

<title>メニュー</title>

</head>
<body>
    <header class="grovalNavigation">
        <div class="logo" title="春戸弁当">
            <a href="st" class="fade_btn"><img src="${pageContext.request.contextPath}/Browser/img/harutoya.png" title="" height="90px" width="375px"></a>
        </div>
    
        <ul id="navi" class="icon_nav">
            <li>
                <a href="top" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_01.png" alt="メニュー" title="">
                    <span>メニュー</span>
                </a>
            </li>
    
            <li>
                <a href="store" target="_blank" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_02.png" alt="店舗検索" title="">
                    <span>店舗検索</span>
                </a>
            </li>
    
            <li>
                <a href="norder" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_03.png" alt="お知らせ" title="">
                    <span>ネット注文</span>
                </a>
            </li>
            <li>
                <a href="page" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_05.png" alt="スタッフ募集" title="">
                        <span>マイページ</span>
                </a>
            </li>
            <li>
                <a href="custom" class="fade_btn">
                    <img src="${pageContext.request.contextPath}/Browser/img/nav_05.png" alt="カート" title="">
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
                    <a href="infomation" >ログイン</a>
                </li>
            </ul>
        </div>
    
    
     </header>
     <div class="allergy">
        <h1>メニュー</h1>
        <a href="start">topページ</a>
        <p>商品の検索</p>
            <form action="search" method="post" name="search">
                <input type="text" name="sname" id="s1">
                <input type="submit" id="sea" value="検索" >
            </form>
        <p>アレルギーの絞り込み</p>

            <form action="refine" method="post" name="refine">
                
                <label>
                    <img src="${pageContext.request.contextPath}/Browser/img/a1.png" name="are" height="40px" width="40px" id="a1">
                    <input type="checkbox" name="check" id="p1" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a1.png')">小麦</label>
                    <input type="hidden" name="check1" id="p1" value="1">
                <label>
                    <img src="${pageContext.request.contextPath}/Browser/img/a2.png" name="are" height="40px" width="40px" id="a2">
                    <input type="checkbox" name="check" id="p2" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a2.png')">卵</label>
                    <input type="hidden" name="check2" id="p2" value="1">
                <label>
                    <img src="${pageContext.request.contextPath}/Browser/img/a3.png" name="are" height="40px" width="40px" id="a3">
                    <input type="checkbox" name="check" id="p3" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a3.png')">乳</label>
                    <input type="hidden" name="check3" id="p3" value="1">
                <label>
                    <img src="${pageContext.request.contextPath}/Browser/img/a4.png" name="are" height="40px" width="40px" id="a4">
                    <input type="checkbox" name="check" id="p4" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a4.png')">落花生</label>
                    <input type="hidden" name="check4" id="p4" value="1">
                <label>
                    <img src="${pageContext.request.contextPath}/Browser/img/a5.png" name="are" height="40px" width="40px" id="a5">
                    <input type="checkbox" name="check" id="p5" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a5.png')">そば</label>
                    <input type="hidden" name="check5" id="p5" value="1">
                <label>
                    <img src="${pageContext.request.contextPath}/Browser/img/a6.png" name="are" height="40px" width="40px" id="a6">
                    <input type="checkbox" name="check" id="p6" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a6.png')">えび</label>
                    <input type="hidden" name="check6" id="p6" value="1">
                <label>
                    <img src="${pageContext.request.contextPath}/Browser/img/a7.png" name="are" height="40px" width="40px" id="a7">
                    <input type="checkbox" name="check" id="p7" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a7.png')">かに</label>
                    <input type="hidden" name="check7" id="p7" value="1">
                <input type="submit" id="ref" value="絞り込みページ" onclick="onButtonClick()">
            </form>

            <form action="SortServlet" method="post">
                <p>並び替え<br>
                    <select size="1" name="sort">
                        <option value="prHigh">値段高い</option>
                        <option value="prLow">値段低い</option>
                        <option value="caHigh">カロリー高い</option>
                        <option value="caLow">カロリー低い</option>
                    </select>
                    <input type="submit" value="並び替え">
                </p>
            </form>

        <h1 id="userid">${result}</h1>
        <a href="look">カートを見る</a>
        <!--<h1>${result}</h1>-->
        <a id="login" href="infomation">ログイン</a>
        <a id="logout" href="vmenu" style="display:none;">ログアウト</a>
        <!--</div>-->
        <div class="tabs">
            <input id="all" type="radio" name="tab_item" checked>
            <label class="tab_item" for="all">弁当</label>
            <input id="programming" type="radio" name="tab_item">
            <label class="tab_item" for="programming">単品</label>
            <input id="design" type="radio" name="tab_item">
            <label class="tab_item" for="design">飲み物</label>
            <div class="tab_content" id="all_content">
                



            <div>
                <table>
                    <tr>
                        <c:forEach var="prof" items="${product}" varStatus="st">
                            <td>
                                <form method="post" name="${prof.id}" action="DetailServlet">                                        <img src="${prof.image}" name="bento" height="70px" width="70px">                                        <input type="hidden" name="id" value="${prof.id}">
                                    <a href="javascript:${prof.id}.submit()">${prof.name}</a>
                                </form>
                                <form action="mmenu" method="post" name="frml" >
                                    <input type="number" name="${prof.id}" id="${prof.id}" value=0 size=6 MIN="O" MAX="99"><br>
                                    <input type="button" value="＋" onClick="javascript:this.form.${prof.id}.value++;"> 
                                    <input type="button" value="－" onClick="javascript:this.form.${prof.id}.value--;">
                                    <input type="submit" value="カート" id="${st.count}" class="dialog" onclick="test('${prof.id}')">
                                </form>
                            </td>
                        </c:forEach>
                    </tr>
                </table>
            </div>
        </div>


    </div>
     <div class="tab_content" id="programming_content">
        プログラミングの内容がここに入ります
    </div>
    <div class="tab_content" id="design_content">
        デザインの内容がここに入ります
    </div>

<!--ダイアログの内容-->
<div id="mydialog2" title="個数を入力して下さい">
    最低注文個数に達していません。（最低注文個数：1個）<br />
</div>

</body>
</html>