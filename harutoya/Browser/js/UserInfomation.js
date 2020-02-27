function check(e){
    console.log(e.value);   
    if(e.value.match(/^(0{1}\d{9,10})$/)==null){
        console.log("error");
    }
}
function showCash(){
    document.getElementById("card").className = "passive";
}
function showCard(){
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
            alert("カード情報を入力してください");    //エラーメッセージを出力
            return false;    //送信ボタン本来の動作をキャンセルします
        }else{
            //条件に一致しない場合(メールアドレスが入力されている場合)
            return true;    //送信ボタン本来の動作を実行します
        }
    }else{
        return true;
    }
});

$(document).ready(function(){
    // alert(document.getElementById("userid").innerText);
    //Console.log(document.getElementById("userid"));
    if(document.getElementById("userid").innerText!=""){
        document.getElementById("login").style.display='none';
        document.getElementById("logout").style.display='block';
        //Console.log("friuhavkh");
    }
});


