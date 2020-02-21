window.onload = function(){
    var path = location.pathname;
    console.log(path);
    var patharray = path.split("/");
    console.log(patharray[0]);
    console.log(patharray[1]);
    console.log(patharray[2]);
    var boxes = document.getElementsByName("target");

    if(patharray[2].substr(0,2)=="us"){
        boxes.item(0).checked = true;
        showSale();
    }
    if(patharray[2].substr(0,2)=="ks"){
        boxes.item(1).checked = true;
        showAdd();
    } 
}

function showSale(){
    document.getElementById("sale").className="on";
    document.getElementById("add").className="off";
}
function showAdd(){
    document.getElementById("sale").className="off";
    document.getElementById("add").className="on";
}

