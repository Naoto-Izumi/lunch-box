import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.*;
import Bean.Product;

import dao.MenuDao;

public class SPUNextServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        doPost(req,res);
    }
public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        req.setCharacterEncoding("UTF-8");

        Product p = new Product();
        HttpSession h = req.getSession();

        // String date = req.getParameter("date");//日付取得
        // String time = req.getParameter("time");//時間取得
        String st_name = req.getParameter("st_name");//店舗名
        String store = req.getParameter("store"); //st_id取得

        
        // p.setDate(date);
        // p.setTime(time);
        p.setSt_name(st_name);
        p.setStore(store);
        h.setAttribute("spuData",p);

        
        MenuDao md=new MenuDao();
        ArrayList mlist = (ArrayList)md.getAllProducts();
        System.out.println(mlist);
        req.setAttribute("product",mlist);

		RequestDispatcher dispatcher=req.getRequestDispatcher("/menu.jsp");
		
		dispatcher.forward(req,res);

	}
}