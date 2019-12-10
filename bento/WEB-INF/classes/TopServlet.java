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

import dao.MenuDao;

public class TopServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        doPost(req,res);
    }
public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        req.setCharacterEncoding("Windows-31J");
        
        MenuDao md=new MenuDao();
        ArrayList mlist = (ArrayList)md.getAllProducts();
        System.out.println(mlist);
        req.setAttribute("users",mlist);

		RequestDispatcher dispatcher=req.getRequestDispatcher("/menu.jsp");
		
		dispatcher.forward(req,res);

	}
}