package Menu.Beans;

import java.io.Serializable;

public class PriceBean{
    int syusyoku = 0; 
    int syusai = 0; 
    int huku1 = 0; 
    int huku2 = 0; 
    int total =0;
    public PriceBean(){}
    
    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return total;
    }
    public void setSyusyoku(int syusyoku){
        this.syusyoku = syusyoku;
    }
    public void setSyusai(int syusai){
        this.syusai = syusai;
    }
    public void setHuku1(int huku1){
        this.huku1 = huku1;
    }
    public void setHuku2(int huku2){
        this.huku2 = huku2;
    }
    public int getSyusyoku(){
        return syusyoku;
    }
    public int getSyusai(){
        return syusai;
    }
    public int getHuku1(){
        return huku1;
    }
    public int getHuku2(){
        return huku2;
    }


}