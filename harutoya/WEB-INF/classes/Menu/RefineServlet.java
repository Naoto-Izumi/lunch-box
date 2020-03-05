package Menu;

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
import Menu.JDBCFiles.RefineDao;
import Menu.Beans.Product;

public class RefineServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        doPost(req,res);
    }
public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        req.setCharacterEncoding("UTF-8");

        Product p = new Product();

        // String[] s=req.getParameterValues("check");



        // p.setPro_wheat(s[0]);
        // p.setPro_egg(s[1]);
        // p.setPro_milk(s[2]);
        // p.setPro_peanuts(s[3]);
        // p.setPro_buckwheat(s[4]);
        // p.setPro_shrimp(s[5]);
        // p.setPro_club(s[6]);
        String s1=req.getParameter("check1");
        String s2=req.getParameter("check2");
        String s3=req.getParameter("check3");
        String s4=req.getParameter("check4");
        String s5=req.getParameter("check5");
        String s6=req.getParameter("check6");
        String s7=req.getParameter("check7");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);

        p.setPro_wheat(s1);
        p.setPro_egg(s2);
        p.setPro_milk(s3);
        p.setPro_peanuts(s4);
        p.setPro_buckwheat(s5);
        p.setPro_shrimp(s6);
        p.setPro_crab(s7);
        
        
        
        
        
        
        
        
        
        RefineDao rd=new RefineDao();
        rd.addProduct(p);
        List pl = rd.getAllProducts();

        req.setAttribute("product",pl);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/menu/menu.jsp");
		
		dispatcher.forward(req,res);

	}
}