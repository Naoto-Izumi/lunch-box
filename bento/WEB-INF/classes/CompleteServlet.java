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



public class CompleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
		req.setCharacterEncoding("Windows-31J");
        HttpSession session = req.getSession();
        // UserBean ub = (UserBean)session.getAttribute("ub");
		Product p=(Product)session.getAttribute("p");
		
		System.out.println(p);
        //�f�[�^�x�[�X�Ɍl���E�w���������̂�insert����

		// ProductUpDao pr=new ProductUpDao();

		Map m=(Map)session.getAttribute("list");
		Set s=m.keySet();
        Iterator it=s.iterator();
		while(it.hasNext()){
            String key=(String)it.next();
            String v=(String)m.get(key);
			System.out.println("�L�["+key+"�l"+v);
			String num=key.substring(2);


        
            p.setNum(num);
			p.setStock(v);

            System.out.println("�L�["+key+"�l"+v+"�؂����"+num);

			OrderInDao pi=new OrderInDao();
			pi.addProduct(p);
        }
		// pr.addProduct(p);

		// OrderInDao pi=new OrderInDao();
		// pi.addProduct(p);
		session.invalidate();







		RequestDispatcher dispatcher=req.getRequestDispatcher("/complete.jsp");
		
		dispatcher.forward(req,res);

	}
}