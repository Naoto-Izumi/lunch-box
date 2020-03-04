<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
import="java.util.ArrayList"
import="Bean.CustomCartBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

    <script src="${pageContext.request.contextPath}/Browser/js/lightbox.js"></script>  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css">


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




















    <c:forEach var="prof" items="${cart}" varStatus="st">
        <c:set var="data" value="${prof.pro_id}" />

        <table>
            <tr>
            <td>${prof.pro_id}</td>
            <td>${prof.pro_name}</td>
            <td>${prof.pro_price}</td>
            <td>${prof.pro_stock}</td>
            <td>${prof.pro_calorie}</td>
            <td>${prof.pro_date}</td>
            <td>${prof.pro_type}</td>
            <td><img src="${prof.pro_image}" width="50px" height="50px"></td>
            <td>${prof.pro_description}</td>
            <td>${prof.pro_protein}</td>
            <td>${prof.pro_carbohydrate}</td>
            <td>${prof.pro_lipid}</td>
            <td>${prof.pro_vitamin}</td>
            <td>${prof.pro_inorganic}</td>
            <!-- <td>${prof.pro_wheat}</td>
            <td>${prof.pro_egg}</td>
            <td>${prof.pro_milk}</td>
            <td>${prof.pro_peanuts}</td>
            <td>${prof.pro_buckwheat}</td>
            <td>${prof.pro_shrimp}</td>
            <td>${prof.pro_crab}</td> -->
            <c:if test="${prof.pro_wheat} != 0}">
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
        <form action="MenuServlet" method="post" name="frml">
            <input type="number" name="${prof.pro_id}" id="${prof.pro_id}" value='${sessionScope.list[data]}' size=6 MIN="O" MAX="99"><br>
            <input type="button" value="＋" onClick="javascript:this.form.${prof.pro_id}.value++;"> 
            <input type="button" value="－" onClick="javascript:this.form.${prof.pro_id}.value--;">
            <input type="submit" value="カート" id="${st.count}" class="dialog"  onclick="test('${prof.pro_id}', '${sessionScope.list[data]}')">
        </form>
        <form action="RemoveServlet" method="post" name="remove">
            <input type="hidden" value="${prof.pro_id}" name="id">
            <input type="hidden" value="0" name="judge">
            <input type="hidden" value="${st.count}" name="remove">
            <input type="submit" value="削除" id="">
        </form>
        
        
    </c:forEach>


    
    <!-- <c:forEach var="prof" items="${customCart}" varStatus="st">
        <c:set var="data" value="${prof.pro_id}" />
        <c:set var="calorie" value="${prof.pro_calorie}" />

        <table class="${st.count}">
            <tr>
            <td>${prof.pro_id}</td>
            <td>${prof.pro_name}</td>
            <td>${prof.pro_price}</td>
            <td>${prof.pro_stock}</td>
            <td>${calorie}</td>
            <td>${prof.pro_date}</td>
            <td>${prof.pro_type}</td>
            <td><img src="${prof.pro_image}" width="50px" height="50px"></td>
            <td>${prof.pro_description}</td>
            <td>${prof.pro_protein}</td>
            <td>${prof.pro_carbohydrate}</td>
            <td>${prof.pro_lipid}</td>
            <td>${prof.pro_vitamin}</td>
            <td>${prof.pro_inorganic}</td>
            <td>${prof.pro_wheat}</td>
            <td>${prof.pro_egg}</td>
            <td>${prof.pro_milk}</td>
            <td>${prof.pro_peanuts}</td>
            <td>${prof.pro_buckwheat}</td>
            <td>${prof.pro_shrimp}</td>
            <td>${prof.pro_crab}</td>
            <td>${sessionScope.customList[data]}個</td>
            <td>${prof.total}円</td>
            </tr>
        </table>
    </c:forEach> -->
    <table>
        <c:forEach var="elements" items="${sessionScope.ccb.customList}" varStatus="el">
        <tr>
            <table>
                <tr>
                <th>id</th>
                <th>img</th>
                <th>name</th>
                <th>money</th>
                <th>calory</th>
                <th>type</th>
                <th>count</th>
                <th>タンパク質</th>
                <th>糖質</th>
                <th>脂質</th>
                <th>ビタミン</th>
                <th>無機質</th>
                <!-- <th>小麦</th>
                <th>卵</th>
                <th>乳</th>
                <th>落花生</th>
                <th>そば</th>
                <th>えび</th>
                <th>かに</th> -->
            </tr>
        <c:forEach var="element" items="${elements.elementList}">                   
            <tr>
                <td>${element.id}</td>
                <td><img src="${element.image}" width="50px" height="50px"></td>
                <td>${element.name}</td>
                <td>${element.money}</td>
                <td>${element.calory}</td>
                <td>${element.type}</td>
                <td>${element.count}</td>
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
                <input type="submit" value="削除" id="">
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
    <a href="TopServlet">もう一度頼む</a>
    <a href="infomation">個人情報入力</a>
    <td><form action="RemoveServlet" method="post" name="remove">
        <input type="hidden" value="2" name="judge">
        <input type="submit" value="カートの中身をすべて削除" id="">
    </form>

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


    
<!--ダイアログの内容-->
<div id="mydialog2" title="個数を入力して下さい">
    最低注文個数に達していません。（最低注文個数：1個）<br />
</div>


    </body>
</html>