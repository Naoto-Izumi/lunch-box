package Menu.Beans;

import java.io.Serializable;
import java.util.ArrayList;

public class TotalPriceBean{
    ArrayList<PriceBean> priceList = new ArrayList<PriceBean>();
    public TotalPriceBean(){}
    public void addPrice(PriceBean b){
        priceList.add(b);
    }
    public void setPriceList(ArrayList a){
        this.priceList = a;
    }
    public ArrayList getPriceList(){
        return priceList;
    }
    
    
}