package Menu.Beans;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomBean implements Serializable{

    ArrayList elementList = new ArrayList();
    private int total_money;


    public void setTotal_money(int total_money){
        this.total_money = total_money;
    }
    public int getTotal_money(){
        return total_money;
    }
    public void setElementList(ArrayList elementList){
        this.elementList = elementList;
    }
    public ArrayList getElementList(){
        return elementList;
    }
    public void elementAdd(ElementBean eb){
        elementList.add(eb);
    }
}