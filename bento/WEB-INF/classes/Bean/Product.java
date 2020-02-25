package Bean;

import java.io.Serializable;

public class Product implements Serializable{
    //Userの注文情報
    private String name = null;
    private String tel = null;
    private String mail = null;
    private String address = null;
    private String time = null; //店舗受け取りでも活用
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

    //アレルギー絞り込み用とmenu検索
    private String pro_name = null; 
    private String pro_id = null; 
    private String pro_stock = null; 
    private String pro_date = null; 
    private String pro_type = null; 
    private String pro_description = null; 
    private String pro_protein = null; 
    private String pro_image = null; 
    private String pro_lipid = null; 
    private String pro_inorganic = null; 
    private String pro_vitamin = null; 
    private String pro_carbohydrate = null; 
    private String  pro_wheat = null;
    private String  pro_egg = null;
    private String  pro_milk = null;
    private String  pro_peanuts = null;
    private String  pro_buckwheat = null;
    private String  pro_shrimp = null;
    private String  pro_crab = null;

    //カロリーと値段を確認画面でつかう
    private String pro_price = null;
    private String pro_calorie = null;

    //custommenuのId
    private String syusyokuId = null;
    private String syusaiId = null;
    private String huku1Id = null;
    private String huku2Id = null;

    //合計金額と注文個数 custommenuservet pricedao
    private String total = null;
    private String count = null;

    //店舗受け取り用＋time
    private String store = null;
    private String date = null;

    //並び替え用　sort
    private String sortVal = null;
    private String sortKind = null;


    



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
    public void setPro_name(String pro_name){
        this.pro_name = pro_name;
    }
    public void setPro_id(String pro_id){
        this.pro_id = pro_id;
    }
    public void setPro_stock(String pro_stock){
        this.pro_stock = pro_stock;
    }
    public void setPro_date(String pro_date){
        this.pro_date = pro_date;
    }
    public void setPro_type(String pro_type){
        this.pro_type = pro_type;
    }
    public void setPro_image(String pro_image){
        this.pro_image = pro_image;
    }
    public void setPro_description(String pro_description){
        this.pro_description = pro_description;
    }
    public void setPro_protein(String pro_protein){
        this.pro_protein = pro_protein;
    }
    public void setPro_carbohydrate(String pro_carbohydrate){
        this.pro_carbohydrate = pro_carbohydrate;
    }
    public void setPro_lipid(String pro_lipid){
        this.pro_lipid = pro_lipid;
    }
    public void setPro_inorganic(String pro_inorganic){
        this.pro_inorganic = pro_inorganic;
    }
    public void setPro_vitamin(String pro_vitamin){
        this.pro_vitamin = pro_vitamin;
    }
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
    public void setPro_crab(String pro_crab){
        this.pro_crab = pro_crab;
    }
    public String getPro_name(){
        return pro_name;
    }
    public String getPro_id(){
        return pro_id;
    }
    public String getPro_stock(){
        return pro_stock;
    }
    public String getPro_date(){
        return pro_date;
    }
    public String getPro_type(){
        return pro_type;
    }
    public String getPro_image(){
        return pro_image;
    }
    public String getPro_description(){
        return pro_description;
    }
    public String getPro_protein(){
        return pro_protein;
    }
    public String getPro_carbohydrate(){
        return pro_carbohydrate;
    }
    public String getPro_lipid(){
        return pro_lipid;
    }
    public String getPro_inorganic(){
        return pro_inorganic;
    }
    public String getPro_vitamin(){
        return pro_vitamin;
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
    public String getPro_crab(){
        return pro_crab;
    }

    //カロリーと値段を確認画面でつかう
    public void setPro_price(String pro_price){
        this.pro_price = pro_price;
    }
    public void setPro_calorie(String pro_calorie){
        this.pro_calorie = pro_calorie;
    }
    public String getPro_price(){
        return pro_price;
    }
    public String getPro_calorie(){
        return pro_calorie;
    }


    //custommenuのID
    public void setSyusyokuId(String syusyokuId){
        this.syusyokuId = syusyokuId;
    }
    public void setSyusaiId(String syusaiId){
        this.syusaiId = syusaiId;
    }
    public void setHuku1Id(String huku1Id){
        this.huku1Id = huku1Id;
    }
    public void setHuku2Id(String huku2Id){
        this.huku2Id = huku2Id;
    }
    public String getSyusyokuId(){
        return syusyokuId;
    }
    public String getSyusaiId(){
        return syusaiId;
    }
    public String getHuku1Id(){
        return huku1Id;
    }
    public String getHuku2Id(){
        return huku2Id;
    }

    //合計金額と注文個数
    public void setTotal(String total){
        this.total = total;
    }
    public void setCount(String count){
        this.count = count;
    }
    public String getTotal(){
        return total;
    }
    public String getCount(){
        return count;
    }

    //合計金額
    public void setStore(String store){
        this.store = store;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getStore(){
        return store;
    }
    public String getDate(){
        return date;
    }

    //合計金額
    public void setSortVal(String sortVal){
        this.sortVal = sortVal;
    }
    public void setSortKind(String sortKind){
        this.sortKind = sortKind;
    }
    public String getSortVal(){
        return sortVal;
    }
    public String getSortKind(){
        return sortKind;
    }
    
    
    

    
}