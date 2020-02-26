<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/Browser/js/Menu.js"></script>
        
        <!-- jQuery UI -->
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

        <script src="${pageContext.request.contextPath}/Browser/js/lightbox.js"></script>  

<title>メニュー</title>
<script>
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

//画像挿入
function gazou(){
    var element;
    $(document).on('input',"input[type='text']", function(event){
        console.log("あああああああああああああ");
        console.log($(this).val());
        var value = $(this).val().substr(28);
        if(value.match(/jpg/)){
            var id = "#"+$(this).attr("id");
            var prev = "#"+$(this).prev().attr("id");
            $(prev).after('<input type="{pageContext.request.contextPath}/Browser/img" id="'+($(this).attr("id")+"1")+'" src="'+value+'" value="'+value+'" height=10% width=10% disabled>');     
            // id=id.slice(0,-1);
            $(id+"2").val(value);
            console.log(id);
            console.log(prev);                 
            $(id).remove();

        }
    });
}
 //customの画像削除のjs
 $(function() {
    $("#reset").on({
        'click': function() {
            var list = new Array("syusyoku","syusai","huku1","huku2");
            for(var i=0;i<4;i++){

            
                $('#'+list[i]+'1').get(0).type = 'text';
                
                var syusyoku = $('input[id='+list[i]+'1]');
                syusyoku.removeAttr("src");
                syusyoku.removeAttr("value");
                syusyoku.removeAttr("height");
                syusyoku.removeAttr("width");
                syusyoku.removeAttr("disabled");
                syusyoku.attr('name',list[i]);
                syusyoku.attr('value','');
                syusyoku.attr('onchange','gazou()');
                syusyoku.attr('id',list[i]);
                var a = $("input[type='hidden']");
                a.removeAttr("value");
            }
        
        }
    });


});


//アレルギーの画像切り替え
function myfunc(value) {
    var obj=value;
    console.log(obj);
    var imgId=obj.substr( 7, 1 );
    console.log(imgId);
    var onImg='${pageContext.request.contextPath}/Browser/img/a'+imgId+'on.png';
    console.log(onImg);
    var offImg='${pageContext.request.contextPath}/Browser/img/a'+imgId+'.png';
    console.log(offImg);
    var abc=document.refine.check[imgId-1];
    console.log(abc);
    console.log(abc.checked);
    if(abc.checked){
        $('#a'+imgId).attr('src', onImg);
        console.log('on');
    }else{
        $('#a'+imgId).attr('src', offImg);
        console.log('off');
    }


}

$(function(){
// ダイアログの初期設定
    $("#mydialog2").dialog({
        autoOpen: false,  // 自動的に開かないように設定
        width: 500,       // 横幅のサイズを設定
        modal: true,      // モーダルダイアログにする
        buttons: [        // ボタン名 : 処理 を設定
        {
            text: '閉じる',
            click: function(){
                console.log("jquery");
                $(this).dialog("close");
            }
        }
        ]
    });
});

function test(count){
    $(document).on("click", ".dialog", function(){
        var product = document.getElementById(count).value;
        if(product <= 0){
            // ダイアログの呼び出し処理
            $("#mydialog2").dialog("open");
            //documentからイベントを削除
            $(document).off("click",".dialog");
            //データの送信をリセット
            return false;
        }
    });
    
}
</script>
</head>
<body>
<h1>メニュー</h1>
<a href="start">topページ</a>
<p>商品の検索</p>
    <form action="search" method="post" name="search">
        <input type="text" name="sname" id="s1">
        <input type="submit" id="sea" value="検索" >
    </form>
