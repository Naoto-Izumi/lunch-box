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
import Menu.JDBCFiles.RefineSyusyokuDao;
import Menu.JDBCFiles.RefineSyusaiDao;
import Menu.JDBCFiles.RefineHukusaiDao;
import Menu.Beans.Product;

public class RefineCusServlet extends HttpServlet{
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

        System.out.println("小麦"+s1);
        System.out.println("卵"+s2);
        System.out.println("乳"+s3);
        System.out.println("落花生"+s4);
        System.out.println("そば"+s5);
        System.out.println("えび"+s6);
        System.out.println("かに"+s7);

        p.setPro_wheat(s1);
        p.setPro_egg(s2);
        p.setPro_milk(s3);
        p.setPro_peanuts(s4);
        p.setPro_buckwheat(s5);
        p.setPro_shrimp(s6);
        p.setPro_crab(s7);
        
        
        
        
        RefineSyusyokuDao syusyoku=new RefineSyusyokuDao();
        RefineSyusaiDao syusai=new RefineSyusaiDao();
        RefineHukusaiDao hukusai=new RefineHukusaiDao();


        syusyoku.addProduct(p);
        syusai.addProduct(p);
        hukusai.addProduct(p);
        ArrayList syusyokuList = (ArrayList)syusyoku.getAllProducts();
        ArrayList syusaiList = (ArrayList)syusai.getAllProducts();
        ArrayList hukuList = (ArrayList)hukusai.getAllProducts();


        req.setAttribute("syusyokuProduct",syusyokuList);
        req.setAttribute("syusaiProduct",syusaiList);
        req.setAttribute("hukuProduct",hukuList);

        
        
        
        
		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/menu/custom.jsp");
		
		dispatcher.forward(req,res);

	}
}