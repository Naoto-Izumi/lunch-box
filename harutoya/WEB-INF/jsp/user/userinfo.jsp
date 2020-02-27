<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>ユーザーのやつ</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Browser/css/User.css">
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