package Bean;

import java.io.Serializable;

public class Product implements Serializable{
    //User‚Ì’•¶î•ñ
    private String name = null;
    private String tel = null;
    private String mail = null;
    private String address = null;
    private String time = null;
    private String price = null;
    private String cardname = null;
    private String cardnumber = null;
    private String carddate = null;
    //¤•iId,¤•i‰æ‘œ 
    private String id = null;
    private String image = null; 

    //Œ³UserBean 
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
    public void setPrice(String price){
        this.price = price;
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
    public String getPrice(){
        return price;
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

    //Œ³menubean@menuDao,topservlet
   
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
    
}