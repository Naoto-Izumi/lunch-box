<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>確認</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="js/lightbox.js"></script>  
    <script>
        //いらないやつ
        $(function(){
            $("li[class='']").attr('class', 'inactive');
        })
        $(function(){
            var element = document.getElementById("target");
            var a = element.className ;
            if(a==null){
                // element.className = "inactive"
                $("div[id='target']").attr('class', 'inactive');
            }
        });
        $(function(){
            var element = document.getElementById("pay");
            var a = element.className ;
            if(a==0){
                document.getElementById("pay").innerText = "現金払い";
            }else{
                document.getElementById("pay").innerText = "カード払い";
            }
        });
    </script>
    <style>
        .active{
            display:block;
        }
        .inactive{
            display:none;
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
ul {
        list-style: none;
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
                    <input type="submit" id="sea" value="検索" class="ref-btn">
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
    

        <div class="zuras">
            <h1>ご注文内容の確認</h1>

            <p>名前${sessionScope.p.name}</p>
            <p>電話番号${sessionScope.p.tel}</p>
            <p>メールアドレス${sessionScope.p.mail}</p>
            <p>住所${sessionScope.p.address}</p>
            <div  class="${sessionScope.spuData.store}" id="target"><P>店舗${sessionScope.spuData.st_name}</P></div>
            <p>日付${sessionScope.p.date}</p>
            <p>時間${sessionScope.p.time}</p>
            <div class="${sessionScope.p.type}" id="pay"><p>支払い方法=${sessionScope.p.type}</p></div>
            <p>合計金額${sessionScope.totalPrice + sessionScope.ccb.custom_total_money}</p>
            <a href="CompleteServlet" class="btn-pop">注文を確定する</a>
        </div>
    </body>
</html>