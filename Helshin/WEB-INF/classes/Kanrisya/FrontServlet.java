package Kanrisya;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

public class FrontServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
			
			doPost(req,res);
		}
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");

		ApplicationController app = new WebApplicationController();
			
			RequestContext reqc = app.getRequest(req);
			
			ResponseContext resc = app.handleRequest(reqc);
		
			resc.setResponse(res);
		
			app.handleResponse(reqc,resc);
	}
}
