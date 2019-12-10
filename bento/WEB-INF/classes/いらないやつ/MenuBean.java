package Bean;

import java.io.Serializable;

public class MenuBean{
    String id = null; 
    String image = null; 
   
    public MenuBean(){}
    
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