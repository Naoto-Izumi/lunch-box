<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Browser/css/Menu2.css">
</head>
    <body>
        <header class="grovalNavigation">
            <div class="logo" title="春戸弁当">
                <a href="st" class="fade_btn"><img src="${pageContext.request.contextPath}/Browser/img/harutoya.png" title="" height="90px" width="375px"></a>
            </div>
        
            <ul id="navi" class="icon_nav">
                <li>
                    <a href="top" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_01.png" alt="メニュー" title="">
                        <span>メニュー</span>
                    </a>
                </li>
        
                <li>
                    <a href="store" target="_blank" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_02.png" alt="店舗検索" title="">
                        <span>店舗検索</span>
                    </a>
                </li>
        
                <li>
                    <a href="norder" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_03.png" alt="お知らせ" title="">
                        <span>ネット注文</span>
                    </a>
                </li>
                <li>
                    <a href="page" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_05.png" alt="スタッフ募集" title="">
                            <span>マイページ</span>
                    </a>
                </li>
                <li>
                    <a href="custom" class="fade_btn">
                        <img src="${pageContext.request.contextPath}/Browser/img/nav_05.png" alt="カート" title="">
                            <span>カート</span>
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
                        <a href="infomation" >ログイン</a>
                    </li>
                </ul>
            </div>
        
        
         </header>
        <div class="allergy">
            <table>
                
                <form method="POST" action="snext">
                    <c:forEach var="prof" items="${product}">
                        <tr>                        
                            <td>
                                ${prof.st_name}
                            </td>
                            <td>
                                ${prof.st_address}
                            </td>
                            <td>
                                ${prof.st_phone}
                            </td>
                            <td>
                                ${prof.st_hours}
                            </td>
                            <td>
                                <input type="hidden" name="st_name" value="${prof.st_name}">
                                <input type="hidden" name="store" value="${prof.st_id}">
                                <input type="submit" value="次へ">
                            </td>
                        </tr>                                        
                    </c:forEach>
                </form>
            </table>
        </div>
    </body>
</html>