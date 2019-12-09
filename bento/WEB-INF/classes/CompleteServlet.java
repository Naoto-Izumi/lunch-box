import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import Bean.UserBean;
import java.util.Iterator;
import java.util.Map;
import java.util.*;

import Bean.Product;


public class CompleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
		req.setCharacterEncoding("Windows-31J");
        HttpSession session = req.getSession();
        Product p = (Product)session.getAttribute("p");
        //データベースに個人情報・購入したものをinsertする

		Product pr=new Product();
		Map m=(Map)session.getAttribute("list");
		Set s=m.keySet();
        Iterator it=s.iterator();
		while(it.hasNext()){
            String key=(String)it.next();
            String v=(String)m.get(key);
        
            pr.meth(v,key);
            System.out.println("キー"+key+"値"+v);
        }

		OrderIn oi=new OrderIn(ub);
		oi.addProduct(p);







		RequestDispatcher dispatcher=req.getRequestDispatcher("/complete.jsp");
		
		dispatcher.forward(req,res);

	}
}