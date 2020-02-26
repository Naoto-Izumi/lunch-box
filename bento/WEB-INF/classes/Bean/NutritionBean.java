package Bean;

import java.io.Serializable;

public class NutritionBean implements Serializable{

    private int pro_protein;
    private int pro_carbohydrate;
    private int pro_lipid;
    private int pro_vitamin;
    private int pro_inorganic;
    
    public void setPro_protein(int pro_protein){
        this.pro_protein = pro_protein;
    }
    public int getPro_protein(){
        return pro_protein;
    }
    public void setPro_carbohydrate(int pro_carbohydrate){
        this.pro_carbohydrate = pro_carbohydrate;
    }
    public int getPro_carbohydrate(){
        return pro_carbohydrate;
    }
    public void setPro_lipid(int pro_lipid){
        this.pro_lipid = pro_lipid;
    }
    public int getPro_lipid(){
        return pro_lipid;
    }
    public void setPro_vitamin(int pro_vitamin){
        this.pro_vitamin = pro_vitamin;
    }
    public int getPro_vitamin(){
        return pro_vitamin;
    }
    public void setPro_inorganic(int pro_inorganic){
        this.pro_inorganic = pro_inorganic;
    }
    public int getPro_inorganic(){
        return pro_inorganic;
    }
}