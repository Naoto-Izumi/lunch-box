package Bean;

import java.io.Serializable;

public class Product implements Serializable{
    //Userの注文情報
    private String name = null;
    private String tel = null;
    private String mail = null;
    private String address = null;
    private String time = null;
    private String type = null;
    private String cardname = null;
    private String cardnumber = null;
    private String carddate = null;
    //商品Id,商品画像 
    private String id = null;
    private String image = null; 

    //商品idと個数
    private String stock = null;
    private String num = null; 

    //店舗情報
    private String  st_id = null;
    private String  st_name = null;
    private String  st_address = null;
    private String  st_phone = null;
    private String  st_hours = null;

    //アレルギー絞り込み用  
    private String  pro_wheat = null;
    private String  pro_egg = null;
    private String  pro_milk = null;
    private String  pro_peanuts = null;
    private String  pro_buckwheat = null;
    private String  pro_shrimp = null;
    private String  pro_club = null;


    



    //元UserBean 
    public void setName(String name){
        this.name = name;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setCardname(String cardname){
        this.cardname = cardname;
    }
    public void setCardnumber(String cardnumber){
        this.cardnumber = cardnumber;
    }
    public void setCarddate(String carddate){
        this.carddate = carddate;
    }
    public String getName(){
        return name;
    }
    public String getTel(){
        return tel;
    }
    public String getMail(){
        return mail;
    }
    public String getAddress(){
        return address;
    }
    public String getTime(){
        return time;
    }
    public String getType(){
        return type;
    }
    public String getCardname(){
        return cardname;
    }
    public String getCardnumber(){
        return cardnumber;
    }
    public String getCarddate(){
        return carddate;
    }

    //元menubean　menuDao,topservlet
   
    public void setId(String id){
        this.id = id;
    }
    public void setImage(String image){
        this.image = image;
    }

    public String getId(){
        return id;
    }
    public String getImage(){
        return image;
    }

    //商品idと個数　productUpDao,Complete

    public void setStock(String stock){
        this.stock = stock;
    }
    public void setNum(String num){
        this.num = num;
    }
    public String getStock(){
        return stock;
    }
    public String getNum(){
        return num;
    }

    //店舗情報 StoreServlet
    public void setSt_id(String st_id){
        this.st_id = st_id;
    }
    public void setSt_name(String st_name){
        this.st_name = st_name;
    }
    public void setSt_address(String st_address){
        this.st_address = st_address;
    }
    public void setSt_phone(String st_phone){
        this.st_phone = st_phone;
    }
    public void setSt_hours(String st_hours){
        this.st_hours = st_hours;
    }

    public String getSt_id(){
        return st_id;
    }
    public String getSt_name(){
        return st_name;
    }
    public String getSt_address(){
        return st_address;
    }
    public String getSt_phone(){
        return st_phone;
    }
    public String getSt_hours(){
        return st_hours;
    }

    //アレルギー絞り込み用　RefineDao,RefineServlet
    public void setPro_wheat(String pro_wheat){
        this.pro_wheat = pro_wheat;
    }
    public void setPro_egg(String pro_egg){
        this.pro_egg = pro_egg;
    }
    public void setPro_milk(String pro_milk){
        this.pro_milk = pro_milk;
    }
    public void setPro_peanuts(String pro_peanuts){
        this.pro_peanuts = pro_peanuts;
    }
    public void setPro_buckwheat(String pro_buckwheat){
        this.pro_buckwheat = pro_buckwheat;
    }
    public void setPro_shrimp(String pro_shrimp){
        this.pro_shrimp = pro_shrimp;
    }
    public void setPro_club(String pro_club){
        this.pro_club = pro_club;
    }
    public String getPro_wheat(){
        return pro_wheat;
    }
    public String getPro_egg(){
        return pro_egg;
    }
    public String getPro_milk(){
        return pro_milk;
    }
    public String getPro_peanuts(){
        return pro_peanuts;
    }
    public String getPro_buckwheat(){
        return pro_buckwheat;
    }
    public String getPro_shrimp(){
        return pro_shrimp;
    }
    public String getPro_club(){
        return pro_club;
    }
    
}