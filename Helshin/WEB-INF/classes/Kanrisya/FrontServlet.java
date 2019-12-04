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

		Map data = req.getParameterMap();
		
		String path = req.getServletPath();
		AbstractCommand command = CommandFactory.getCommand(path);	//ConcreteCommandを取得・
			
		command.init(data);
			
		String url = command.execute();//executeでwhileを呼び込む。
			
		Object ppp = command.getResult();	//AbstractCommandクラスにあるgetResult()メソッドを取得。
			System.out.println(ppp);
		req.setAttribute("result",ppp);		//Objectの変数にあるpppからsetAttributeでresultを呼び出す。
				
		//KanrisyaInsert.OracleKanrisyaInsert(ppp);
			
		RequestDispatcher r = req.getRequestDispatcher(url);
			
		r.forward(req,res);
	}
}
