/*confirmation.jsp*/
//いらないやつ

/*menu.jsp・custom.jsp*/
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