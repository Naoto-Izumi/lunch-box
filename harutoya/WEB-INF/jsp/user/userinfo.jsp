<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>ユーザーのやつ</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/User.css">
	<script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>
	<style>
		.active{
            display: inline;
        }
        .passive{
            display: none;
        }
	</style>

</head>
<body>
	<header class="grovalNavigation">
		<div class="logo" title="春戸弁当">
			<a href="start" class="fade_btn"><img src="${pageContext.request.contextPath}/Browser/img/harutoya.png" title="" height="90px" width="375px"></a>
		</div>
	
		<ul id="navi" class="icon_nav">
			<li>
				<a href="TopServlet" class="fade_btn">
					<img src="${pageContext.request.contextPath}/Browser/img/5.png" alt="メニュー" title="">
					<span>メニュー</span>
				</a>
			</li>
			<li>
				<a href="TopCusServlet" class="fade_btn">
					<img src="${pageContext.request.contextPath}/Browser/img/4.png" alt="カスタムメニュー" title="">
						<span>カスタムメニュー</span>
				</a>
			</li>
	
			<li>
				<a href="StoreServlet"  class="fade_btn">
					<img src="${pageContext.request.contextPath}/Browser/img/1.png" alt="店舗検索" title="">
					<span>店舗検索</span>
				</a>
			</li>
	
			<li>
				<a href="norder" class="fade_btn">
					<img src="${pageContext.request.contextPath}/Browser/img/2.png" alt="お知らせ" title="">
					<span>ネット注文</span>
				</a>
			</li>
			
			<li>
				<a href="look" class="fade_btn">
					<img src="${pageContext.request.contextPath}/Browser/img/3.png" alt="カート" title="">
						<span>カート</span>
				</a>
			</li>
			<li>
				<a href="page" class="fade_btn">
					<img src="${pageContext.request.contextPath}/Browser/img/6.png" alt="カート" title="">
						<span>マイページ</span>
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
                <div id="newregist">
                <li>
                     <a href="ruser" >新規会員登録</a>
                </li>
                </div>
                <li>
                    <h1 id ="userid" style="display:none;">${menutoken}</h1>
                    <a id="login"  href="page" >ログイン</a>
                    <a id="logout" href="vmenu" style="display:none;">ログアウト</a>
                </li>
            </ul>
		</div>
	</header>
	<div class="mypage">

	<h1>個人情報の変更</h1>
	
		<c:forEach var="u" items="${result}">
			<form method='post' action='uuc'>
			<p>現在の姓 ${u.seik}<input type="hidden" name="seik" value="${u.seik}"></p>
			変更しない<input type='radio' name='radioseik' value='0' checked="checked" ><br>
			変更する<input type='radio' name='radioseik' value='1'>
			<input type="text" name="newseik"><br>

			<p>現在の名 ${u.meik}<input type="hidden" name="meik" value="${u.meik}"></p>
			変更しない<input type='radio' name='radiomeik' value='0' checked="checked" ><br>
			変更する<input type='radio' name='radiomeik' value='1'>
			<input type="text" name="newmeik"><br>

			<p>現在のせい ${u.seih}<input type="hidden" name="seih" value="${u.seih}"></p>
			変更しない<input type='radio' name='radioseih' value='0' checked="checked" ><br>
			変更する<input type='radio' name='radioseih' value='1'>
			<input type="text" name="newseih"><br>

			<p>現在のめい ${u.meih}<input type="hidden" name="meih" value="${u.meih}"></p>
			変更しない<input type='radio' name='radiomeih' value='0' checked="checked" ><br>
			変更する<input type='radio' name='radiomeih' value='1'>
			<input type="text" name="newmeih"><br>

			<p>現在の性別 ${u.sex}<input type="hidden" name="sex" value="${u.sex}"></p>
			変更しない<input type='radio' name='radiosex' value='0' checked="checked" ><br>
			変更する<input type='radio' name='radiosex' value='1'>
			<input type="text" name="newsex"><br>
			
			<p>現在のメールアドレス ${u.mail}<input type="hidden" name="mail" value="${u.mail}"></p>
			変更しない<input type='radio' name='radiomail' value='0' checked="checked" ><br>
			変更する<input type='radio' name='radiomail' value='1'>
			<input type="text" name="newmail"><br>
			
			<p>現在のパスワード ${u.pass}<br><input type="password" name="pass" value="${u.pass}"></p>
			変更しない<input type='radio' name='radiopass' value='0' checked="checked" ><br>
			変更する<input type='radio' name='radiopass' value='1'>
			<input type="text" name="newpass"><br>

			<p>現在の携帯番号 ${u.phone}<input type="hidden" name="phone" value="${u.phone}"></p>
			変更しない<input type='radio' name='radiophone' value='0' checked="checked" ><br>
			変更する<input type='radio' name='radiophone' value='1'>
			<input type="text" name="newphone"><br>
			<input type="submit" value="変更">
			</form>
		</c:forEach>
	</table>
</div>
<br>	

</body>
</html>