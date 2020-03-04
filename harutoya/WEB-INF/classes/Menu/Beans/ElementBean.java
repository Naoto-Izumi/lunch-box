package Menu.Beans;

import java.io.Serializable;

public class ElementBean implements Serializable{
    private String id = null;
    private String image = null;
    private String name = null;
    private int money;
    private String calory = null;
    private String type = null;
    private String count = null;
    private AllergyBean ab = new AllergyBean(); 
    private NutritionBean nb = new NutritionBean(); 

    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return image;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public int getMoney(){
        return money;
    }
    public void setCalory(String calory){
        this.calory = calory;
    }
    public String getCalory(){
        return calory;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setCount(String count){
        this.count = count;
    }
    public String getCount(){
        return count;
    }
    public void setAb(AllergyBean ab){
        this.ab = ab;
    }
    public AllergyBean getAb(){
        return ab;
    }
    public void setNb(NutritionBean nb){
        this.nb = nb;
    }
    public NutritionBean getNb(){
        return nb;
    }
}