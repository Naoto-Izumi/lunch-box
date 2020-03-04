package Menu.Beans;

import java.util.ArrayList;
import java.io.Serializable;

public class CartCustomBean implements Serializable{

    private ArrayList custom = new ArrayList();

    public void setCustom(ArrayList custom){
        this.custom = custom;
    }
    public ArrayList getCustom(){
        return custom;
    }
}