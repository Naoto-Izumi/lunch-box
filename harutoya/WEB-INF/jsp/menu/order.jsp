<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
import="java.util.Map"
import="java.util.TreeMap"
import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/Browser/js/lightbox.js"></script> 
    <script src="${pageContext.request.contextPath}/Browser/js/Order.js"></script> 
    <script src="${pageContext.request.contextPath}/Browser/js/Menu.js"></script> 
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Browser/css/Menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Browser/css/Menu2.css">

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
        <c:forEach var="prof" items="${cart}">
            <table id="${prof.pro_id}">
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
                <td>${prof.pro_wheat}</td>
                <td>${prof.pro_egg}</td>
                <td>${prof.pro_milk}</td>
                <td>${prof.pro_peanuts}</td>
                <td>${prof.pro_buckwheat}</td>
                <td>${prof.pro_shrimp}</td>
                <td>${prof.pro_crab}</td>
                <td>${sessionScope.list}個</td>
                </tr>
            </table>
            <p>合計:${totalPrice}</p>
            <a href="top">もう一度頼む</a>
            <a href="infomation">個人情報入力</a>
            <input type="number" name="${prof.id}" value=0 size=6 MIN="O" MAX="99"><br>
            <input type="button" value="＋" onClick="javascript:this.form.${prof.id}.value++;"> 
            <input type="button" value="－" onClick="javascript:this.form.${prof.id}.value--;">
        </c:forEach>    

        <%! Map map = null; %>
        <%
            map = (TreeMap)session.getAttribute("list");
            
            if(map!=null){
        
                for (Object val : map.values()) {

        %>
        <li><%=val%>個</li>
        <%
                }
            }
        %>

        <%


            if(map==null){

        %>
        <p>カートに商品が入っておりません。</p>
        <a href="top">TOPページへ</a>
        <%
            }
        %>

     </div>

    </body>
</html>