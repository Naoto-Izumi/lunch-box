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
import dao.SearchDao;
import Bean.Product;

public class SearchServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        doPost(req,res);
    }
public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        req.setCharacterEncoding("UTF-8");

        Product p = new Product();

        String sname=req.getParameter("sname");

        System.out.println(sname);

        p.setPro_name(sname);
     
        SearchDao rd=new SearchDao();
        rd.addProduct(p);
        List pl = rd.getAllProducts();

        req.setAttribute("product",pl);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/menu.jsp");
		
		dispatcher.forward(req,res);

	}
}