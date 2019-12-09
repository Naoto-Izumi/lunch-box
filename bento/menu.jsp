<%@page pageEncoding="Windows-31J" contentType="text/html; charset=Windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="js/lightbox.js"></script>  

<title>メニュー</title>
<script>
    function check(){
        if(document.custom.syusyoku.value==""){
            alert("");
        }else if(document.custom.syusai.value==""){
            alert("");
        }else if(document.custom.huku1.value==""){
            alert("");
        }else if(document.custom.huku2.value==""){
            alert("");
        }else{
            document.custom.submit();
        }
    }

    function amount(){
        document.frml.count.value++;
    }


    $(function() {
  $("#droparea").on({
    "dragenter dragover":function(e){
      e.preventDefault();
    },
    "drop":function(e){
      var file = e.originalEvent.dataTransfer.files[0];
      var fr1 = new FileReader();
      fr1.onload = function(e) {
        var blob=new Blob([e.target.result],{"type":file.type});
        var fr2 = new FileReader();
        fr2.onload = function(e) {
          var src=e.target.result;
          src=new Uint8Array(src);
          src=String.fromCharCode.apply("",src);
          src=btoa(src);
          src="data:"+file.type+";base64,"+src;
          $("<img>").attr({"src":src,"alt":file.name}).appendTo('#viewarea');
        }
        fr2.readAsArrayBuffer(blob);
      }
      fr1.readAsArrayBuffer(file);
      e.preventDefault();
    },
  });
});

</script>
</head>
<body>
<h1>メニュー</h1>
<div id="droparea">ファイルをドロップしてください。</div>
<div id="viewarea">ここに表示</div>
<div>
    <form action="CustomMenuServlet"" method="post" name="custom">
        主食：<input type="text" name="syusyoku"><br>
        主菜：<input type="text" name="syusai" value=""><br>
        副菜：<input type="text" name="huku1" value=""><br>
        副菜：<input type="text" name="huku2" ><br>
        <input type="button" onclick="check();" value="カート">
    </form>
    <img src="image/bento1.jpg" alt="image/bento1.jpg" height="10%" width="10%">
    <img src="image/bento2.jpg" height="10%" width="10%">
    <img src="image/bento3.jpg" height="10%" width="10%">
    <img src="image/bento4.jpg" height="10%" width="10%">
    <img src="image/bento5.jpg" height="10%" width="10%">
</div>

<div>
    <table>
    <tr>
        <c:forEach var="prof" items="${users}">
            <td>
                <img src="${prof.image}" name="bento alt="" height="10%" width="10%">
                <form action="MenuServlet" method="post" name="frml" >
                    <input type="text" name="${prof.id}" value=0 size=6 MIN="O" MAX="99"><br>
                    <input type="button" value="＋" onClick="javascript:this.form.${prof.id}.value++;"> 
                    <input type="button" value="－" onClick="javascript:this.form.${prof.id}.value--;">
                    <input type="submit" value="カート">
                </form>
            </td>
            </c:forEach>
        </tr>
    </table>
</div>

<!-- <table>
    <tr>
        <td><img src="image/bento1.jpg" name="bento" alt="image/bento1.jpg" height="10%" width="10%"><br>
            <form action="MenuServlet" method="post" name="frml" >
            <input type="text" name="count1" value=0 size=6 MIN="O" MAX="99"><br>
            <input type="button" value="＋" onClick="javascript:this.form.count1.value++;"> 
            <input type="button" value="－" onClick="javascript:this.form.count1.value--;">
            <input type="submit" value="カート">
            </form>
        </td>
        
        
        <td><img src="image/bento2.jpg" name="bento" height="10%" width="10%"><br>
            <form action="MenuServlet" method="post" name="frml" >
            <input type=text name="count2" value=0 size=6 MIN="O" MAX="99"><br>
            <input type=button value="＋" onClick="javascript:this.form.count2.value++;"> 
            <input type=button value="－" onClick="javascript:this.form.count2.value--;">
            <input type="submit"  value="カート">
            </form>        
        </td>
        
        
        <td><img src="image/bento3.jpg" name="bento" height="10%" width="10%"><br>
            <form action="MenuServlet" method="post" name="frml" >
            <input type=text name="count3" value=0 size=6 MIN="O" MAX="99"><br>
            <input type=button value="＋" onClick="javascript:this.form.count3.value++;"> 
            <input type=button value="－" onClick="javascript:this.form.count3.value--;">
            <input type="submit"  value="カート">
            </form>
        </td>
    </tr>
    <tr>
        
        <td><img src="image/bento4.jpg" name="bento" height="10%" width="10%" MIN="O" MAX="99"><br>
            <form action="MenuServlet" method="post" name="frml" >
            <input type=text name="count4" value=0 size=6><br>
            <input type=button value="＋" onClick="javascript:this.form.count4.value++;"> 
            <input type=button value="－" onClick="javascript:this.form.count4.value--;">
            <input type="submit"  value="カート">
            </form>
        </td>
        
        <td><img src="image/bento5.jpg" name="bento" height="10%" width="10%" MIN="O" MAX="99"><br>
            <form action="MenuServlet" method="post" name="frml" >
            <input type=text name="count5" value=0 size=6><br>
            <input type=button value="＋" onClick="javascript:this.form.count5.value++;"> 
            <input type=button value="－" onClick="javascript:this.form.count5.value--;">
            <input type="submit"  value="カート">
            </form>
        </td>
        
        <td><img src="image/bento5.jpg" name="bento" height="10%" width="10%" MIN="O" MAX="99"><br>
            <form action="MenuServlet" method="post" name="frml" >
            <input type=text name="count6" value=0 size=6><br>
            <input type=button value="＋" onClick="javascript:this.form.count6.value++;"> 
            <input type=button value="－" onClick="javascript:this.form.count6.value--;">
            <input type="submit"  value="カート">
            </form>
        </td>
     </tr>
</table> -->
</body>
</html>