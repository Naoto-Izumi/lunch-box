<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  
    <script>
        function check(e){
            console.log(e.value);   
            if(e.value.match(/^(0{1}\d{9,10})$/)==null){
                console.log("error");
            }
        }
        function showCash(){
            $(".cardinfo").removeAttr('required');
            document.getElementById("card").className = "passive";
        }
        function showCard(){
            $(".cardinfo").attr('required','');
            document.getElementById("card").className = "active";
            
        }

        $(function() {
            $.datepicker.setDefaults( $.datepicker.regional[ "ja" ] );
            $( "#datepicker" ).datepicker({ minDate: 0, maxDate: "+1M +10D" });
        });

        $(document).on("click", "#awawa", function(){
            var a=info.type.value;
            console.log(a);
            if(a==1){
                if (info.cardname.value == ""||info.cardnumber.value == ""||info.carddate.value == ""){
                    //条件に一致する場合(メールアドレスが空の場合)
                    // ダイアログの呼び出し処理
                    $("#mydialog2").dialog("open");
                    //documentからイベントを削除
                    $(document).off("click",".dialog");
                    return false;    //送信ボタン本来の動作をキャンセルします
                }else{
                    //条件に一致しない場合(メールアドレスが入力されている場合)
                    return true;    //送信ボタン本来の動作を実行します
                }
            }else{
                return true;
            }
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



    $(function() {
      // For the gray theme
      var grayThemeCreditly = Creditly.initialize(
          '.creditly-wrapper.gray-theme .expiration-month-and-year',
          '.creditly-wrapper.gray-theme .credit-card-number',
          '.creditly-wrapper.gray-theme .security-code',
          '.creditly-wrapper.gray-theme .card-type');

      $(".creditly-gray-theme-submit").click(function(e) {
        e.preventDefault();
        var output = grayThemeCreditly.validate();
        if (output) {
          // Your validated credit card output
          console.log(output);
        }
      });
    });



        
    </script>
    <style>
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




<div class="zuras">
    <h1>ご注文内容の指定</h1>
    <form method="POST" action="UserInformationServlet" name="info">
            名前<input type="text" name="name" required><br>
            電話<input type="tel" name="tel" oninput="check(this)"  required><br>
            メール<input type="email" name="mail" required><br>
            住所<input type="text" name="address" required><br>
            日付<input type="text" name="date" id="datepicker" required><br>
            時間<input type="time" name="time"  required><br>
            支払い方法
            <input type="radio" name="type" value="0" onchange="showCash();" checked>現金
            <input type="radio" name="type" value="1" onchange="showCard();" >カード<br>

            <ul id="card" class="passive">
                <li>カード名義人(半角ローマ字)<input type="text" name="cardname" class="cardinfo"　maxlength="50" pattern="/d*"></li>
                <li>カード番号<input type="password" name="cardnumber" class="cardinfo" pattern="/d*"></li>
                <li>有効期限<input type="password" name="carddate" class="cardinfo" pattern="/d*"></li>
            </ul>
            <input type="submit" value="確認" id="awawa" >
        </form>

        <!--ダイアログの内容-->
        <div id="mydialog2" title="入力欄が空白です">
            カード情報を入力してください<br />
        </div>
    </div>

    </body>
</html>