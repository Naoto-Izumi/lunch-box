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

import dao.CusSyusyokuDao;
import dao.CusSyusaiDao;
import dao.CusHukusaiDao;

public class TopCusServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        doPost(req,res);
    }
public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{	
        req.setCharacterEncoding("UTF-8");
        
        CusSyusyokuDao syusyoku=new CusSyusyokuDao();
        CusSyusaiDao syusai=new CusSyusaiDao();
        CusHukusaiDao hukusai=new CusHukusaiDao();
        ArrayList syusyokuList = (ArrayList)syusyoku.getAllProducts();
        ArrayList syusaiList = (ArrayList)syusai.getAllProducts();
        ArrayList hukuList = (ArrayList)hukusai.getAllProducts();


        req.setAttribute("syusyokuProduct",syusyokuList);
        req.setAttribute("syusaiProduct",syusaiList);
        req.setAttribute("hukuProduct",hukuList);

		RequestDispatcher dispatcher=req.getRequestDispatcher("/custom.jsp");
		
		dispatcher.forward(req,res);

	}
}