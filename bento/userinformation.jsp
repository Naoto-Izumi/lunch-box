<%@page pageEncoding="Windows-31J" contentType="text/html; charset=Windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script>
        function check(e){
            if(e.value.match(/^([0-9]{10,11})$/)==null){
                console.log("error");
            }
        }
        function showCash(){
            document.getElementById("card").className = "passive";
        }
        function showCard(){
            document.getElementById("card").className = "active";
        }

        
    </script>
    
</head>
<body>
    <form method="POST" action="UserInformationServlet">
            名前<input type="text" name="name"><br>
            電話<input type="tel" name="tel" onblur="check(this)"><br>
            メール<input type="email" name="mail" ><br>
            住所<input type="text" name="address"><br>
            時間<input type="time" name="time"><br>
            支払い方法
            <input type="radio" name="type" value="0" onchange="showCash();" checked>現金
            <input type="radio" name="type" value="1" onchange="showCard();">カード<br>

            <ul id="card" class="passive">
                <li>カード名義人(半角ローマ字)<input type="text" name="cardname"></li>
                <li>カード番号<input type="text" name="cardnumber"></li>
                <li>有効期限<input type="text" name="carddate"></li>
            </ul>
            <input type="submit" value="確認">
        </form>
    </body>
</html>