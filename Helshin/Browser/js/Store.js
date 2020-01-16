window.onload = function(){
    var path = location.pathname;
    console.log(path);
    var patharray = path.split("/");
    console.log(patharray[0]);
    console.log(patharray[1]);
    console.log(patharray[2]);
    var boxes = document.getElementsByName("target");

    if(patharray[2]=="sde"){
        boxes.item(0).checked = true;
        showDelete();
    } 
}
function showDelete(){
    document.getElementById("delete").className="on";
    document.getElementById("add").className="off";
}
function showAdd(){
    document.getElementById("delete").className="off";
    document.getElementById("add").className="on";
}
function store(){
    
    if(document.form1.sname.value==""){
        alert("店舗名を入力してください。"); 
    }
    else{   
        alert("店舗を登録しました。"); 
        document.form1.submit();
    }   
}
