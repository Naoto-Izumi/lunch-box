package Menu.Beans;

import java.io.Serializable;

public class CustomProduct implements Serializable{

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


    //合計金額と注文個数 custommenuservet pricedao
    private String total = null;
    private String count = null;




    


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


 
    
    

    
}