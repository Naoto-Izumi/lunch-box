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
            <p>名前${sessionScope.p.name}</p>
            <p>電話番号${sessionScope.p.tel}</p>
            <p>メールアドレス${sessionScope.p.mail}</p>
            <p>住所${sessionScope.p.address}</p>
            <div  class="${sessionScope.spuData.store}" id="target"><P>店舗${sessionScope.spuData.st_name}</P></div>
            <p>日付${sessionScope.p.date}</p>
            <p>時間${sessionScope.p.time}</p>
            <p>支払い方法=${sessionScope.p.type}</p>
            <p>合計金額${sessionScope.totalPrice}</p>
            <a href="CompleteServlet">完了ページ</a>
    </body>
</html>