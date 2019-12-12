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
    document.getElementById("stock").className="st";
}
