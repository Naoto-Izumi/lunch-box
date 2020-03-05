<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="js/lightbox.js"></script>  
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <script>


        $(function(){
            $("li[name='0']").attr('class', 'inactive');
        });


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
    
    function test(count){
        $(document).on("click", ".dialog", function(){
            console.log(count);
            var product = document.getElementById(count).value;
            if(product <= 0){
                // ダイアログの呼び出し処理
                $("#mydialog2").dialog("open");
                //documentからイベントを削除
                $(document).off("click",".dialog");
                //データの送信をリセット
                return false;
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

        .cho{
            padding:100px 0 0 0;
        }
    </style>
</head>
    <body>


        <header class="grovalNavigation">
            <div class="logo" title="春戸弁当">
                <a href="top.jsp" class="fade_btn"><img src="image/harutoya.png" title="" height="90px" width="375px"></a>
            </div>
        
            <ul id="navi" class="icon_nav">
                <li>
                    <a href="TopServlet" class="fade_btn">
                        <img src="image/5.png" alt="メニュー" title="">
                    </a>
                </li>
                <li>
                    <a href="TopCusServlet" class="fade_btn">
                        <img src="image/4.png" alt="カスタムメニュー" title="">
    
                    </a>
                </li>
        
                <li>
                    <a href="StoreServlet"  class="fade_btn">
                        <img src="image/1.png" alt="店舗検索" title="">
                    </a>
                </li>
        
                <li>
                    <a href="NetOrder.jsp" class="fade_btn">
                        <img src="image/2.png" alt="お知らせ" title="">
                    </a>
                </li>
                
                <li>
                    <a href="order.jsp" class="fade_btn">
                        <img src="image/3.png" alt="カート" title="">
    
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
                        <a href="" >ログイン</a>
                    </li>
                </ul>
            </div>
        
        
         </header>


















        <div class="cho">
                    <c:forEach var="prof" items="${product}">    
                            <img src="${prof.pro_image}"  height="300px" width="300px">
                            <br>
                            ${prof.pro_name}
                            
                            ${prof.pro_price}円
<br>
                            ${prof.pro_description}
<br>
                            ${prof.pro_calorie}㎉

                            
                            
                            
                            <ul id="alle">
                                <p>アレルギー物質表示</p>
                                <li class="active" name="${prof.pro_wheat}">小麦</li>
                                <li class="active" name="${prof.pro_egg}">卵</li>
                                <li class="active" name="${prof.pro_milk}">乳</li>
                                <li class="active" name="${prof.pro_peanuts}">落花生</li>
                                <li class="active" name="${prof.pro_buckwheat}">そば</li>
                                <li class="active" name="${prof.pro_shrimp}">えび</li>
                                <li class="active" name="${prof.pro_crab}">かに</li>
                            
                            </ul>  

                        <table border=1>
                            <tr>
                                <th>タンパク質</th>
                                <th>糖質</th>
                                <th>脂質</th>
                                <th>ビタミン</th>
                                <th>無機質</th>
                            </tr>
                            <tr>
                                <td>${prof.pro_protein}</td>
                                <td>${prof.pro_carbohydrate}</td>
                                <td>${prof.pro_lipid}</td>
                                <td>${prof.pro_vitamin}</td>
                                <td>${prof.pro_inorganic}</td>
                            </tr>
                        </table>
                        <p>この商品をカートに追加</p>
                        <form action="MenuServlet" method="post" name="frml" >
                            <input type="text" name="${prof.pro_id}" id="${prof.pro_id}" value=0 size=6 MIN="O" MAX="99"><br>
                            <input type="button" value="＋" onClick="javascript:this.form.${prof.pro_id}.value++;"> 
                            <input type="button" value="－" onClick="javascript:this.form.${prof.pro_id}.value--;"><br>
                            <input type="submit" value="カート" class="dialog" onclick="test('${prof.pro_id}')">
                        </form>
                                    
                    </c:forEach>
                    <a href="TopServlet">Topへ戻る</a>
                    
          
        </div>

        <!--ダイアログの内容-->
        <div id="mydialog2" title="個数を入力して下さい">
            最低注文個数に達していません。（最低注文個数：1個）<br />
        </div>
    </body>
</html>