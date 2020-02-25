import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import Bean.CustomBentoBean;
import Bean.CartBean;
import Bean.TotalPriceBean;
import Bean.PriceBean;
import function.price;
import function.CutURL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.*;
import dao.PriceDao;
import Bean.Product;

public class CustomMenuServlet extends HttpServlet{
    
    private CartBean cb = new CartBean();
    private TotalPriceBean tpb = new TotalPriceBean();

    public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
        doPost(req,res);
    }	

	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("UTF-8");
		
		String syusyoku=req.getParameter("syusyoku");
		String syusai=req.getParameter("syusai");
        String huku1=req.getParameter("huku1");
		String huku2=req.getParameter("huku2");

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
            total += Integer.parseInt(pro.getTotal());
        }

        HttpSession session = req.getSession();
        if(session.getAttribute("customTotalPrice") != null){
            Integer i = (Integer)session.getAttribute("customTotalPrice");
            total += i;
        }
        ArrayList ii = new ArrayList();
        if(session.getAttribute("customCart") != null){
            ii = (ArrayList)session.getAttribute("customCart");
        }
        for(int k=0;k<4;k++){
           // System.out.println("ppppppppppppppppppppppppp"+data.get(k));
            ii.add(data.get(k));

            
        }

        





    
        //session.setAttribute("a",data);
        req.setAttribute("product",ii);
        session.setAttribute("customCart",ii);
        req.setAttribute("total",total);
        session.setAttribute("customTotalPrice",total);



        Map sessionlist;

        
        
        if(null==session.getAttribute("customList")){
            sessionlist=new TreeMap();
        }else{
            sessionlist=(Map)session.getAttribute("customList");
        }

        sessionlist.put("no"+syusyoku, 1);
        sessionlist.put("no"+syusai, 1);
        sessionlist.put("no"+huku1, 1);
        sessionlist.put("no"+huku2, 1);

        System.out.println("kkkkkkkkkkkk1"+sessionlist.get("no1"));
        System.out.println("kkkkkkkkkkkk2"+sessionlist.get("no2"));
        System.out.println("kkkkkkkkkkkk3"+sessionlist.get("no3"));
        System.out.println("kkkkkkkkkkkk4"+sessionlist.get("no4"));

        session.setAttribute("customList",sessionlist);

        req.setAttribute("plist", sessionlist);
			


        RequestDispatcher dispatcher=req.getRequestDispatcher("/order.jsp");
		
		dispatcher.forward(req,res);
	}
}