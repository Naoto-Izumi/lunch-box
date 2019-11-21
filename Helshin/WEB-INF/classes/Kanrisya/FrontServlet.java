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
		req.setCharacterEncoding("UTF-8");
			doPost(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("UTF-8");
		
		Map data = req.getParameterMap();
		
		String path = req.getServletPath();
		AbstractCommand command = CommandFactory.getCommand(path);
		command.init(data);
		
		String url = command.execute();
		
		Object result = command.getResult();
		req.setAttribute("result",result);
		
		Product pp = new Product();
		pp.setLname("a");
		pp.setTelphone("e");
		pp.setMail("f");
		pp.setId("1");
		//req.setAttribute("product",pp);
		
		//KanrisyaData.OracleKanrisyaData(pp);
		
		RequestDispatcher dis = req.getRequestDispatcher(url);
		dis.forward(req,res);
	}
}
