<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <!-- jQuery UI -->
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">

        <script src="js/lightbox.js"></script>  

<title>メニュー</title>
<script>
    // function check(){
    //     if(document.custom.syusyoku.value==""){
    //         alert("");
    //     }else if(document.custom.syusai.value==""){
    //         alert("");
    //     }else if(document.custom.huku1.value==""){
    //         alert("");
    //     }else if(document.custom.huku2.value==""){
    //         alert("");
    //     }else{
    //         document.custom.submit();
    //     }
    // }
    
    //個数増減
    function amount(){
        document.frml.count.value++;
    }

    //アレルギー絞り込み
    // function onButtonClick() {
    //     pro1 = document.refine.p1;
    //     pro2 = document.refine.p2;
    //     pro3 = document.refine.p3;
    //     pro4 = document.refine.p4;
    //     pro5 = document.refine.p5;
    //     pro6 = document.refine.p6;
    //     pro7 = document.refine.p7;
    //     judgment(pro1);
    //     judgment(pro2);
    //     judgment(pro3);
    //     judgment(pro4);
    //     judgment(pro5);
    //     judgment(pro6);
    //     judgment(pro7);
    // }
    // function judgment(pro){
    //     var proId=getId(pro);
    //     if (pro.checked == true) {
    //         $("#"+proId).val("0");
    //     } else {
    //         $("#"+proId).val("1");
    //     }
    // }
    // function getId(ele){
    //     var id_value = ele.id; // eleのプロパティとしてidを取得
    //     console.log(id_value); //
    //     return id_value;
    // }

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
                $(prev).after('<input type="image" id="'+($(this).attr("id")+"1")+'" src="'+value+'" value="'+value+'" height=10% width=10% disabled>');     
                // id=id.slice(0,-1);
                $(id+"2").val(value);
                console.log(id);
                console.log(prev);                 
                $(id).remove();

            }
        });
    }





    


    //アレルギーの画像切り替え
    function myfunc(value) {
        var obj=value;
        console.log(obj);
        var imgId=obj.substr( 7, 1 );
        console.log(imgId);
        var onImg='image/a'+imgId+'on.png';
        console.log(onImg);
        var offImg='image/a'+imgId+'.png';
        console.log(offImg);
        var abc=document.refine.check[imgId-1];
        console.log(abc);
        // var def='document.getElementById("p'+imgId+'")';
        // console.log(def);
        console.log(abc.checked);
        if(abc.checked){
            $('#a'+imgId).attr('src', onImg);
            $('#p'+imgId).val("0");
            console.log($('#p'+imgId).val());
            console.log('on');
        }else{
            $('#a'+imgId).attr('src', offImg);
            $('#p'+imgId).val("1");
            console.log($('#p'+imgId).val());
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
            console.log(count);
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
<style>
    /*タブ切り替え全体のスタイル*/
.tabs {
  margin-top: 50px;
  padding-bottom: 40px;
  background-color: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  width: 80%;
  margin: 0 auto;}

/*タブのスタイル*/
.tab_item {
  width: calc(100%/3);
  height: 50px;
  border-bottom: 3px solid #e49e61;
  background-color: #d9d9d9;
  line-height: 50px;
  font-size: 16px;
  text-align: center;
  color: #565656;
  display: block;
  float: left;
  text-align: center;
  font-weight: bold;
  transition: all 0.2s ease;
}
.tab_item:hover {
  opacity: 0.75;
}

/*ラジオボタンを全て消す*/
input[name="tab_item"] {
  display: none;
}

/*タブ切り替えの中身のスタイル*/
.tab_content {
  display: none;
  padding: 40px 40px 0;
  clear: both;
  overflow: hidden;
}


/*選択されているタブのコンテンツのみを表示*/
#all:checked ~ #all_content,
#programming:checked ~ #programming_content,
#design:checked ~ #design_content {
  display: block;
}

/*選択されているタブのスタイルを変える*/
.tabs input:checked + .tab_item {
  background-color: #e49e61;
  color: #fff;
}

.customtext1{
    background-color:#f0f8ff;
    font-size:50px;
    border-color:#6495ed;
    border-width:5px;
    position: relative;
    height: 300px;
    width: 400px;
}
.customtext2{
    background-color:#f0f8ff;
    font-size:50px;
    border-color:#6495ed;
    border-width:5px;
    position: relative;
    height: 150px;
    width: 400px;
    top:75px;
    right:7px;

}
.customtext3{
    background-color:#f0f8ff;
    font-size:50px;
    border-color:#6495ed;
    border-width:5px;
    position: relative;
    height: 150px;
    width: 200px;
    right:412px;
    bottom: 75px;
}
.customtext4{
    background-color:#f0f8ff;
    font-size:50px;
    border-color:#6495ed;
    border-width:5px;
    position: relative;
    height: 150px;
    width: 200px;
    right:418px;
    bottom: 75px;

}

body{
    margin:0;
    padding:0;
}


.grovalNavigation{
    z-index: 9999;
    width: 100%;
    height: 100px;
    text-align: center;
    background-color:#ffffff;
    color: #000000;
    position: fixed;
}
#navi {
  list-style: none;
  overflow: hidden;
}
 
