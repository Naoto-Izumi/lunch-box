package Bean;

import java.util.ArrayList;
import java.io.Serializable;

public class CartBean implements Serializable{
	ArrayList<CustomBentoBean> cartList = new ArrayList<CustomBentoBean>();
	public CartBean(){}
    public void addBento(CustomBentoBean b){
		cartList.add(b);
    }
	public void setCartList(ArrayList a){
        this.cartList = a;
	}
	
	public ArrayList getCartList(){
		return cartList;
	}

	
}