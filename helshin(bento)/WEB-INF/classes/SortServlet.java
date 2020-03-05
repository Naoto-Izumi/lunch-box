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
import dao.SortSyusyokuDao;
import dao.SortSyusaiDao;
import dao.SortHukuDao;
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
        String s2=null;


        System.out.println(s1);


        
        if(s1.equals("prHigh")){
            s1="pro_type='弁当' ORDER BY pro_price DESC";
            s2="menu";
            System.out.println(s1);


        }else if(s1.equals("prLow")){
            s1="pro_type='弁当' ORDER BY pro_price ASC";
            s2="menu";
            System.out.println(s1);


        }else if(s1.equals("caHigh")){
            s1="pro_type='弁当' ORDER BY pro_calorie DESC";
            s2="menu";
            System.out.println(s1);

            
        }else if(s1.equals("caLow")){
            s1="pro_type='弁当' ORDER BY pro_calorie ASC";
            s2="menu";
            System.out.println(s1);

            
        }else if(s1.equals("cusPrHigh")){
            s1="ORDER BY pro_price DESC";
            s2="custom";
            System.out.println(s1);


        }else if(s1.equals("cusPrLow")){
            s1="ORDER BY pro_price ASC";
            s2="custom";
            System.out.println(s1);


        }else if(s1.equals("cusCaHigh")){
            s1="ORDER BY pro_calorie DESC";
            s2="custom";
            System.out.println(s1);

            
        }else if(s1.equals("cusCaLow")){
            s1="ORDER BY pro_calorie ASC";
            s2="custom";
            System.out.println(s1);

            
        }else{
            System.out.println("当てはまらない");
        }

        System.out.println(s1);


        p.setSortVal(s1);
        if(s2.equals("menu")){
            SortDao rd=new SortDao();
            rd.addProduct(p);
            List pl = rd.getAllProducts();

            req.setAttribute("product",pl);
        }else{
            
            SortSyusyokuDao sd=new SortSyusyokuDao();
            SortSyusaiDao ad=new SortSyusaiDao();
            SortHukuDao hd=new SortHukuDao();

            sd.addProduct(p);
            ad.addProduct(p);
            hd.addProduct(p);

            List p1 = sd.getAllProducts();
            List p2 = ad.getAllProducts();
            List p3 = hd.getAllProducts();

            req.setAttribute("syusyokuProduct",p1);
            req.setAttribute("syusaiProduct",p2);
            req.setAttribute("hukuProduct",p3);

        }
        
                
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/"+s2+".jsp");

		
		dispatcher.forward(req,res);

	}
}