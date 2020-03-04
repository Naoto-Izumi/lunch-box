$(function(){
    $("li[name='0']").attr('class', 'inactive');
});

function amount(){
    document.frml.count.value++;
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

function test(id, count){
    $(document).on("click", ".dialog", function(){
        //countが今カートに入ってる個数 2　productが上書きしたい個数 18
        var product = document.getElementById(id).value;
        console.log("product:"+product+" id:"+id);
        if(product <= 0){
            // ダイアログの呼び出し処理
            $("#mydialog2").dialog("open");
            //documentからイベントを削除
            $(document).off("click",".dialog");
            //データの送信をリセット
            return false;
        }else{
            var i = product - count;
            console.log("product- count"+i);
            $('#'+id).attr('value', i);
            //documentからイベントを削除
            $(document).off("click",".dialog");
        }
        
    });
}