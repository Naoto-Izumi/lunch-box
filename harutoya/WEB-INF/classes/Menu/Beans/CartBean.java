package Menu.Beans;

import java.util.ArrayList;
import java.io.Serializable;

public class CartBean implements Serializable{
	ArrayList<Product> cartList = new ArrayList<Product>();
	public CartBean(){}
    public void addBento(Product b){
		cartList.add(b);
    }
	public void setCartList(ArrayList a){
        this.cartList = a;
	}
	
	public ArrayList getCartList(){
		return cartList;
	}

	
}