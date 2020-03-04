function check(e){
    console.log(e.value);   
    if(e.value.match(/^(0{1}\d{9,10})$/)==null){
        console.log("error");
    }
}
function showCash(){
    $(".cardinfo").removeAttr('required');
    document.getElementById("card").className = "passive";
}
function showCard(){
    $(".cardinfo").attr('required','');
    document.getElementById("card").className = "active";
    
}

$(function() {
    $.datepicker.setDefaults( $.datepicker.regional[ "ja" ] );
    $( "#datepicker" ).datepicker({ minDate: 0, maxDate: "+1M +10D" });
});

$(document).on("click", "#awawa", function(){
    var a=info.type.value;
    console.log(a);
    if(a==1){
        if (info.cardname.value == ""||info.cardnumber.value == ""||info.carddate.value == ""){
            //条件に一致する場合(メールアドレスが空の場合)
            // ダイアログの呼び出し処理
            $("#mydialog2").dialog("open");
            //documentからイベントを削除
            $(document).off("click",".dialog");
            return false;    //送信ボタン本来の動作をキャンセルします
        }else{
            //条件に一致しない場合(メールアドレスが入力されている場合)
            return true;    //送信ボタン本来の動作を実行します
        }
    }else{
        return true;
    }
});


    
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



$(function() {
// For the gray theme
    var grayThemeCreditly = Creditly.initialize(
        '.creditly-wrapper.gray-theme .expiration-month-and-year',
        '.creditly-wrapper.gray-theme .credit-card-number',
        '.creditly-wrapper.gray-theme .security-code',
        '.creditly-wrapper.gray-theme .card-type');

        $(".creditly-gray-theme-submit").click(function(e) {
        e.preventDefault();
        var output = grayThemeCreditly.validate();
        if (output) {
            // Your validated credit card output
            console.log(output);
        }
    });
});



