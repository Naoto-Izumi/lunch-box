package Menu.function;

public class price{
    public int priceIf(String pic){
        int priceprice = 0;
        if(pic.contains("1.jpg")){
            priceprice = 100;
        }else if(pic.contains("2.jpg")){
            priceprice = 200;
        }else if(pic.contains("3.jpg")){
            priceprice = 300;
        }else if(pic.contains("4.jpg")){
            priceprice = 400;
        }else if(pic.contains("5.jpg")){
            priceprice = 500;
        }
        return priceprice;
    }

}