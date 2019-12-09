package function;

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

    public int bentoPriceIf(String pic,int count){
        int priceprice = 0;
        if(pic.contains("bento")){
            priceprice = 100*count;
            
        }else if(pic.contains("2.jpg")){
            priceprice = 200*count;
        }else if(pic.contains("3.jpg")){
            priceprice = 300*count;
        }else if(pic.contains("4.jpg")){
            priceprice = 400*count;
        }else if(pic.contains("5.jpg")){
            priceprice = 500*count;
        }
        return priceprice;
    }

}