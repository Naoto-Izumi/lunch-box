$(document).ready(function(){
    //alert(document.getElementById("userid").innerText);
    //Console.log(document.getElementById("userid"));
    if(document.getElementById("userid").innerText!=""){
        document.getElementById("userid").style.display='none';
        document.getElementById("newregist").style.display='none';
        document.getElementById("login").style.display='none';
        document.getElementById("logout").style.display='block';
        //Console.log("friuhavkh");
    }
});