package Menu;
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

import Menu.JDBCFiles.MenuDao;

public class TopServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        doPost(req,res);
    }
public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        req.setCharacterEncoding("UTF-8");
        
        MenuDao md=new MenuDao();
        ArrayList mlist = (ArrayList)md.getAllProducts();
        System.out.println(mlist);
        req.setAttribute("product",mlist);

		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/menu/menu.jsp");
		
		dispatcher.forward(req,res);

	}
}