<p>アレルギーの絞り込み</p>

    <form action="refine" method="post" name="refine">
        
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a1.png" name="are" height="40px" width="40px" id="a1">
            <input type="checkbox" name="check" id="p1" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a1.png')">小麦</label>
            <input type="hidden" name="check1" id="p1" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a2.png" name="are" height="40px" width="40px" id="a2">
            <input type="checkbox" name="check" id="p2" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a2.png')">卵</label>
            <input type="hidden" name="check2" id="p2" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a3.png" name="are" height="40px" width="40px" id="a3">
            <input type="checkbox" name="check" id="p3" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a3.png')">乳</label>
            <input type="hidden" name="check3" id="p3" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a4.png" name="are" height="40px" width="40px" id="a4">
            <input type="checkbox" name="check" id="p4" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a4.png')">落花生</label>
            <input type="hidden" name="check4" id="p4" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a5.png" name="are" height="40px" width="40px" id="a5">
            <input type="checkbox" name="check" id="p5" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a5.png')">そば</label>
            <input type="hidden" name="check5" id="p5" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a6.png" name="are" height="40px" width="40px" id="a6">
            <input type="checkbox" name="check" id="p6" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a6.png')">えび</label>
            <input type="hidden" name="check6" id="p6" value="1">
        <label>
            <img src="${pageContext.request.contextPath}/Browser/img/a7.png" name="are" height="40px" width="40px" id="a7">
            <input type="checkbox" name="check" id="p7" value="0" onchange="myfunc('${pageContext.request.contextPath}/Browser/img/a7.png')">かに</label>
            <input type="hidden" name="check7" id="p7" value="1">
        <input type="submit" id="ref" value="絞り込みページ" onclick="onButtonClick()">
    </form>



<div>
        <form action="cmenu" method="POST" name="custom">
            <div id="">
            <span id="one">主食</span><input type="text" id="syusyoku" name="syusyoku" value="" oninput="gazou()" ><br>
            <input type="hidden" id="syusyoku2" name="syusyoku" >
            <span id="two">主菜</span><input type="text" id="syusai" name="syusai" value="" oninput="gazou()"><br>
            <input type="hidden" id="syusai2" name="syusai" >
            <span id="three">副菜</span><input type="text" id="huku1" name="huku1" value="" oninput="gazou()"><br>
            <input type="hidden" id="huku12" name="huku1" >
            <span id="four">副菜</span><input type="text" id="huku2" name="huku2" oninput="gazou()"><br>
            <input type="hidden" id="huku22" name="huku2" >
            </div>
            <!-- このコードは使わない<input type="button" onclick="check();" value="カート"> -->
             <input type="submit" id="cart" value="カート">
             
        </form>
        <button id="reset" >reset</button>
        <table>
            <tr>
                <c:forEach var="prof" items="${product}">
                    <td>
                        <form method="post" name="${prof.id}1" action="detail">
                            <img src="${prof.image}" name="bento" height="70px" width="70px">
                            <input type="hidden" name="id" value="${prof.id}">
                            <a href="javascript:${prof.id}1.submit()">${prof.name}</a>
                        </form>
                    </td>
                </c:forEach>
            </tr>
        </table>
            
</div> 


<div>
    <table>
        <tr>
            <c:forEach var="prof" items="${product}" varStatus="st">
                <td>
                    <form method="post" name="${prof.id}" action="detail">
                        <img src="${prof.image}" name="bento" height="70px" width="70px">
                        <input type="hidden" name="id" value="${prof.id}">
                        <a href="javascript:${prof.id}1.submit()">${prof.name}</a>
                    </form>
                    <form action="mmenu" method="post" name="frml" >
                        <input type="number" name="${prof.id}" id="${prof.id}" value=0 size=6 MIN="O" MAX="99"><br>
                        <input type="button" value="＋" onClick="javascript:this.form.${prof.id}.value++;"> 
                        <input type="button" value="－" onClick="javascript:this.form.${prof.id}.value--;">
                        <input type="submit" value="カート" id="${st.count}" class="dialog" onclick="test('${prof.id}')">
                    </form>
                </td>
            </c:forEach>
        </tr>
    </table>
</div>
<h1 id="userid">${result}</h1>
<a href="look">カートを見る</a>
<!--<h1>${result}</h1>-->
<a id="login" href="infomation">ログイン</a>
<a id="logout" href="vmenu" style="display:none;">ログアウト</a>
<!--</div>-->

<!--ダイアログの内容-->
<div id="mydialog2" title="個数を入力して下さい">
    最低注文個数に達していません。（最低注文個数：1個）<br />
</div>

</body>
</html>