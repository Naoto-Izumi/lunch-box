<%@page pageEncoding="Windows-31J" contentType="text/html; charset=Windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>���j���[</title>
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
            ���O<input type="text" name="name"><br>
            �d�b<input type="tel" name="tel" onblur="check(this)"><br>
            ���[��<input type="email" name="mail" ><br>
            �Z��<input type="text" name="address"><br>
            ����<input type="time" name="time"><br>
            �x�������@
            <input type="radio" name="type" value="0" onchange="showCash();" checked>����
            <input type="radio" name="type" value="1" onchange="showCard();">�J�[�h<br>

            <ul id="card" class="passive">
                <li>�J�[�h���`�l(���p���[�}��)<input type="text" name="cardname"></li>
                <li>�J�[�h�ԍ�<input type="text" name="cardnumber"></li>
                <li>�L������<input type="text" name="carddate"></li>
            </ul>
            <input type="submit" value="�m�F">
        </form>
    </body>
</html>