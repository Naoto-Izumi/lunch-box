package Menu.CommandFiles;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import Menu.Beans.CustomBentoBean;
import Menu.Beans.CartBean;
import Menu.Beans.TotalPriceBean;
import Menu.Beans.PriceBean;
import Menu.function.price;
import Menu.function.CutURL;
import java.util.*;
import Menu.JDBCFiles.PriceDao;
import Menu.Beans.Product;

import Main.RequestContext;
import Main.ResponseContext;
import Main.AbstractCommand;

public class CustomMenuCommand extends AbstractCommand{
    
    private CartBean cb = new CartBean();
    private TotalPriceBean tpb = new TotalPriceBean();

    public ResponseContext execute(ResponseContext resc){
		
        RequestContext reqc = getRequestContext();

		String syusyoku=((String[])reqc.getParameter("syusyoku"))[0];
		String syusai=((String[])reqc.getParameter("syusai"))[0];
        String huku1=((String[])reqc.getParameter("huku1"))[0];
		String huku2=((String[])reqc.getParameter("huku2"))[0];

        System.out.println(syusyoku);
        System.out.println(syusai);
        System.out.println(huku1);
        System.out.println(huku2);


        //pathを切り取って数字だけにして、product表のidと一致させたい
        syusyoku = syusyoku.substring(11);
        syusyoku = syusyoku.replace(".jpg","");
        syusai = syusai.substring(11);
        syusai = syusai.replace(".jpg","");
        huku1 = huku1.substring(11);
        huku1 = huku1.replace(".jpg","");
        huku2 = huku2.substring(11);
        huku2 = huku2.replace(".jpg","");
        
        System.out.println(syusyoku);
        System.out.println(syusai);
        System.out.println(huku1);
        System.out.println(huku2);
        
        Product p = new Product();
        p.setSyusyokuId(syusyoku);
        p.setSyusaiId(syusai);
        p.setHuku1Id(huku1);
        p.setHuku2Id(huku2);

        // price p = new price();
        // int Syusyoku = p.priceIf(syusyoku);
        // int Syusai = p.priceIf(syusai);
        // int Huku1 = p.priceIf(huku1);
        // int Huku2 = p.priceIf(huku2);
        // int total = Syusyoku+Syusai+Huku1+Huku2;

        //daoで4つの商品IDを使いたいからdaoのフィールドにProductを登録
        PriceDao pd = new PriceDao();
        pd.addProduct(p);
        //daoからselectでデータをとってくる、
        ArrayList data=(ArrayList)pd.getAllProducts();
        Iterator it = data.iterator();
        int total = 0;
        while(it.hasNext()){
            Product pro = (Product)it.next();
            total = Integer.parseInt(pro.getTotal());
        }

        //HttpSession session = reqc.getSessionObject();
        if(reqc.getSessionObject("totalPrice") != null){
            Integer i = (Integer)reqc.getSessionObject("totalPrice");
            total += i;
        }
        ArrayList ii = new ArrayList();
        if(reqc.getSessionObject("cart") != null){
            ii = (ArrayList)reqc.getSessionObject("cart");
        }
        for(int k=0;k<4;k++){
           // System.out.println("ppppppppppppppppppppppppp"+data.get(k));
            ii.add(data.get(k));
            
        }


    
        //session.setAttribute("a",data);
        reqc.setSessionObject("cart",ii);
        resc.setResult(ii);
        resc.setResultName("product");

        reqc.setSessionObject("totalPrice",total);
        reqc.setResult("total",total);



        // PriceBean pb = new PriceBean();
        // pb.setSyusyoku(Syusyoku);
        // pb.setSyusai(Syusai);
        // pb.setHuku1(Huku1);
        // pb.setHuku2(Huku2);
        // pb.setTotal(total);

        

        // tpb.addPrice(pb);
        // int realTotal = 0;
        // ArrayList list = tpb.getPriceList();
        // Iterator it = list.iterator();
        // while(it.hasNext()){
        //     PriceBean priceb = (PriceBean)it.next();
        //     realTotal += priceb.getTotal();
        // }
     

        // //商品IDのみ（Product）の登録
        // cb.addBento(p);
        
     
        // // session.setAttribute("tpb",tpb);
        // session.setAttribute("allInfo",price);
        // session.setAttribute("cb",cb);

        Map sessionlist;

        
        
        if(null==reqc.getSessionObject("list")){
            sessionlist=new TreeMap();
        }else{
            sessionlist=(Map)reqc.getSessionObject("list");
        }

        sessionlist.put(syusyoku, 1);
        sessionlist.put(syusai, 1);
        sessionlist.put(huku1, 1);
        sessionlist.put(huku2, 1);

        System.out.println("kkkkkkkkkkkk1"+sessionlist.get("1"));
        System.out.println("kkkkkkkkkkkk2"+sessionlist.get("2"));
        System.out.println("kkkkkkkkkkkk3"+sessionlist.get("3"));
        System.out.println("kkkkkkkkkkkk4"+sessionlist.get("4"));

        reqc.setSessionObject("list",sessionlist);

        reqc.setResult("plist",sessionlist);
        
			


        resc.setTarget("menu/order");

        return resc;
	}
}