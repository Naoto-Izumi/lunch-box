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
            document.getElementById("card").className = "passive";
        }
        function showCard(){
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
                    alert("カード情報を入力してください");    //エラーメッセージを出力
                    return false;    //送信ボタン本来の動作をキャンセルします
                }else{
                    //条件に一致しない場合(メールアドレスが入力されている場合)
                    return true;    //送信ボタン本来の動作を実行します
                }
            }else{
                return true;
            }
        });



        
    </script>
    
</head>
<body>
    <form method="POST" action="uinfo" name="info">
            名前<input type="text" name="name" required><br>
            電話<input type="tel" name="tel" oninput="check(this)" required><br>
            メール<input type="email" name="mail" required><br>
            住所<input type="text" name="address" required><br>
            日付<input type="text" name="date" id="datepicker" required><br>
            時間<input type="time" name="time"  required><br>
            支払い方法
            <input type="radio" name="type" value="0" onchange="showCash();" checked>現金
            <input type="radio" name="type" value="1" onchange="showCard();" >カード<br>

            <ul id="card" class="passive">
                <li>カード名義人(半角ローマ字)<input type="text" name="cardname" ></li>
                <li>カード番号<input type="password" name="cardnumber" ></li>
                <li>有効期限<input type="password" name="carddate" ></li>
            </ul>
            <input type="submit" value="確認" id="awawa" >
        </form>
    </body>
</html>