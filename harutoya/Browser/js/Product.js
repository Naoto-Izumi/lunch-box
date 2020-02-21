window.onload = function(){
    var path = location.pathname;
    console.log(path);
    var patharray = path.split("/");
    console.log(patharray[0]);
    console.log(patharray[1]);
    console.log(patharray[2]);
    var boxes = document.getElementsByName("target");

    if(patharray[2]=="pde"){
        boxes.item(0).checked = true;
        showAdd();
    } 
    if(patharray[2]=="prs"){
        boxes.item(1).checked = true;
        showDelete();
    } 
}

function showAdd(){
    document.getElementById("delete").className="off";
    document.getElementById("add").className="on";
    document.getElementById("stock").className="off";
}
function showDelete(){
    document.getElementById("delete").className="on";
    document.getElementById("add").className="off";
    document.getElementById("stock").className="off";
}
function showStock(){
    document.getElementById("delete").className="off";
    document.getElementById("add").className="off";
    document.getElementById("stock").className="on";
}
function product(){
    
    if(document.form1.pname.value==""){
        alert("商品名を入力してください。"); 
    }
    else if(document.form1.price.value==""){
        alert("金額を入力してください。"); 
    }
    else if(document.form1.cate.value==""){
        alert("商品の種類を入力してください。"); 
    }
    else{   
        alert("商品を登録しました。"); 
        document.form1.submit();
    }   
}