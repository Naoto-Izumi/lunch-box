package Bean;

import java.io.Serializable;

public class AllergyBean implements Serializable{

    private int pro_wheat;
    private int pro_egg;
    private int pro_milk;
    private int pro_peanuts;
    private int pro_buckwheat;
    private int pro_shrimp;
    private int pro_crab;
    
    public void setPro_wheat(int pro_wheat){
        this.pro_wheat = pro_wheat;
    }
    public int getPro_wheat(){
        return pro_wheat;
    }
    public void setPro_egg(int pro_egg){
        this.pro_egg = pro_egg;
    }
    public int getPro_egg(){
        return pro_egg;
    }
    public void setPro_milk(int pro_milk){
        this.pro_milk = pro_milk;
    }
    public int getPro_milk(){
        return pro_milk;
    }
    public void setPro_peanuts(int pro_peanuts){
        this.pro_peanuts = pro_peanuts;
    }
    public int getPro_peanuts(){
        return pro_peanuts;
    }
    public void setPro_buckwheat(int pro_buckwheat){
        this.pro_buckwheat = pro_buckwheat;
    }
    public int getPro_buckwheat(){
        return pro_buckwheat;
    }
    public void setPro_shrimp(int pro_shrimp){
        this.pro_shrimp = pro_shrimp;
    }
    public int getPro_shrimp(){
        return pro_shrimp;
    }
    public void setPro_crab(int pro_crab){
        this.pro_crab = pro_crab;
    }
    public int getPro_crab(){
        return pro_crab;
    }
}