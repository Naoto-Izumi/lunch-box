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
import Menu.JDBCFiles.StoreDao;

public class StorePickUpServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        doPost(req,res);
    }
public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        req.setCharacterEncoding("UTF-8");
        
        StoreDao st=new StoreDao();
        ArrayList slist = (ArrayList)st.getAllProducts();
        System.out.println(slist);
        req.setAttribute("product",slist);

		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/menu/StorePickUp.jsp");
		
		dispatcher.forward(req,res);

	}
}