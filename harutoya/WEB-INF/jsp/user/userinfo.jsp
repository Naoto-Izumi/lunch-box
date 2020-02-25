<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>ユーザーのやつ</title></head>
<body>
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
<br>	

</body>
</html>