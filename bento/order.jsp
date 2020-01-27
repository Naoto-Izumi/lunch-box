<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
import="java.util.Map"
import="java.util.TreeMap"
import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="js/lightbox.js"></script>  
    <script>


        $(function(){
            $("li[name='0']").attr('class', 'inactive');
        });


   
 

    
    </script>
    <style>
        .active{
            display:block;
        }
        .inactive{
            display:none;
        }
    </style>


</head>
<body>
    <!-- <table>
    <c:forEach var="list" items="${sessionScope.cb.cartList}">
    <tr><td>${list.syusyoku}</td>
            <td>${list.syusai}</td>
            <td>${list.huku1}</td>
            <td>${list.huku2}</td></tr>
        </c:forEach>
    </table>    
    <table>
        <p>注文個数(仮)</p>
    <c:forEach var="list" items="${sessionScope.tpb.priceList}">
            <tr><td>${list.syusyoku}</td>
            <td>${list.syusai}</td>
            <td>${list.huku1}</td>
            <td>${list.huku2}</td>
            <td>${list.total}</td></tr>
        </c:forEach>
    </table> -->

    <c:forEach var="prof" items="${cart}">  
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
            <td>${prof.pro_wheat}</td>
            <td>${prof.pro_egg}</td>
            <td>${prof.pro_milk}</td>
            <td>${prof.pro_peanuts}</td>
            <td>${prof.pro_buckwheat}</td>
            <td>${prof.pro_shrimp}</td>
            <td>${prof.pro_crab}</td>
            </tr>
        </table>
          
    </c:forEach>    



    <%
        Map map = (TreeMap)request.getAttribute("plist");

        for (Object val : map.values()) {

    %>
    <p><%=val%></p>
    <%
        }
    %>
<!-- 
    <table>
            <c:forEach var="list" items="${sessionScope.plist}">
                <tr><td>${list.name}</td>
                <td>${list.count}</td></tr>
            </c:forEach>
     </table>

    <p>${plist.count1}</p>
    <p>${plist.count2}</p>
    <p>${plist.count3}</p>
    <p>${plist.count4}</p>
    <p>${plist.count5}</p>
    <p>${plist.count6}</p> -->

        <p>合計:${total}</p>
        <a href="TopServlet">もう一度頼む</a>
        <a href="userinformation.jsp">個人情報入力</a>
    </body>
</html>