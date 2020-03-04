//いらないやつ
$(function(){
    $("li[class='']").attr('class', 'inactive');
})
$(function(){
    var element = document.getElementById("target");
    var a = element.className ;
    if(a==null){
        // element.className = "inactive"
        $("div[id='target']").attr('class', 'inactive');
    }
});
$(function(){
    var element = document.getElementById("pay");
    var a = element.className ;
    if(a==0){
        document.getElementById("pay").innerText = "現金払い";
    }else{
        document.getElementById("pay").innerText = "カード払い";
    }
});