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

public class MenuServlet extends HttpServlet{


	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		Map m=req.getParameterMap();
        Set s=m.keySet();
        Iterator it=s.iterator();
        HttpSession h=req.getSession();
        Map sessionlist;
        
        if(null==h.getAttribute("list")){
            sessionlist=new TreeMap();
        }else{
            sessionlist=(Map)h.getAttribute("list");
        }
        while(it.hasNext()){
            String key=(String)it.next();
            String[] v=(String[])m.get(key);
        
            sessionlist.put(key,v[0]);
            System.out.println("キー"+key+"値"+v[0]);
        }

        h.setAttribute("list",sessionlist);

        req.setAttribute("plist",sessionlist);



		RequestDispatcher dispatcher=req.getRequestDispatcher("/order.jsp");
		
		dispatcher.forward(req,res);

	}
}