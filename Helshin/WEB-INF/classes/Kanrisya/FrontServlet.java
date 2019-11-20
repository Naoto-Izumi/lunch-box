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
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		Map data = req.getParameterMap();
		
		String path = req.getServletPath();
		AbstractCommand command = CommandFactory.getCommand(path);
		command.init(data);
		
		String url = command.execute();
		
		Object result = command.getResult();
		req.setAttribute("result",result);
		
		RequestDispatcher dis = req.getRequestDispatcher(url);
		dis.forward(req,res);
	}
}
