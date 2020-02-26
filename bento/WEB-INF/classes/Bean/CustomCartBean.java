package Bean;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomCartBean implements Serializable{

    ArrayList customList = new ArrayList();
    private int custom_total_money;


    public void setCustom_total_money(int custom_total_money){
        this.custom_total_money = custom_total_money;
    }
    public int getCustom_total_money(){
        return custom_total_money;
    }
    public void setCustomList(ArrayList customList){
        this.customList = customList;
    }
    public ArrayList getCustomList(){
        return customList;
    }
    public void customAdd(CustomBean eb){
        customList.add(eb);
    }
    public int customRemove(int index){
        CustomBean cb = (CustomBean)customList.get(index);
        int minus_money = cb.getTotal_money();
        customList.remove(index);
        return minus_money;
    }
}