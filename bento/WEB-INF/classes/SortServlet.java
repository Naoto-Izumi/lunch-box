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

        String s2 = null;
        
        if(s1=="prHigh"){
            s1="pro_price";
            s2="DESC";

        }else if(s1=="prLow"){
            s1="pro_price";
            s2="ASC";

        }else if(s1=="caHigh"){
            s1="pro_calorie";
            s2="DESC";
            
        }else if(s1=="caLow"){
            s1="pro_calorie";
            s2="ASC";
            
        }

        System.out.println(s1);
        System.out.println(s2);

        p.setSortVal(s1);
        p.setSortKind(s2);
        
        SortDao rd=new SortDao();
        rd.addProduct(p);
        List pl = rd.getAllProducts();

        req.setAttribute("product",pl);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/menu.jsp");
		
		dispatcher.forward(req,res);

	}
}