#navi li {
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
  color: rgb(174, 211, 180);
  font-weight: bold;
  padding: 20px;
}
#navi li img{
    width: 80px;
    height:80px;
}
#navi li span{
    /* position: absolute;
    right: 60px;
    top: 20px;
    font-size: 13px;
    text-align: center; */
    position: absolute;
    bottom: 0;
    top: 50%;
    margin-top: -0.5em;
    
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

.allergy{
    padding:100px 0 0 0;
}
.menuset{
    display: inline-block;      /* インラインブロック要素にする */
    background-color:  #fff;    /* 背景色指定 */
    padding:  29px;             /* 余白指定 */
    height: 370px;              /* 高さ指定 */
}

/* .are_btn{
    position:absolute;
    margin-left: 710px;
    top: 230px;
} */
.ref-btn {
  display       : inline-block;
  border-radius : 5%;          /* 角丸       */
  font-size     : 10pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 6px 6px;   /* 余白       */
  background    : #e8ecef;     /* 背景色     */
  color         : #09186e;     /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  transition    : .3s;         /* なめらか変化 */
  box-shadow    : 1px 1px 1px #666666;  /* 影の設定 */
  border        : 2px solid #e8ecef;    /* 枠の指定 */
}
.ref-btn:hover {
  box-shadow    : none;        /* カーソル時の影消去 */
  color         : #3d4da7;     /* 背景色     */
  background    : #ffffff;     /* 文字色     */
}
a {
text-decoration: none;
}
.btn-pop {
  position: relative;
  display: inline-block;
  padding: 0.25em 0.5em;
  text-decoration: none;
  color: #FFF;
  background: #fd9535;/*背景色*/
  border-bottom: solid 2px #d27d00;/*少し濃い目の色に*/
  border-radius: 4px;/*角の丸み*/
  box-shadow: inset 0 2px 0 rgba(255,255,255,0.2), 0 2px 2px rgba(0, 0, 0, 0.19);
  font-weight: bold;
}

.btn-pop:active {
  border-bottom: solid 2px #fd9535;
  box-shadow: 0 0 2px rgba(0, 0, 0, 0.30);
}
.btn-square-pop {
  position: relative;
  display: inline-block;
  padding: 0.25em 0.5em;
  text-decoration: none;
  color: #FFF;
  background: #fd9535;/*背景色*/
  border-bottom: solid 2px #d27d00;/*少し濃い目の色に*/
  border-radius: 4px;/*角の丸み*/
  box-shadow: inset 0 2px 0 rgba(255,255,255,0.2), 0 2px 2px rgba(0, 0, 0, 0.19);
  font-weight: bold;
}

