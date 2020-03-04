package Menu.Beans;

import java.util.ArrayList;
import java.io.Serializable;

public class BentoBean implements Serializable{
	ArrayList<String> bentoList = new ArrayList<String>();
	public BentoBean(){}
    public void addBento(String b){
		bentoList.add(b);
    }
	public void setBentoList(ArrayList a){
        this.bentoList = a;
	}
	
	public ArrayList getBentoList(){
		return bentoList;
	}
	
}



