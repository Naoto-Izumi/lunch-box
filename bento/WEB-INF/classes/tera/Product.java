package tera;

import java.io.Serializable;

public class Product implements Serializable{
    private String pid;
    private String name;
    private String price;

    public String getPid(){
        return pid;
    }
    public void setPid(String pid){
        this.pid=pid;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price=price;
    }
}