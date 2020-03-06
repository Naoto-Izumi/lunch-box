<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
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
        <h1>店舗詳細</h1>
        <div>
            
                
                    <c:forEach var="prof" items="${product}">
                        <h2>${prof.st_name}</h2>
                        <dl>
                            <dt>営業時間</dt><dd>${prof.st_hours}</dd>
                        </dl>
                        <dl>
                            <dt>住所</dt><dd>${prof.st_address}</dd>
                        </dl>
                        <dl>
                            <dt>TEL</dt><dd>${prof.st_phone}</dd>
                        </dl>                                
                    </c:forEach>
            
            
        </div>
        </div>  
    </body>
</html>