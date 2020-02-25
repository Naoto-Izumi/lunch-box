<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

    <script src="js/lightbox.js"></script>  
    <script>


        $(function(){
            $("li[name='0']").attr('class', 'inactive');
        });

        function amount(){
            document.frml.count.value++;
        }

        $(function(){
            // ダイアログの初期設定
            $("#mydialog2").dialog({
                autoOpen: false,  // 自動的に開かないように設定
                width: 500,       // 横幅のサイズを設定
                modal: true,      // モーダルダイアログにする
                buttons: [        // ボタン名 : 処理 を設定
                {
                    text: '閉じる',
                    click: function(){
                        console.log("jquery");
                        $(this).dialog("close");
                    }
                }
                ]
            });
        });
        
        function test(id, count){
            $(document).on("click", ".dialog", function(){
                //countが今カートに入ってる個数 2　productが上書きしたい個数 18
                var product = document.getElementById(id).value;
                console.log("product:"+product+" id:"+id);
                if(product <= 0){
                    // ダイアログの呼び出し処理
                    $("#mydialog2").dialog("open");
                    //documentからイベントを削除
                    $(document).off("click",".dialog");
                    //データの送信をリセット
                    return false;
                }else{
                    var i = product - count;
                    console.log("product- count"+i);
                    $('#'+id).attr('value', i);
                    //documentからイベントを削除
                    $(document).off("click",".dialog");
                }
                
            });
        }

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
            <td>${prof.pro_wheat}</td>
            <td>${prof.pro_egg}</td>
            <td>${prof.pro_milk}</td>
            <td>${prof.pro_peanuts}</td>
            <td>${prof.pro_buckwheat}</td>
            <td>${prof.pro_shrimp}</td>
            <td>${prof.pro_crab}</td>
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
            <input type="hidden" value="${st.count}" name="remove">
            <input type="submit" value="削除" id="">
        </form>
        
        
    </c:forEach>



    <c:forEach var="prof" items="${customCart}" varStatus="st">
        <c:set var="data" value="${prof.pro_id}" />
        <c:set var="calorie" value="${prof.pro_calorie}" />

        <table>
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
    </c:forEach>
    <%! ArrayList list = null;
        ArrayList customCart = null;
     %>
    <%
        list = (ArrayList)session.getAttribute("cart");
        customCart = (ArrayList)session.getAttribute("customCart");
        if(!(list==null && customCart==null)){
    %>
    <p>合計：${sessionScope.totalPrice + sessionScope.customTotalPrice}円</p>
    <a href="TopServlet">もう一度頼む</a>
    <a href="userinformation.jsp">個人情報入力</a>

    <%
        }
        if(list==null && customCart==null){
    %>
    <p>カートに商品が入っておりません。</p>
    <a href="TopServlet">TOPページへ</a>
    <%
        }
    %>


    
<!--ダイアログの内容-->
<div id="mydialog2" title="個数を入力して下さい">
    最低注文個数に達していません。（最低注文個数：1個）<br />
</div>


    </body>
</html>