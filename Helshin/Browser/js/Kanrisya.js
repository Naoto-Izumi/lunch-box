window.onload = function(){
    var path = location.pathname;
    console.log(path);
    var patharray = path.split("/");
    console.log(patharray[0]);
    console.log(patharray[1]);
    console.log(patharray[2]);
    var boxes = document.getElementsByName("target");

    if(patharray[2]=="uriage"){
        boxes.item(0).checked = true;
        showSale()
    }
    if(patharray[2]=="view"){
        boxes.item(1).checked = true;
        showAdd()
    } 
}

function showSale(){
    document.getElementById("sale").className="on";
    document.getElementById("add").className="off";
    document.getElementById("stock").className="off";
}
function showAdd(){
    document.getElementById("sale").className="off";
    document.getElementById("add").className="on";
    document.getElementById("stock").className="off";
}
function showStock(){
    document.getElementById("sale").className="off";
    document.getElementById("add").className="off";
    document.getElementById("stock").className="on";
}
