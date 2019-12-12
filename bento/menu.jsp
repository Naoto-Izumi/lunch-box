<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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

    //アレルギー絞り込み
    function onButtonClick() {
        pro1 = document.refine.p1;
        pro2 = document.refine.p2;
        pro3 = document.refine.p3;
        pro4 = document.refine.p4;
        pro5 = document.refine.p5;
        pro6 = document.refine.p6;
        pro7 = document.refine.p7;
        judgment(pro1);
        judgment(pro2);
        judgment(pro3);
        judgment(pro4);
        judgment(pro5);
        judgment(pro6);
        judgment(pro7);
    }
    function judgment(pro){
        var proId=getId(pro);
        if (pro.checked == true) {
            $("#"+proId).val("0");
        } else {
            $("#"+proId).val("1");
        }
    }


    function getId(ele){
        var id_value = ele.id; // eleのプロパティとしてidを取得
        console.log(id_value); //
        return id_value;
    }
 
    






</script>
</head>
<body>
<h1>メニュー</h1>
<a href="top.jsp">topページ</a>

    <form action="RefineServlet" method="post" name="refine">
        
        <label><input type="checkbox" name="check1" id="p1" value="0" >小麦</label>
        <input type="hidden" name="check1" id="p1" value="1">
        <label><input type="checkbox" name="check2" id="p2" value="0" >卵</label>
        <input type="hidden" name="check2" id="p2" value="1">
        <label><input type="checkbox" name="check3" id="p3" value="0" >乳</label>
        <input type="hidden" name="check3" id="p3" value="1">
        <label><input type="checkbox" name="check4" id="p4" value="0" >落花生</label>
        <input type="hidden" name="check4" id="p4" value="1">
        <label><input type="checkbox" name="check5" id="p5" value="0" >そば</label>
        <input type="hidden" name="check5" id="p5" value="1">
        <label><input type="checkbox" name="check6" id="p6" value="0" >えび</label>
        <input type="hidden" name="check6" id="p6" value="1">
        <label><input type="checkbox" name="check7" id="p7" value="0" >かに</label>
        <input type="hidden" name="check7" id="p7" value="1">
        <input type="submit" id="ref" value="絞り込みページ" onclick="onButtonClick();">
    </form>



<div>
    <form action="CustomMenuServlet" method="post" name="custom">
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
        <c:forEach var="prof" items="${product}">
            <td>
                <img src="${prof.image}" name="bento alt="" height="15%" width="40%">
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