package Bean;

import java.io.Serializable;

public class CartCustomBean implements Serializable{

    private ArrayList custom = new ArrayList();

    public void setCustom(String custom){
        this.custom = custom;
    }
    public String getCustom(){
        return custom;
    }
}