.btn-square-pop:active {
  border-bottom: solid 2px #fd9535;
  box-shadow: 0 0 2px rgba(0, 0, 0, 0.30);
}
ul {
  list-style: none;
}
.plmi{
    border-color: #887f7a;
  border-style: solid;
  background-color:#eaf4fc;
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

<a href="top.jsp" class="btn-pop">topページ</a>
<!-- <p>商品の検索</p>
    <form action="SearchServlet" method="post" name="search">
        <input type="text" name="sname" id="s1">
        <input type="submit" id="sea" value="検索" >
    </form> -->
    <div class="allergy">
        <p>アレルギーの絞り込み</p>
    </div>
    <div class="refbar">
        <form action="RefineServlet" method="post" name="refine">
            
            <label>
                <img src="image/a1.png" name="are" height="40px" width="40px" id="a1">
                <input type="checkbox" name="check"  onchange="myfunc('image/a1.png')">小麦</label>
                <input type="hidden" name="check1" id="p1" value="1">
            <label>
                <img src="image/a2.png" name="are" height="40px" width="40px" id="a2">
                <input type="checkbox" name="check"  onchange="myfunc('image/a2.png')">卵</label>
                <input type="hidden" name="check2" id="p2" value="1">
            <label>
                <img src="image/a3.png" name="are" height="40px" width="40px" id="a3">
                <input type="checkbox" name="check"  onchange="myfunc('image/a3.png')">乳</label>
                <input type="hidden" name="check3" id="p3" value="1">
            <label>
                <img src="image/a4.png" name="are" height="40px" width="40px" id="a4">
                <input type="checkbox" name="check"  onchange="myfunc('image/a4.png')">落花生</label>
                <input type="hidden" name="check4" id="p4" value="1">
            <label>
                <img src="image/a5.png" name="are" height="40px" width="40px" id="a5">
                <input type="checkbox" name="check"  onchange="myfunc('image/a5.png')">そば</label>
                <input type="hidden" name="check5" id="p5" value="1">
            <label>
                <img src="image/a6.png" name="are" height="40px" width="40px" id="a6">
                <input type="checkbox" name="check"  onchange="myfunc('image/a6.png')">えび</label>
                <input type="hidden" name="check6" id="p6" value="1">
            <label>
                <img src="image/a7.png" name="are" height="40px" width="40px" id="a7">
                <input type="checkbox" name="check"  onchange="myfunc('image/a7.png')">かに</label>
                <input type="hidden" name="check7" id="p7" value="1">
                    <input type="submit" id="ref" value="を表示しない" class="ref-btn">
        </form>
    </div>


    <form action="SortServlet" method="post">
        <p>並び替え<br>
            <select size="1" name="sort">
                <option value="prHigh">値段高い</option>
                <option value="prLow">値段低い</option>
                <option value="caHigh">カロリー高い</option>
                <option value="caLow">カロリー低い</option>
            </select>
            <input type="submit" value="並び替え" class="ref-btn">
        </p>
    </form>
        

    <div class="tabs">
        <input id="all" type="radio" name="tab_item" checked>
        <label class="tab_item" for="all">弁当</label>
        <!-- <input id="programming" type="radio" name="tab_item">
        <label class="tab_item" for="programming">単品</label>
        <input id="design" type="radio" name="tab_item">
        <label class="tab_item" for="design">飲み物</label> -->
        <div class="tab_content" id="all_content">
            



            <div>
                        <c:forEach var="prof" items="${product}" varStatus="st">
                            <diV class="menuset">
                                <form method="post" name="${prof.id}" action="DetailServlet">
                                    <a href="javascript:document.forms.${prof.id}.submit()">
                                        <img src="${prof.image}" name="bento" height="170px" width="170px">
                                        <input type="hidden" name="id" value="${prof.id}"><br>
                                        <p>${prof.name}</p>
                                    </a>
                                    <p>${prof.pro_price}円</p>
                                    <p>${prof.pro_calorie}㎉</p>
                                </form>
                                <form action="MenuServlet" method="post" name="frml" >
                                    <input type="number" name="${prof.id}" id="${prof.id}" value=0 size=6 MIN="O" MAX="99"><br>
                                    <input type="button" value="＋" onClick="javascript:this.form.${prof.id}.value++;" class="plmi"> 
                                    <input type="button" value="－" onClick="javascript:this.form.${prof.id}.value--;" class="plmi">
                                    <input type="submit" value="カート" id="${st.count}" class="dialog ref-btn" onclick="test('${prof.id}')">
                                
                                </form>
                            </diV>
                        </c:forEach>

            </div>
            


        </div>
        <!-- <div class="tab_content" id="programming_content">
            単品メニュー
    </div>
        <div class="tab_content" id="design_content">
            飲み物メニュー  
    </div> -->
    </div>


<!--ダイアログの内容-->
<div id="mydialog2" title="個数を入力して下さい">
    最低注文個数に達していません。（最低注文個数：1個）<br />
</div>



</body>
</html>