import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;
import java.util.*;

import dao.OrderInDao;
// import dao.ProductUpDao;
import Bean.Product;
import Bean.CustomBean;
import Bean.CustomCartBean;
import Bean.ElementBean;



public class CompleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
		req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        // UserBean ub = (UserBean)session.getAttribute("ub");
		Product p=(Product)session.getAttribute("p");
		
		System.out.println(p);
        //データベースに個人情報・購入したものをinsertする

		// ProductUpDao pr=new ProductUpDao();
		CustomCartBean ccb = null;
		if(session.getAttribute("ccb")==null){
		    Map m=(Map)session.getAttribute("list");
		if(m!=null){
			Set s=m.keySet();
			Iterator it=s.iterator();
			while(it.hasNext()){
				String key=(String)it.next();
				String v = null;
				if(m.get(key) instanceof Integer){
					Integer integer = (Integer)m.get(key);
					v = Integer.toString(integer);
				}else{
					v = (String)m.get(key);
				}
				
				System.out.println("キー"+key+"値"+v);
				String num = null;
				if(key.length()==3){
					num=key.substring(2);
				}else{
					num=key;
				}


			
				p.setNum(num);
				p.setStock(v);

				System.out.println("キー"+key+"値"+v+"切り取り後"+num);

				OrderInDao pi=new OrderInDao();
				pi.addProduct(p);
			}
		}
		}else{
		    ccb =(CustomCartBean)session.getAttribute("ccb");
		    Iterator it_cutom = ccb.getCustomList().iterator();
		    while(it_cutom.hasNext()){
			    CustomBean cb = (CustomBean)it_cutom.next();
			    Iterator it_element = cb.getElementList().iterator();
			    while(it_element.hasNext()){
				    ElementBean eb = (ElementBean)it_element.next();
				    p.setNum(eb.getId());
				    p.setStock("1");
				    OrderInDao pi=new OrderInDao();
				    pi.addProduct(p);
			    }
		    }



			Map m=(Map)session.getAttribute("list");
		if(m!=null){
			Set s=m.keySet();
			Iterator it=s.iterator();
			while(it.hasNext()){
				String key=(String)it.next();
				String v = null;
				if(m.get(key) instanceof Integer){
					Integer integer = (Integer)m.get(key);
					v = Integer.toString(integer);
				}else{
					v = (String)m.get(key);
				}
				
				System.out.println("キー"+key+"値"+v);
				String num = null;
				if(key.length()==3){
					num=key.substring(2);
				}else{
					num=key;
				}


			
				p.setNum(num);
				p.setStock(v);

				System.out.println("キー"+key+"値"+v+"切り取り後"+num);

				OrderInDao pi=new OrderInDao();
				pi.addProduct(p);
			}
		}
		}













		
		// pr.addProduct(p);

		// OrderInDao pi=new OrderInDao();
		// pi.addProduct(p);
		//sessionを消す
		session.invalidate();
		RequestDispatcher dispatcher=req.getRequestDispatcher("/complete.jsp");
		
		dispatcher.forward(req,res);

	}
}