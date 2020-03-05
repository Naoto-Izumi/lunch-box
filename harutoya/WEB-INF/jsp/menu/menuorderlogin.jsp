<%@ page pageEncoding="utf-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!-- jQuery UI -->
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/Menu.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/Browser/favicon/favicon.ico">
	<script src="${pageContext.request.contextPath}/Browser/js/login.js"></script>
	<title>ログイン画面</title></head>
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
				<a href="StoreServlet" class="fade_btn">
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
				<a href="TopCusServlet" class="fade_btn">
					<img src="${pageContext.request.contextPath}/Browser/img/3.png" alt="カート" title="">
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
                <div id="newregist">
                <li>
                     <a href="ruser" >新規会員登録</a>
                </li>
                </div>
                <li>
                    <h1 id ="userid">${menutoken}</h1>
                    <a id="login"  href="page" >ログイン</a>
                    <a id="logout" href="vmenu" style="display:none;">ログアウト</a>
                </li>
            </ul>
		</div>
	
	
	 </header>
	 <div class="zuras">
		<div class="login">
			<h1>ログイン</h1>
			<form action="page" method="post">
				氏名   ：<input type="text" name="name"><br>
				パスワード：<input type="password" name="pass"><br><br>
				<input type="submit" value="ログイン">
			</form>
		</div>
	</div>
</body>
</html>