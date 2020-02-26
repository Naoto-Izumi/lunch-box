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
import dao.SortDao;
import Bean.Product;

public class SortServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        doPost(req,res);
    }
public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        req.setCharacterEncoding("UTF-8");

        Product p = new Product();

        String s1=req.getParameter("sort");

        System.out.println(s1);

        
        if(s1.equals("prHigh")){
            s1="pro_price DESC";
            System.out.println(s1);


        }else if(s1.equals("prLow")){
            s1="pro_price ASC";
            System.out.println(s1);


        }else if(s1.equals("caHigh")){
            s1="pro_calorie DESC";
            System.out.println(s1);

            
        }else if(s1.equals("caLow")){
            s1="pro_calorie ASC";
            System.out.println(s1);

            
        }else{
            System.out.println("当てはまらない");
        }

        System.out.println(s1);


        p.setSortVal(s1);

        
        SortDao rd=new SortDao();
        rd.addProduct(p);
        List pl = rd.getAllProducts();

        req.setAttribute("product",pl);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/menu.jsp");
		
		dispatcher.forward(req,res);

	}
}